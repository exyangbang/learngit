package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class CertificateIndustryInfoCondition {
    private PlusEntityWrapper<CertificateIndustryInfo> ew;

    public CertificateIndustryInfoCondition() {
        this.ew = new PlusEntityWrapper(CertificateIndustryInfo.class);
    }

    public static CertificateIndustryInfoCondition builder() {
        return new CertificateIndustryInfoCondition();
    }

    public PlusEntityWrapper<CertificateIndustryInfo> build() {
        return this.ew;
    }

    public CertificateIndustryInfoCondition or() {
        this.ew.orNew();
        return this;
    }

    public CertificateIndustryInfoCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(CertificateIndustryInfo.class);
    }

    public CertificateIndustryInfoCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public CertificateIndustryInfoCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public CertificateIndustryInfoCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public CertificateIndustryInfoCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> CertificateIndustryInfoCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> CertificateIndustryInfoCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> CertificateIndustryInfoCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public CertificateIndustryInfoCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public CertificateIndustryInfoCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public CertificateIndustryInfoCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public CertificateIndustryInfoCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public CertificateIndustryInfoCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public CertificateIndustryInfoCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public CertificateIndustryInfoCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public CertificateIndustryInfoCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public CertificateIndustryInfoCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public CertificateIndustryInfoCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public CertificateIndustryInfoCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public CertificateIndustryInfoCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public CertificateIndustryInfoCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public CertificateIndustryInfoCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public CertificateIndustryInfoCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public CertificateIndustryInfoCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public CertificateIndustryInfoCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public CertificateIndustryInfoCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public CertificateIndustryInfoCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public CertificateIndustryInfoCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public CertificateIndustryInfoCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public CertificateIndustryInfoCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public CertificateIndustryInfoCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public CertificateIndustryInfoCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public CertificateIndustryInfoCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public CertificateIndustryInfoCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public CertificateIndustryInfoCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public CertificateIndustryInfoCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public CertificateIndustryInfoCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public CertificateIndustryInfoCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public CertificateIndustryInfoCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public CertificateIndustryInfoCondition andCertIdIsNull() {
        ew.isNull("cert_id");
        return this;
    }

    public CertificateIndustryInfoCondition orCertIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("cert_id");
        return this;
    }

    public CertificateIndustryInfoCondition andCertIdIsNotNull() {
        ew.isNotNull("cert_id");
        return this;
    }

    public CertificateIndustryInfoCondition orCertIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("cert_id");
        return this;
    }

    public CertificateIndustryInfoCondition andCertIdEq(Object value) {
        ew.eq("cert_id", value);
        return this;
    }

    public CertificateIndustryInfoCondition orCertIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("cert_id", value);
        return this;
    }

    public CertificateIndustryInfoCondition andCertIdNe(Object value) {
        ew.ne("cert_id", value);
        return this;
    }

    public CertificateIndustryInfoCondition orCertIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("cert_id", value);
        return this;
    }

    public CertificateIndustryInfoCondition andCertIdGt(Object value) {
        ew.gt("cert_id", value);
        return this;
    }

    public CertificateIndustryInfoCondition orCertIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("cert_id", value);
        return this;
    }

    public CertificateIndustryInfoCondition andCertIdGe(Object value) {
        ew.ge("cert_id", value);
        return this;
    }

    public CertificateIndustryInfoCondition orCertIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("cert_id", value);
        return this;
    }

    public CertificateIndustryInfoCondition andCertIdLt(Object value) {
        ew.lt("cert_id", value);
        return this;
    }

    public CertificateIndustryInfoCondition orCertIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("cert_id", value);
        return this;
    }

    public CertificateIndustryInfoCondition andCertIdLe(Object value) {
        ew.le("cert_id", value);
        return this;
    }

    public CertificateIndustryInfoCondition orCertIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("cert_id", value);
        return this;
    }

    public CertificateIndustryInfoCondition andCertIdIn(Object... value) {
        ew.in("cert_id", value);
        return this;
    }

    public CertificateIndustryInfoCondition orCertIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("cert_id", value);
        return this;
    }

    public CertificateIndustryInfoCondition andCertIdNotIn(Object... value) {
        ew.notIn("cert_id", value);
        return this;
    }

    public CertificateIndustryInfoCondition orCertIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("cert_id", value);
        return this;
    }

    public CertificateIndustryInfoCondition andCertIdBetween(Object value, Object value1) {
        ew.between("cert_id", value, value1);
        return this;
    }

    public CertificateIndustryInfoCondition orCertIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("cert_id", value, value1);
        return this;
    }

    public CertificateIndustryInfoCondition andCertIdNotBetween(Object value, Object value1) {
        ew.notBetween("cert_id", value, value1);
        return this;
    }

    public CertificateIndustryInfoCondition orCertIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("cert_id", value, value1);
        return this;
    }

    public CertificateIndustryInfoCondition andCertIdLike(String value) {
        ew.like("cert_id", value);
        return this;
    }

    public CertificateIndustryInfoCondition orCertIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("cert_id", value);
        return this;
    }

    public CertificateIndustryInfoCondition andCertIdNotLike(String value) {
        ew.notLike("cert_id", value);
        return this;
    }

    public CertificateIndustryInfoCondition orCertIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("cert_id", value);
        return this;
    }

    public CertificateIndustryInfoCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public CertificateIndustryInfoCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public CertificateIndustryInfoCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public CertificateIndustryInfoCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public CertificateIndustryInfoCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public CertificateIndustryInfoCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public CertificateIndustryInfoCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public CertificateIndustryInfoCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public CertificateIndustryInfoCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public CertificateIndustryInfoCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public CertificateIndustryInfoCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public CertificateIndustryInfoCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public CertificateIndustryInfoCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public CertificateIndustryInfoCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public CertificateIndustryInfoCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public CertificateIndustryInfoCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public CertificateIndustryInfoCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public CertificateIndustryInfoCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public CertificateIndustryInfoCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public CertificateIndustryInfoCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public CertificateIndustryInfoCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public CertificateIndustryInfoCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public CertificateIndustryInfoCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public CertificateIndustryInfoCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public CertificateIndustryInfoCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public CertificateIndustryInfoCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public CertificateIndustryInfoCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public CertificateIndustryInfoCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }
}