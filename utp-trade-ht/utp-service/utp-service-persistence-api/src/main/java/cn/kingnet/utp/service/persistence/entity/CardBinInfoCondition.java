package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class CardBinInfoCondition {
    private PlusEntityWrapper<CardBinInfo> ew;

    public CardBinInfoCondition() {
        this.ew = new PlusEntityWrapper(CardBinInfo.class);
    }

    public static CardBinInfoCondition builder() {
        return new CardBinInfoCondition();
    }

    public PlusEntityWrapper<CardBinInfo> build() {
        return this.ew;
    }

    public CardBinInfoCondition or() {
        this.ew.orNew();
        return this;
    }

    public CardBinInfoCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(CardBinInfo.class);
    }

    public CardBinInfoCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public CardBinInfoCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public CardBinInfoCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public CardBinInfoCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> CardBinInfoCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> CardBinInfoCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> CardBinInfoCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public CardBinInfoCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public CardBinInfoCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public CardBinInfoCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public CardBinInfoCondition andIdIsNull() {
        ew.isNull("ID");
        return this;
    }

    public CardBinInfoCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ID");
        return this;
    }

    public CardBinInfoCondition andIdIsNotNull() {
        ew.isNotNull("ID");
        return this;
    }

    public CardBinInfoCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ID");
        return this;
    }

    public CardBinInfoCondition andIdEq(Object value) {
        ew.eq("ID", value);
        return this;
    }

    public CardBinInfoCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ID", value);
        return this;
    }

    public CardBinInfoCondition andIdNe(Object value) {
        ew.ne("ID", value);
        return this;
    }

    public CardBinInfoCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ID", value);
        return this;
    }

    public CardBinInfoCondition andIdGt(Object value) {
        ew.gt("ID", value);
        return this;
    }

    public CardBinInfoCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ID", value);
        return this;
    }

    public CardBinInfoCondition andIdGe(Object value) {
        ew.ge("ID", value);
        return this;
    }

    public CardBinInfoCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ID", value);
        return this;
    }

    public CardBinInfoCondition andIdLt(Object value) {
        ew.lt("ID", value);
        return this;
    }

    public CardBinInfoCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ID", value);
        return this;
    }

    public CardBinInfoCondition andIdLe(Object value) {
        ew.le("ID", value);
        return this;
    }

    public CardBinInfoCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ID", value);
        return this;
    }

    public CardBinInfoCondition andIdIn(Object... value) {
        ew.in("ID", value);
        return this;
    }

    public CardBinInfoCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ID", value);
        return this;
    }

    public CardBinInfoCondition andIdNotIn(Object... value) {
        ew.notIn("ID", value);
        return this;
    }

    public CardBinInfoCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ID", value);
        return this;
    }

    public CardBinInfoCondition andIdBetween(Object value, Object value1) {
        ew.between("ID", value, value1);
        return this;
    }

    public CardBinInfoCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ID", value, value1);
        return this;
    }

    public CardBinInfoCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("ID", value, value1);
        return this;
    }

    public CardBinInfoCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ID", value, value1);
        return this;
    }

    public CardBinInfoCondition andIdLike(String value) {
        ew.like("ID", value);
        return this;
    }

    public CardBinInfoCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ID", value);
        return this;
    }

    public CardBinInfoCondition andIdNotLike(String value) {
        ew.notLike("ID", value);
        return this;
    }

    public CardBinInfoCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ID", value);
        return this;
    }

    public CardBinInfoCondition andIssuercodeIsNull() {
        ew.isNull("ISSUERCODE");
        return this;
    }

    public CardBinInfoCondition orIssuercodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ISSUERCODE");
        return this;
    }

    public CardBinInfoCondition andIssuercodeIsNotNull() {
        ew.isNotNull("ISSUERCODE");
        return this;
    }

    public CardBinInfoCondition orIssuercodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ISSUERCODE");
        return this;
    }

    public CardBinInfoCondition andIssuercodeEq(Object value) {
        ew.eq("ISSUERCODE", value);
        return this;
    }

    public CardBinInfoCondition orIssuercodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ISSUERCODE", value);
        return this;
    }

    public CardBinInfoCondition andIssuercodeNe(Object value) {
        ew.ne("ISSUERCODE", value);
        return this;
    }

    public CardBinInfoCondition orIssuercodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ISSUERCODE", value);
        return this;
    }

    public CardBinInfoCondition andIssuercodeGt(Object value) {
        ew.gt("ISSUERCODE", value);
        return this;
    }

    public CardBinInfoCondition orIssuercodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ISSUERCODE", value);
        return this;
    }

    public CardBinInfoCondition andIssuercodeGe(Object value) {
        ew.ge("ISSUERCODE", value);
        return this;
    }

    public CardBinInfoCondition orIssuercodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ISSUERCODE", value);
        return this;
    }

    public CardBinInfoCondition andIssuercodeLt(Object value) {
        ew.lt("ISSUERCODE", value);
        return this;
    }

    public CardBinInfoCondition orIssuercodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ISSUERCODE", value);
        return this;
    }

    public CardBinInfoCondition andIssuercodeLe(Object value) {
        ew.le("ISSUERCODE", value);
        return this;
    }

    public CardBinInfoCondition orIssuercodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ISSUERCODE", value);
        return this;
    }

    public CardBinInfoCondition andIssuercodeIn(Object... value) {
        ew.in("ISSUERCODE", value);
        return this;
    }

    public CardBinInfoCondition orIssuercodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ISSUERCODE", value);
        return this;
    }

    public CardBinInfoCondition andIssuercodeNotIn(Object... value) {
        ew.notIn("ISSUERCODE", value);
        return this;
    }

    public CardBinInfoCondition orIssuercodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ISSUERCODE", value);
        return this;
    }

    public CardBinInfoCondition andIssuercodeBetween(Object value, Object value1) {
        ew.between("ISSUERCODE", value, value1);
        return this;
    }

    public CardBinInfoCondition orIssuercodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ISSUERCODE", value, value1);
        return this;
    }

    public CardBinInfoCondition andIssuercodeNotBetween(Object value, Object value1) {
        ew.notBetween("ISSUERCODE", value, value1);
        return this;
    }

    public CardBinInfoCondition orIssuercodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ISSUERCODE", value, value1);
        return this;
    }

    public CardBinInfoCondition andIssuercodeLike(String value) {
        ew.like("ISSUERCODE", value);
        return this;
    }

    public CardBinInfoCondition orIssuercodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ISSUERCODE", value);
        return this;
    }

    public CardBinInfoCondition andIssuercodeNotLike(String value) {
        ew.notLike("ISSUERCODE", value);
        return this;
    }

    public CardBinInfoCondition orIssuercodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ISSUERCODE", value);
        return this;
    }

    public CardBinInfoCondition andIssuernameIsNull() {
        ew.isNull("ISSUERNAME");
        return this;
    }

    public CardBinInfoCondition orIssuernameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ISSUERNAME");
        return this;
    }

    public CardBinInfoCondition andIssuernameIsNotNull() {
        ew.isNotNull("ISSUERNAME");
        return this;
    }

    public CardBinInfoCondition orIssuernameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ISSUERNAME");
        return this;
    }

    public CardBinInfoCondition andIssuernameEq(Object value) {
        ew.eq("ISSUERNAME", value);
        return this;
    }

    public CardBinInfoCondition orIssuernameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ISSUERNAME", value);
        return this;
    }

    public CardBinInfoCondition andIssuernameNe(Object value) {
        ew.ne("ISSUERNAME", value);
        return this;
    }

    public CardBinInfoCondition orIssuernameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ISSUERNAME", value);
        return this;
    }

    public CardBinInfoCondition andIssuernameGt(Object value) {
        ew.gt("ISSUERNAME", value);
        return this;
    }

    public CardBinInfoCondition orIssuernameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ISSUERNAME", value);
        return this;
    }

    public CardBinInfoCondition andIssuernameGe(Object value) {
        ew.ge("ISSUERNAME", value);
        return this;
    }

    public CardBinInfoCondition orIssuernameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ISSUERNAME", value);
        return this;
    }

    public CardBinInfoCondition andIssuernameLt(Object value) {
        ew.lt("ISSUERNAME", value);
        return this;
    }

    public CardBinInfoCondition orIssuernameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ISSUERNAME", value);
        return this;
    }

    public CardBinInfoCondition andIssuernameLe(Object value) {
        ew.le("ISSUERNAME", value);
        return this;
    }

    public CardBinInfoCondition orIssuernameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ISSUERNAME", value);
        return this;
    }

    public CardBinInfoCondition andIssuernameIn(Object... value) {
        ew.in("ISSUERNAME", value);
        return this;
    }

    public CardBinInfoCondition orIssuernameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ISSUERNAME", value);
        return this;
    }

    public CardBinInfoCondition andIssuernameNotIn(Object... value) {
        ew.notIn("ISSUERNAME", value);
        return this;
    }

    public CardBinInfoCondition orIssuernameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ISSUERNAME", value);
        return this;
    }

    public CardBinInfoCondition andIssuernameBetween(Object value, Object value1) {
        ew.between("ISSUERNAME", value, value1);
        return this;
    }

    public CardBinInfoCondition orIssuernameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ISSUERNAME", value, value1);
        return this;
    }

    public CardBinInfoCondition andIssuernameNotBetween(Object value, Object value1) {
        ew.notBetween("ISSUERNAME", value, value1);
        return this;
    }

    public CardBinInfoCondition orIssuernameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ISSUERNAME", value, value1);
        return this;
    }

    public CardBinInfoCondition andIssuernameLike(String value) {
        ew.like("ISSUERNAME", value);
        return this;
    }

    public CardBinInfoCondition orIssuernameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ISSUERNAME", value);
        return this;
    }

    public CardBinInfoCondition andIssuernameNotLike(String value) {
        ew.notLike("ISSUERNAME", value);
        return this;
    }

    public CardBinInfoCondition orIssuernameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ISSUERNAME", value);
        return this;
    }

    public CardBinInfoCondition andCardnameIsNull() {
        ew.isNull("CARDNAME");
        return this;
    }

    public CardBinInfoCondition orCardnameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("CARDNAME");
        return this;
    }

    public CardBinInfoCondition andCardnameIsNotNull() {
        ew.isNotNull("CARDNAME");
        return this;
    }

    public CardBinInfoCondition orCardnameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("CARDNAME");
        return this;
    }

    public CardBinInfoCondition andCardnameEq(Object value) {
        ew.eq("CARDNAME", value);
        return this;
    }

    public CardBinInfoCondition orCardnameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("CARDNAME", value);
        return this;
    }

    public CardBinInfoCondition andCardnameNe(Object value) {
        ew.ne("CARDNAME", value);
        return this;
    }

    public CardBinInfoCondition orCardnameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("CARDNAME", value);
        return this;
    }

    public CardBinInfoCondition andCardnameGt(Object value) {
        ew.gt("CARDNAME", value);
        return this;
    }

    public CardBinInfoCondition orCardnameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("CARDNAME", value);
        return this;
    }

    public CardBinInfoCondition andCardnameGe(Object value) {
        ew.ge("CARDNAME", value);
        return this;
    }

    public CardBinInfoCondition orCardnameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("CARDNAME", value);
        return this;
    }

    public CardBinInfoCondition andCardnameLt(Object value) {
        ew.lt("CARDNAME", value);
        return this;
    }

    public CardBinInfoCondition orCardnameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("CARDNAME", value);
        return this;
    }

    public CardBinInfoCondition andCardnameLe(Object value) {
        ew.le("CARDNAME", value);
        return this;
    }

    public CardBinInfoCondition orCardnameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("CARDNAME", value);
        return this;
    }

    public CardBinInfoCondition andCardnameIn(Object... value) {
        ew.in("CARDNAME", value);
        return this;
    }

    public CardBinInfoCondition orCardnameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("CARDNAME", value);
        return this;
    }

    public CardBinInfoCondition andCardnameNotIn(Object... value) {
        ew.notIn("CARDNAME", value);
        return this;
    }

    public CardBinInfoCondition orCardnameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("CARDNAME", value);
        return this;
    }

    public CardBinInfoCondition andCardnameBetween(Object value, Object value1) {
        ew.between("CARDNAME", value, value1);
        return this;
    }

    public CardBinInfoCondition orCardnameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("CARDNAME", value, value1);
        return this;
    }

    public CardBinInfoCondition andCardnameNotBetween(Object value, Object value1) {
        ew.notBetween("CARDNAME", value, value1);
        return this;
    }

    public CardBinInfoCondition orCardnameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("CARDNAME", value, value1);
        return this;
    }

    public CardBinInfoCondition andCardnameLike(String value) {
        ew.like("CARDNAME", value);
        return this;
    }

    public CardBinInfoCondition orCardnameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("CARDNAME", value);
        return this;
    }

    public CardBinInfoCondition andCardnameNotLike(String value) {
        ew.notLike("CARDNAME", value);
        return this;
    }

    public CardBinInfoCondition orCardnameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("CARDNAME", value);
        return this;
    }

    public CardBinInfoCondition andCardnotrackIsNull() {
        ew.isNull("CARDNOTRACK");
        return this;
    }

    public CardBinInfoCondition orCardnotrackIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("CARDNOTRACK");
        return this;
    }

    public CardBinInfoCondition andCardnotrackIsNotNull() {
        ew.isNotNull("CARDNOTRACK");
        return this;
    }

    public CardBinInfoCondition orCardnotrackIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("CARDNOTRACK");
        return this;
    }

    public CardBinInfoCondition andCardnotrackEq(Object value) {
        ew.eq("CARDNOTRACK", value);
        return this;
    }

    public CardBinInfoCondition orCardnotrackEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("CARDNOTRACK", value);
        return this;
    }

    public CardBinInfoCondition andCardnotrackNe(Object value) {
        ew.ne("CARDNOTRACK", value);
        return this;
    }

    public CardBinInfoCondition orCardnotrackNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("CARDNOTRACK", value);
        return this;
    }

    public CardBinInfoCondition andCardnotrackGt(Object value) {
        ew.gt("CARDNOTRACK", value);
        return this;
    }

    public CardBinInfoCondition orCardnotrackGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("CARDNOTRACK", value);
        return this;
    }

    public CardBinInfoCondition andCardnotrackGe(Object value) {
        ew.ge("CARDNOTRACK", value);
        return this;
    }

    public CardBinInfoCondition orCardnotrackGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("CARDNOTRACK", value);
        return this;
    }

    public CardBinInfoCondition andCardnotrackLt(Object value) {
        ew.lt("CARDNOTRACK", value);
        return this;
    }

    public CardBinInfoCondition orCardnotrackLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("CARDNOTRACK", value);
        return this;
    }

    public CardBinInfoCondition andCardnotrackLe(Object value) {
        ew.le("CARDNOTRACK", value);
        return this;
    }

    public CardBinInfoCondition orCardnotrackLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("CARDNOTRACK", value);
        return this;
    }

    public CardBinInfoCondition andCardnotrackIn(Object... value) {
        ew.in("CARDNOTRACK", value);
        return this;
    }

    public CardBinInfoCondition orCardnotrackIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("CARDNOTRACK", value);
        return this;
    }

    public CardBinInfoCondition andCardnotrackNotIn(Object... value) {
        ew.notIn("CARDNOTRACK", value);
        return this;
    }

    public CardBinInfoCondition orCardnotrackNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("CARDNOTRACK", value);
        return this;
    }

    public CardBinInfoCondition andCardnotrackBetween(Object value, Object value1) {
        ew.between("CARDNOTRACK", value, value1);
        return this;
    }

    public CardBinInfoCondition orCardnotrackBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("CARDNOTRACK", value, value1);
        return this;
    }

    public CardBinInfoCondition andCardnotrackNotBetween(Object value, Object value1) {
        ew.notBetween("CARDNOTRACK", value, value1);
        return this;
    }

    public CardBinInfoCondition orCardnotrackNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("CARDNOTRACK", value, value1);
        return this;
    }

    public CardBinInfoCondition andCardnotrackLike(String value) {
        ew.like("CARDNOTRACK", value);
        return this;
    }

    public CardBinInfoCondition orCardnotrackLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("CARDNOTRACK", value);
        return this;
    }

    public CardBinInfoCondition andCardnotrackNotLike(String value) {
        ew.notLike("CARDNOTRACK", value);
        return this;
    }

    public CardBinInfoCondition orCardnotrackNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("CARDNOTRACK", value);
        return this;
    }

    public CardBinInfoCondition andCardnostartPosIsNull() {
        ew.isNull("CARDNOSTART_POS");
        return this;
    }

    public CardBinInfoCondition orCardnostartPosIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("CARDNOSTART_POS");
        return this;
    }

    public CardBinInfoCondition andCardnostartPosIsNotNull() {
        ew.isNotNull("CARDNOSTART_POS");
        return this;
    }

    public CardBinInfoCondition orCardnostartPosIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("CARDNOSTART_POS");
        return this;
    }

    public CardBinInfoCondition andCardnostartPosEq(Object value) {
        ew.eq("CARDNOSTART_POS", value);
        return this;
    }

    public CardBinInfoCondition orCardnostartPosEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("CARDNOSTART_POS", value);
        return this;
    }

    public CardBinInfoCondition andCardnostartPosNe(Object value) {
        ew.ne("CARDNOSTART_POS", value);
        return this;
    }

    public CardBinInfoCondition orCardnostartPosNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("CARDNOSTART_POS", value);
        return this;
    }

    public CardBinInfoCondition andCardnostartPosGt(Object value) {
        ew.gt("CARDNOSTART_POS", value);
        return this;
    }

    public CardBinInfoCondition orCardnostartPosGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("CARDNOSTART_POS", value);
        return this;
    }

    public CardBinInfoCondition andCardnostartPosGe(Object value) {
        ew.ge("CARDNOSTART_POS", value);
        return this;
    }

    public CardBinInfoCondition orCardnostartPosGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("CARDNOSTART_POS", value);
        return this;
    }

    public CardBinInfoCondition andCardnostartPosLt(Object value) {
        ew.lt("CARDNOSTART_POS", value);
        return this;
    }

    public CardBinInfoCondition orCardnostartPosLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("CARDNOSTART_POS", value);
        return this;
    }

    public CardBinInfoCondition andCardnostartPosLe(Object value) {
        ew.le("CARDNOSTART_POS", value);
        return this;
    }

    public CardBinInfoCondition orCardnostartPosLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("CARDNOSTART_POS", value);
        return this;
    }

    public CardBinInfoCondition andCardnostartPosIn(Object... value) {
        ew.in("CARDNOSTART_POS", value);
        return this;
    }

    public CardBinInfoCondition orCardnostartPosIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("CARDNOSTART_POS", value);
        return this;
    }

    public CardBinInfoCondition andCardnostartPosNotIn(Object... value) {
        ew.notIn("CARDNOSTART_POS", value);
        return this;
    }

    public CardBinInfoCondition orCardnostartPosNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("CARDNOSTART_POS", value);
        return this;
    }

    public CardBinInfoCondition andCardnostartPosBetween(Object value, Object value1) {
        ew.between("CARDNOSTART_POS", value, value1);
        return this;
    }

    public CardBinInfoCondition orCardnostartPosBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("CARDNOSTART_POS", value, value1);
        return this;
    }

    public CardBinInfoCondition andCardnostartPosNotBetween(Object value, Object value1) {
        ew.notBetween("CARDNOSTART_POS", value, value1);
        return this;
    }

    public CardBinInfoCondition orCardnostartPosNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("CARDNOSTART_POS", value, value1);
        return this;
    }

    public CardBinInfoCondition andCardnostartPosLike(String value) {
        ew.like("CARDNOSTART_POS", value);
        return this;
    }

    public CardBinInfoCondition orCardnostartPosLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("CARDNOSTART_POS", value);
        return this;
    }

    public CardBinInfoCondition andCardnostartPosNotLike(String value) {
        ew.notLike("CARDNOSTART_POS", value);
        return this;
    }

    public CardBinInfoCondition orCardnostartPosNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("CARDNOSTART_POS", value);
        return this;
    }

    public CardBinInfoCondition andCardnolenIsNull() {
        ew.isNull("CARDNOLEN");
        return this;
    }

    public CardBinInfoCondition orCardnolenIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("CARDNOLEN");
        return this;
    }

    public CardBinInfoCondition andCardnolenIsNotNull() {
        ew.isNotNull("CARDNOLEN");
        return this;
    }

    public CardBinInfoCondition orCardnolenIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("CARDNOLEN");
        return this;
    }

    public CardBinInfoCondition andCardnolenEq(Object value) {
        ew.eq("CARDNOLEN", value);
        return this;
    }

    public CardBinInfoCondition orCardnolenEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("CARDNOLEN", value);
        return this;
    }

    public CardBinInfoCondition andCardnolenNe(Object value) {
        ew.ne("CARDNOLEN", value);
        return this;
    }

    public CardBinInfoCondition orCardnolenNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("CARDNOLEN", value);
        return this;
    }

    public CardBinInfoCondition andCardnolenGt(Object value) {
        ew.gt("CARDNOLEN", value);
        return this;
    }

    public CardBinInfoCondition orCardnolenGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("CARDNOLEN", value);
        return this;
    }

    public CardBinInfoCondition andCardnolenGe(Object value) {
        ew.ge("CARDNOLEN", value);
        return this;
    }

    public CardBinInfoCondition orCardnolenGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("CARDNOLEN", value);
        return this;
    }

    public CardBinInfoCondition andCardnolenLt(Object value) {
        ew.lt("CARDNOLEN", value);
        return this;
    }

    public CardBinInfoCondition orCardnolenLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("CARDNOLEN", value);
        return this;
    }

    public CardBinInfoCondition andCardnolenLe(Object value) {
        ew.le("CARDNOLEN", value);
        return this;
    }

    public CardBinInfoCondition orCardnolenLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("CARDNOLEN", value);
        return this;
    }

    public CardBinInfoCondition andCardnolenIn(Object... value) {
        ew.in("CARDNOLEN", value);
        return this;
    }

    public CardBinInfoCondition orCardnolenIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("CARDNOLEN", value);
        return this;
    }

    public CardBinInfoCondition andCardnolenNotIn(Object... value) {
        ew.notIn("CARDNOLEN", value);
        return this;
    }

    public CardBinInfoCondition orCardnolenNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("CARDNOLEN", value);
        return this;
    }

    public CardBinInfoCondition andCardnolenBetween(Object value, Object value1) {
        ew.between("CARDNOLEN", value, value1);
        return this;
    }

    public CardBinInfoCondition orCardnolenBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("CARDNOLEN", value, value1);
        return this;
    }

    public CardBinInfoCondition andCardnolenNotBetween(Object value, Object value1) {
        ew.notBetween("CARDNOLEN", value, value1);
        return this;
    }

    public CardBinInfoCondition orCardnolenNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("CARDNOLEN", value, value1);
        return this;
    }

    public CardBinInfoCondition andCardnolenLike(String value) {
        ew.like("CARDNOLEN", value);
        return this;
    }

    public CardBinInfoCondition orCardnolenLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("CARDNOLEN", value);
        return this;
    }

    public CardBinInfoCondition andCardnolenNotLike(String value) {
        ew.notLike("CARDNOLEN", value);
        return this;
    }

    public CardBinInfoCondition orCardnolenNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("CARDNOLEN", value);
        return this;
    }

    public CardBinInfoCondition andBinnumIsNull() {
        ew.isNull("BINNUM");
        return this;
    }

    public CardBinInfoCondition orBinnumIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("BINNUM");
        return this;
    }

    public CardBinInfoCondition andBinnumIsNotNull() {
        ew.isNotNull("BINNUM");
        return this;
    }

    public CardBinInfoCondition orBinnumIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("BINNUM");
        return this;
    }

    public CardBinInfoCondition andBinnumEq(Object value) {
        ew.eq("BINNUM", value);
        return this;
    }

    public CardBinInfoCondition orBinnumEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("BINNUM", value);
        return this;
    }

    public CardBinInfoCondition andBinnumNe(Object value) {
        ew.ne("BINNUM", value);
        return this;
    }

    public CardBinInfoCondition orBinnumNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("BINNUM", value);
        return this;
    }

    public CardBinInfoCondition andBinnumGt(Object value) {
        ew.gt("BINNUM", value);
        return this;
    }

    public CardBinInfoCondition orBinnumGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("BINNUM", value);
        return this;
    }

    public CardBinInfoCondition andBinnumGe(Object value) {
        ew.ge("BINNUM", value);
        return this;
    }

    public CardBinInfoCondition orBinnumGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("BINNUM", value);
        return this;
    }

    public CardBinInfoCondition andBinnumLt(Object value) {
        ew.lt("BINNUM", value);
        return this;
    }

    public CardBinInfoCondition orBinnumLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("BINNUM", value);
        return this;
    }

    public CardBinInfoCondition andBinnumLe(Object value) {
        ew.le("BINNUM", value);
        return this;
    }

    public CardBinInfoCondition orBinnumLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("BINNUM", value);
        return this;
    }

    public CardBinInfoCondition andBinnumIn(Object... value) {
        ew.in("BINNUM", value);
        return this;
    }

    public CardBinInfoCondition orBinnumIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("BINNUM", value);
        return this;
    }

    public CardBinInfoCondition andBinnumNotIn(Object... value) {
        ew.notIn("BINNUM", value);
        return this;
    }

    public CardBinInfoCondition orBinnumNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("BINNUM", value);
        return this;
    }

    public CardBinInfoCondition andBinnumBetween(Object value, Object value1) {
        ew.between("BINNUM", value, value1);
        return this;
    }

    public CardBinInfoCondition orBinnumBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("BINNUM", value, value1);
        return this;
    }

    public CardBinInfoCondition andBinnumNotBetween(Object value, Object value1) {
        ew.notBetween("BINNUM", value, value1);
        return this;
    }

    public CardBinInfoCondition orBinnumNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("BINNUM", value, value1);
        return this;
    }

    public CardBinInfoCondition andBinnumLike(String value) {
        ew.like("BINNUM", value);
        return this;
    }

    public CardBinInfoCondition orBinnumLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("BINNUM", value);
        return this;
    }

    public CardBinInfoCondition andBinnumNotLike(String value) {
        ew.notLike("BINNUM", value);
        return this;
    }

    public CardBinInfoCondition orBinnumNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("BINNUM", value);
        return this;
    }

    public CardBinInfoCondition andBintrackIsNull() {
        ew.isNull("BINTRACK");
        return this;
    }

    public CardBinInfoCondition orBintrackIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("BINTRACK");
        return this;
    }

    public CardBinInfoCondition andBintrackIsNotNull() {
        ew.isNotNull("BINTRACK");
        return this;
    }

    public CardBinInfoCondition orBintrackIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("BINTRACK");
        return this;
    }

    public CardBinInfoCondition andBintrackEq(Object value) {
        ew.eq("BINTRACK", value);
        return this;
    }

    public CardBinInfoCondition orBintrackEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("BINTRACK", value);
        return this;
    }

    public CardBinInfoCondition andBintrackNe(Object value) {
        ew.ne("BINTRACK", value);
        return this;
    }

    public CardBinInfoCondition orBintrackNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("BINTRACK", value);
        return this;
    }

    public CardBinInfoCondition andBintrackGt(Object value) {
        ew.gt("BINTRACK", value);
        return this;
    }

    public CardBinInfoCondition orBintrackGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("BINTRACK", value);
        return this;
    }

    public CardBinInfoCondition andBintrackGe(Object value) {
        ew.ge("BINTRACK", value);
        return this;
    }

    public CardBinInfoCondition orBintrackGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("BINTRACK", value);
        return this;
    }

    public CardBinInfoCondition andBintrackLt(Object value) {
        ew.lt("BINTRACK", value);
        return this;
    }

    public CardBinInfoCondition orBintrackLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("BINTRACK", value);
        return this;
    }

    public CardBinInfoCondition andBintrackLe(Object value) {
        ew.le("BINTRACK", value);
        return this;
    }

    public CardBinInfoCondition orBintrackLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("BINTRACK", value);
        return this;
    }

    public CardBinInfoCondition andBintrackIn(Object... value) {
        ew.in("BINTRACK", value);
        return this;
    }

    public CardBinInfoCondition orBintrackIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("BINTRACK", value);
        return this;
    }

    public CardBinInfoCondition andBintrackNotIn(Object... value) {
        ew.notIn("BINTRACK", value);
        return this;
    }

    public CardBinInfoCondition orBintrackNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("BINTRACK", value);
        return this;
    }

    public CardBinInfoCondition andBintrackBetween(Object value, Object value1) {
        ew.between("BINTRACK", value, value1);
        return this;
    }

    public CardBinInfoCondition orBintrackBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("BINTRACK", value, value1);
        return this;
    }

    public CardBinInfoCondition andBintrackNotBetween(Object value, Object value1) {
        ew.notBetween("BINTRACK", value, value1);
        return this;
    }

    public CardBinInfoCondition orBintrackNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("BINTRACK", value, value1);
        return this;
    }

    public CardBinInfoCondition andBintrackLike(String value) {
        ew.like("BINTRACK", value);
        return this;
    }

    public CardBinInfoCondition orBintrackLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("BINTRACK", value);
        return this;
    }

    public CardBinInfoCondition andBintrackNotLike(String value) {
        ew.notLike("BINTRACK", value);
        return this;
    }

    public CardBinInfoCondition orBintrackNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("BINTRACK", value);
        return this;
    }

    public CardBinInfoCondition andBinstartposIsNull() {
        ew.isNull("BINSTARTPOS");
        return this;
    }

    public CardBinInfoCondition orBinstartposIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("BINSTARTPOS");
        return this;
    }

    public CardBinInfoCondition andBinstartposIsNotNull() {
        ew.isNotNull("BINSTARTPOS");
        return this;
    }

    public CardBinInfoCondition orBinstartposIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("BINSTARTPOS");
        return this;
    }

    public CardBinInfoCondition andBinstartposEq(Object value) {
        ew.eq("BINSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition orBinstartposEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("BINSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition andBinstartposNe(Object value) {
        ew.ne("BINSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition orBinstartposNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("BINSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition andBinstartposGt(Object value) {
        ew.gt("BINSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition orBinstartposGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("BINSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition andBinstartposGe(Object value) {
        ew.ge("BINSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition orBinstartposGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("BINSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition andBinstartposLt(Object value) {
        ew.lt("BINSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition orBinstartposLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("BINSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition andBinstartposLe(Object value) {
        ew.le("BINSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition orBinstartposLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("BINSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition andBinstartposIn(Object... value) {
        ew.in("BINSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition orBinstartposIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("BINSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition andBinstartposNotIn(Object... value) {
        ew.notIn("BINSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition orBinstartposNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("BINSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition andBinstartposBetween(Object value, Object value1) {
        ew.between("BINSTARTPOS", value, value1);
        return this;
    }

    public CardBinInfoCondition orBinstartposBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("BINSTARTPOS", value, value1);
        return this;
    }

    public CardBinInfoCondition andBinstartposNotBetween(Object value, Object value1) {
        ew.notBetween("BINSTARTPOS", value, value1);
        return this;
    }

    public CardBinInfoCondition orBinstartposNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("BINSTARTPOS", value, value1);
        return this;
    }

    public CardBinInfoCondition andBinstartposLike(String value) {
        ew.like("BINSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition orBinstartposLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("BINSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition andBinstartposNotLike(String value) {
        ew.notLike("BINSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition orBinstartposNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("BINSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition andBinlenIsNull() {
        ew.isNull("BINLEN");
        return this;
    }

    public CardBinInfoCondition orBinlenIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("BINLEN");
        return this;
    }

    public CardBinInfoCondition andBinlenIsNotNull() {
        ew.isNotNull("BINLEN");
        return this;
    }

    public CardBinInfoCondition orBinlenIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("BINLEN");
        return this;
    }

    public CardBinInfoCondition andBinlenEq(Object value) {
        ew.eq("BINLEN", value);
        return this;
    }

    public CardBinInfoCondition orBinlenEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("BINLEN", value);
        return this;
    }

    public CardBinInfoCondition andBinlenNe(Object value) {
        ew.ne("BINLEN", value);
        return this;
    }

    public CardBinInfoCondition orBinlenNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("BINLEN", value);
        return this;
    }

    public CardBinInfoCondition andBinlenGt(Object value) {
        ew.gt("BINLEN", value);
        return this;
    }

    public CardBinInfoCondition orBinlenGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("BINLEN", value);
        return this;
    }

    public CardBinInfoCondition andBinlenGe(Object value) {
        ew.ge("BINLEN", value);
        return this;
    }

    public CardBinInfoCondition orBinlenGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("BINLEN", value);
        return this;
    }

    public CardBinInfoCondition andBinlenLt(Object value) {
        ew.lt("BINLEN", value);
        return this;
    }

    public CardBinInfoCondition orBinlenLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("BINLEN", value);
        return this;
    }

    public CardBinInfoCondition andBinlenLe(Object value) {
        ew.le("BINLEN", value);
        return this;
    }

    public CardBinInfoCondition orBinlenLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("BINLEN", value);
        return this;
    }

    public CardBinInfoCondition andBinlenIn(Object... value) {
        ew.in("BINLEN", value);
        return this;
    }

    public CardBinInfoCondition orBinlenIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("BINLEN", value);
        return this;
    }

    public CardBinInfoCondition andBinlenNotIn(Object... value) {
        ew.notIn("BINLEN", value);
        return this;
    }

    public CardBinInfoCondition orBinlenNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("BINLEN", value);
        return this;
    }

    public CardBinInfoCondition andBinlenBetween(Object value, Object value1) {
        ew.between("BINLEN", value, value1);
        return this;
    }

    public CardBinInfoCondition orBinlenBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("BINLEN", value, value1);
        return this;
    }

    public CardBinInfoCondition andBinlenNotBetween(Object value, Object value1) {
        ew.notBetween("BINLEN", value, value1);
        return this;
    }

    public CardBinInfoCondition orBinlenNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("BINLEN", value, value1);
        return this;
    }

    public CardBinInfoCondition andBinlenLike(String value) {
        ew.like("BINLEN", value);
        return this;
    }

    public CardBinInfoCondition orBinlenLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("BINLEN", value);
        return this;
    }

    public CardBinInfoCondition andBinlenNotLike(String value) {
        ew.notLike("BINLEN", value);
        return this;
    }

    public CardBinInfoCondition orBinlenNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("BINLEN", value);
        return this;
    }

    public CardBinInfoCondition andAlltrackIsNull() {
        ew.isNull("ALLTRACK");
        return this;
    }

    public CardBinInfoCondition orAlltrackIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ALLTRACK");
        return this;
    }

    public CardBinInfoCondition andAlltrackIsNotNull() {
        ew.isNotNull("ALLTRACK");
        return this;
    }

    public CardBinInfoCondition orAlltrackIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ALLTRACK");
        return this;
    }

    public CardBinInfoCondition andAlltrackEq(Object value) {
        ew.eq("ALLTRACK", value);
        return this;
    }

    public CardBinInfoCondition orAlltrackEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ALLTRACK", value);
        return this;
    }

    public CardBinInfoCondition andAlltrackNe(Object value) {
        ew.ne("ALLTRACK", value);
        return this;
    }

    public CardBinInfoCondition orAlltrackNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ALLTRACK", value);
        return this;
    }

    public CardBinInfoCondition andAlltrackGt(Object value) {
        ew.gt("ALLTRACK", value);
        return this;
    }

    public CardBinInfoCondition orAlltrackGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ALLTRACK", value);
        return this;
    }

    public CardBinInfoCondition andAlltrackGe(Object value) {
        ew.ge("ALLTRACK", value);
        return this;
    }

    public CardBinInfoCondition orAlltrackGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ALLTRACK", value);
        return this;
    }

    public CardBinInfoCondition andAlltrackLt(Object value) {
        ew.lt("ALLTRACK", value);
        return this;
    }

    public CardBinInfoCondition orAlltrackLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ALLTRACK", value);
        return this;
    }

    public CardBinInfoCondition andAlltrackLe(Object value) {
        ew.le("ALLTRACK", value);
        return this;
    }

    public CardBinInfoCondition orAlltrackLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ALLTRACK", value);
        return this;
    }

    public CardBinInfoCondition andAlltrackIn(Object... value) {
        ew.in("ALLTRACK", value);
        return this;
    }

    public CardBinInfoCondition orAlltrackIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ALLTRACK", value);
        return this;
    }

    public CardBinInfoCondition andAlltrackNotIn(Object... value) {
        ew.notIn("ALLTRACK", value);
        return this;
    }

    public CardBinInfoCondition orAlltrackNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ALLTRACK", value);
        return this;
    }

    public CardBinInfoCondition andAlltrackBetween(Object value, Object value1) {
        ew.between("ALLTRACK", value, value1);
        return this;
    }

    public CardBinInfoCondition orAlltrackBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ALLTRACK", value, value1);
        return this;
    }

    public CardBinInfoCondition andAlltrackNotBetween(Object value, Object value1) {
        ew.notBetween("ALLTRACK", value, value1);
        return this;
    }

    public CardBinInfoCondition orAlltrackNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ALLTRACK", value, value1);
        return this;
    }

    public CardBinInfoCondition andAlltrackLike(String value) {
        ew.like("ALLTRACK", value);
        return this;
    }

    public CardBinInfoCondition orAlltrackLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ALLTRACK", value);
        return this;
    }

    public CardBinInfoCondition andAlltrackNotLike(String value) {
        ew.notLike("ALLTRACK", value);
        return this;
    }

    public CardBinInfoCondition orAlltrackNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ALLTRACK", value);
        return this;
    }

    public CardBinInfoCondition andAlltrackstartposIsNull() {
        ew.isNull("ALLTRACKSTARTPOS");
        return this;
    }

    public CardBinInfoCondition orAlltrackstartposIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ALLTRACKSTARTPOS");
        return this;
    }

    public CardBinInfoCondition andAlltrackstartposIsNotNull() {
        ew.isNotNull("ALLTRACKSTARTPOS");
        return this;
    }

    public CardBinInfoCondition orAlltrackstartposIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ALLTRACKSTARTPOS");
        return this;
    }

    public CardBinInfoCondition andAlltrackstartposEq(Object value) {
        ew.eq("ALLTRACKSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition orAlltrackstartposEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ALLTRACKSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition andAlltrackstartposNe(Object value) {
        ew.ne("ALLTRACKSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition orAlltrackstartposNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ALLTRACKSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition andAlltrackstartposGt(Object value) {
        ew.gt("ALLTRACKSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition orAlltrackstartposGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ALLTRACKSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition andAlltrackstartposGe(Object value) {
        ew.ge("ALLTRACKSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition orAlltrackstartposGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ALLTRACKSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition andAlltrackstartposLt(Object value) {
        ew.lt("ALLTRACKSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition orAlltrackstartposLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ALLTRACKSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition andAlltrackstartposLe(Object value) {
        ew.le("ALLTRACKSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition orAlltrackstartposLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ALLTRACKSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition andAlltrackstartposIn(Object... value) {
        ew.in("ALLTRACKSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition orAlltrackstartposIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ALLTRACKSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition andAlltrackstartposNotIn(Object... value) {
        ew.notIn("ALLTRACKSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition orAlltrackstartposNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ALLTRACKSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition andAlltrackstartposBetween(Object value, Object value1) {
        ew.between("ALLTRACKSTARTPOS", value, value1);
        return this;
    }

    public CardBinInfoCondition orAlltrackstartposBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ALLTRACKSTARTPOS", value, value1);
        return this;
    }

    public CardBinInfoCondition andAlltrackstartposNotBetween(Object value, Object value1) {
        ew.notBetween("ALLTRACKSTARTPOS", value, value1);
        return this;
    }

    public CardBinInfoCondition orAlltrackstartposNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ALLTRACKSTARTPOS", value, value1);
        return this;
    }

    public CardBinInfoCondition andAlltrackstartposLike(String value) {
        ew.like("ALLTRACKSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition orAlltrackstartposLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ALLTRACKSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition andAlltrackstartposNotLike(String value) {
        ew.notLike("ALLTRACKSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition orAlltrackstartposNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ALLTRACKSTARTPOS", value);
        return this;
    }

    public CardBinInfoCondition andAlltracklenIsNull() {
        ew.isNull("ALLTRACKLEN");
        return this;
    }

    public CardBinInfoCondition orAlltracklenIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ALLTRACKLEN");
        return this;
    }

    public CardBinInfoCondition andAlltracklenIsNotNull() {
        ew.isNotNull("ALLTRACKLEN");
        return this;
    }

    public CardBinInfoCondition orAlltracklenIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ALLTRACKLEN");
        return this;
    }

    public CardBinInfoCondition andAlltracklenEq(Object value) {
        ew.eq("ALLTRACKLEN", value);
        return this;
    }

    public CardBinInfoCondition orAlltracklenEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ALLTRACKLEN", value);
        return this;
    }

    public CardBinInfoCondition andAlltracklenNe(Object value) {
        ew.ne("ALLTRACKLEN", value);
        return this;
    }

    public CardBinInfoCondition orAlltracklenNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ALLTRACKLEN", value);
        return this;
    }

    public CardBinInfoCondition andAlltracklenGt(Object value) {
        ew.gt("ALLTRACKLEN", value);
        return this;
    }

    public CardBinInfoCondition orAlltracklenGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ALLTRACKLEN", value);
        return this;
    }

    public CardBinInfoCondition andAlltracklenGe(Object value) {
        ew.ge("ALLTRACKLEN", value);
        return this;
    }

    public CardBinInfoCondition orAlltracklenGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ALLTRACKLEN", value);
        return this;
    }

    public CardBinInfoCondition andAlltracklenLt(Object value) {
        ew.lt("ALLTRACKLEN", value);
        return this;
    }

    public CardBinInfoCondition orAlltracklenLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ALLTRACKLEN", value);
        return this;
    }

    public CardBinInfoCondition andAlltracklenLe(Object value) {
        ew.le("ALLTRACKLEN", value);
        return this;
    }

    public CardBinInfoCondition orAlltracklenLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ALLTRACKLEN", value);
        return this;
    }

    public CardBinInfoCondition andAlltracklenIn(Object... value) {
        ew.in("ALLTRACKLEN", value);
        return this;
    }

    public CardBinInfoCondition orAlltracklenIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ALLTRACKLEN", value);
        return this;
    }

    public CardBinInfoCondition andAlltracklenNotIn(Object... value) {
        ew.notIn("ALLTRACKLEN", value);
        return this;
    }

    public CardBinInfoCondition orAlltracklenNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ALLTRACKLEN", value);
        return this;
    }

    public CardBinInfoCondition andAlltracklenBetween(Object value, Object value1) {
        ew.between("ALLTRACKLEN", value, value1);
        return this;
    }

    public CardBinInfoCondition orAlltracklenBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ALLTRACKLEN", value, value1);
        return this;
    }

    public CardBinInfoCondition andAlltracklenNotBetween(Object value, Object value1) {
        ew.notBetween("ALLTRACKLEN", value, value1);
        return this;
    }

    public CardBinInfoCondition orAlltracklenNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ALLTRACKLEN", value, value1);
        return this;
    }

    public CardBinInfoCondition andAlltracklenLike(String value) {
        ew.like("ALLTRACKLEN", value);
        return this;
    }

    public CardBinInfoCondition orAlltracklenLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ALLTRACKLEN", value);
        return this;
    }

    public CardBinInfoCondition andAlltracklenNotLike(String value) {
        ew.notLike("ALLTRACKLEN", value);
        return this;
    }

    public CardBinInfoCondition orAlltracklenNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ALLTRACKLEN", value);
        return this;
    }

    public CardBinInfoCondition andCuplogoflagIsNull() {
        ew.isNull("CUPLOGOFLAG");
        return this;
    }

    public CardBinInfoCondition orCuplogoflagIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("CUPLOGOFLAG");
        return this;
    }

    public CardBinInfoCondition andCuplogoflagIsNotNull() {
        ew.isNotNull("CUPLOGOFLAG");
        return this;
    }

    public CardBinInfoCondition orCuplogoflagIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("CUPLOGOFLAG");
        return this;
    }

    public CardBinInfoCondition andCuplogoflagEq(Object value) {
        ew.eq("CUPLOGOFLAG", value);
        return this;
    }

    public CardBinInfoCondition orCuplogoflagEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("CUPLOGOFLAG", value);
        return this;
    }

    public CardBinInfoCondition andCuplogoflagNe(Object value) {
        ew.ne("CUPLOGOFLAG", value);
        return this;
    }

    public CardBinInfoCondition orCuplogoflagNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("CUPLOGOFLAG", value);
        return this;
    }

    public CardBinInfoCondition andCuplogoflagGt(Object value) {
        ew.gt("CUPLOGOFLAG", value);
        return this;
    }

    public CardBinInfoCondition orCuplogoflagGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("CUPLOGOFLAG", value);
        return this;
    }

    public CardBinInfoCondition andCuplogoflagGe(Object value) {
        ew.ge("CUPLOGOFLAG", value);
        return this;
    }

    public CardBinInfoCondition orCuplogoflagGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("CUPLOGOFLAG", value);
        return this;
    }

    public CardBinInfoCondition andCuplogoflagLt(Object value) {
        ew.lt("CUPLOGOFLAG", value);
        return this;
    }

    public CardBinInfoCondition orCuplogoflagLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("CUPLOGOFLAG", value);
        return this;
    }

    public CardBinInfoCondition andCuplogoflagLe(Object value) {
        ew.le("CUPLOGOFLAG", value);
        return this;
    }

    public CardBinInfoCondition orCuplogoflagLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("CUPLOGOFLAG", value);
        return this;
    }

    public CardBinInfoCondition andCuplogoflagIn(Object... value) {
        ew.in("CUPLOGOFLAG", value);
        return this;
    }

    public CardBinInfoCondition orCuplogoflagIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("CUPLOGOFLAG", value);
        return this;
    }

    public CardBinInfoCondition andCuplogoflagNotIn(Object... value) {
        ew.notIn("CUPLOGOFLAG", value);
        return this;
    }

    public CardBinInfoCondition orCuplogoflagNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("CUPLOGOFLAG", value);
        return this;
    }

    public CardBinInfoCondition andCuplogoflagBetween(Object value, Object value1) {
        ew.between("CUPLOGOFLAG", value, value1);
        return this;
    }

    public CardBinInfoCondition orCuplogoflagBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("CUPLOGOFLAG", value, value1);
        return this;
    }

    public CardBinInfoCondition andCuplogoflagNotBetween(Object value, Object value1) {
        ew.notBetween("CUPLOGOFLAG", value, value1);
        return this;
    }

    public CardBinInfoCondition orCuplogoflagNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("CUPLOGOFLAG", value, value1);
        return this;
    }

    public CardBinInfoCondition andCuplogoflagLike(String value) {
        ew.like("CUPLOGOFLAG", value);
        return this;
    }

    public CardBinInfoCondition orCuplogoflagLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("CUPLOGOFLAG", value);
        return this;
    }

    public CardBinInfoCondition andCuplogoflagNotLike(String value) {
        ew.notLike("CUPLOGOFLAG", value);
        return this;
    }

    public CardBinInfoCondition orCuplogoflagNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("CUPLOGOFLAG", value);
        return this;
    }

    public CardBinInfoCondition andDebitcreditflagIsNull() {
        ew.isNull("debitcreditflag");
        return this;
    }

    public CardBinInfoCondition orDebitcreditflagIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("debitcreditflag");
        return this;
    }

    public CardBinInfoCondition andDebitcreditflagIsNotNull() {
        ew.isNotNull("debitcreditflag");
        return this;
    }

    public CardBinInfoCondition orDebitcreditflagIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("debitcreditflag");
        return this;
    }

    public CardBinInfoCondition andDebitcreditflagEq(Object value) {
        ew.eq("debitcreditflag", value);
        return this;
    }

    public CardBinInfoCondition orDebitcreditflagEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("debitcreditflag", value);
        return this;
    }

    public CardBinInfoCondition andDebitcreditflagNe(Object value) {
        ew.ne("debitcreditflag", value);
        return this;
    }

    public CardBinInfoCondition orDebitcreditflagNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("debitcreditflag", value);
        return this;
    }

    public CardBinInfoCondition andDebitcreditflagGt(Object value) {
        ew.gt("debitcreditflag", value);
        return this;
    }

    public CardBinInfoCondition orDebitcreditflagGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("debitcreditflag", value);
        return this;
    }

    public CardBinInfoCondition andDebitcreditflagGe(Object value) {
        ew.ge("debitcreditflag", value);
        return this;
    }

    public CardBinInfoCondition orDebitcreditflagGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("debitcreditflag", value);
        return this;
    }

    public CardBinInfoCondition andDebitcreditflagLt(Object value) {
        ew.lt("debitcreditflag", value);
        return this;
    }

    public CardBinInfoCondition orDebitcreditflagLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("debitcreditflag", value);
        return this;
    }

    public CardBinInfoCondition andDebitcreditflagLe(Object value) {
        ew.le("debitcreditflag", value);
        return this;
    }

    public CardBinInfoCondition orDebitcreditflagLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("debitcreditflag", value);
        return this;
    }

    public CardBinInfoCondition andDebitcreditflagIn(Object... value) {
        ew.in("debitcreditflag", value);
        return this;
    }

    public CardBinInfoCondition orDebitcreditflagIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("debitcreditflag", value);
        return this;
    }

    public CardBinInfoCondition andDebitcreditflagNotIn(Object... value) {
        ew.notIn("debitcreditflag", value);
        return this;
    }

    public CardBinInfoCondition orDebitcreditflagNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("debitcreditflag", value);
        return this;
    }

    public CardBinInfoCondition andDebitcreditflagBetween(Object value, Object value1) {
        ew.between("debitcreditflag", value, value1);
        return this;
    }

    public CardBinInfoCondition orDebitcreditflagBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("debitcreditflag", value, value1);
        return this;
    }

    public CardBinInfoCondition andDebitcreditflagNotBetween(Object value, Object value1) {
        ew.notBetween("debitcreditflag", value, value1);
        return this;
    }

    public CardBinInfoCondition orDebitcreditflagNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("debitcreditflag", value, value1);
        return this;
    }

    public CardBinInfoCondition andDebitcreditflagLike(String value) {
        ew.like("debitcreditflag", value);
        return this;
    }

    public CardBinInfoCondition orDebitcreditflagLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("debitcreditflag", value);
        return this;
    }

    public CardBinInfoCondition andDebitcreditflagNotLike(String value) {
        ew.notLike("debitcreditflag", value);
        return this;
    }

    public CardBinInfoCondition orDebitcreditflagNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("debitcreditflag", value);
        return this;
    }

    public CardBinInfoCondition andAdddeletestatIsNull() {
        ew.isNull("ADDDELETESTAT");
        return this;
    }

    public CardBinInfoCondition orAdddeletestatIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ADDDELETESTAT");
        return this;
    }

    public CardBinInfoCondition andAdddeletestatIsNotNull() {
        ew.isNotNull("ADDDELETESTAT");
        return this;
    }

    public CardBinInfoCondition orAdddeletestatIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ADDDELETESTAT");
        return this;
    }

    public CardBinInfoCondition andAdddeletestatEq(Object value) {
        ew.eq("ADDDELETESTAT", value);
        return this;
    }

    public CardBinInfoCondition orAdddeletestatEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ADDDELETESTAT", value);
        return this;
    }

    public CardBinInfoCondition andAdddeletestatNe(Object value) {
        ew.ne("ADDDELETESTAT", value);
        return this;
    }

    public CardBinInfoCondition orAdddeletestatNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ADDDELETESTAT", value);
        return this;
    }

    public CardBinInfoCondition andAdddeletestatGt(Object value) {
        ew.gt("ADDDELETESTAT", value);
        return this;
    }

    public CardBinInfoCondition orAdddeletestatGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ADDDELETESTAT", value);
        return this;
    }

    public CardBinInfoCondition andAdddeletestatGe(Object value) {
        ew.ge("ADDDELETESTAT", value);
        return this;
    }

    public CardBinInfoCondition orAdddeletestatGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ADDDELETESTAT", value);
        return this;
    }

    public CardBinInfoCondition andAdddeletestatLt(Object value) {
        ew.lt("ADDDELETESTAT", value);
        return this;
    }

    public CardBinInfoCondition orAdddeletestatLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ADDDELETESTAT", value);
        return this;
    }

    public CardBinInfoCondition andAdddeletestatLe(Object value) {
        ew.le("ADDDELETESTAT", value);
        return this;
    }

    public CardBinInfoCondition orAdddeletestatLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ADDDELETESTAT", value);
        return this;
    }

    public CardBinInfoCondition andAdddeletestatIn(Object... value) {
        ew.in("ADDDELETESTAT", value);
        return this;
    }

    public CardBinInfoCondition orAdddeletestatIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ADDDELETESTAT", value);
        return this;
    }

    public CardBinInfoCondition andAdddeletestatNotIn(Object... value) {
        ew.notIn("ADDDELETESTAT", value);
        return this;
    }

    public CardBinInfoCondition orAdddeletestatNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ADDDELETESTAT", value);
        return this;
    }

    public CardBinInfoCondition andAdddeletestatBetween(Object value, Object value1) {
        ew.between("ADDDELETESTAT", value, value1);
        return this;
    }

    public CardBinInfoCondition orAdddeletestatBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ADDDELETESTAT", value, value1);
        return this;
    }

    public CardBinInfoCondition andAdddeletestatNotBetween(Object value, Object value1) {
        ew.notBetween("ADDDELETESTAT", value, value1);
        return this;
    }

    public CardBinInfoCondition orAdddeletestatNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ADDDELETESTAT", value, value1);
        return this;
    }

    public CardBinInfoCondition andAdddeletestatLike(String value) {
        ew.like("ADDDELETESTAT", value);
        return this;
    }

    public CardBinInfoCondition orAdddeletestatLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ADDDELETESTAT", value);
        return this;
    }

    public CardBinInfoCondition andAdddeletestatNotLike(String value) {
        ew.notLike("ADDDELETESTAT", value);
        return this;
    }

    public CardBinInfoCondition orAdddeletestatNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ADDDELETESTAT", value);
        return this;
    }

    public CardBinInfoCondition andClearbanknoIsNull() {
        ew.isNull("CLEARBANKNO");
        return this;
    }

    public CardBinInfoCondition orClearbanknoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("CLEARBANKNO");
        return this;
    }

    public CardBinInfoCondition andClearbanknoIsNotNull() {
        ew.isNotNull("CLEARBANKNO");
        return this;
    }

    public CardBinInfoCondition orClearbanknoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("CLEARBANKNO");
        return this;
    }

    public CardBinInfoCondition andClearbanknoEq(Object value) {
        ew.eq("CLEARBANKNO", value);
        return this;
    }

    public CardBinInfoCondition orClearbanknoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("CLEARBANKNO", value);
        return this;
    }

    public CardBinInfoCondition andClearbanknoNe(Object value) {
        ew.ne("CLEARBANKNO", value);
        return this;
    }

    public CardBinInfoCondition orClearbanknoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("CLEARBANKNO", value);
        return this;
    }

    public CardBinInfoCondition andClearbanknoGt(Object value) {
        ew.gt("CLEARBANKNO", value);
        return this;
    }

    public CardBinInfoCondition orClearbanknoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("CLEARBANKNO", value);
        return this;
    }

    public CardBinInfoCondition andClearbanknoGe(Object value) {
        ew.ge("CLEARBANKNO", value);
        return this;
    }

    public CardBinInfoCondition orClearbanknoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("CLEARBANKNO", value);
        return this;
    }

    public CardBinInfoCondition andClearbanknoLt(Object value) {
        ew.lt("CLEARBANKNO", value);
        return this;
    }

    public CardBinInfoCondition orClearbanknoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("CLEARBANKNO", value);
        return this;
    }

    public CardBinInfoCondition andClearbanknoLe(Object value) {
        ew.le("CLEARBANKNO", value);
        return this;
    }

    public CardBinInfoCondition orClearbanknoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("CLEARBANKNO", value);
        return this;
    }

    public CardBinInfoCondition andClearbanknoIn(Object... value) {
        ew.in("CLEARBANKNO", value);
        return this;
    }

    public CardBinInfoCondition orClearbanknoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("CLEARBANKNO", value);
        return this;
    }

    public CardBinInfoCondition andClearbanknoNotIn(Object... value) {
        ew.notIn("CLEARBANKNO", value);
        return this;
    }

    public CardBinInfoCondition orClearbanknoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("CLEARBANKNO", value);
        return this;
    }

    public CardBinInfoCondition andClearbanknoBetween(Object value, Object value1) {
        ew.between("CLEARBANKNO", value, value1);
        return this;
    }

    public CardBinInfoCondition orClearbanknoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("CLEARBANKNO", value, value1);
        return this;
    }

    public CardBinInfoCondition andClearbanknoNotBetween(Object value, Object value1) {
        ew.notBetween("CLEARBANKNO", value, value1);
        return this;
    }

    public CardBinInfoCondition orClearbanknoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("CLEARBANKNO", value, value1);
        return this;
    }

    public CardBinInfoCondition andClearbanknoLike(String value) {
        ew.like("CLEARBANKNO", value);
        return this;
    }

    public CardBinInfoCondition orClearbanknoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("CLEARBANKNO", value);
        return this;
    }

    public CardBinInfoCondition andClearbanknoNotLike(String value) {
        ew.notLike("CLEARBANKNO", value);
        return this;
    }

    public CardBinInfoCondition orClearbanknoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("CLEARBANKNO", value);
        return this;
    }

    public CardBinInfoCondition andClearbanknameIsNull() {
        ew.isNull("CLEARBANKNAME");
        return this;
    }

    public CardBinInfoCondition orClearbanknameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("CLEARBANKNAME");
        return this;
    }

    public CardBinInfoCondition andClearbanknameIsNotNull() {
        ew.isNotNull("CLEARBANKNAME");
        return this;
    }

    public CardBinInfoCondition orClearbanknameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("CLEARBANKNAME");
        return this;
    }

    public CardBinInfoCondition andClearbanknameEq(Object value) {
        ew.eq("CLEARBANKNAME", value);
        return this;
    }

    public CardBinInfoCondition orClearbanknameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("CLEARBANKNAME", value);
        return this;
    }

    public CardBinInfoCondition andClearbanknameNe(Object value) {
        ew.ne("CLEARBANKNAME", value);
        return this;
    }

    public CardBinInfoCondition orClearbanknameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("CLEARBANKNAME", value);
        return this;
    }

    public CardBinInfoCondition andClearbanknameGt(Object value) {
        ew.gt("CLEARBANKNAME", value);
        return this;
    }

    public CardBinInfoCondition orClearbanknameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("CLEARBANKNAME", value);
        return this;
    }

    public CardBinInfoCondition andClearbanknameGe(Object value) {
        ew.ge("CLEARBANKNAME", value);
        return this;
    }

    public CardBinInfoCondition orClearbanknameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("CLEARBANKNAME", value);
        return this;
    }

    public CardBinInfoCondition andClearbanknameLt(Object value) {
        ew.lt("CLEARBANKNAME", value);
        return this;
    }

    public CardBinInfoCondition orClearbanknameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("CLEARBANKNAME", value);
        return this;
    }

    public CardBinInfoCondition andClearbanknameLe(Object value) {
        ew.le("CLEARBANKNAME", value);
        return this;
    }

    public CardBinInfoCondition orClearbanknameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("CLEARBANKNAME", value);
        return this;
    }

    public CardBinInfoCondition andClearbanknameIn(Object... value) {
        ew.in("CLEARBANKNAME", value);
        return this;
    }

    public CardBinInfoCondition orClearbanknameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("CLEARBANKNAME", value);
        return this;
    }

    public CardBinInfoCondition andClearbanknameNotIn(Object... value) {
        ew.notIn("CLEARBANKNAME", value);
        return this;
    }

    public CardBinInfoCondition orClearbanknameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("CLEARBANKNAME", value);
        return this;
    }

    public CardBinInfoCondition andClearbanknameBetween(Object value, Object value1) {
        ew.between("CLEARBANKNAME", value, value1);
        return this;
    }

    public CardBinInfoCondition orClearbanknameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("CLEARBANKNAME", value, value1);
        return this;
    }

    public CardBinInfoCondition andClearbanknameNotBetween(Object value, Object value1) {
        ew.notBetween("CLEARBANKNAME", value, value1);
        return this;
    }

    public CardBinInfoCondition orClearbanknameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("CLEARBANKNAME", value, value1);
        return this;
    }

    public CardBinInfoCondition andClearbanknameLike(String value) {
        ew.like("CLEARBANKNAME", value);
        return this;
    }

    public CardBinInfoCondition orClearbanknameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("CLEARBANKNAME", value);
        return this;
    }

    public CardBinInfoCondition andClearbanknameNotLike(String value) {
        ew.notLike("CLEARBANKNAME", value);
        return this;
    }

    public CardBinInfoCondition orClearbanknameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("CLEARBANKNAME", value);
        return this;
    }

    public CardBinInfoCondition andStatusIsNull() {
        ew.isNull("STATUS");
        return this;
    }

    public CardBinInfoCondition orStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("STATUS");
        return this;
    }

    public CardBinInfoCondition andStatusIsNotNull() {
        ew.isNotNull("STATUS");
        return this;
    }

    public CardBinInfoCondition orStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("STATUS");
        return this;
    }

    public CardBinInfoCondition andStatusEq(Object value) {
        ew.eq("STATUS", value);
        return this;
    }

    public CardBinInfoCondition orStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("STATUS", value);
        return this;
    }

    public CardBinInfoCondition andStatusNe(Object value) {
        ew.ne("STATUS", value);
        return this;
    }

    public CardBinInfoCondition orStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("STATUS", value);
        return this;
    }

    public CardBinInfoCondition andStatusGt(Object value) {
        ew.gt("STATUS", value);
        return this;
    }

    public CardBinInfoCondition orStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("STATUS", value);
        return this;
    }

    public CardBinInfoCondition andStatusGe(Object value) {
        ew.ge("STATUS", value);
        return this;
    }

    public CardBinInfoCondition orStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("STATUS", value);
        return this;
    }

    public CardBinInfoCondition andStatusLt(Object value) {
        ew.lt("STATUS", value);
        return this;
    }

    public CardBinInfoCondition orStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("STATUS", value);
        return this;
    }

    public CardBinInfoCondition andStatusLe(Object value) {
        ew.le("STATUS", value);
        return this;
    }

    public CardBinInfoCondition orStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("STATUS", value);
        return this;
    }

    public CardBinInfoCondition andStatusIn(Object... value) {
        ew.in("STATUS", value);
        return this;
    }

    public CardBinInfoCondition orStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("STATUS", value);
        return this;
    }

    public CardBinInfoCondition andStatusNotIn(Object... value) {
        ew.notIn("STATUS", value);
        return this;
    }

    public CardBinInfoCondition orStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("STATUS", value);
        return this;
    }

    public CardBinInfoCondition andStatusBetween(Object value, Object value1) {
        ew.between("STATUS", value, value1);
        return this;
    }

    public CardBinInfoCondition orStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("STATUS", value, value1);
        return this;
    }

    public CardBinInfoCondition andStatusNotBetween(Object value, Object value1) {
        ew.notBetween("STATUS", value, value1);
        return this;
    }

    public CardBinInfoCondition orStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("STATUS", value, value1);
        return this;
    }

    public CardBinInfoCondition andStatusLike(String value) {
        ew.like("STATUS", value);
        return this;
    }

    public CardBinInfoCondition orStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("STATUS", value);
        return this;
    }

    public CardBinInfoCondition andStatusNotLike(String value) {
        ew.notLike("STATUS", value);
        return this;
    }

    public CardBinInfoCondition orStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("STATUS", value);
        return this;
    }

    public CardBinInfoCondition andAdddataIsNull() {
        ew.isNull("ADDDATA");
        return this;
    }

    public CardBinInfoCondition orAdddataIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ADDDATA");
        return this;
    }

    public CardBinInfoCondition andAdddataIsNotNull() {
        ew.isNotNull("ADDDATA");
        return this;
    }

    public CardBinInfoCondition orAdddataIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ADDDATA");
        return this;
    }

    public CardBinInfoCondition andAdddataEq(Object value) {
        ew.eq("ADDDATA", value);
        return this;
    }

    public CardBinInfoCondition orAdddataEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ADDDATA", value);
        return this;
    }

    public CardBinInfoCondition andAdddataNe(Object value) {
        ew.ne("ADDDATA", value);
        return this;
    }

    public CardBinInfoCondition orAdddataNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ADDDATA", value);
        return this;
    }

    public CardBinInfoCondition andAdddataGt(Object value) {
        ew.gt("ADDDATA", value);
        return this;
    }

    public CardBinInfoCondition orAdddataGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ADDDATA", value);
        return this;
    }

    public CardBinInfoCondition andAdddataGe(Object value) {
        ew.ge("ADDDATA", value);
        return this;
    }

    public CardBinInfoCondition orAdddataGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ADDDATA", value);
        return this;
    }

    public CardBinInfoCondition andAdddataLt(Object value) {
        ew.lt("ADDDATA", value);
        return this;
    }

    public CardBinInfoCondition orAdddataLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ADDDATA", value);
        return this;
    }

    public CardBinInfoCondition andAdddataLe(Object value) {
        ew.le("ADDDATA", value);
        return this;
    }

    public CardBinInfoCondition orAdddataLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ADDDATA", value);
        return this;
    }

    public CardBinInfoCondition andAdddataIn(Object... value) {
        ew.in("ADDDATA", value);
        return this;
    }

    public CardBinInfoCondition orAdddataIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ADDDATA", value);
        return this;
    }

    public CardBinInfoCondition andAdddataNotIn(Object... value) {
        ew.notIn("ADDDATA", value);
        return this;
    }

    public CardBinInfoCondition orAdddataNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ADDDATA", value);
        return this;
    }

    public CardBinInfoCondition andAdddataBetween(Object value, Object value1) {
        ew.between("ADDDATA", value, value1);
        return this;
    }

    public CardBinInfoCondition orAdddataBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ADDDATA", value, value1);
        return this;
    }

    public CardBinInfoCondition andAdddataNotBetween(Object value, Object value1) {
        ew.notBetween("ADDDATA", value, value1);
        return this;
    }

    public CardBinInfoCondition orAdddataNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ADDDATA", value, value1);
        return this;
    }

    public CardBinInfoCondition andAdddataLike(String value) {
        ew.like("ADDDATA", value);
        return this;
    }

    public CardBinInfoCondition orAdddataLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ADDDATA", value);
        return this;
    }

    public CardBinInfoCondition andAdddataNotLike(String value) {
        ew.notLike("ADDDATA", value);
        return this;
    }

    public CardBinInfoCondition orAdddataNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ADDDATA", value);
        return this;
    }

    public CardBinInfoCondition andRemark1IsNull() {
        ew.isNull("REMARK1");
        return this;
    }

    public CardBinInfoCondition orRemark1IsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("REMARK1");
        return this;
    }

    public CardBinInfoCondition andRemark1IsNotNull() {
        ew.isNotNull("REMARK1");
        return this;
    }

    public CardBinInfoCondition orRemark1IsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("REMARK1");
        return this;
    }

    public CardBinInfoCondition andRemark1Eq(Object value) {
        ew.eq("REMARK1", value);
        return this;
    }

    public CardBinInfoCondition orRemark1Eq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("REMARK1", value);
        return this;
    }

    public CardBinInfoCondition andRemark1Ne(Object value) {
        ew.ne("REMARK1", value);
        return this;
    }

    public CardBinInfoCondition orRemark1Ne(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("REMARK1", value);
        return this;
    }

    public CardBinInfoCondition andRemark1Gt(Object value) {
        ew.gt("REMARK1", value);
        return this;
    }

    public CardBinInfoCondition orRemark1Gt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("REMARK1", value);
        return this;
    }

    public CardBinInfoCondition andRemark1Ge(Object value) {
        ew.ge("REMARK1", value);
        return this;
    }

    public CardBinInfoCondition orRemark1Ge(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("REMARK1", value);
        return this;
    }

    public CardBinInfoCondition andRemark1Lt(Object value) {
        ew.lt("REMARK1", value);
        return this;
    }

    public CardBinInfoCondition orRemark1Lt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("REMARK1", value);
        return this;
    }

    public CardBinInfoCondition andRemark1Le(Object value) {
        ew.le("REMARK1", value);
        return this;
    }

    public CardBinInfoCondition orRemark1Le(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("REMARK1", value);
        return this;
    }

    public CardBinInfoCondition andRemark1In(Object... value) {
        ew.in("REMARK1", value);
        return this;
    }

    public CardBinInfoCondition orRemark1In(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("REMARK1", value);
        return this;
    }

    public CardBinInfoCondition andRemark1NotIn(Object... value) {
        ew.notIn("REMARK1", value);
        return this;
    }

    public CardBinInfoCondition orRemark1NotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("REMARK1", value);
        return this;
    }

    public CardBinInfoCondition andRemark1Between(Object value, Object value1) {
        ew.between("REMARK1", value, value1);
        return this;
    }

    public CardBinInfoCondition orRemark1Between(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("REMARK1", value, value1);
        return this;
    }

    public CardBinInfoCondition andRemark1NotBetween(Object value, Object value1) {
        ew.notBetween("REMARK1", value, value1);
        return this;
    }

    public CardBinInfoCondition orRemark1NotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("REMARK1", value, value1);
        return this;
    }

    public CardBinInfoCondition andRemark1Like(String value) {
        ew.like("REMARK1", value);
        return this;
    }

    public CardBinInfoCondition orRemark1Like(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("REMARK1", value);
        return this;
    }

    public CardBinInfoCondition andRemark1NotLike(String value) {
        ew.notLike("REMARK1", value);
        return this;
    }

    public CardBinInfoCondition orRemark1NotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("REMARK1", value);
        return this;
    }

    public CardBinInfoCondition andRemark2IsNull() {
        ew.isNull("REMARK2");
        return this;
    }

    public CardBinInfoCondition orRemark2IsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("REMARK2");
        return this;
    }

    public CardBinInfoCondition andRemark2IsNotNull() {
        ew.isNotNull("REMARK2");
        return this;
    }

    public CardBinInfoCondition orRemark2IsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("REMARK2");
        return this;
    }

    public CardBinInfoCondition andRemark2Eq(Object value) {
        ew.eq("REMARK2", value);
        return this;
    }

    public CardBinInfoCondition orRemark2Eq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("REMARK2", value);
        return this;
    }

    public CardBinInfoCondition andRemark2Ne(Object value) {
        ew.ne("REMARK2", value);
        return this;
    }

    public CardBinInfoCondition orRemark2Ne(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("REMARK2", value);
        return this;
    }

    public CardBinInfoCondition andRemark2Gt(Object value) {
        ew.gt("REMARK2", value);
        return this;
    }

    public CardBinInfoCondition orRemark2Gt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("REMARK2", value);
        return this;
    }

    public CardBinInfoCondition andRemark2Ge(Object value) {
        ew.ge("REMARK2", value);
        return this;
    }

    public CardBinInfoCondition orRemark2Ge(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("REMARK2", value);
        return this;
    }

    public CardBinInfoCondition andRemark2Lt(Object value) {
        ew.lt("REMARK2", value);
        return this;
    }

    public CardBinInfoCondition orRemark2Lt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("REMARK2", value);
        return this;
    }

    public CardBinInfoCondition andRemark2Le(Object value) {
        ew.le("REMARK2", value);
        return this;
    }

    public CardBinInfoCondition orRemark2Le(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("REMARK2", value);
        return this;
    }

    public CardBinInfoCondition andRemark2In(Object... value) {
        ew.in("REMARK2", value);
        return this;
    }

    public CardBinInfoCondition orRemark2In(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("REMARK2", value);
        return this;
    }

    public CardBinInfoCondition andRemark2NotIn(Object... value) {
        ew.notIn("REMARK2", value);
        return this;
    }

    public CardBinInfoCondition orRemark2NotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("REMARK2", value);
        return this;
    }

    public CardBinInfoCondition andRemark2Between(Object value, Object value1) {
        ew.between("REMARK2", value, value1);
        return this;
    }

    public CardBinInfoCondition orRemark2Between(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("REMARK2", value, value1);
        return this;
    }

    public CardBinInfoCondition andRemark2NotBetween(Object value, Object value1) {
        ew.notBetween("REMARK2", value, value1);
        return this;
    }

    public CardBinInfoCondition orRemark2NotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("REMARK2", value, value1);
        return this;
    }

    public CardBinInfoCondition andRemark2Like(String value) {
        ew.like("REMARK2", value);
        return this;
    }

    public CardBinInfoCondition orRemark2Like(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("REMARK2", value);
        return this;
    }

    public CardBinInfoCondition andRemark2NotLike(String value) {
        ew.notLike("REMARK2", value);
        return this;
    }

    public CardBinInfoCondition orRemark2NotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("REMARK2", value);
        return this;
    }

    public CardBinInfoCondition andRemark3IsNull() {
        ew.isNull("REMARK3");
        return this;
    }

    public CardBinInfoCondition orRemark3IsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("REMARK3");
        return this;
    }

    public CardBinInfoCondition andRemark3IsNotNull() {
        ew.isNotNull("REMARK3");
        return this;
    }

    public CardBinInfoCondition orRemark3IsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("REMARK3");
        return this;
    }

    public CardBinInfoCondition andRemark3Eq(Object value) {
        ew.eq("REMARK3", value);
        return this;
    }

    public CardBinInfoCondition orRemark3Eq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("REMARK3", value);
        return this;
    }

    public CardBinInfoCondition andRemark3Ne(Object value) {
        ew.ne("REMARK3", value);
        return this;
    }

    public CardBinInfoCondition orRemark3Ne(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("REMARK3", value);
        return this;
    }

    public CardBinInfoCondition andRemark3Gt(Object value) {
        ew.gt("REMARK3", value);
        return this;
    }

    public CardBinInfoCondition orRemark3Gt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("REMARK3", value);
        return this;
    }

    public CardBinInfoCondition andRemark3Ge(Object value) {
        ew.ge("REMARK3", value);
        return this;
    }

    public CardBinInfoCondition orRemark3Ge(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("REMARK3", value);
        return this;
    }

    public CardBinInfoCondition andRemark3Lt(Object value) {
        ew.lt("REMARK3", value);
        return this;
    }

    public CardBinInfoCondition orRemark3Lt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("REMARK3", value);
        return this;
    }

    public CardBinInfoCondition andRemark3Le(Object value) {
        ew.le("REMARK3", value);
        return this;
    }

    public CardBinInfoCondition orRemark3Le(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("REMARK3", value);
        return this;
    }

    public CardBinInfoCondition andRemark3In(Object... value) {
        ew.in("REMARK3", value);
        return this;
    }

    public CardBinInfoCondition orRemark3In(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("REMARK3", value);
        return this;
    }

    public CardBinInfoCondition andRemark3NotIn(Object... value) {
        ew.notIn("REMARK3", value);
        return this;
    }

    public CardBinInfoCondition orRemark3NotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("REMARK3", value);
        return this;
    }

    public CardBinInfoCondition andRemark3Between(Object value, Object value1) {
        ew.between("REMARK3", value, value1);
        return this;
    }

    public CardBinInfoCondition orRemark3Between(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("REMARK3", value, value1);
        return this;
    }

    public CardBinInfoCondition andRemark3NotBetween(Object value, Object value1) {
        ew.notBetween("REMARK3", value, value1);
        return this;
    }

    public CardBinInfoCondition orRemark3NotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("REMARK3", value, value1);
        return this;
    }

    public CardBinInfoCondition andRemark3Like(String value) {
        ew.like("REMARK3", value);
        return this;
    }

    public CardBinInfoCondition orRemark3Like(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("REMARK3", value);
        return this;
    }

    public CardBinInfoCondition andRemark3NotLike(String value) {
        ew.notLike("REMARK3", value);
        return this;
    }

    public CardBinInfoCondition orRemark3NotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("REMARK3", value);
        return this;
    }

    public CardBinInfoCondition andCreateTimeIsNull() {
        ew.isNull("CREATE_TIME");
        return this;
    }

    public CardBinInfoCondition orCreateTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("CREATE_TIME");
        return this;
    }

    public CardBinInfoCondition andCreateTimeIsNotNull() {
        ew.isNotNull("CREATE_TIME");
        return this;
    }

    public CardBinInfoCondition orCreateTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("CREATE_TIME");
        return this;
    }

    public CardBinInfoCondition andCreateTimeEq(Object value) {
        ew.eq("CREATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition orCreateTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("CREATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition andCreateTimeNe(Object value) {
        ew.ne("CREATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition orCreateTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("CREATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition andCreateTimeGt(Object value) {
        ew.gt("CREATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition orCreateTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("CREATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition andCreateTimeGe(Object value) {
        ew.ge("CREATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition orCreateTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("CREATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition andCreateTimeLt(Object value) {
        ew.lt("CREATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition orCreateTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("CREATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition andCreateTimeLe(Object value) {
        ew.le("CREATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition orCreateTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("CREATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition andCreateTimeIn(Object... value) {
        ew.in("CREATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition orCreateTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("CREATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition andCreateTimeNotIn(Object... value) {
        ew.notIn("CREATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition orCreateTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("CREATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition andCreateTimeBetween(Object value, Object value1) {
        ew.between("CREATE_TIME", value, value1);
        return this;
    }

    public CardBinInfoCondition orCreateTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("CREATE_TIME", value, value1);
        return this;
    }

    public CardBinInfoCondition andCreateTimeNotBetween(Object value, Object value1) {
        ew.notBetween("CREATE_TIME", value, value1);
        return this;
    }

    public CardBinInfoCondition orCreateTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("CREATE_TIME", value, value1);
        return this;
    }

    public CardBinInfoCondition andCreateTimeLike(String value) {
        ew.like("CREATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition orCreateTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("CREATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition andCreateTimeNotLike(String value) {
        ew.notLike("CREATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition orCreateTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("CREATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition andCreateorIsNull() {
        ew.isNull("CREATEOR");
        return this;
    }

    public CardBinInfoCondition orCreateorIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("CREATEOR");
        return this;
    }

    public CardBinInfoCondition andCreateorIsNotNull() {
        ew.isNotNull("CREATEOR");
        return this;
    }

    public CardBinInfoCondition orCreateorIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("CREATEOR");
        return this;
    }

    public CardBinInfoCondition andCreateorEq(Object value) {
        ew.eq("CREATEOR", value);
        return this;
    }

    public CardBinInfoCondition orCreateorEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("CREATEOR", value);
        return this;
    }

    public CardBinInfoCondition andCreateorNe(Object value) {
        ew.ne("CREATEOR", value);
        return this;
    }

    public CardBinInfoCondition orCreateorNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("CREATEOR", value);
        return this;
    }

    public CardBinInfoCondition andCreateorGt(Object value) {
        ew.gt("CREATEOR", value);
        return this;
    }

    public CardBinInfoCondition orCreateorGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("CREATEOR", value);
        return this;
    }

    public CardBinInfoCondition andCreateorGe(Object value) {
        ew.ge("CREATEOR", value);
        return this;
    }

    public CardBinInfoCondition orCreateorGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("CREATEOR", value);
        return this;
    }

    public CardBinInfoCondition andCreateorLt(Object value) {
        ew.lt("CREATEOR", value);
        return this;
    }

    public CardBinInfoCondition orCreateorLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("CREATEOR", value);
        return this;
    }

    public CardBinInfoCondition andCreateorLe(Object value) {
        ew.le("CREATEOR", value);
        return this;
    }

    public CardBinInfoCondition orCreateorLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("CREATEOR", value);
        return this;
    }

    public CardBinInfoCondition andCreateorIn(Object... value) {
        ew.in("CREATEOR", value);
        return this;
    }

    public CardBinInfoCondition orCreateorIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("CREATEOR", value);
        return this;
    }

    public CardBinInfoCondition andCreateorNotIn(Object... value) {
        ew.notIn("CREATEOR", value);
        return this;
    }

    public CardBinInfoCondition orCreateorNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("CREATEOR", value);
        return this;
    }

    public CardBinInfoCondition andCreateorBetween(Object value, Object value1) {
        ew.between("CREATEOR", value, value1);
        return this;
    }

    public CardBinInfoCondition orCreateorBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("CREATEOR", value, value1);
        return this;
    }

    public CardBinInfoCondition andCreateorNotBetween(Object value, Object value1) {
        ew.notBetween("CREATEOR", value, value1);
        return this;
    }

    public CardBinInfoCondition orCreateorNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("CREATEOR", value, value1);
        return this;
    }

    public CardBinInfoCondition andCreateorLike(String value) {
        ew.like("CREATEOR", value);
        return this;
    }

    public CardBinInfoCondition orCreateorLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("CREATEOR", value);
        return this;
    }

    public CardBinInfoCondition andCreateorNotLike(String value) {
        ew.notLike("CREATEOR", value);
        return this;
    }

    public CardBinInfoCondition orCreateorNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("CREATEOR", value);
        return this;
    }

    public CardBinInfoCondition andUpdateorIsNull() {
        ew.isNull("UPDATEOR");
        return this;
    }

    public CardBinInfoCondition orUpdateorIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("UPDATEOR");
        return this;
    }

    public CardBinInfoCondition andUpdateorIsNotNull() {
        ew.isNotNull("UPDATEOR");
        return this;
    }

    public CardBinInfoCondition orUpdateorIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("UPDATEOR");
        return this;
    }

    public CardBinInfoCondition andUpdateorEq(Object value) {
        ew.eq("UPDATEOR", value);
        return this;
    }

    public CardBinInfoCondition orUpdateorEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("UPDATEOR", value);
        return this;
    }

    public CardBinInfoCondition andUpdateorNe(Object value) {
        ew.ne("UPDATEOR", value);
        return this;
    }

    public CardBinInfoCondition orUpdateorNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("UPDATEOR", value);
        return this;
    }

    public CardBinInfoCondition andUpdateorGt(Object value) {
        ew.gt("UPDATEOR", value);
        return this;
    }

    public CardBinInfoCondition orUpdateorGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("UPDATEOR", value);
        return this;
    }

    public CardBinInfoCondition andUpdateorGe(Object value) {
        ew.ge("UPDATEOR", value);
        return this;
    }

    public CardBinInfoCondition orUpdateorGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("UPDATEOR", value);
        return this;
    }

    public CardBinInfoCondition andUpdateorLt(Object value) {
        ew.lt("UPDATEOR", value);
        return this;
    }

    public CardBinInfoCondition orUpdateorLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("UPDATEOR", value);
        return this;
    }

    public CardBinInfoCondition andUpdateorLe(Object value) {
        ew.le("UPDATEOR", value);
        return this;
    }

    public CardBinInfoCondition orUpdateorLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("UPDATEOR", value);
        return this;
    }

    public CardBinInfoCondition andUpdateorIn(Object... value) {
        ew.in("UPDATEOR", value);
        return this;
    }

    public CardBinInfoCondition orUpdateorIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("UPDATEOR", value);
        return this;
    }

    public CardBinInfoCondition andUpdateorNotIn(Object... value) {
        ew.notIn("UPDATEOR", value);
        return this;
    }

    public CardBinInfoCondition orUpdateorNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("UPDATEOR", value);
        return this;
    }

    public CardBinInfoCondition andUpdateorBetween(Object value, Object value1) {
        ew.between("UPDATEOR", value, value1);
        return this;
    }

    public CardBinInfoCondition orUpdateorBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("UPDATEOR", value, value1);
        return this;
    }

    public CardBinInfoCondition andUpdateorNotBetween(Object value, Object value1) {
        ew.notBetween("UPDATEOR", value, value1);
        return this;
    }

    public CardBinInfoCondition orUpdateorNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("UPDATEOR", value, value1);
        return this;
    }

    public CardBinInfoCondition andUpdateorLike(String value) {
        ew.like("UPDATEOR", value);
        return this;
    }

    public CardBinInfoCondition orUpdateorLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("UPDATEOR", value);
        return this;
    }

    public CardBinInfoCondition andUpdateorNotLike(String value) {
        ew.notLike("UPDATEOR", value);
        return this;
    }

    public CardBinInfoCondition orUpdateorNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("UPDATEOR", value);
        return this;
    }

    public CardBinInfoCondition andUpdateTimeIsNull() {
        ew.isNull("UPDATE_TIME");
        return this;
    }

    public CardBinInfoCondition orUpdateTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("UPDATE_TIME");
        return this;
    }

    public CardBinInfoCondition andUpdateTimeIsNotNull() {
        ew.isNotNull("UPDATE_TIME");
        return this;
    }

    public CardBinInfoCondition orUpdateTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("UPDATE_TIME");
        return this;
    }

    public CardBinInfoCondition andUpdateTimeEq(Object value) {
        ew.eq("UPDATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition orUpdateTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("UPDATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition andUpdateTimeNe(Object value) {
        ew.ne("UPDATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition orUpdateTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("UPDATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition andUpdateTimeGt(Object value) {
        ew.gt("UPDATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition orUpdateTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("UPDATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition andUpdateTimeGe(Object value) {
        ew.ge("UPDATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition orUpdateTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("UPDATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition andUpdateTimeLt(Object value) {
        ew.lt("UPDATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition orUpdateTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("UPDATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition andUpdateTimeLe(Object value) {
        ew.le("UPDATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition orUpdateTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("UPDATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition andUpdateTimeIn(Object... value) {
        ew.in("UPDATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition orUpdateTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("UPDATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition andUpdateTimeNotIn(Object... value) {
        ew.notIn("UPDATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition orUpdateTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("UPDATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition andUpdateTimeBetween(Object value, Object value1) {
        ew.between("UPDATE_TIME", value, value1);
        return this;
    }

    public CardBinInfoCondition orUpdateTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("UPDATE_TIME", value, value1);
        return this;
    }

    public CardBinInfoCondition andUpdateTimeNotBetween(Object value, Object value1) {
        ew.notBetween("UPDATE_TIME", value, value1);
        return this;
    }

    public CardBinInfoCondition orUpdateTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("UPDATE_TIME", value, value1);
        return this;
    }

    public CardBinInfoCondition andUpdateTimeLike(String value) {
        ew.like("UPDATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition orUpdateTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("UPDATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition andUpdateTimeNotLike(String value) {
        ew.notLike("UPDATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition orUpdateTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("UPDATE_TIME", value);
        return this;
    }

    public CardBinInfoCondition andBankcodeIsNull() {
        ew.isNull("bankcode");
        return this;
    }

    public CardBinInfoCondition orBankcodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("bankcode");
        return this;
    }

    public CardBinInfoCondition andBankcodeIsNotNull() {
        ew.isNotNull("bankcode");
        return this;
    }

    public CardBinInfoCondition orBankcodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("bankcode");
        return this;
    }

    public CardBinInfoCondition andBankcodeEq(Object value) {
        ew.eq("bankcode", value);
        return this;
    }

    public CardBinInfoCondition orBankcodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("bankcode", value);
        return this;
    }

    public CardBinInfoCondition andBankcodeNe(Object value) {
        ew.ne("bankcode", value);
        return this;
    }

    public CardBinInfoCondition orBankcodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("bankcode", value);
        return this;
    }

    public CardBinInfoCondition andBankcodeGt(Object value) {
        ew.gt("bankcode", value);
        return this;
    }

    public CardBinInfoCondition orBankcodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("bankcode", value);
        return this;
    }

    public CardBinInfoCondition andBankcodeGe(Object value) {
        ew.ge("bankcode", value);
        return this;
    }

    public CardBinInfoCondition orBankcodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("bankcode", value);
        return this;
    }

    public CardBinInfoCondition andBankcodeLt(Object value) {
        ew.lt("bankcode", value);
        return this;
    }

    public CardBinInfoCondition orBankcodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("bankcode", value);
        return this;
    }

    public CardBinInfoCondition andBankcodeLe(Object value) {
        ew.le("bankcode", value);
        return this;
    }

    public CardBinInfoCondition orBankcodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("bankcode", value);
        return this;
    }

    public CardBinInfoCondition andBankcodeIn(Object... value) {
        ew.in("bankcode", value);
        return this;
    }

    public CardBinInfoCondition orBankcodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("bankcode", value);
        return this;
    }

    public CardBinInfoCondition andBankcodeNotIn(Object... value) {
        ew.notIn("bankcode", value);
        return this;
    }

    public CardBinInfoCondition orBankcodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("bankcode", value);
        return this;
    }

    public CardBinInfoCondition andBankcodeBetween(Object value, Object value1) {
        ew.between("bankcode", value, value1);
        return this;
    }

    public CardBinInfoCondition orBankcodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("bankcode", value, value1);
        return this;
    }

    public CardBinInfoCondition andBankcodeNotBetween(Object value, Object value1) {
        ew.notBetween("bankcode", value, value1);
        return this;
    }

    public CardBinInfoCondition orBankcodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("bankcode", value, value1);
        return this;
    }

    public CardBinInfoCondition andBankcodeLike(String value) {
        ew.like("bankcode", value);
        return this;
    }

    public CardBinInfoCondition orBankcodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("bankcode", value);
        return this;
    }

    public CardBinInfoCondition andBankcodeNotLike(String value) {
        ew.notLike("bankcode", value);
        return this;
    }

    public CardBinInfoCondition orBankcodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("bankcode", value);
        return this;
    }

    public CardBinInfoCondition andBanknameIsNull() {
        ew.isNull("bankname");
        return this;
    }

    public CardBinInfoCondition orBanknameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("bankname");
        return this;
    }

    public CardBinInfoCondition andBanknameIsNotNull() {
        ew.isNotNull("bankname");
        return this;
    }

    public CardBinInfoCondition orBanknameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("bankname");
        return this;
    }

    public CardBinInfoCondition andBanknameEq(Object value) {
        ew.eq("bankname", value);
        return this;
    }

    public CardBinInfoCondition orBanknameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("bankname", value);
        return this;
    }

    public CardBinInfoCondition andBanknameNe(Object value) {
        ew.ne("bankname", value);
        return this;
    }

    public CardBinInfoCondition orBanknameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("bankname", value);
        return this;
    }

    public CardBinInfoCondition andBanknameGt(Object value) {
        ew.gt("bankname", value);
        return this;
    }

    public CardBinInfoCondition orBanknameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("bankname", value);
        return this;
    }

    public CardBinInfoCondition andBanknameGe(Object value) {
        ew.ge("bankname", value);
        return this;
    }

    public CardBinInfoCondition orBanknameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("bankname", value);
        return this;
    }

    public CardBinInfoCondition andBanknameLt(Object value) {
        ew.lt("bankname", value);
        return this;
    }

    public CardBinInfoCondition orBanknameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("bankname", value);
        return this;
    }

    public CardBinInfoCondition andBanknameLe(Object value) {
        ew.le("bankname", value);
        return this;
    }

    public CardBinInfoCondition orBanknameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("bankname", value);
        return this;
    }

    public CardBinInfoCondition andBanknameIn(Object... value) {
        ew.in("bankname", value);
        return this;
    }

    public CardBinInfoCondition orBanknameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("bankname", value);
        return this;
    }

    public CardBinInfoCondition andBanknameNotIn(Object... value) {
        ew.notIn("bankname", value);
        return this;
    }

    public CardBinInfoCondition orBanknameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("bankname", value);
        return this;
    }

    public CardBinInfoCondition andBanknameBetween(Object value, Object value1) {
        ew.between("bankname", value, value1);
        return this;
    }

    public CardBinInfoCondition orBanknameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("bankname", value, value1);
        return this;
    }

    public CardBinInfoCondition andBanknameNotBetween(Object value, Object value1) {
        ew.notBetween("bankname", value, value1);
        return this;
    }

    public CardBinInfoCondition orBanknameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("bankname", value, value1);
        return this;
    }

    public CardBinInfoCondition andBanknameLike(String value) {
        ew.like("bankname", value);
        return this;
    }

    public CardBinInfoCondition orBanknameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("bankname", value);
        return this;
    }

    public CardBinInfoCondition andBanknameNotLike(String value) {
        ew.notLike("bankname", value);
        return this;
    }

    public CardBinInfoCondition orBanknameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("bankname", value);
        return this;
    }

    public CardBinInfoCondition andBanktypeflagIsNull() {
        ew.isNull("banktypeflag");
        return this;
    }

    public CardBinInfoCondition orBanktypeflagIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("banktypeflag");
        return this;
    }

    public CardBinInfoCondition andBanktypeflagIsNotNull() {
        ew.isNotNull("banktypeflag");
        return this;
    }

    public CardBinInfoCondition orBanktypeflagIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("banktypeflag");
        return this;
    }

    public CardBinInfoCondition andBanktypeflagEq(Object value) {
        ew.eq("banktypeflag", value);
        return this;
    }

    public CardBinInfoCondition orBanktypeflagEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("banktypeflag", value);
        return this;
    }

    public CardBinInfoCondition andBanktypeflagNe(Object value) {
        ew.ne("banktypeflag", value);
        return this;
    }

    public CardBinInfoCondition orBanktypeflagNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("banktypeflag", value);
        return this;
    }

    public CardBinInfoCondition andBanktypeflagGt(Object value) {
        ew.gt("banktypeflag", value);
        return this;
    }

    public CardBinInfoCondition orBanktypeflagGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("banktypeflag", value);
        return this;
    }

    public CardBinInfoCondition andBanktypeflagGe(Object value) {
        ew.ge("banktypeflag", value);
        return this;
    }

    public CardBinInfoCondition orBanktypeflagGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("banktypeflag", value);
        return this;
    }

    public CardBinInfoCondition andBanktypeflagLt(Object value) {
        ew.lt("banktypeflag", value);
        return this;
    }

    public CardBinInfoCondition orBanktypeflagLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("banktypeflag", value);
        return this;
    }

    public CardBinInfoCondition andBanktypeflagLe(Object value) {
        ew.le("banktypeflag", value);
        return this;
    }

    public CardBinInfoCondition orBanktypeflagLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("banktypeflag", value);
        return this;
    }

    public CardBinInfoCondition andBanktypeflagIn(Object... value) {
        ew.in("banktypeflag", value);
        return this;
    }

    public CardBinInfoCondition orBanktypeflagIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("banktypeflag", value);
        return this;
    }

    public CardBinInfoCondition andBanktypeflagNotIn(Object... value) {
        ew.notIn("banktypeflag", value);
        return this;
    }

    public CardBinInfoCondition orBanktypeflagNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("banktypeflag", value);
        return this;
    }

    public CardBinInfoCondition andBanktypeflagBetween(Object value, Object value1) {
        ew.between("banktypeflag", value, value1);
        return this;
    }

    public CardBinInfoCondition orBanktypeflagBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("banktypeflag", value, value1);
        return this;
    }

    public CardBinInfoCondition andBanktypeflagNotBetween(Object value, Object value1) {
        ew.notBetween("banktypeflag", value, value1);
        return this;
    }

    public CardBinInfoCondition orBanktypeflagNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("banktypeflag", value, value1);
        return this;
    }

    public CardBinInfoCondition andBanktypeflagLike(String value) {
        ew.like("banktypeflag", value);
        return this;
    }

    public CardBinInfoCondition orBanktypeflagLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("banktypeflag", value);
        return this;
    }

    public CardBinInfoCondition andBanktypeflagNotLike(String value) {
        ew.notLike("banktypeflag", value);
        return this;
    }

    public CardBinInfoCondition orBanktypeflagNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("banktypeflag", value);
        return this;
    }
}