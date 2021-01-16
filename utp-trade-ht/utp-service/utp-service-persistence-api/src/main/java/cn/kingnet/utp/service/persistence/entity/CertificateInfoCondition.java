package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class CertificateInfoCondition {
    private PlusEntityWrapper<CertificateInfo> ew;

    public CertificateInfoCondition() {
        this.ew = new PlusEntityWrapper(CertificateInfo.class);
    }

    public static CertificateInfoCondition builder() {
        return new CertificateInfoCondition();
    }

    public PlusEntityWrapper<CertificateInfo> build() {
        return this.ew;
    }

    public CertificateInfoCondition or() {
        this.ew.orNew();
        return this;
    }

    public CertificateInfoCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(CertificateInfo.class);
    }

    public CertificateInfoCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public CertificateInfoCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public CertificateInfoCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public CertificateInfoCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> CertificateInfoCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> CertificateInfoCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> CertificateInfoCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public CertificateInfoCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public CertificateInfoCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public CertificateInfoCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public CertificateInfoCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public CertificateInfoCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public CertificateInfoCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public CertificateInfoCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public CertificateInfoCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public CertificateInfoCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public CertificateInfoCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public CertificateInfoCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public CertificateInfoCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public CertificateInfoCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public CertificateInfoCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public CertificateInfoCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public CertificateInfoCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public CertificateInfoCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public CertificateInfoCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public CertificateInfoCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public CertificateInfoCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public CertificateInfoCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public CertificateInfoCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public CertificateInfoCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public CertificateInfoCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public CertificateInfoCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public CertificateInfoCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public CertificateInfoCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public CertificateInfoCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public CertificateInfoCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public CertificateInfoCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public CertificateInfoCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public CertificateInfoCondition andCertificateNoIsNull() {
        ew.isNull("certificate_no");
        return this;
    }

    public CertificateInfoCondition orCertificateNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("certificate_no");
        return this;
    }

    public CertificateInfoCondition andCertificateNoIsNotNull() {
        ew.isNotNull("certificate_no");
        return this;
    }

    public CertificateInfoCondition orCertificateNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("certificate_no");
        return this;
    }

    public CertificateInfoCondition andCertificateNoEq(Object value) {
        ew.eq("certificate_no", value);
        return this;
    }

    public CertificateInfoCondition orCertificateNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("certificate_no", value);
        return this;
    }

    public CertificateInfoCondition andCertificateNoNe(Object value) {
        ew.ne("certificate_no", value);
        return this;
    }

    public CertificateInfoCondition orCertificateNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("certificate_no", value);
        return this;
    }

    public CertificateInfoCondition andCertificateNoGt(Object value) {
        ew.gt("certificate_no", value);
        return this;
    }

    public CertificateInfoCondition orCertificateNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("certificate_no", value);
        return this;
    }

    public CertificateInfoCondition andCertificateNoGe(Object value) {
        ew.ge("certificate_no", value);
        return this;
    }

    public CertificateInfoCondition orCertificateNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("certificate_no", value);
        return this;
    }

    public CertificateInfoCondition andCertificateNoLt(Object value) {
        ew.lt("certificate_no", value);
        return this;
    }

    public CertificateInfoCondition orCertificateNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("certificate_no", value);
        return this;
    }

    public CertificateInfoCondition andCertificateNoLe(Object value) {
        ew.le("certificate_no", value);
        return this;
    }

    public CertificateInfoCondition orCertificateNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("certificate_no", value);
        return this;
    }

    public CertificateInfoCondition andCertificateNoIn(Object... value) {
        ew.in("certificate_no", value);
        return this;
    }

    public CertificateInfoCondition orCertificateNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("certificate_no", value);
        return this;
    }

    public CertificateInfoCondition andCertificateNoNotIn(Object... value) {
        ew.notIn("certificate_no", value);
        return this;
    }

    public CertificateInfoCondition orCertificateNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("certificate_no", value);
        return this;
    }

    public CertificateInfoCondition andCertificateNoBetween(Object value, Object value1) {
        ew.between("certificate_no", value, value1);
        return this;
    }

    public CertificateInfoCondition orCertificateNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("certificate_no", value, value1);
        return this;
    }

    public CertificateInfoCondition andCertificateNoNotBetween(Object value, Object value1) {
        ew.notBetween("certificate_no", value, value1);
        return this;
    }

    public CertificateInfoCondition orCertificateNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("certificate_no", value, value1);
        return this;
    }

    public CertificateInfoCondition andCertificateNoLike(String value) {
        ew.like("certificate_no", value);
        return this;
    }

    public CertificateInfoCondition orCertificateNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("certificate_no", value);
        return this;
    }

    public CertificateInfoCondition andCertificateNoNotLike(String value) {
        ew.notLike("certificate_no", value);
        return this;
    }

    public CertificateInfoCondition orCertificateNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("certificate_no", value);
        return this;
    }

    public CertificateInfoCondition andCertificateSeqIsNull() {
        ew.isNull("certificate_seq");
        return this;
    }

    public CertificateInfoCondition orCertificateSeqIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("certificate_seq");
        return this;
    }

    public CertificateInfoCondition andCertificateSeqIsNotNull() {
        ew.isNotNull("certificate_seq");
        return this;
    }

    public CertificateInfoCondition orCertificateSeqIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("certificate_seq");
        return this;
    }

    public CertificateInfoCondition andCertificateSeqEq(Object value) {
        ew.eq("certificate_seq", value);
        return this;
    }

    public CertificateInfoCondition orCertificateSeqEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("certificate_seq", value);
        return this;
    }

    public CertificateInfoCondition andCertificateSeqNe(Object value) {
        ew.ne("certificate_seq", value);
        return this;
    }

    public CertificateInfoCondition orCertificateSeqNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("certificate_seq", value);
        return this;
    }

    public CertificateInfoCondition andCertificateSeqGt(Object value) {
        ew.gt("certificate_seq", value);
        return this;
    }

    public CertificateInfoCondition orCertificateSeqGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("certificate_seq", value);
        return this;
    }

    public CertificateInfoCondition andCertificateSeqGe(Object value) {
        ew.ge("certificate_seq", value);
        return this;
    }

    public CertificateInfoCondition orCertificateSeqGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("certificate_seq", value);
        return this;
    }

    public CertificateInfoCondition andCertificateSeqLt(Object value) {
        ew.lt("certificate_seq", value);
        return this;
    }

    public CertificateInfoCondition orCertificateSeqLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("certificate_seq", value);
        return this;
    }

    public CertificateInfoCondition andCertificateSeqLe(Object value) {
        ew.le("certificate_seq", value);
        return this;
    }

    public CertificateInfoCondition orCertificateSeqLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("certificate_seq", value);
        return this;
    }

    public CertificateInfoCondition andCertificateSeqIn(Object... value) {
        ew.in("certificate_seq", value);
        return this;
    }

    public CertificateInfoCondition orCertificateSeqIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("certificate_seq", value);
        return this;
    }

    public CertificateInfoCondition andCertificateSeqNotIn(Object... value) {
        ew.notIn("certificate_seq", value);
        return this;
    }

    public CertificateInfoCondition orCertificateSeqNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("certificate_seq", value);
        return this;
    }

    public CertificateInfoCondition andCertificateSeqBetween(Object value, Object value1) {
        ew.between("certificate_seq", value, value1);
        return this;
    }

    public CertificateInfoCondition orCertificateSeqBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("certificate_seq", value, value1);
        return this;
    }

    public CertificateInfoCondition andCertificateSeqNotBetween(Object value, Object value1) {
        ew.notBetween("certificate_seq", value, value1);
        return this;
    }

    public CertificateInfoCondition orCertificateSeqNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("certificate_seq", value, value1);
        return this;
    }

    public CertificateInfoCondition andCertificateSeqLike(String value) {
        ew.like("certificate_seq", value);
        return this;
    }

    public CertificateInfoCondition orCertificateSeqLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("certificate_seq", value);
        return this;
    }

    public CertificateInfoCondition andCertificateSeqNotLike(String value) {
        ew.notLike("certificate_seq", value);
        return this;
    }

    public CertificateInfoCondition orCertificateSeqNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("certificate_seq", value);
        return this;
    }

    public CertificateInfoCondition andCertificateNameIsNull() {
        ew.isNull("certificate_name");
        return this;
    }

    public CertificateInfoCondition orCertificateNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("certificate_name");
        return this;
    }

    public CertificateInfoCondition andCertificateNameIsNotNull() {
        ew.isNotNull("certificate_name");
        return this;
    }

    public CertificateInfoCondition orCertificateNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("certificate_name");
        return this;
    }

    public CertificateInfoCondition andCertificateNameEq(Object value) {
        ew.eq("certificate_name", value);
        return this;
    }

    public CertificateInfoCondition orCertificateNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("certificate_name", value);
        return this;
    }

    public CertificateInfoCondition andCertificateNameNe(Object value) {
        ew.ne("certificate_name", value);
        return this;
    }

    public CertificateInfoCondition orCertificateNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("certificate_name", value);
        return this;
    }

    public CertificateInfoCondition andCertificateNameGt(Object value) {
        ew.gt("certificate_name", value);
        return this;
    }

    public CertificateInfoCondition orCertificateNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("certificate_name", value);
        return this;
    }

    public CertificateInfoCondition andCertificateNameGe(Object value) {
        ew.ge("certificate_name", value);
        return this;
    }

    public CertificateInfoCondition orCertificateNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("certificate_name", value);
        return this;
    }

    public CertificateInfoCondition andCertificateNameLt(Object value) {
        ew.lt("certificate_name", value);
        return this;
    }

    public CertificateInfoCondition orCertificateNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("certificate_name", value);
        return this;
    }

    public CertificateInfoCondition andCertificateNameLe(Object value) {
        ew.le("certificate_name", value);
        return this;
    }

    public CertificateInfoCondition orCertificateNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("certificate_name", value);
        return this;
    }

    public CertificateInfoCondition andCertificateNameIn(Object... value) {
        ew.in("certificate_name", value);
        return this;
    }

    public CertificateInfoCondition orCertificateNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("certificate_name", value);
        return this;
    }

    public CertificateInfoCondition andCertificateNameNotIn(Object... value) {
        ew.notIn("certificate_name", value);
        return this;
    }

    public CertificateInfoCondition orCertificateNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("certificate_name", value);
        return this;
    }

    public CertificateInfoCondition andCertificateNameBetween(Object value, Object value1) {
        ew.between("certificate_name", value, value1);
        return this;
    }

    public CertificateInfoCondition orCertificateNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("certificate_name", value, value1);
        return this;
    }

    public CertificateInfoCondition andCertificateNameNotBetween(Object value, Object value1) {
        ew.notBetween("certificate_name", value, value1);
        return this;
    }

    public CertificateInfoCondition orCertificateNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("certificate_name", value, value1);
        return this;
    }

    public CertificateInfoCondition andCertificateNameLike(String value) {
        ew.like("certificate_name", value);
        return this;
    }

    public CertificateInfoCondition orCertificateNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("certificate_name", value);
        return this;
    }

    public CertificateInfoCondition andCertificateNameNotLike(String value) {
        ew.notLike("certificate_name", value);
        return this;
    }

    public CertificateInfoCondition orCertificateNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("certificate_name", value);
        return this;
    }

    public CertificateInfoCondition andChannelKeyIsNull() {
        ew.isNull("channel_key");
        return this;
    }

    public CertificateInfoCondition orChannelKeyIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("channel_key");
        return this;
    }

    public CertificateInfoCondition andChannelKeyIsNotNull() {
        ew.isNotNull("channel_key");
        return this;
    }

    public CertificateInfoCondition orChannelKeyIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("channel_key");
        return this;
    }

    public CertificateInfoCondition andChannelKeyEq(Object value) {
        ew.eq("channel_key", value);
        return this;
    }

    public CertificateInfoCondition orChannelKeyEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("channel_key", value);
        return this;
    }

    public CertificateInfoCondition andChannelKeyNe(Object value) {
        ew.ne("channel_key", value);
        return this;
    }

    public CertificateInfoCondition orChannelKeyNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("channel_key", value);
        return this;
    }

    public CertificateInfoCondition andChannelKeyGt(Object value) {
        ew.gt("channel_key", value);
        return this;
    }

    public CertificateInfoCondition orChannelKeyGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("channel_key", value);
        return this;
    }

    public CertificateInfoCondition andChannelKeyGe(Object value) {
        ew.ge("channel_key", value);
        return this;
    }

    public CertificateInfoCondition orChannelKeyGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("channel_key", value);
        return this;
    }

    public CertificateInfoCondition andChannelKeyLt(Object value) {
        ew.lt("channel_key", value);
        return this;
    }

    public CertificateInfoCondition orChannelKeyLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("channel_key", value);
        return this;
    }

    public CertificateInfoCondition andChannelKeyLe(Object value) {
        ew.le("channel_key", value);
        return this;
    }

    public CertificateInfoCondition orChannelKeyLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("channel_key", value);
        return this;
    }

    public CertificateInfoCondition andChannelKeyIn(Object... value) {
        ew.in("channel_key", value);
        return this;
    }

    public CertificateInfoCondition orChannelKeyIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("channel_key", value);
        return this;
    }

    public CertificateInfoCondition andChannelKeyNotIn(Object... value) {
        ew.notIn("channel_key", value);
        return this;
    }

    public CertificateInfoCondition orChannelKeyNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("channel_key", value);
        return this;
    }

    public CertificateInfoCondition andChannelKeyBetween(Object value, Object value1) {
        ew.between("channel_key", value, value1);
        return this;
    }

    public CertificateInfoCondition orChannelKeyBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("channel_key", value, value1);
        return this;
    }

    public CertificateInfoCondition andChannelKeyNotBetween(Object value, Object value1) {
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public CertificateInfoCondition orChannelKeyNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("channel_key", value, value1);
        return this;
    }

    public CertificateInfoCondition andChannelKeyLike(String value) {
        ew.like("channel_key", value);
        return this;
    }

    public CertificateInfoCondition orChannelKeyLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("channel_key", value);
        return this;
    }

    public CertificateInfoCondition andChannelKeyNotLike(String value) {
        ew.notLike("channel_key", value);
        return this;
    }

    public CertificateInfoCondition orChannelKeyNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("channel_key", value);
        return this;
    }

    public CertificateInfoCondition andProductCodeIsNull() {
        ew.isNull("product_code");
        return this;
    }

    public CertificateInfoCondition orProductCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("product_code");
        return this;
    }

    public CertificateInfoCondition andProductCodeIsNotNull() {
        ew.isNotNull("product_code");
        return this;
    }

    public CertificateInfoCondition orProductCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("product_code");
        return this;
    }

    public CertificateInfoCondition andProductCodeEq(Object value) {
        ew.eq("product_code", value);
        return this;
    }

    public CertificateInfoCondition orProductCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("product_code", value);
        return this;
    }

    public CertificateInfoCondition andProductCodeNe(Object value) {
        ew.ne("product_code", value);
        return this;
    }

    public CertificateInfoCondition orProductCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("product_code", value);
        return this;
    }

    public CertificateInfoCondition andProductCodeGt(Object value) {
        ew.gt("product_code", value);
        return this;
    }

    public CertificateInfoCondition orProductCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("product_code", value);
        return this;
    }

    public CertificateInfoCondition andProductCodeGe(Object value) {
        ew.ge("product_code", value);
        return this;
    }

    public CertificateInfoCondition orProductCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("product_code", value);
        return this;
    }

    public CertificateInfoCondition andProductCodeLt(Object value) {
        ew.lt("product_code", value);
        return this;
    }

    public CertificateInfoCondition orProductCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("product_code", value);
        return this;
    }

    public CertificateInfoCondition andProductCodeLe(Object value) {
        ew.le("product_code", value);
        return this;
    }

    public CertificateInfoCondition orProductCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("product_code", value);
        return this;
    }

    public CertificateInfoCondition andProductCodeIn(Object... value) {
        ew.in("product_code", value);
        return this;
    }

    public CertificateInfoCondition orProductCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("product_code", value);
        return this;
    }

    public CertificateInfoCondition andProductCodeNotIn(Object... value) {
        ew.notIn("product_code", value);
        return this;
    }

    public CertificateInfoCondition orProductCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("product_code", value);
        return this;
    }

    public CertificateInfoCondition andProductCodeBetween(Object value, Object value1) {
        ew.between("product_code", value, value1);
        return this;
    }

    public CertificateInfoCondition orProductCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("product_code", value, value1);
        return this;
    }

    public CertificateInfoCondition andProductCodeNotBetween(Object value, Object value1) {
        ew.notBetween("product_code", value, value1);
        return this;
    }

    public CertificateInfoCondition orProductCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("product_code", value, value1);
        return this;
    }

    public CertificateInfoCondition andProductCodeLike(String value) {
        ew.like("product_code", value);
        return this;
    }

    public CertificateInfoCondition orProductCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("product_code", value);
        return this;
    }

    public CertificateInfoCondition andProductCodeNotLike(String value) {
        ew.notLike("product_code", value);
        return this;
    }

    public CertificateInfoCondition orProductCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("product_code", value);
        return this;
    }

    public CertificateInfoCondition andOrgCodeIsNull() {
        ew.isNull("org_code");
        return this;
    }

    public CertificateInfoCondition orOrgCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("org_code");
        return this;
    }

    public CertificateInfoCondition andOrgCodeIsNotNull() {
        ew.isNotNull("org_code");
        return this;
    }

    public CertificateInfoCondition orOrgCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("org_code");
        return this;
    }

    public CertificateInfoCondition andOrgCodeEq(Object value) {
        ew.eq("org_code", value);
        return this;
    }

    public CertificateInfoCondition orOrgCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("org_code", value);
        return this;
    }

    public CertificateInfoCondition andOrgCodeNe(Object value) {
        ew.ne("org_code", value);
        return this;
    }

    public CertificateInfoCondition orOrgCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("org_code", value);
        return this;
    }

    public CertificateInfoCondition andOrgCodeGt(Object value) {
        ew.gt("org_code", value);
        return this;
    }

    public CertificateInfoCondition orOrgCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("org_code", value);
        return this;
    }

    public CertificateInfoCondition andOrgCodeGe(Object value) {
        ew.ge("org_code", value);
        return this;
    }

    public CertificateInfoCondition orOrgCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("org_code", value);
        return this;
    }

    public CertificateInfoCondition andOrgCodeLt(Object value) {
        ew.lt("org_code", value);
        return this;
    }

    public CertificateInfoCondition orOrgCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("org_code", value);
        return this;
    }

    public CertificateInfoCondition andOrgCodeLe(Object value) {
        ew.le("org_code", value);
        return this;
    }

    public CertificateInfoCondition orOrgCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("org_code", value);
        return this;
    }

    public CertificateInfoCondition andOrgCodeIn(Object... value) {
        ew.in("org_code", value);
        return this;
    }

    public CertificateInfoCondition orOrgCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("org_code", value);
        return this;
    }

    public CertificateInfoCondition andOrgCodeNotIn(Object... value) {
        ew.notIn("org_code", value);
        return this;
    }

    public CertificateInfoCondition orOrgCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("org_code", value);
        return this;
    }

    public CertificateInfoCondition andOrgCodeBetween(Object value, Object value1) {
        ew.between("org_code", value, value1);
        return this;
    }

    public CertificateInfoCondition orOrgCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("org_code", value, value1);
        return this;
    }

    public CertificateInfoCondition andOrgCodeNotBetween(Object value, Object value1) {
        ew.notBetween("org_code", value, value1);
        return this;
    }

    public CertificateInfoCondition orOrgCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("org_code", value, value1);
        return this;
    }

    public CertificateInfoCondition andOrgCodeLike(String value) {
        ew.like("org_code", value);
        return this;
    }

    public CertificateInfoCondition orOrgCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("org_code", value);
        return this;
    }

    public CertificateInfoCondition andOrgCodeNotLike(String value) {
        ew.notLike("org_code", value);
        return this;
    }

    public CertificateInfoCondition orOrgCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("org_code", value);
        return this;
    }

    public CertificateInfoCondition andOrgNameIsNull() {
        ew.isNull("org_name");
        return this;
    }

    public CertificateInfoCondition orOrgNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("org_name");
        return this;
    }

    public CertificateInfoCondition andOrgNameIsNotNull() {
        ew.isNotNull("org_name");
        return this;
    }

    public CertificateInfoCondition orOrgNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("org_name");
        return this;
    }

    public CertificateInfoCondition andOrgNameEq(Object value) {
        ew.eq("org_name", value);
        return this;
    }

    public CertificateInfoCondition orOrgNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("org_name", value);
        return this;
    }

    public CertificateInfoCondition andOrgNameNe(Object value) {
        ew.ne("org_name", value);
        return this;
    }

    public CertificateInfoCondition orOrgNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("org_name", value);
        return this;
    }

    public CertificateInfoCondition andOrgNameGt(Object value) {
        ew.gt("org_name", value);
        return this;
    }

    public CertificateInfoCondition orOrgNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("org_name", value);
        return this;
    }

    public CertificateInfoCondition andOrgNameGe(Object value) {
        ew.ge("org_name", value);
        return this;
    }

    public CertificateInfoCondition orOrgNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("org_name", value);
        return this;
    }

    public CertificateInfoCondition andOrgNameLt(Object value) {
        ew.lt("org_name", value);
        return this;
    }

    public CertificateInfoCondition orOrgNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("org_name", value);
        return this;
    }

    public CertificateInfoCondition andOrgNameLe(Object value) {
        ew.le("org_name", value);
        return this;
    }

    public CertificateInfoCondition orOrgNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("org_name", value);
        return this;
    }

    public CertificateInfoCondition andOrgNameIn(Object... value) {
        ew.in("org_name", value);
        return this;
    }

    public CertificateInfoCondition orOrgNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("org_name", value);
        return this;
    }

    public CertificateInfoCondition andOrgNameNotIn(Object... value) {
        ew.notIn("org_name", value);
        return this;
    }

    public CertificateInfoCondition orOrgNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("org_name", value);
        return this;
    }

    public CertificateInfoCondition andOrgNameBetween(Object value, Object value1) {
        ew.between("org_name", value, value1);
        return this;
    }

    public CertificateInfoCondition orOrgNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("org_name", value, value1);
        return this;
    }

    public CertificateInfoCondition andOrgNameNotBetween(Object value, Object value1) {
        ew.notBetween("org_name", value, value1);
        return this;
    }

    public CertificateInfoCondition orOrgNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("org_name", value, value1);
        return this;
    }

    public CertificateInfoCondition andOrgNameLike(String value) {
        ew.like("org_name", value);
        return this;
    }

    public CertificateInfoCondition orOrgNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("org_name", value);
        return this;
    }

    public CertificateInfoCondition andOrgNameNotLike(String value) {
        ew.notLike("org_name", value);
        return this;
    }

    public CertificateInfoCondition orOrgNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("org_name", value);
        return this;
    }

    public CertificateInfoCondition andCertificateTypeIsNull() {
        ew.isNull("certificate_type");
        return this;
    }

    public CertificateInfoCondition orCertificateTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("certificate_type");
        return this;
    }

    public CertificateInfoCondition andCertificateTypeIsNotNull() {
        ew.isNotNull("certificate_type");
        return this;
    }

    public CertificateInfoCondition orCertificateTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("certificate_type");
        return this;
    }

    public CertificateInfoCondition andCertificateTypeEq(Object value) {
        ew.eq("certificate_type", value);
        return this;
    }

    public CertificateInfoCondition orCertificateTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("certificate_type", value);
        return this;
    }

    public CertificateInfoCondition andCertificateTypeNe(Object value) {
        ew.ne("certificate_type", value);
        return this;
    }

    public CertificateInfoCondition orCertificateTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("certificate_type", value);
        return this;
    }

    public CertificateInfoCondition andCertificateTypeGt(Object value) {
        ew.gt("certificate_type", value);
        return this;
    }

    public CertificateInfoCondition orCertificateTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("certificate_type", value);
        return this;
    }

    public CertificateInfoCondition andCertificateTypeGe(Object value) {
        ew.ge("certificate_type", value);
        return this;
    }

    public CertificateInfoCondition orCertificateTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("certificate_type", value);
        return this;
    }

    public CertificateInfoCondition andCertificateTypeLt(Object value) {
        ew.lt("certificate_type", value);
        return this;
    }

    public CertificateInfoCondition orCertificateTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("certificate_type", value);
        return this;
    }

    public CertificateInfoCondition andCertificateTypeLe(Object value) {
        ew.le("certificate_type", value);
        return this;
    }

    public CertificateInfoCondition orCertificateTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("certificate_type", value);
        return this;
    }

    public CertificateInfoCondition andCertificateTypeIn(Object... value) {
        ew.in("certificate_type", value);
        return this;
    }

    public CertificateInfoCondition orCertificateTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("certificate_type", value);
        return this;
    }

    public CertificateInfoCondition andCertificateTypeNotIn(Object... value) {
        ew.notIn("certificate_type", value);
        return this;
    }

    public CertificateInfoCondition orCertificateTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("certificate_type", value);
        return this;
    }

    public CertificateInfoCondition andCertificateTypeBetween(Object value, Object value1) {
        ew.between("certificate_type", value, value1);
        return this;
    }

    public CertificateInfoCondition orCertificateTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("certificate_type", value, value1);
        return this;
    }

    public CertificateInfoCondition andCertificateTypeNotBetween(Object value, Object value1) {
        ew.notBetween("certificate_type", value, value1);
        return this;
    }

    public CertificateInfoCondition orCertificateTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("certificate_type", value, value1);
        return this;
    }

    public CertificateInfoCondition andCertificateTypeLike(String value) {
        ew.like("certificate_type", value);
        return this;
    }

    public CertificateInfoCondition orCertificateTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("certificate_type", value);
        return this;
    }

    public CertificateInfoCondition andCertificateTypeNotLike(String value) {
        ew.notLike("certificate_type", value);
        return this;
    }

    public CertificateInfoCondition orCertificateTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("certificate_type", value);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyPasswordIsNull() {
        ew.isNull("private_key_password");
        return this;
    }

    public CertificateInfoCondition orPrivateKeyPasswordIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("private_key_password");
        return this;
    }

    public CertificateInfoCondition andPrivateKeyPasswordIsNotNull() {
        ew.isNotNull("private_key_password");
        return this;
    }

    public CertificateInfoCondition orPrivateKeyPasswordIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("private_key_password");
        return this;
    }

    public CertificateInfoCondition andPrivateKeyPasswordEq(Object value) {
        ew.eq("private_key_password", value);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyPasswordEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("private_key_password", value);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyPasswordNe(Object value) {
        ew.ne("private_key_password", value);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyPasswordNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("private_key_password", value);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyPasswordGt(Object value) {
        ew.gt("private_key_password", value);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyPasswordGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("private_key_password", value);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyPasswordGe(Object value) {
        ew.ge("private_key_password", value);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyPasswordGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("private_key_password", value);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyPasswordLt(Object value) {
        ew.lt("private_key_password", value);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyPasswordLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("private_key_password", value);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyPasswordLe(Object value) {
        ew.le("private_key_password", value);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyPasswordLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("private_key_password", value);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyPasswordIn(Object... value) {
        ew.in("private_key_password", value);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyPasswordIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("private_key_password", value);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyPasswordNotIn(Object... value) {
        ew.notIn("private_key_password", value);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyPasswordNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("private_key_password", value);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyPasswordBetween(Object value, Object value1) {
        ew.between("private_key_password", value, value1);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyPasswordBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("private_key_password", value, value1);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyPasswordNotBetween(Object value, Object value1) {
        ew.notBetween("private_key_password", value, value1);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyPasswordNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("private_key_password", value, value1);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyPasswordLike(String value) {
        ew.like("private_key_password", value);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyPasswordLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("private_key_password", value);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyPasswordNotLike(String value) {
        ew.notLike("private_key_password", value);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyPasswordNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("private_key_password", value);
        return this;
    }

    public CertificateInfoCondition andPrivateStorePasswordIsNull() {
        ew.isNull("private_store_password");
        return this;
    }

    public CertificateInfoCondition orPrivateStorePasswordIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("private_store_password");
        return this;
    }

    public CertificateInfoCondition andPrivateStorePasswordIsNotNull() {
        ew.isNotNull("private_store_password");
        return this;
    }

    public CertificateInfoCondition orPrivateStorePasswordIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("private_store_password");
        return this;
    }

    public CertificateInfoCondition andPrivateStorePasswordEq(Object value) {
        ew.eq("private_store_password", value);
        return this;
    }

    public CertificateInfoCondition orPrivateStorePasswordEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("private_store_password", value);
        return this;
    }

    public CertificateInfoCondition andPrivateStorePasswordNe(Object value) {
        ew.ne("private_store_password", value);
        return this;
    }

    public CertificateInfoCondition orPrivateStorePasswordNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("private_store_password", value);
        return this;
    }

    public CertificateInfoCondition andPrivateStorePasswordGt(Object value) {
        ew.gt("private_store_password", value);
        return this;
    }

    public CertificateInfoCondition orPrivateStorePasswordGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("private_store_password", value);
        return this;
    }

    public CertificateInfoCondition andPrivateStorePasswordGe(Object value) {
        ew.ge("private_store_password", value);
        return this;
    }

    public CertificateInfoCondition orPrivateStorePasswordGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("private_store_password", value);
        return this;
    }

    public CertificateInfoCondition andPrivateStorePasswordLt(Object value) {
        ew.lt("private_store_password", value);
        return this;
    }

    public CertificateInfoCondition orPrivateStorePasswordLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("private_store_password", value);
        return this;
    }

    public CertificateInfoCondition andPrivateStorePasswordLe(Object value) {
        ew.le("private_store_password", value);
        return this;
    }

    public CertificateInfoCondition orPrivateStorePasswordLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("private_store_password", value);
        return this;
    }

    public CertificateInfoCondition andPrivateStorePasswordIn(Object... value) {
        ew.in("private_store_password", value);
        return this;
    }

    public CertificateInfoCondition orPrivateStorePasswordIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("private_store_password", value);
        return this;
    }

    public CertificateInfoCondition andPrivateStorePasswordNotIn(Object... value) {
        ew.notIn("private_store_password", value);
        return this;
    }

    public CertificateInfoCondition orPrivateStorePasswordNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("private_store_password", value);
        return this;
    }

    public CertificateInfoCondition andPrivateStorePasswordBetween(Object value, Object value1) {
        ew.between("private_store_password", value, value1);
        return this;
    }

    public CertificateInfoCondition orPrivateStorePasswordBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("private_store_password", value, value1);
        return this;
    }

    public CertificateInfoCondition andPrivateStorePasswordNotBetween(Object value, Object value1) {
        ew.notBetween("private_store_password", value, value1);
        return this;
    }

    public CertificateInfoCondition orPrivateStorePasswordNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("private_store_password", value, value1);
        return this;
    }

    public CertificateInfoCondition andPrivateStorePasswordLike(String value) {
        ew.like("private_store_password", value);
        return this;
    }

    public CertificateInfoCondition orPrivateStorePasswordLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("private_store_password", value);
        return this;
    }

    public CertificateInfoCondition andPrivateStorePasswordNotLike(String value) {
        ew.notLike("private_store_password", value);
        return this;
    }

    public CertificateInfoCondition orPrivateStorePasswordNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("private_store_password", value);
        return this;
    }

    public CertificateInfoCondition andEffectiveDateIsNull() {
        ew.isNull("effective_date");
        return this;
    }

    public CertificateInfoCondition orEffectiveDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("effective_date");
        return this;
    }

    public CertificateInfoCondition andEffectiveDateIsNotNull() {
        ew.isNotNull("effective_date");
        return this;
    }

    public CertificateInfoCondition orEffectiveDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("effective_date");
        return this;
    }

    public CertificateInfoCondition andEffectiveDateEq(Object value) {
        ew.eq("effective_date", value);
        return this;
    }

    public CertificateInfoCondition orEffectiveDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("effective_date", value);
        return this;
    }

    public CertificateInfoCondition andEffectiveDateNe(Object value) {
        ew.ne("effective_date", value);
        return this;
    }

    public CertificateInfoCondition orEffectiveDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("effective_date", value);
        return this;
    }

    public CertificateInfoCondition andEffectiveDateGt(Object value) {
        ew.gt("effective_date", value);
        return this;
    }

    public CertificateInfoCondition orEffectiveDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("effective_date", value);
        return this;
    }

    public CertificateInfoCondition andEffectiveDateGe(Object value) {
        ew.ge("effective_date", value);
        return this;
    }

    public CertificateInfoCondition orEffectiveDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("effective_date", value);
        return this;
    }

    public CertificateInfoCondition andEffectiveDateLt(Object value) {
        ew.lt("effective_date", value);
        return this;
    }

    public CertificateInfoCondition orEffectiveDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("effective_date", value);
        return this;
    }

    public CertificateInfoCondition andEffectiveDateLe(Object value) {
        ew.le("effective_date", value);
        return this;
    }

    public CertificateInfoCondition orEffectiveDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("effective_date", value);
        return this;
    }

    public CertificateInfoCondition andEffectiveDateIn(Object... value) {
        ew.in("effective_date", value);
        return this;
    }

    public CertificateInfoCondition orEffectiveDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("effective_date", value);
        return this;
    }

    public CertificateInfoCondition andEffectiveDateNotIn(Object... value) {
        ew.notIn("effective_date", value);
        return this;
    }

    public CertificateInfoCondition orEffectiveDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("effective_date", value);
        return this;
    }

    public CertificateInfoCondition andEffectiveDateBetween(Object value, Object value1) {
        ew.between("effective_date", value, value1);
        return this;
    }

    public CertificateInfoCondition orEffectiveDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("effective_date", value, value1);
        return this;
    }

    public CertificateInfoCondition andEffectiveDateNotBetween(Object value, Object value1) {
        ew.notBetween("effective_date", value, value1);
        return this;
    }

    public CertificateInfoCondition orEffectiveDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("effective_date", value, value1);
        return this;
    }

    public CertificateInfoCondition andEffectiveDateLike(String value) {
        ew.like("effective_date", value);
        return this;
    }

    public CertificateInfoCondition orEffectiveDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("effective_date", value);
        return this;
    }

    public CertificateInfoCondition andEffectiveDateNotLike(String value) {
        ew.notLike("effective_date", value);
        return this;
    }

    public CertificateInfoCondition orEffectiveDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("effective_date", value);
        return this;
    }

    public CertificateInfoCondition andExpirationDateIsNull() {
        ew.isNull("expiration_date");
        return this;
    }

    public CertificateInfoCondition orExpirationDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("expiration_date");
        return this;
    }

    public CertificateInfoCondition andExpirationDateIsNotNull() {
        ew.isNotNull("expiration_date");
        return this;
    }

    public CertificateInfoCondition orExpirationDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("expiration_date");
        return this;
    }

    public CertificateInfoCondition andExpirationDateEq(Object value) {
        ew.eq("expiration_date", value);
        return this;
    }

    public CertificateInfoCondition orExpirationDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("expiration_date", value);
        return this;
    }

    public CertificateInfoCondition andExpirationDateNe(Object value) {
        ew.ne("expiration_date", value);
        return this;
    }

    public CertificateInfoCondition orExpirationDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("expiration_date", value);
        return this;
    }

    public CertificateInfoCondition andExpirationDateGt(Object value) {
        ew.gt("expiration_date", value);
        return this;
    }

    public CertificateInfoCondition orExpirationDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("expiration_date", value);
        return this;
    }

    public CertificateInfoCondition andExpirationDateGe(Object value) {
        ew.ge("expiration_date", value);
        return this;
    }

    public CertificateInfoCondition orExpirationDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("expiration_date", value);
        return this;
    }

    public CertificateInfoCondition andExpirationDateLt(Object value) {
        ew.lt("expiration_date", value);
        return this;
    }

    public CertificateInfoCondition orExpirationDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("expiration_date", value);
        return this;
    }

    public CertificateInfoCondition andExpirationDateLe(Object value) {
        ew.le("expiration_date", value);
        return this;
    }

    public CertificateInfoCondition orExpirationDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("expiration_date", value);
        return this;
    }

    public CertificateInfoCondition andExpirationDateIn(Object... value) {
        ew.in("expiration_date", value);
        return this;
    }

    public CertificateInfoCondition orExpirationDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("expiration_date", value);
        return this;
    }

    public CertificateInfoCondition andExpirationDateNotIn(Object... value) {
        ew.notIn("expiration_date", value);
        return this;
    }

    public CertificateInfoCondition orExpirationDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("expiration_date", value);
        return this;
    }

    public CertificateInfoCondition andExpirationDateBetween(Object value, Object value1) {
        ew.between("expiration_date", value, value1);
        return this;
    }

    public CertificateInfoCondition orExpirationDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("expiration_date", value, value1);
        return this;
    }

    public CertificateInfoCondition andExpirationDateNotBetween(Object value, Object value1) {
        ew.notBetween("expiration_date", value, value1);
        return this;
    }

    public CertificateInfoCondition orExpirationDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("expiration_date", value, value1);
        return this;
    }

    public CertificateInfoCondition andExpirationDateLike(String value) {
        ew.like("expiration_date", value);
        return this;
    }

    public CertificateInfoCondition orExpirationDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("expiration_date", value);
        return this;
    }

    public CertificateInfoCondition andExpirationDateNotLike(String value) {
        ew.notLike("expiration_date", value);
        return this;
    }

    public CertificateInfoCondition orExpirationDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("expiration_date", value);
        return this;
    }

    public CertificateInfoCondition andCertificatePathIsNull() {
        ew.isNull("certificate_path");
        return this;
    }

    public CertificateInfoCondition orCertificatePathIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("certificate_path");
        return this;
    }

    public CertificateInfoCondition andCertificatePathIsNotNull() {
        ew.isNotNull("certificate_path");
        return this;
    }

    public CertificateInfoCondition orCertificatePathIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("certificate_path");
        return this;
    }

    public CertificateInfoCondition andCertificatePathEq(Object value) {
        ew.eq("certificate_path", value);
        return this;
    }

    public CertificateInfoCondition orCertificatePathEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("certificate_path", value);
        return this;
    }

    public CertificateInfoCondition andCertificatePathNe(Object value) {
        ew.ne("certificate_path", value);
        return this;
    }

    public CertificateInfoCondition orCertificatePathNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("certificate_path", value);
        return this;
    }

    public CertificateInfoCondition andCertificatePathGt(Object value) {
        ew.gt("certificate_path", value);
        return this;
    }

    public CertificateInfoCondition orCertificatePathGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("certificate_path", value);
        return this;
    }

    public CertificateInfoCondition andCertificatePathGe(Object value) {
        ew.ge("certificate_path", value);
        return this;
    }

    public CertificateInfoCondition orCertificatePathGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("certificate_path", value);
        return this;
    }

    public CertificateInfoCondition andCertificatePathLt(Object value) {
        ew.lt("certificate_path", value);
        return this;
    }

    public CertificateInfoCondition orCertificatePathLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("certificate_path", value);
        return this;
    }

    public CertificateInfoCondition andCertificatePathLe(Object value) {
        ew.le("certificate_path", value);
        return this;
    }

    public CertificateInfoCondition orCertificatePathLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("certificate_path", value);
        return this;
    }

    public CertificateInfoCondition andCertificatePathIn(Object... value) {
        ew.in("certificate_path", value);
        return this;
    }

    public CertificateInfoCondition orCertificatePathIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("certificate_path", value);
        return this;
    }

    public CertificateInfoCondition andCertificatePathNotIn(Object... value) {
        ew.notIn("certificate_path", value);
        return this;
    }

    public CertificateInfoCondition orCertificatePathNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("certificate_path", value);
        return this;
    }

    public CertificateInfoCondition andCertificatePathBetween(Object value, Object value1) {
        ew.between("certificate_path", value, value1);
        return this;
    }

    public CertificateInfoCondition orCertificatePathBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("certificate_path", value, value1);
        return this;
    }

    public CertificateInfoCondition andCertificatePathNotBetween(Object value, Object value1) {
        ew.notBetween("certificate_path", value, value1);
        return this;
    }

    public CertificateInfoCondition orCertificatePathNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("certificate_path", value, value1);
        return this;
    }

    public CertificateInfoCondition andCertificatePathLike(String value) {
        ew.like("certificate_path", value);
        return this;
    }

    public CertificateInfoCondition orCertificatePathLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("certificate_path", value);
        return this;
    }

    public CertificateInfoCondition andCertificatePathNotLike(String value) {
        ew.notLike("certificate_path", value);
        return this;
    }

    public CertificateInfoCondition orCertificatePathNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("certificate_path", value);
        return this;
    }

    public CertificateInfoCondition andStatusIsNull() {
        ew.isNull("status");
        return this;
    }

    public CertificateInfoCondition orStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("status");
        return this;
    }

    public CertificateInfoCondition andStatusIsNotNull() {
        ew.isNotNull("status");
        return this;
    }

    public CertificateInfoCondition orStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("status");
        return this;
    }

    public CertificateInfoCondition andStatusEq(Object value) {
        ew.eq("status", value);
        return this;
    }

    public CertificateInfoCondition orStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("status", value);
        return this;
    }

    public CertificateInfoCondition andStatusNe(Object value) {
        ew.ne("status", value);
        return this;
    }

    public CertificateInfoCondition orStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("status", value);
        return this;
    }

    public CertificateInfoCondition andStatusGt(Object value) {
        ew.gt("status", value);
        return this;
    }

    public CertificateInfoCondition orStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("status", value);
        return this;
    }

    public CertificateInfoCondition andStatusGe(Object value) {
        ew.ge("status", value);
        return this;
    }

    public CertificateInfoCondition orStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("status", value);
        return this;
    }

    public CertificateInfoCondition andStatusLt(Object value) {
        ew.lt("status", value);
        return this;
    }

    public CertificateInfoCondition orStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("status", value);
        return this;
    }

    public CertificateInfoCondition andStatusLe(Object value) {
        ew.le("status", value);
        return this;
    }

    public CertificateInfoCondition orStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("status", value);
        return this;
    }

    public CertificateInfoCondition andStatusIn(Object... value) {
        ew.in("status", value);
        return this;
    }

    public CertificateInfoCondition orStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("status", value);
        return this;
    }

    public CertificateInfoCondition andStatusNotIn(Object... value) {
        ew.notIn("status", value);
        return this;
    }

    public CertificateInfoCondition orStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("status", value);
        return this;
    }

    public CertificateInfoCondition andStatusBetween(Object value, Object value1) {
        ew.between("status", value, value1);
        return this;
    }

    public CertificateInfoCondition orStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("status", value, value1);
        return this;
    }

    public CertificateInfoCondition andStatusNotBetween(Object value, Object value1) {
        ew.notBetween("status", value, value1);
        return this;
    }

    public CertificateInfoCondition orStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("status", value, value1);
        return this;
    }

    public CertificateInfoCondition andStatusLike(String value) {
        ew.like("status", value);
        return this;
    }

    public CertificateInfoCondition orStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("status", value);
        return this;
    }

    public CertificateInfoCondition andStatusNotLike(String value) {
        ew.notLike("status", value);
        return this;
    }

    public CertificateInfoCondition orStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("status", value);
        return this;
    }

    public CertificateInfoCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public CertificateInfoCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public CertificateInfoCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public CertificateInfoCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public CertificateInfoCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public CertificateInfoCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public CertificateInfoCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public CertificateInfoCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public CertificateInfoCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public CertificateInfoCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public CertificateInfoCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public CertificateInfoCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public CertificateInfoCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public CertificateInfoCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public CertificateInfoCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public CertificateInfoCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public CertificateInfoCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public CertificateInfoCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public CertificateInfoCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public CertificateInfoCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public CertificateInfoCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public CertificateInfoCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public CertificateInfoCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public CertificateInfoCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public CertificateInfoCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public CertificateInfoCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public CertificateInfoCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public CertificateInfoCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }

    public CertificateInfoCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public CertificateInfoCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public CertificateInfoCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public CertificateInfoCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public CertificateInfoCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public CertificateInfoCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public CertificateInfoCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public CertificateInfoCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public CertificateInfoCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public CertificateInfoCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public CertificateInfoCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public CertificateInfoCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public CertificateInfoCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public CertificateInfoCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public CertificateInfoCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public CertificateInfoCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public CertificateInfoCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public CertificateInfoCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public CertificateInfoCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public CertificateInfoCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public CertificateInfoCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public CertificateInfoCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public CertificateInfoCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public CertificateInfoCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public CertificateInfoCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public CertificateInfoCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public CertificateInfoCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public CertificateInfoCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public CertificateInfoCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public CertificateInfoCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public CertificateInfoCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public CertificateInfoCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public CertificateInfoCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public CertificateInfoCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public CertificateInfoCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public CertificateInfoCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public CertificateInfoCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public CertificateInfoCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public CertificateInfoCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public CertificateInfoCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public CertificateInfoCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public CertificateInfoCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public CertificateInfoCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public CertificateInfoCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public CertificateInfoCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public CertificateInfoCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public CertificateInfoCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public CertificateInfoCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public CertificateInfoCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public CertificateInfoCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public CertificateInfoCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public CertificateInfoCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public CertificateInfoCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public CertificateInfoCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public CertificateInfoCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public CertificateInfoCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public CertificateInfoCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public CertificateInfoCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public CertificateInfoCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public CertificateInfoCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public CertificateInfoCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public CertificateInfoCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public CertificateInfoCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public CertificateInfoCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public CertificateInfoCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public CertificateInfoCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public CertificateInfoCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public CertificateInfoCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public CertificateInfoCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public CertificateInfoCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public CertificateInfoCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public CertificateInfoCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public CertificateInfoCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public CertificateInfoCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public CertificateInfoCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public CertificateInfoCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public CertificateInfoCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public CertificateInfoCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public CertificateInfoCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public CertificateInfoCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public CertificateInfoCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public CertificateInfoCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public CertificateInfoCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public CertificateInfoCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public CertificateInfoCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public CertificateInfoCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public CertificateInfoCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public CertificateInfoCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public CertificateInfoCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public CertificateInfoCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public CertificateInfoCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public CertificateInfoCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public CertificateInfoCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public CertificateInfoCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public CertificateInfoCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public CertificateInfoCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public CertificateInfoCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public CertificateInfoCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public CertificateInfoCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public CertificateInfoCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public CertificateInfoCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public CertificateInfoCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public CertificateInfoCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public CertificateInfoCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public CertificateInfoCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public CertificateInfoCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public CertificateInfoCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public CertificateInfoCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public CertificateInfoCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public CertificateInfoCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public CertificateInfoCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public CertificateInfoCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyIsNull() {
        ew.isNull("private_key");
        return this;
    }

    public CertificateInfoCondition orPrivateKeyIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("private_key");
        return this;
    }

    public CertificateInfoCondition andPrivateKeyIsNotNull() {
        ew.isNotNull("private_key");
        return this;
    }

    public CertificateInfoCondition orPrivateKeyIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("private_key");
        return this;
    }

    public CertificateInfoCondition andPrivateKeyEq(Object value) {
        ew.eq("private_key", value);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("private_key", value);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyNe(Object value) {
        ew.ne("private_key", value);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("private_key", value);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyGt(Object value) {
        ew.gt("private_key", value);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("private_key", value);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyGe(Object value) {
        ew.ge("private_key", value);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("private_key", value);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyLt(Object value) {
        ew.lt("private_key", value);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("private_key", value);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyLe(Object value) {
        ew.le("private_key", value);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("private_key", value);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyIn(Object... value) {
        ew.in("private_key", value);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("private_key", value);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyNotIn(Object... value) {
        ew.notIn("private_key", value);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("private_key", value);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyBetween(Object value, Object value1) {
        ew.between("private_key", value, value1);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("private_key", value, value1);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyNotBetween(Object value, Object value1) {
        ew.notBetween("private_key", value, value1);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("private_key", value, value1);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyLike(String value) {
        ew.like("private_key", value);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("private_key", value);
        return this;
    }

    public CertificateInfoCondition andPrivateKeyNotLike(String value) {
        ew.notLike("private_key", value);
        return this;
    }

    public CertificateInfoCondition orPrivateKeyNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("private_key", value);
        return this;
    }

    public CertificateInfoCondition andPublicKeyIsNull() {
        ew.isNull("public_key");
        return this;
    }

    public CertificateInfoCondition orPublicKeyIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("public_key");
        return this;
    }

    public CertificateInfoCondition andPublicKeyIsNotNull() {
        ew.isNotNull("public_key");
        return this;
    }

    public CertificateInfoCondition orPublicKeyIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("public_key");
        return this;
    }

    public CertificateInfoCondition andPublicKeyEq(Object value) {
        ew.eq("public_key", value);
        return this;
    }

    public CertificateInfoCondition orPublicKeyEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("public_key", value);
        return this;
    }

    public CertificateInfoCondition andPublicKeyNe(Object value) {
        ew.ne("public_key", value);
        return this;
    }

    public CertificateInfoCondition orPublicKeyNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("public_key", value);
        return this;
    }

    public CertificateInfoCondition andPublicKeyGt(Object value) {
        ew.gt("public_key", value);
        return this;
    }

    public CertificateInfoCondition orPublicKeyGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("public_key", value);
        return this;
    }

    public CertificateInfoCondition andPublicKeyGe(Object value) {
        ew.ge("public_key", value);
        return this;
    }

    public CertificateInfoCondition orPublicKeyGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("public_key", value);
        return this;
    }

    public CertificateInfoCondition andPublicKeyLt(Object value) {
        ew.lt("public_key", value);
        return this;
    }

    public CertificateInfoCondition orPublicKeyLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("public_key", value);
        return this;
    }

    public CertificateInfoCondition andPublicKeyLe(Object value) {
        ew.le("public_key", value);
        return this;
    }

    public CertificateInfoCondition orPublicKeyLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("public_key", value);
        return this;
    }

    public CertificateInfoCondition andPublicKeyIn(Object... value) {
        ew.in("public_key", value);
        return this;
    }

    public CertificateInfoCondition orPublicKeyIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("public_key", value);
        return this;
    }

    public CertificateInfoCondition andPublicKeyNotIn(Object... value) {
        ew.notIn("public_key", value);
        return this;
    }

    public CertificateInfoCondition orPublicKeyNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("public_key", value);
        return this;
    }

    public CertificateInfoCondition andPublicKeyBetween(Object value, Object value1) {
        ew.between("public_key", value, value1);
        return this;
    }

    public CertificateInfoCondition orPublicKeyBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("public_key", value, value1);
        return this;
    }

    public CertificateInfoCondition andPublicKeyNotBetween(Object value, Object value1) {
        ew.notBetween("public_key", value, value1);
        return this;
    }

    public CertificateInfoCondition orPublicKeyNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("public_key", value, value1);
        return this;
    }

    public CertificateInfoCondition andPublicKeyLike(String value) {
        ew.like("public_key", value);
        return this;
    }

    public CertificateInfoCondition orPublicKeyLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("public_key", value);
        return this;
    }

    public CertificateInfoCondition andPublicKeyNotLike(String value) {
        ew.notLike("public_key", value);
        return this;
    }

    public CertificateInfoCondition orPublicKeyNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("public_key", value);
        return this;
    }

    public CertificateInfoCondition andCertificateFileIsNull() {
        ew.isNull("certificate_file");
        return this;
    }

    public CertificateInfoCondition orCertificateFileIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("certificate_file");
        return this;
    }

    public CertificateInfoCondition andCertificateFileIsNotNull() {
        ew.isNotNull("certificate_file");
        return this;
    }

    public CertificateInfoCondition orCertificateFileIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("certificate_file");
        return this;
    }

    public CertificateInfoCondition andCertificateFileEq(Object value) {
        ew.eq("certificate_file", value);
        return this;
    }

    public CertificateInfoCondition orCertificateFileEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("certificate_file", value);
        return this;
    }

    public CertificateInfoCondition andCertificateFileNe(Object value) {
        ew.ne("certificate_file", value);
        return this;
    }

    public CertificateInfoCondition orCertificateFileNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("certificate_file", value);
        return this;
    }

    public CertificateInfoCondition andCertificateFileGt(Object value) {
        ew.gt("certificate_file", value);
        return this;
    }

    public CertificateInfoCondition orCertificateFileGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("certificate_file", value);
        return this;
    }

    public CertificateInfoCondition andCertificateFileGe(Object value) {
        ew.ge("certificate_file", value);
        return this;
    }

    public CertificateInfoCondition orCertificateFileGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("certificate_file", value);
        return this;
    }

    public CertificateInfoCondition andCertificateFileLt(Object value) {
        ew.lt("certificate_file", value);
        return this;
    }

    public CertificateInfoCondition orCertificateFileLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("certificate_file", value);
        return this;
    }

    public CertificateInfoCondition andCertificateFileLe(Object value) {
        ew.le("certificate_file", value);
        return this;
    }

    public CertificateInfoCondition orCertificateFileLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("certificate_file", value);
        return this;
    }

    public CertificateInfoCondition andCertificateFileIn(Object... value) {
        ew.in("certificate_file", value);
        return this;
    }

    public CertificateInfoCondition orCertificateFileIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("certificate_file", value);
        return this;
    }

    public CertificateInfoCondition andCertificateFileNotIn(Object... value) {
        ew.notIn("certificate_file", value);
        return this;
    }

    public CertificateInfoCondition orCertificateFileNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("certificate_file", value);
        return this;
    }

    public CertificateInfoCondition andCertificateFileBetween(Object value, Object value1) {
        ew.between("certificate_file", value, value1);
        return this;
    }

    public CertificateInfoCondition orCertificateFileBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("certificate_file", value, value1);
        return this;
    }

    public CertificateInfoCondition andCertificateFileNotBetween(Object value, Object value1) {
        ew.notBetween("certificate_file", value, value1);
        return this;
    }

    public CertificateInfoCondition orCertificateFileNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("certificate_file", value, value1);
        return this;
    }

    public CertificateInfoCondition andCertificateFileLike(String value) {
        ew.like("certificate_file", value);
        return this;
    }

    public CertificateInfoCondition orCertificateFileLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("certificate_file", value);
        return this;
    }

    public CertificateInfoCondition andCertificateFileNotLike(String value) {
        ew.notLike("certificate_file", value);
        return this;
    }

    public CertificateInfoCondition orCertificateFileNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("certificate_file", value);
        return this;
    }
}