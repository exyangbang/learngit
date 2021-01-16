package cn.kingnet.utp.scheduler.data.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class MerchantInfoCondition {
    private PlusEntityWrapper<MerchantInfo> ew;

    public MerchantInfoCondition() {
        this.ew = new PlusEntityWrapper(MerchantInfo.class);
    }

    public static MerchantInfoCondition builder() {
        return new MerchantInfoCondition();
    }

    public PlusEntityWrapper<MerchantInfo> build() {
        return this.ew;
    }

    public MerchantInfoCondition or() {
        this.ew.orNew();
        return this;
    }

    public MerchantInfoCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(MerchantInfo.class);
    }

    public MerchantInfoCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public MerchantInfoCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public MerchantInfoCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public MerchantInfoCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> MerchantInfoCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> MerchantInfoCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> MerchantInfoCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public MerchantInfoCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public MerchantInfoCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public MerchantInfoCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public MerchantInfoCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public MerchantInfoCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public MerchantInfoCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public MerchantInfoCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public MerchantInfoCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public MerchantInfoCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public MerchantInfoCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public MerchantInfoCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public MerchantInfoCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public MerchantInfoCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public MerchantInfoCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public MerchantInfoCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public MerchantInfoCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public MerchantInfoCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public MerchantInfoCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public MerchantInfoCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public MerchantInfoCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public MerchantInfoCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public MerchantInfoCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public MerchantInfoCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public MerchantInfoCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public MerchantInfoCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public MerchantInfoCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public MerchantInfoCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public MerchantInfoCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public MerchantInfoCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public MerchantInfoCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public MerchantInfoCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public MerchantInfoCondition andMerNoIsNull() {
        ew.isNull("mer_no");
        return this;
    }

    public MerchantInfoCondition orMerNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_no");
        return this;
    }

    public MerchantInfoCondition andMerNoIsNotNull() {
        ew.isNotNull("mer_no");
        return this;
    }

    public MerchantInfoCondition orMerNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_no");
        return this;
    }

    public MerchantInfoCondition andMerNoEq(Object value) {
        ew.eq("mer_no", value);
        return this;
    }

    public MerchantInfoCondition orMerNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_no", value);
        return this;
    }

    public MerchantInfoCondition andMerNoNe(Object value) {
        ew.ne("mer_no", value);
        return this;
    }

    public MerchantInfoCondition orMerNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_no", value);
        return this;
    }

    public MerchantInfoCondition andMerNoGt(Object value) {
        ew.gt("mer_no", value);
        return this;
    }

    public MerchantInfoCondition orMerNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_no", value);
        return this;
    }

    public MerchantInfoCondition andMerNoGe(Object value) {
        ew.ge("mer_no", value);
        return this;
    }

    public MerchantInfoCondition orMerNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_no", value);
        return this;
    }

    public MerchantInfoCondition andMerNoLt(Object value) {
        ew.lt("mer_no", value);
        return this;
    }

    public MerchantInfoCondition orMerNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_no", value);
        return this;
    }

    public MerchantInfoCondition andMerNoLe(Object value) {
        ew.le("mer_no", value);
        return this;
    }

    public MerchantInfoCondition orMerNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_no", value);
        return this;
    }

    public MerchantInfoCondition andMerNoIn(Object... value) {
        ew.in("mer_no", value);
        return this;
    }

    public MerchantInfoCondition orMerNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_no", value);
        return this;
    }

    public MerchantInfoCondition andMerNoNotIn(Object... value) {
        ew.notIn("mer_no", value);
        return this;
    }

    public MerchantInfoCondition orMerNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_no", value);
        return this;
    }

    public MerchantInfoCondition andMerNoBetween(Object value, Object value1) {
        ew.between("mer_no", value, value1);
        return this;
    }

    public MerchantInfoCondition orMerNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_no", value, value1);
        return this;
    }

    public MerchantInfoCondition andMerNoNotBetween(Object value, Object value1) {
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public MerchantInfoCondition orMerNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_no", value, value1);
        return this;
    }

    public MerchantInfoCondition andMerNoLike(String value) {
        ew.like("mer_no", value);
        return this;
    }

    public MerchantInfoCondition orMerNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_no", value);
        return this;
    }

    public MerchantInfoCondition andMerNoNotLike(String value) {
        ew.notLike("mer_no", value);
        return this;
    }

    public MerchantInfoCondition orMerNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_no", value);
        return this;
    }

    public MerchantInfoCondition andAccountIsNull() {
        ew.isNull("account");
        return this;
    }

    public MerchantInfoCondition orAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account");
        return this;
    }

    public MerchantInfoCondition andAccountIsNotNull() {
        ew.isNotNull("account");
        return this;
    }

    public MerchantInfoCondition orAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account");
        return this;
    }

    public MerchantInfoCondition andAccountEq(Object value) {
        ew.eq("account", value);
        return this;
    }

    public MerchantInfoCondition orAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account", value);
        return this;
    }

    public MerchantInfoCondition andAccountNe(Object value) {
        ew.ne("account", value);
        return this;
    }

    public MerchantInfoCondition orAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account", value);
        return this;
    }

    public MerchantInfoCondition andAccountGt(Object value) {
        ew.gt("account", value);
        return this;
    }

    public MerchantInfoCondition orAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account", value);
        return this;
    }

    public MerchantInfoCondition andAccountGe(Object value) {
        ew.ge("account", value);
        return this;
    }

    public MerchantInfoCondition orAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account", value);
        return this;
    }

    public MerchantInfoCondition andAccountLt(Object value) {
        ew.lt("account", value);
        return this;
    }

    public MerchantInfoCondition orAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account", value);
        return this;
    }

    public MerchantInfoCondition andAccountLe(Object value) {
        ew.le("account", value);
        return this;
    }

    public MerchantInfoCondition orAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account", value);
        return this;
    }

    public MerchantInfoCondition andAccountIn(Object... value) {
        ew.in("account", value);
        return this;
    }

    public MerchantInfoCondition orAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account", value);
        return this;
    }

    public MerchantInfoCondition andAccountNotIn(Object... value) {
        ew.notIn("account", value);
        return this;
    }

    public MerchantInfoCondition orAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account", value);
        return this;
    }

    public MerchantInfoCondition andAccountBetween(Object value, Object value1) {
        ew.between("account", value, value1);
        return this;
    }

    public MerchantInfoCondition orAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account", value, value1);
        return this;
    }

    public MerchantInfoCondition andAccountNotBetween(Object value, Object value1) {
        ew.notBetween("account", value, value1);
        return this;
    }

    public MerchantInfoCondition orAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account", value, value1);
        return this;
    }

    public MerchantInfoCondition andAccountLike(String value) {
        ew.like("account", value);
        return this;
    }

    public MerchantInfoCondition orAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account", value);
        return this;
    }

    public MerchantInfoCondition andAccountNotLike(String value) {
        ew.notLike("account", value);
        return this;
    }

    public MerchantInfoCondition orAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account", value);
        return this;
    }

    public MerchantInfoCondition andMerNameIsNull() {
        ew.isNull("mer_name");
        return this;
    }

    public MerchantInfoCondition orMerNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("mer_name");
        return this;
    }

    public MerchantInfoCondition andMerNameIsNotNull() {
        ew.isNotNull("mer_name");
        return this;
    }

    public MerchantInfoCondition orMerNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("mer_name");
        return this;
    }

    public MerchantInfoCondition andMerNameEq(Object value) {
        ew.eq("mer_name", value);
        return this;
    }

    public MerchantInfoCondition orMerNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("mer_name", value);
        return this;
    }

    public MerchantInfoCondition andMerNameNe(Object value) {
        ew.ne("mer_name", value);
        return this;
    }

    public MerchantInfoCondition orMerNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("mer_name", value);
        return this;
    }

    public MerchantInfoCondition andMerNameGt(Object value) {
        ew.gt("mer_name", value);
        return this;
    }

    public MerchantInfoCondition orMerNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("mer_name", value);
        return this;
    }

    public MerchantInfoCondition andMerNameGe(Object value) {
        ew.ge("mer_name", value);
        return this;
    }

    public MerchantInfoCondition orMerNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("mer_name", value);
        return this;
    }

    public MerchantInfoCondition andMerNameLt(Object value) {
        ew.lt("mer_name", value);
        return this;
    }

    public MerchantInfoCondition orMerNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("mer_name", value);
        return this;
    }

    public MerchantInfoCondition andMerNameLe(Object value) {
        ew.le("mer_name", value);
        return this;
    }

    public MerchantInfoCondition orMerNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("mer_name", value);
        return this;
    }

    public MerchantInfoCondition andMerNameIn(Object... value) {
        ew.in("mer_name", value);
        return this;
    }

    public MerchantInfoCondition orMerNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("mer_name", value);
        return this;
    }

    public MerchantInfoCondition andMerNameNotIn(Object... value) {
        ew.notIn("mer_name", value);
        return this;
    }

    public MerchantInfoCondition orMerNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("mer_name", value);
        return this;
    }

    public MerchantInfoCondition andMerNameBetween(Object value, Object value1) {
        ew.between("mer_name", value, value1);
        return this;
    }

    public MerchantInfoCondition orMerNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("mer_name", value, value1);
        return this;
    }

    public MerchantInfoCondition andMerNameNotBetween(Object value, Object value1) {
        ew.notBetween("mer_name", value, value1);
        return this;
    }

    public MerchantInfoCondition orMerNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("mer_name", value, value1);
        return this;
    }

    public MerchantInfoCondition andMerNameLike(String value) {
        ew.like("mer_name", value);
        return this;
    }

    public MerchantInfoCondition orMerNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("mer_name", value);
        return this;
    }

    public MerchantInfoCondition andMerNameNotLike(String value) {
        ew.notLike("mer_name", value);
        return this;
    }

    public MerchantInfoCondition orMerNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("mer_name", value);
        return this;
    }

    public MerchantInfoCondition andNameAbbreviationIsNull() {
        ew.isNull("name_abbreviation");
        return this;
    }

    public MerchantInfoCondition orNameAbbreviationIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("name_abbreviation");
        return this;
    }

    public MerchantInfoCondition andNameAbbreviationIsNotNull() {
        ew.isNotNull("name_abbreviation");
        return this;
    }

    public MerchantInfoCondition orNameAbbreviationIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("name_abbreviation");
        return this;
    }

    public MerchantInfoCondition andNameAbbreviationEq(Object value) {
        ew.eq("name_abbreviation", value);
        return this;
    }

    public MerchantInfoCondition orNameAbbreviationEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("name_abbreviation", value);
        return this;
    }

    public MerchantInfoCondition andNameAbbreviationNe(Object value) {
        ew.ne("name_abbreviation", value);
        return this;
    }

    public MerchantInfoCondition orNameAbbreviationNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("name_abbreviation", value);
        return this;
    }

    public MerchantInfoCondition andNameAbbreviationGt(Object value) {
        ew.gt("name_abbreviation", value);
        return this;
    }

    public MerchantInfoCondition orNameAbbreviationGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("name_abbreviation", value);
        return this;
    }

    public MerchantInfoCondition andNameAbbreviationGe(Object value) {
        ew.ge("name_abbreviation", value);
        return this;
    }

    public MerchantInfoCondition orNameAbbreviationGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("name_abbreviation", value);
        return this;
    }

    public MerchantInfoCondition andNameAbbreviationLt(Object value) {
        ew.lt("name_abbreviation", value);
        return this;
    }

    public MerchantInfoCondition orNameAbbreviationLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("name_abbreviation", value);
        return this;
    }

    public MerchantInfoCondition andNameAbbreviationLe(Object value) {
        ew.le("name_abbreviation", value);
        return this;
    }

    public MerchantInfoCondition orNameAbbreviationLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("name_abbreviation", value);
        return this;
    }

    public MerchantInfoCondition andNameAbbreviationIn(Object... value) {
        ew.in("name_abbreviation", value);
        return this;
    }

    public MerchantInfoCondition orNameAbbreviationIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("name_abbreviation", value);
        return this;
    }

    public MerchantInfoCondition andNameAbbreviationNotIn(Object... value) {
        ew.notIn("name_abbreviation", value);
        return this;
    }

    public MerchantInfoCondition orNameAbbreviationNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("name_abbreviation", value);
        return this;
    }

    public MerchantInfoCondition andNameAbbreviationBetween(Object value, Object value1) {
        ew.between("name_abbreviation", value, value1);
        return this;
    }

    public MerchantInfoCondition orNameAbbreviationBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("name_abbreviation", value, value1);
        return this;
    }

    public MerchantInfoCondition andNameAbbreviationNotBetween(Object value, Object value1) {
        ew.notBetween("name_abbreviation", value, value1);
        return this;
    }

    public MerchantInfoCondition orNameAbbreviationNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("name_abbreviation", value, value1);
        return this;
    }

    public MerchantInfoCondition andNameAbbreviationLike(String value) {
        ew.like("name_abbreviation", value);
        return this;
    }

    public MerchantInfoCondition orNameAbbreviationLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("name_abbreviation", value);
        return this;
    }

    public MerchantInfoCondition andNameAbbreviationNotLike(String value) {
        ew.notLike("name_abbreviation", value);
        return this;
    }

    public MerchantInfoCondition orNameAbbreviationNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("name_abbreviation", value);
        return this;
    }

    public MerchantInfoCondition andAdministrativeCodeIsNull() {
        ew.isNull("administrative_code");
        return this;
    }

    public MerchantInfoCondition orAdministrativeCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("administrative_code");
        return this;
    }

    public MerchantInfoCondition andAdministrativeCodeIsNotNull() {
        ew.isNotNull("administrative_code");
        return this;
    }

    public MerchantInfoCondition orAdministrativeCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("administrative_code");
        return this;
    }

    public MerchantInfoCondition andAdministrativeCodeEq(Object value) {
        ew.eq("administrative_code", value);
        return this;
    }

    public MerchantInfoCondition orAdministrativeCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("administrative_code", value);
        return this;
    }

    public MerchantInfoCondition andAdministrativeCodeNe(Object value) {
        ew.ne("administrative_code", value);
        return this;
    }

    public MerchantInfoCondition orAdministrativeCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("administrative_code", value);
        return this;
    }

    public MerchantInfoCondition andAdministrativeCodeGt(Object value) {
        ew.gt("administrative_code", value);
        return this;
    }

    public MerchantInfoCondition orAdministrativeCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("administrative_code", value);
        return this;
    }

    public MerchantInfoCondition andAdministrativeCodeGe(Object value) {
        ew.ge("administrative_code", value);
        return this;
    }

    public MerchantInfoCondition orAdministrativeCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("administrative_code", value);
        return this;
    }

    public MerchantInfoCondition andAdministrativeCodeLt(Object value) {
        ew.lt("administrative_code", value);
        return this;
    }

    public MerchantInfoCondition orAdministrativeCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("administrative_code", value);
        return this;
    }

    public MerchantInfoCondition andAdministrativeCodeLe(Object value) {
        ew.le("administrative_code", value);
        return this;
    }

    public MerchantInfoCondition orAdministrativeCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("administrative_code", value);
        return this;
    }

    public MerchantInfoCondition andAdministrativeCodeIn(Object... value) {
        ew.in("administrative_code", value);
        return this;
    }

    public MerchantInfoCondition orAdministrativeCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("administrative_code", value);
        return this;
    }

    public MerchantInfoCondition andAdministrativeCodeNotIn(Object... value) {
        ew.notIn("administrative_code", value);
        return this;
    }

    public MerchantInfoCondition orAdministrativeCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("administrative_code", value);
        return this;
    }

    public MerchantInfoCondition andAdministrativeCodeBetween(Object value, Object value1) {
        ew.between("administrative_code", value, value1);
        return this;
    }

    public MerchantInfoCondition orAdministrativeCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("administrative_code", value, value1);
        return this;
    }

    public MerchantInfoCondition andAdministrativeCodeNotBetween(Object value, Object value1) {
        ew.notBetween("administrative_code", value, value1);
        return this;
    }

    public MerchantInfoCondition orAdministrativeCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("administrative_code", value, value1);
        return this;
    }

    public MerchantInfoCondition andAdministrativeCodeLike(String value) {
        ew.like("administrative_code", value);
        return this;
    }

    public MerchantInfoCondition orAdministrativeCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("administrative_code", value);
        return this;
    }

    public MerchantInfoCondition andAdministrativeCodeNotLike(String value) {
        ew.notLike("administrative_code", value);
        return this;
    }

    public MerchantInfoCondition orAdministrativeCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("administrative_code", value);
        return this;
    }

    public MerchantInfoCondition andOrgCodeIsNull() {
        ew.isNull("org_code");
        return this;
    }

    public MerchantInfoCondition orOrgCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("org_code");
        return this;
    }

    public MerchantInfoCondition andOrgCodeIsNotNull() {
        ew.isNotNull("org_code");
        return this;
    }

    public MerchantInfoCondition orOrgCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("org_code");
        return this;
    }

    public MerchantInfoCondition andOrgCodeEq(Object value) {
        ew.eq("org_code", value);
        return this;
    }

    public MerchantInfoCondition orOrgCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("org_code", value);
        return this;
    }

    public MerchantInfoCondition andOrgCodeNe(Object value) {
        ew.ne("org_code", value);
        return this;
    }

    public MerchantInfoCondition orOrgCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("org_code", value);
        return this;
    }

    public MerchantInfoCondition andOrgCodeGt(Object value) {
        ew.gt("org_code", value);
        return this;
    }

    public MerchantInfoCondition orOrgCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("org_code", value);
        return this;
    }

    public MerchantInfoCondition andOrgCodeGe(Object value) {
        ew.ge("org_code", value);
        return this;
    }

    public MerchantInfoCondition orOrgCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("org_code", value);
        return this;
    }

    public MerchantInfoCondition andOrgCodeLt(Object value) {
        ew.lt("org_code", value);
        return this;
    }

    public MerchantInfoCondition orOrgCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("org_code", value);
        return this;
    }

    public MerchantInfoCondition andOrgCodeLe(Object value) {
        ew.le("org_code", value);
        return this;
    }

    public MerchantInfoCondition orOrgCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("org_code", value);
        return this;
    }

    public MerchantInfoCondition andOrgCodeIn(Object... value) {
        ew.in("org_code", value);
        return this;
    }

    public MerchantInfoCondition orOrgCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("org_code", value);
        return this;
    }

    public MerchantInfoCondition andOrgCodeNotIn(Object... value) {
        ew.notIn("org_code", value);
        return this;
    }

    public MerchantInfoCondition orOrgCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("org_code", value);
        return this;
    }

    public MerchantInfoCondition andOrgCodeBetween(Object value, Object value1) {
        ew.between("org_code", value, value1);
        return this;
    }

    public MerchantInfoCondition orOrgCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("org_code", value, value1);
        return this;
    }

    public MerchantInfoCondition andOrgCodeNotBetween(Object value, Object value1) {
        ew.notBetween("org_code", value, value1);
        return this;
    }

    public MerchantInfoCondition orOrgCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("org_code", value, value1);
        return this;
    }

    public MerchantInfoCondition andOrgCodeLike(String value) {
        ew.like("org_code", value);
        return this;
    }

    public MerchantInfoCondition orOrgCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("org_code", value);
        return this;
    }

    public MerchantInfoCondition andOrgCodeNotLike(String value) {
        ew.notLike("org_code", value);
        return this;
    }

    public MerchantInfoCondition orOrgCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("org_code", value);
        return this;
    }

    public MerchantInfoCondition andOrgNameIsNull() {
        ew.isNull("org_name");
        return this;
    }

    public MerchantInfoCondition orOrgNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("org_name");
        return this;
    }

    public MerchantInfoCondition andOrgNameIsNotNull() {
        ew.isNotNull("org_name");
        return this;
    }

    public MerchantInfoCondition orOrgNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("org_name");
        return this;
    }

    public MerchantInfoCondition andOrgNameEq(Object value) {
        ew.eq("org_name", value);
        return this;
    }

    public MerchantInfoCondition orOrgNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("org_name", value);
        return this;
    }

    public MerchantInfoCondition andOrgNameNe(Object value) {
        ew.ne("org_name", value);
        return this;
    }

    public MerchantInfoCondition orOrgNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("org_name", value);
        return this;
    }

    public MerchantInfoCondition andOrgNameGt(Object value) {
        ew.gt("org_name", value);
        return this;
    }

    public MerchantInfoCondition orOrgNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("org_name", value);
        return this;
    }

    public MerchantInfoCondition andOrgNameGe(Object value) {
        ew.ge("org_name", value);
        return this;
    }

    public MerchantInfoCondition orOrgNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("org_name", value);
        return this;
    }

    public MerchantInfoCondition andOrgNameLt(Object value) {
        ew.lt("org_name", value);
        return this;
    }

    public MerchantInfoCondition orOrgNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("org_name", value);
        return this;
    }

    public MerchantInfoCondition andOrgNameLe(Object value) {
        ew.le("org_name", value);
        return this;
    }

    public MerchantInfoCondition orOrgNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("org_name", value);
        return this;
    }

    public MerchantInfoCondition andOrgNameIn(Object... value) {
        ew.in("org_name", value);
        return this;
    }

    public MerchantInfoCondition orOrgNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("org_name", value);
        return this;
    }

    public MerchantInfoCondition andOrgNameNotIn(Object... value) {
        ew.notIn("org_name", value);
        return this;
    }

    public MerchantInfoCondition orOrgNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("org_name", value);
        return this;
    }

    public MerchantInfoCondition andOrgNameBetween(Object value, Object value1) {
        ew.between("org_name", value, value1);
        return this;
    }

    public MerchantInfoCondition orOrgNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("org_name", value, value1);
        return this;
    }

    public MerchantInfoCondition andOrgNameNotBetween(Object value, Object value1) {
        ew.notBetween("org_name", value, value1);
        return this;
    }

    public MerchantInfoCondition orOrgNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("org_name", value, value1);
        return this;
    }

    public MerchantInfoCondition andOrgNameLike(String value) {
        ew.like("org_name", value);
        return this;
    }

    public MerchantInfoCondition orOrgNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("org_name", value);
        return this;
    }

    public MerchantInfoCondition andOrgNameNotLike(String value) {
        ew.notLike("org_name", value);
        return this;
    }

    public MerchantInfoCondition orOrgNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("org_name", value);
        return this;
    }

    public MerchantInfoCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public MerchantInfoCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public MerchantInfoCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public MerchantInfoCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public MerchantInfoCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public MerchantInfoCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public MerchantInfoCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public MerchantInfoCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public MerchantInfoCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public MerchantInfoCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public MerchantInfoCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public MerchantInfoCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public MerchantInfoCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public MerchantInfoCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public MerchantInfoCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public MerchantInfoCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public MerchantInfoCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public MerchantInfoCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public MerchantInfoCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public MerchantInfoCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public MerchantInfoCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public MerchantInfoCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public MerchantInfoCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public MerchantInfoCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public MerchantInfoCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public MerchantInfoCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public MerchantInfoCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public MerchantInfoCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public MerchantInfoCondition andIndustryNameIsNull() {
        ew.isNull("industry_name");
        return this;
    }

    public MerchantInfoCondition orIndustryNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_name");
        return this;
    }

    public MerchantInfoCondition andIndustryNameIsNotNull() {
        ew.isNotNull("industry_name");
        return this;
    }

    public MerchantInfoCondition orIndustryNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_name");
        return this;
    }

    public MerchantInfoCondition andIndustryNameEq(Object value) {
        ew.eq("industry_name", value);
        return this;
    }

    public MerchantInfoCondition orIndustryNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_name", value);
        return this;
    }

    public MerchantInfoCondition andIndustryNameNe(Object value) {
        ew.ne("industry_name", value);
        return this;
    }

    public MerchantInfoCondition orIndustryNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_name", value);
        return this;
    }

    public MerchantInfoCondition andIndustryNameGt(Object value) {
        ew.gt("industry_name", value);
        return this;
    }

    public MerchantInfoCondition orIndustryNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_name", value);
        return this;
    }

    public MerchantInfoCondition andIndustryNameGe(Object value) {
        ew.ge("industry_name", value);
        return this;
    }

    public MerchantInfoCondition orIndustryNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_name", value);
        return this;
    }

    public MerchantInfoCondition andIndustryNameLt(Object value) {
        ew.lt("industry_name", value);
        return this;
    }

    public MerchantInfoCondition orIndustryNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_name", value);
        return this;
    }

    public MerchantInfoCondition andIndustryNameLe(Object value) {
        ew.le("industry_name", value);
        return this;
    }

    public MerchantInfoCondition orIndustryNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_name", value);
        return this;
    }

    public MerchantInfoCondition andIndustryNameIn(Object... value) {
        ew.in("industry_name", value);
        return this;
    }

    public MerchantInfoCondition orIndustryNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_name", value);
        return this;
    }

    public MerchantInfoCondition andIndustryNameNotIn(Object... value) {
        ew.notIn("industry_name", value);
        return this;
    }

    public MerchantInfoCondition orIndustryNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_name", value);
        return this;
    }

    public MerchantInfoCondition andIndustryNameBetween(Object value, Object value1) {
        ew.between("industry_name", value, value1);
        return this;
    }

    public MerchantInfoCondition orIndustryNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_name", value, value1);
        return this;
    }

    public MerchantInfoCondition andIndustryNameNotBetween(Object value, Object value1) {
        ew.notBetween("industry_name", value, value1);
        return this;
    }

    public MerchantInfoCondition orIndustryNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_name", value, value1);
        return this;
    }

    public MerchantInfoCondition andIndustryNameLike(String value) {
        ew.like("industry_name", value);
        return this;
    }

    public MerchantInfoCondition orIndustryNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_name", value);
        return this;
    }

    public MerchantInfoCondition andIndustryNameNotLike(String value) {
        ew.notLike("industry_name", value);
        return this;
    }

    public MerchantInfoCondition orIndustryNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_name", value);
        return this;
    }

    public MerchantInfoCondition andProvinceCodeIsNull() {
        ew.isNull("province_code");
        return this;
    }

    public MerchantInfoCondition orProvinceCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("province_code");
        return this;
    }

    public MerchantInfoCondition andProvinceCodeIsNotNull() {
        ew.isNotNull("province_code");
        return this;
    }

    public MerchantInfoCondition orProvinceCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("province_code");
        return this;
    }

    public MerchantInfoCondition andProvinceCodeEq(Object value) {
        ew.eq("province_code", value);
        return this;
    }

    public MerchantInfoCondition orProvinceCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("province_code", value);
        return this;
    }

    public MerchantInfoCondition andProvinceCodeNe(Object value) {
        ew.ne("province_code", value);
        return this;
    }

    public MerchantInfoCondition orProvinceCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("province_code", value);
        return this;
    }

    public MerchantInfoCondition andProvinceCodeGt(Object value) {
        ew.gt("province_code", value);
        return this;
    }

    public MerchantInfoCondition orProvinceCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("province_code", value);
        return this;
    }

    public MerchantInfoCondition andProvinceCodeGe(Object value) {
        ew.ge("province_code", value);
        return this;
    }

    public MerchantInfoCondition orProvinceCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("province_code", value);
        return this;
    }

    public MerchantInfoCondition andProvinceCodeLt(Object value) {
        ew.lt("province_code", value);
        return this;
    }

    public MerchantInfoCondition orProvinceCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("province_code", value);
        return this;
    }

    public MerchantInfoCondition andProvinceCodeLe(Object value) {
        ew.le("province_code", value);
        return this;
    }

    public MerchantInfoCondition orProvinceCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("province_code", value);
        return this;
    }

    public MerchantInfoCondition andProvinceCodeIn(Object... value) {
        ew.in("province_code", value);
        return this;
    }

    public MerchantInfoCondition orProvinceCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("province_code", value);
        return this;
    }

    public MerchantInfoCondition andProvinceCodeNotIn(Object... value) {
        ew.notIn("province_code", value);
        return this;
    }

    public MerchantInfoCondition orProvinceCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("province_code", value);
        return this;
    }

    public MerchantInfoCondition andProvinceCodeBetween(Object value, Object value1) {
        ew.between("province_code", value, value1);
        return this;
    }

    public MerchantInfoCondition orProvinceCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("province_code", value, value1);
        return this;
    }

    public MerchantInfoCondition andProvinceCodeNotBetween(Object value, Object value1) {
        ew.notBetween("province_code", value, value1);
        return this;
    }

    public MerchantInfoCondition orProvinceCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("province_code", value, value1);
        return this;
    }

    public MerchantInfoCondition andProvinceCodeLike(String value) {
        ew.like("province_code", value);
        return this;
    }

    public MerchantInfoCondition orProvinceCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("province_code", value);
        return this;
    }

    public MerchantInfoCondition andProvinceCodeNotLike(String value) {
        ew.notLike("province_code", value);
        return this;
    }

    public MerchantInfoCondition orProvinceCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("province_code", value);
        return this;
    }

    public MerchantInfoCondition andCityCodeIsNull() {
        ew.isNull("city_code");
        return this;
    }

    public MerchantInfoCondition orCityCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("city_code");
        return this;
    }

    public MerchantInfoCondition andCityCodeIsNotNull() {
        ew.isNotNull("city_code");
        return this;
    }

    public MerchantInfoCondition orCityCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("city_code");
        return this;
    }

    public MerchantInfoCondition andCityCodeEq(Object value) {
        ew.eq("city_code", value);
        return this;
    }

    public MerchantInfoCondition orCityCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("city_code", value);
        return this;
    }

    public MerchantInfoCondition andCityCodeNe(Object value) {
        ew.ne("city_code", value);
        return this;
    }

    public MerchantInfoCondition orCityCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("city_code", value);
        return this;
    }

    public MerchantInfoCondition andCityCodeGt(Object value) {
        ew.gt("city_code", value);
        return this;
    }

    public MerchantInfoCondition orCityCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("city_code", value);
        return this;
    }

    public MerchantInfoCondition andCityCodeGe(Object value) {
        ew.ge("city_code", value);
        return this;
    }

    public MerchantInfoCondition orCityCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("city_code", value);
        return this;
    }

    public MerchantInfoCondition andCityCodeLt(Object value) {
        ew.lt("city_code", value);
        return this;
    }

    public MerchantInfoCondition orCityCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("city_code", value);
        return this;
    }

    public MerchantInfoCondition andCityCodeLe(Object value) {
        ew.le("city_code", value);
        return this;
    }

    public MerchantInfoCondition orCityCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("city_code", value);
        return this;
    }

    public MerchantInfoCondition andCityCodeIn(Object... value) {
        ew.in("city_code", value);
        return this;
    }

    public MerchantInfoCondition orCityCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("city_code", value);
        return this;
    }

    public MerchantInfoCondition andCityCodeNotIn(Object... value) {
        ew.notIn("city_code", value);
        return this;
    }

    public MerchantInfoCondition orCityCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("city_code", value);
        return this;
    }

    public MerchantInfoCondition andCityCodeBetween(Object value, Object value1) {
        ew.between("city_code", value, value1);
        return this;
    }

    public MerchantInfoCondition orCityCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("city_code", value, value1);
        return this;
    }

    public MerchantInfoCondition andCityCodeNotBetween(Object value, Object value1) {
        ew.notBetween("city_code", value, value1);
        return this;
    }

    public MerchantInfoCondition orCityCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("city_code", value, value1);
        return this;
    }

    public MerchantInfoCondition andCityCodeLike(String value) {
        ew.like("city_code", value);
        return this;
    }

    public MerchantInfoCondition orCityCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("city_code", value);
        return this;
    }

    public MerchantInfoCondition andCityCodeNotLike(String value) {
        ew.notLike("city_code", value);
        return this;
    }

    public MerchantInfoCondition orCityCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("city_code", value);
        return this;
    }

    public MerchantInfoCondition andCountyCodeIsNull() {
        ew.isNull("county_code");
        return this;
    }

    public MerchantInfoCondition orCountyCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("county_code");
        return this;
    }

    public MerchantInfoCondition andCountyCodeIsNotNull() {
        ew.isNotNull("county_code");
        return this;
    }

    public MerchantInfoCondition orCountyCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("county_code");
        return this;
    }

    public MerchantInfoCondition andCountyCodeEq(Object value) {
        ew.eq("county_code", value);
        return this;
    }

    public MerchantInfoCondition orCountyCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("county_code", value);
        return this;
    }

    public MerchantInfoCondition andCountyCodeNe(Object value) {
        ew.ne("county_code", value);
        return this;
    }

    public MerchantInfoCondition orCountyCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("county_code", value);
        return this;
    }

    public MerchantInfoCondition andCountyCodeGt(Object value) {
        ew.gt("county_code", value);
        return this;
    }

    public MerchantInfoCondition orCountyCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("county_code", value);
        return this;
    }

    public MerchantInfoCondition andCountyCodeGe(Object value) {
        ew.ge("county_code", value);
        return this;
    }

    public MerchantInfoCondition orCountyCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("county_code", value);
        return this;
    }

    public MerchantInfoCondition andCountyCodeLt(Object value) {
        ew.lt("county_code", value);
        return this;
    }

    public MerchantInfoCondition orCountyCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("county_code", value);
        return this;
    }

    public MerchantInfoCondition andCountyCodeLe(Object value) {
        ew.le("county_code", value);
        return this;
    }

    public MerchantInfoCondition orCountyCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("county_code", value);
        return this;
    }

    public MerchantInfoCondition andCountyCodeIn(Object... value) {
        ew.in("county_code", value);
        return this;
    }

    public MerchantInfoCondition orCountyCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("county_code", value);
        return this;
    }

    public MerchantInfoCondition andCountyCodeNotIn(Object... value) {
        ew.notIn("county_code", value);
        return this;
    }

    public MerchantInfoCondition orCountyCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("county_code", value);
        return this;
    }

    public MerchantInfoCondition andCountyCodeBetween(Object value, Object value1) {
        ew.between("county_code", value, value1);
        return this;
    }

    public MerchantInfoCondition orCountyCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("county_code", value, value1);
        return this;
    }

    public MerchantInfoCondition andCountyCodeNotBetween(Object value, Object value1) {
        ew.notBetween("county_code", value, value1);
        return this;
    }

    public MerchantInfoCondition orCountyCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("county_code", value, value1);
        return this;
    }

    public MerchantInfoCondition andCountyCodeLike(String value) {
        ew.like("county_code", value);
        return this;
    }

    public MerchantInfoCondition orCountyCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("county_code", value);
        return this;
    }

    public MerchantInfoCondition andCountyCodeNotLike(String value) {
        ew.notLike("county_code", value);
        return this;
    }

    public MerchantInfoCondition orCountyCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("county_code", value);
        return this;
    }

    public MerchantInfoCondition andRegAddressIsNull() {
        ew.isNull("reg_address");
        return this;
    }

    public MerchantInfoCondition orRegAddressIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reg_address");
        return this;
    }

    public MerchantInfoCondition andRegAddressIsNotNull() {
        ew.isNotNull("reg_address");
        return this;
    }

    public MerchantInfoCondition orRegAddressIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reg_address");
        return this;
    }

    public MerchantInfoCondition andRegAddressEq(Object value) {
        ew.eq("reg_address", value);
        return this;
    }

    public MerchantInfoCondition orRegAddressEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reg_address", value);
        return this;
    }

    public MerchantInfoCondition andRegAddressNe(Object value) {
        ew.ne("reg_address", value);
        return this;
    }

    public MerchantInfoCondition orRegAddressNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reg_address", value);
        return this;
    }

    public MerchantInfoCondition andRegAddressGt(Object value) {
        ew.gt("reg_address", value);
        return this;
    }

    public MerchantInfoCondition orRegAddressGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reg_address", value);
        return this;
    }

    public MerchantInfoCondition andRegAddressGe(Object value) {
        ew.ge("reg_address", value);
        return this;
    }

    public MerchantInfoCondition orRegAddressGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reg_address", value);
        return this;
    }

    public MerchantInfoCondition andRegAddressLt(Object value) {
        ew.lt("reg_address", value);
        return this;
    }

    public MerchantInfoCondition orRegAddressLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reg_address", value);
        return this;
    }

    public MerchantInfoCondition andRegAddressLe(Object value) {
        ew.le("reg_address", value);
        return this;
    }

    public MerchantInfoCondition orRegAddressLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reg_address", value);
        return this;
    }

    public MerchantInfoCondition andRegAddressIn(Object... value) {
        ew.in("reg_address", value);
        return this;
    }

    public MerchantInfoCondition orRegAddressIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reg_address", value);
        return this;
    }

    public MerchantInfoCondition andRegAddressNotIn(Object... value) {
        ew.notIn("reg_address", value);
        return this;
    }

    public MerchantInfoCondition orRegAddressNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reg_address", value);
        return this;
    }

    public MerchantInfoCondition andRegAddressBetween(Object value, Object value1) {
        ew.between("reg_address", value, value1);
        return this;
    }

    public MerchantInfoCondition orRegAddressBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reg_address", value, value1);
        return this;
    }

    public MerchantInfoCondition andRegAddressNotBetween(Object value, Object value1) {
        ew.notBetween("reg_address", value, value1);
        return this;
    }

    public MerchantInfoCondition orRegAddressNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reg_address", value, value1);
        return this;
    }

    public MerchantInfoCondition andRegAddressLike(String value) {
        ew.like("reg_address", value);
        return this;
    }

    public MerchantInfoCondition orRegAddressLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reg_address", value);
        return this;
    }

    public MerchantInfoCondition andRegAddressNotLike(String value) {
        ew.notLike("reg_address", value);
        return this;
    }

    public MerchantInfoCondition orRegAddressNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reg_address", value);
        return this;
    }

    public MerchantInfoCondition andBusinessAddressIsNull() {
        ew.isNull("business_address");
        return this;
    }

    public MerchantInfoCondition orBusinessAddressIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("business_address");
        return this;
    }

    public MerchantInfoCondition andBusinessAddressIsNotNull() {
        ew.isNotNull("business_address");
        return this;
    }

    public MerchantInfoCondition orBusinessAddressIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("business_address");
        return this;
    }

    public MerchantInfoCondition andBusinessAddressEq(Object value) {
        ew.eq("business_address", value);
        return this;
    }

    public MerchantInfoCondition orBusinessAddressEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("business_address", value);
        return this;
    }

    public MerchantInfoCondition andBusinessAddressNe(Object value) {
        ew.ne("business_address", value);
        return this;
    }

    public MerchantInfoCondition orBusinessAddressNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("business_address", value);
        return this;
    }

    public MerchantInfoCondition andBusinessAddressGt(Object value) {
        ew.gt("business_address", value);
        return this;
    }

    public MerchantInfoCondition orBusinessAddressGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("business_address", value);
        return this;
    }

    public MerchantInfoCondition andBusinessAddressGe(Object value) {
        ew.ge("business_address", value);
        return this;
    }

    public MerchantInfoCondition orBusinessAddressGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("business_address", value);
        return this;
    }

    public MerchantInfoCondition andBusinessAddressLt(Object value) {
        ew.lt("business_address", value);
        return this;
    }

    public MerchantInfoCondition orBusinessAddressLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("business_address", value);
        return this;
    }

    public MerchantInfoCondition andBusinessAddressLe(Object value) {
        ew.le("business_address", value);
        return this;
    }

    public MerchantInfoCondition orBusinessAddressLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("business_address", value);
        return this;
    }

    public MerchantInfoCondition andBusinessAddressIn(Object... value) {
        ew.in("business_address", value);
        return this;
    }

    public MerchantInfoCondition orBusinessAddressIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("business_address", value);
        return this;
    }

    public MerchantInfoCondition andBusinessAddressNotIn(Object... value) {
        ew.notIn("business_address", value);
        return this;
    }

    public MerchantInfoCondition orBusinessAddressNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("business_address", value);
        return this;
    }

    public MerchantInfoCondition andBusinessAddressBetween(Object value, Object value1) {
        ew.between("business_address", value, value1);
        return this;
    }

    public MerchantInfoCondition orBusinessAddressBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("business_address", value, value1);
        return this;
    }

    public MerchantInfoCondition andBusinessAddressNotBetween(Object value, Object value1) {
        ew.notBetween("business_address", value, value1);
        return this;
    }

    public MerchantInfoCondition orBusinessAddressNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("business_address", value, value1);
        return this;
    }

    public MerchantInfoCondition andBusinessAddressLike(String value) {
        ew.like("business_address", value);
        return this;
    }

    public MerchantInfoCondition orBusinessAddressLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("business_address", value);
        return this;
    }

    public MerchantInfoCondition andBusinessAddressNotLike(String value) {
        ew.notLike("business_address", value);
        return this;
    }

    public MerchantInfoCondition orBusinessAddressNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("business_address", value);
        return this;
    }

    public MerchantInfoCondition andLegalNameIsNull() {
        ew.isNull("legal_name");
        return this;
    }

    public MerchantInfoCondition orLegalNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("legal_name");
        return this;
    }

    public MerchantInfoCondition andLegalNameIsNotNull() {
        ew.isNotNull("legal_name");
        return this;
    }

    public MerchantInfoCondition orLegalNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("legal_name");
        return this;
    }

    public MerchantInfoCondition andLegalNameEq(Object value) {
        ew.eq("legal_name", value);
        return this;
    }

    public MerchantInfoCondition orLegalNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("legal_name", value);
        return this;
    }

    public MerchantInfoCondition andLegalNameNe(Object value) {
        ew.ne("legal_name", value);
        return this;
    }

    public MerchantInfoCondition orLegalNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("legal_name", value);
        return this;
    }

    public MerchantInfoCondition andLegalNameGt(Object value) {
        ew.gt("legal_name", value);
        return this;
    }

    public MerchantInfoCondition orLegalNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("legal_name", value);
        return this;
    }

    public MerchantInfoCondition andLegalNameGe(Object value) {
        ew.ge("legal_name", value);
        return this;
    }

    public MerchantInfoCondition orLegalNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("legal_name", value);
        return this;
    }

    public MerchantInfoCondition andLegalNameLt(Object value) {
        ew.lt("legal_name", value);
        return this;
    }

    public MerchantInfoCondition orLegalNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("legal_name", value);
        return this;
    }

    public MerchantInfoCondition andLegalNameLe(Object value) {
        ew.le("legal_name", value);
        return this;
    }

    public MerchantInfoCondition orLegalNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("legal_name", value);
        return this;
    }

    public MerchantInfoCondition andLegalNameIn(Object... value) {
        ew.in("legal_name", value);
        return this;
    }

    public MerchantInfoCondition orLegalNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("legal_name", value);
        return this;
    }

    public MerchantInfoCondition andLegalNameNotIn(Object... value) {
        ew.notIn("legal_name", value);
        return this;
    }

    public MerchantInfoCondition orLegalNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("legal_name", value);
        return this;
    }

    public MerchantInfoCondition andLegalNameBetween(Object value, Object value1) {
        ew.between("legal_name", value, value1);
        return this;
    }

    public MerchantInfoCondition orLegalNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("legal_name", value, value1);
        return this;
    }

    public MerchantInfoCondition andLegalNameNotBetween(Object value, Object value1) {
        ew.notBetween("legal_name", value, value1);
        return this;
    }

    public MerchantInfoCondition orLegalNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("legal_name", value, value1);
        return this;
    }

    public MerchantInfoCondition andLegalNameLike(String value) {
        ew.like("legal_name", value);
        return this;
    }

    public MerchantInfoCondition orLegalNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("legal_name", value);
        return this;
    }

    public MerchantInfoCondition andLegalNameNotLike(String value) {
        ew.notLike("legal_name", value);
        return this;
    }

    public MerchantInfoCondition orLegalNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("legal_name", value);
        return this;
    }

    public MerchantInfoCondition andStatusIsNull() {
        ew.isNull("status");
        return this;
    }

    public MerchantInfoCondition orStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("status");
        return this;
    }

    public MerchantInfoCondition andStatusIsNotNull() {
        ew.isNotNull("status");
        return this;
    }

    public MerchantInfoCondition orStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("status");
        return this;
    }

    public MerchantInfoCondition andStatusEq(Object value) {
        ew.eq("status", value);
        return this;
    }

    public MerchantInfoCondition orStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("status", value);
        return this;
    }

    public MerchantInfoCondition andStatusNe(Object value) {
        ew.ne("status", value);
        return this;
    }

    public MerchantInfoCondition orStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("status", value);
        return this;
    }

    public MerchantInfoCondition andStatusGt(Object value) {
        ew.gt("status", value);
        return this;
    }

    public MerchantInfoCondition orStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("status", value);
        return this;
    }

    public MerchantInfoCondition andStatusGe(Object value) {
        ew.ge("status", value);
        return this;
    }

    public MerchantInfoCondition orStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("status", value);
        return this;
    }

    public MerchantInfoCondition andStatusLt(Object value) {
        ew.lt("status", value);
        return this;
    }

    public MerchantInfoCondition orStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("status", value);
        return this;
    }

    public MerchantInfoCondition andStatusLe(Object value) {
        ew.le("status", value);
        return this;
    }

    public MerchantInfoCondition orStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("status", value);
        return this;
    }

    public MerchantInfoCondition andStatusIn(Object... value) {
        ew.in("status", value);
        return this;
    }

    public MerchantInfoCondition orStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("status", value);
        return this;
    }

    public MerchantInfoCondition andStatusNotIn(Object... value) {
        ew.notIn("status", value);
        return this;
    }

    public MerchantInfoCondition orStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("status", value);
        return this;
    }

    public MerchantInfoCondition andStatusBetween(Object value, Object value1) {
        ew.between("status", value, value1);
        return this;
    }

    public MerchantInfoCondition orStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("status", value, value1);
        return this;
    }

    public MerchantInfoCondition andStatusNotBetween(Object value, Object value1) {
        ew.notBetween("status", value, value1);
        return this;
    }

    public MerchantInfoCondition orStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("status", value, value1);
        return this;
    }

    public MerchantInfoCondition andStatusLike(String value) {
        ew.like("status", value);
        return this;
    }

    public MerchantInfoCondition orStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("status", value);
        return this;
    }

    public MerchantInfoCondition andStatusNotLike(String value) {
        ew.notLike("status", value);
        return this;
    }

    public MerchantInfoCondition orStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("status", value);
        return this;
    }

    public MerchantInfoCondition andWebsiteNameIsNull() {
        ew.isNull("website_name");
        return this;
    }

    public MerchantInfoCondition orWebsiteNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("website_name");
        return this;
    }

    public MerchantInfoCondition andWebsiteNameIsNotNull() {
        ew.isNotNull("website_name");
        return this;
    }

    public MerchantInfoCondition orWebsiteNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("website_name");
        return this;
    }

    public MerchantInfoCondition andWebsiteNameEq(Object value) {
        ew.eq("website_name", value);
        return this;
    }

    public MerchantInfoCondition orWebsiteNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("website_name", value);
        return this;
    }

    public MerchantInfoCondition andWebsiteNameNe(Object value) {
        ew.ne("website_name", value);
        return this;
    }

    public MerchantInfoCondition orWebsiteNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("website_name", value);
        return this;
    }

    public MerchantInfoCondition andWebsiteNameGt(Object value) {
        ew.gt("website_name", value);
        return this;
    }

    public MerchantInfoCondition orWebsiteNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("website_name", value);
        return this;
    }

    public MerchantInfoCondition andWebsiteNameGe(Object value) {
        ew.ge("website_name", value);
        return this;
    }

    public MerchantInfoCondition orWebsiteNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("website_name", value);
        return this;
    }

    public MerchantInfoCondition andWebsiteNameLt(Object value) {
        ew.lt("website_name", value);
        return this;
    }

    public MerchantInfoCondition orWebsiteNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("website_name", value);
        return this;
    }

    public MerchantInfoCondition andWebsiteNameLe(Object value) {
        ew.le("website_name", value);
        return this;
    }

    public MerchantInfoCondition orWebsiteNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("website_name", value);
        return this;
    }

    public MerchantInfoCondition andWebsiteNameIn(Object... value) {
        ew.in("website_name", value);
        return this;
    }

    public MerchantInfoCondition orWebsiteNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("website_name", value);
        return this;
    }

    public MerchantInfoCondition andWebsiteNameNotIn(Object... value) {
        ew.notIn("website_name", value);
        return this;
    }

    public MerchantInfoCondition orWebsiteNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("website_name", value);
        return this;
    }

    public MerchantInfoCondition andWebsiteNameBetween(Object value, Object value1) {
        ew.between("website_name", value, value1);
        return this;
    }

    public MerchantInfoCondition orWebsiteNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("website_name", value, value1);
        return this;
    }

    public MerchantInfoCondition andWebsiteNameNotBetween(Object value, Object value1) {
        ew.notBetween("website_name", value, value1);
        return this;
    }

    public MerchantInfoCondition orWebsiteNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("website_name", value, value1);
        return this;
    }

    public MerchantInfoCondition andWebsiteNameLike(String value) {
        ew.like("website_name", value);
        return this;
    }

    public MerchantInfoCondition orWebsiteNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("website_name", value);
        return this;
    }

    public MerchantInfoCondition andWebsiteNameNotLike(String value) {
        ew.notLike("website_name", value);
        return this;
    }

    public MerchantInfoCondition orWebsiteNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("website_name", value);
        return this;
    }

    public MerchantInfoCondition andPayMerchantNoIsNull() {
        ew.isNull("pay_merchant_no");
        return this;
    }

    public MerchantInfoCondition orPayMerchantNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("pay_merchant_no");
        return this;
    }

    public MerchantInfoCondition andPayMerchantNoIsNotNull() {
        ew.isNotNull("pay_merchant_no");
        return this;
    }

    public MerchantInfoCondition orPayMerchantNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("pay_merchant_no");
        return this;
    }

    public MerchantInfoCondition andPayMerchantNoEq(Object value) {
        ew.eq("pay_merchant_no", value);
        return this;
    }

    public MerchantInfoCondition orPayMerchantNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("pay_merchant_no", value);
        return this;
    }

    public MerchantInfoCondition andPayMerchantNoNe(Object value) {
        ew.ne("pay_merchant_no", value);
        return this;
    }

    public MerchantInfoCondition orPayMerchantNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("pay_merchant_no", value);
        return this;
    }

    public MerchantInfoCondition andPayMerchantNoGt(Object value) {
        ew.gt("pay_merchant_no", value);
        return this;
    }

    public MerchantInfoCondition orPayMerchantNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("pay_merchant_no", value);
        return this;
    }

    public MerchantInfoCondition andPayMerchantNoGe(Object value) {
        ew.ge("pay_merchant_no", value);
        return this;
    }

    public MerchantInfoCondition orPayMerchantNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("pay_merchant_no", value);
        return this;
    }

    public MerchantInfoCondition andPayMerchantNoLt(Object value) {
        ew.lt("pay_merchant_no", value);
        return this;
    }

    public MerchantInfoCondition orPayMerchantNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("pay_merchant_no", value);
        return this;
    }

    public MerchantInfoCondition andPayMerchantNoLe(Object value) {
        ew.le("pay_merchant_no", value);
        return this;
    }

    public MerchantInfoCondition orPayMerchantNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("pay_merchant_no", value);
        return this;
    }

    public MerchantInfoCondition andPayMerchantNoIn(Object... value) {
        ew.in("pay_merchant_no", value);
        return this;
    }

    public MerchantInfoCondition orPayMerchantNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("pay_merchant_no", value);
        return this;
    }

    public MerchantInfoCondition andPayMerchantNoNotIn(Object... value) {
        ew.notIn("pay_merchant_no", value);
        return this;
    }

    public MerchantInfoCondition orPayMerchantNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("pay_merchant_no", value);
        return this;
    }

    public MerchantInfoCondition andPayMerchantNoBetween(Object value, Object value1) {
        ew.between("pay_merchant_no", value, value1);
        return this;
    }

    public MerchantInfoCondition orPayMerchantNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("pay_merchant_no", value, value1);
        return this;
    }

    public MerchantInfoCondition andPayMerchantNoNotBetween(Object value, Object value1) {
        ew.notBetween("pay_merchant_no", value, value1);
        return this;
    }

    public MerchantInfoCondition orPayMerchantNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("pay_merchant_no", value, value1);
        return this;
    }

    public MerchantInfoCondition andPayMerchantNoLike(String value) {
        ew.like("pay_merchant_no", value);
        return this;
    }

    public MerchantInfoCondition orPayMerchantNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("pay_merchant_no", value);
        return this;
    }

    public MerchantInfoCondition andPayMerchantNoNotLike(String value) {
        ew.notLike("pay_merchant_no", value);
        return this;
    }

    public MerchantInfoCondition orPayMerchantNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("pay_merchant_no", value);
        return this;
    }

    public MerchantInfoCondition andTemplateIdIsNull() {
        ew.isNull("template_id");
        return this;
    }

    public MerchantInfoCondition orTemplateIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("template_id");
        return this;
    }

    public MerchantInfoCondition andTemplateIdIsNotNull() {
        ew.isNotNull("template_id");
        return this;
    }

    public MerchantInfoCondition orTemplateIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("template_id");
        return this;
    }

    public MerchantInfoCondition andTemplateIdEq(Object value) {
        ew.eq("template_id", value);
        return this;
    }

    public MerchantInfoCondition orTemplateIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("template_id", value);
        return this;
    }

    public MerchantInfoCondition andTemplateIdNe(Object value) {
        ew.ne("template_id", value);
        return this;
    }

    public MerchantInfoCondition orTemplateIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("template_id", value);
        return this;
    }

    public MerchantInfoCondition andTemplateIdGt(Object value) {
        ew.gt("template_id", value);
        return this;
    }

    public MerchantInfoCondition orTemplateIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("template_id", value);
        return this;
    }

    public MerchantInfoCondition andTemplateIdGe(Object value) {
        ew.ge("template_id", value);
        return this;
    }

    public MerchantInfoCondition orTemplateIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("template_id", value);
        return this;
    }

    public MerchantInfoCondition andTemplateIdLt(Object value) {
        ew.lt("template_id", value);
        return this;
    }

    public MerchantInfoCondition orTemplateIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("template_id", value);
        return this;
    }

    public MerchantInfoCondition andTemplateIdLe(Object value) {
        ew.le("template_id", value);
        return this;
    }

    public MerchantInfoCondition orTemplateIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("template_id", value);
        return this;
    }

    public MerchantInfoCondition andTemplateIdIn(Object... value) {
        ew.in("template_id", value);
        return this;
    }

    public MerchantInfoCondition orTemplateIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("template_id", value);
        return this;
    }

    public MerchantInfoCondition andTemplateIdNotIn(Object... value) {
        ew.notIn("template_id", value);
        return this;
    }

    public MerchantInfoCondition orTemplateIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("template_id", value);
        return this;
    }

    public MerchantInfoCondition andTemplateIdBetween(Object value, Object value1) {
        ew.between("template_id", value, value1);
        return this;
    }

    public MerchantInfoCondition orTemplateIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("template_id", value, value1);
        return this;
    }

    public MerchantInfoCondition andTemplateIdNotBetween(Object value, Object value1) {
        ew.notBetween("template_id", value, value1);
        return this;
    }

    public MerchantInfoCondition orTemplateIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("template_id", value, value1);
        return this;
    }

    public MerchantInfoCondition andTemplateIdLike(String value) {
        ew.like("template_id", value);
        return this;
    }

    public MerchantInfoCondition orTemplateIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("template_id", value);
        return this;
    }

    public MerchantInfoCondition andTemplateIdNotLike(String value) {
        ew.notLike("template_id", value);
        return this;
    }

    public MerchantInfoCondition orTemplateIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("template_id", value);
        return this;
    }

    public MerchantInfoCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public MerchantInfoCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public MerchantInfoCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public MerchantInfoCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public MerchantInfoCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public MerchantInfoCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public MerchantInfoCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public MerchantInfoCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public MerchantInfoCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public MerchantInfoCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public MerchantInfoCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public MerchantInfoCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public MerchantInfoCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public MerchantInfoCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public MerchantInfoCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public MerchantInfoCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public MerchantInfoCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public MerchantInfoCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public MerchantInfoCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public MerchantInfoCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public MerchantInfoCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public MerchantInfoCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public MerchantInfoCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public MerchantInfoCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public MerchantInfoCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public MerchantInfoCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public MerchantInfoCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public MerchantInfoCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public MerchantInfoCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public MerchantInfoCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public MerchantInfoCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public MerchantInfoCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public MerchantInfoCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public MerchantInfoCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public MerchantInfoCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public MerchantInfoCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public MerchantInfoCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public MerchantInfoCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public MerchantInfoCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public MerchantInfoCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public MerchantInfoCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public MerchantInfoCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public MerchantInfoCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public MerchantInfoCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public MerchantInfoCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public MerchantInfoCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public MerchantInfoCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public MerchantInfoCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public MerchantInfoCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public MerchantInfoCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public MerchantInfoCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public MerchantInfoCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public MerchantInfoCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public MerchantInfoCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public MerchantInfoCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public MerchantInfoCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public MerchantInfoCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public MerchantInfoCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public MerchantInfoCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public MerchantInfoCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public MerchantInfoCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public MerchantInfoCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public MerchantInfoCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public MerchantInfoCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public MerchantInfoCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public MerchantInfoCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public MerchantInfoCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public MerchantInfoCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public MerchantInfoCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public MerchantInfoCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public MerchantInfoCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public MerchantInfoCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public MerchantInfoCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public MerchantInfoCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public MerchantInfoCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public MerchantInfoCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public MerchantInfoCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public MerchantInfoCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public MerchantInfoCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public MerchantInfoCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public MerchantInfoCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public MerchantInfoCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public MerchantInfoCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public MerchantInfoCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public MerchantInfoCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public MerchantInfoCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public MerchantInfoCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public MerchantInfoCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public MerchantInfoCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public MerchantInfoCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public MerchantInfoCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public MerchantInfoCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public MerchantInfoCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public MerchantInfoCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public MerchantInfoCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public MerchantInfoCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public MerchantInfoCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public MerchantInfoCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public MerchantInfoCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public MerchantInfoCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public MerchantInfoCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public MerchantInfoCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public MerchantInfoCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public MerchantInfoCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public MerchantInfoCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public MerchantInfoCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public MerchantInfoCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public MerchantInfoCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public MerchantInfoCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public MerchantInfoCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public MerchantInfoCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public MerchantInfoCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public MerchantInfoCondition andUserTypeIsNull() {
        ew.isNull("user_type");
        return this;
    }

    public MerchantInfoCondition orUserTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_type");
        return this;
    }

    public MerchantInfoCondition andUserTypeIsNotNull() {
        ew.isNotNull("user_type");
        return this;
    }

    public MerchantInfoCondition orUserTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_type");
        return this;
    }

    public MerchantInfoCondition andUserTypeEq(Object value) {
        ew.eq("user_type", value);
        return this;
    }

    public MerchantInfoCondition orUserTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_type", value);
        return this;
    }

    public MerchantInfoCondition andUserTypeNe(Object value) {
        ew.ne("user_type", value);
        return this;
    }

    public MerchantInfoCondition orUserTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_type", value);
        return this;
    }

    public MerchantInfoCondition andUserTypeGt(Object value) {
        ew.gt("user_type", value);
        return this;
    }

    public MerchantInfoCondition orUserTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_type", value);
        return this;
    }

    public MerchantInfoCondition andUserTypeGe(Object value) {
        ew.ge("user_type", value);
        return this;
    }

    public MerchantInfoCondition orUserTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_type", value);
        return this;
    }

    public MerchantInfoCondition andUserTypeLt(Object value) {
        ew.lt("user_type", value);
        return this;
    }

    public MerchantInfoCondition orUserTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_type", value);
        return this;
    }

    public MerchantInfoCondition andUserTypeLe(Object value) {
        ew.le("user_type", value);
        return this;
    }

    public MerchantInfoCondition orUserTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_type", value);
        return this;
    }

    public MerchantInfoCondition andUserTypeIn(Object... value) {
        ew.in("user_type", value);
        return this;
    }

    public MerchantInfoCondition orUserTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_type", value);
        return this;
    }

    public MerchantInfoCondition andUserTypeNotIn(Object... value) {
        ew.notIn("user_type", value);
        return this;
    }

    public MerchantInfoCondition orUserTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_type", value);
        return this;
    }

    public MerchantInfoCondition andUserTypeBetween(Object value, Object value1) {
        ew.between("user_type", value, value1);
        return this;
    }

    public MerchantInfoCondition orUserTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_type", value, value1);
        return this;
    }

    public MerchantInfoCondition andUserTypeNotBetween(Object value, Object value1) {
        ew.notBetween("user_type", value, value1);
        return this;
    }

    public MerchantInfoCondition orUserTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_type", value, value1);
        return this;
    }

    public MerchantInfoCondition andUserTypeLike(String value) {
        ew.like("user_type", value);
        return this;
    }

    public MerchantInfoCondition orUserTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_type", value);
        return this;
    }

    public MerchantInfoCondition andUserTypeNotLike(String value) {
        ew.notLike("user_type", value);
        return this;
    }

    public MerchantInfoCondition orUserTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_type", value);
        return this;
    }

    public MerchantInfoCondition andIdTypeIsNull() {
        ew.isNull("id_type");
        return this;
    }

    public MerchantInfoCondition orIdTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id_type");
        return this;
    }

    public MerchantInfoCondition andIdTypeIsNotNull() {
        ew.isNotNull("id_type");
        return this;
    }

    public MerchantInfoCondition orIdTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id_type");
        return this;
    }

    public MerchantInfoCondition andIdTypeEq(Object value) {
        ew.eq("id_type", value);
        return this;
    }

    public MerchantInfoCondition orIdTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id_type", value);
        return this;
    }

    public MerchantInfoCondition andIdTypeNe(Object value) {
        ew.ne("id_type", value);
        return this;
    }

    public MerchantInfoCondition orIdTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id_type", value);
        return this;
    }

    public MerchantInfoCondition andIdTypeGt(Object value) {
        ew.gt("id_type", value);
        return this;
    }

    public MerchantInfoCondition orIdTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id_type", value);
        return this;
    }

    public MerchantInfoCondition andIdTypeGe(Object value) {
        ew.ge("id_type", value);
        return this;
    }

    public MerchantInfoCondition orIdTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id_type", value);
        return this;
    }

    public MerchantInfoCondition andIdTypeLt(Object value) {
        ew.lt("id_type", value);
        return this;
    }

    public MerchantInfoCondition orIdTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id_type", value);
        return this;
    }

    public MerchantInfoCondition andIdTypeLe(Object value) {
        ew.le("id_type", value);
        return this;
    }

    public MerchantInfoCondition orIdTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id_type", value);
        return this;
    }

    public MerchantInfoCondition andIdTypeIn(Object... value) {
        ew.in("id_type", value);
        return this;
    }

    public MerchantInfoCondition orIdTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id_type", value);
        return this;
    }

    public MerchantInfoCondition andIdTypeNotIn(Object... value) {
        ew.notIn("id_type", value);
        return this;
    }

    public MerchantInfoCondition orIdTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id_type", value);
        return this;
    }

    public MerchantInfoCondition andIdTypeBetween(Object value, Object value1) {
        ew.between("id_type", value, value1);
        return this;
    }

    public MerchantInfoCondition orIdTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id_type", value, value1);
        return this;
    }

    public MerchantInfoCondition andIdTypeNotBetween(Object value, Object value1) {
        ew.notBetween("id_type", value, value1);
        return this;
    }

    public MerchantInfoCondition orIdTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id_type", value, value1);
        return this;
    }

    public MerchantInfoCondition andIdTypeLike(String value) {
        ew.like("id_type", value);
        return this;
    }

    public MerchantInfoCondition orIdTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id_type", value);
        return this;
    }

    public MerchantInfoCondition andIdTypeNotLike(String value) {
        ew.notLike("id_type", value);
        return this;
    }

    public MerchantInfoCondition orIdTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id_type", value);
        return this;
    }

    public MerchantInfoCondition andIdCodeIsNull() {
        ew.isNull("id_code");
        return this;
    }

    public MerchantInfoCondition orIdCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id_code");
        return this;
    }

    public MerchantInfoCondition andIdCodeIsNotNull() {
        ew.isNotNull("id_code");
        return this;
    }

    public MerchantInfoCondition orIdCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id_code");
        return this;
    }

    public MerchantInfoCondition andIdCodeEq(Object value) {
        ew.eq("id_code", value);
        return this;
    }

    public MerchantInfoCondition orIdCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id_code", value);
        return this;
    }

    public MerchantInfoCondition andIdCodeNe(Object value) {
        ew.ne("id_code", value);
        return this;
    }

    public MerchantInfoCondition orIdCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id_code", value);
        return this;
    }

    public MerchantInfoCondition andIdCodeGt(Object value) {
        ew.gt("id_code", value);
        return this;
    }

    public MerchantInfoCondition orIdCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id_code", value);
        return this;
    }

    public MerchantInfoCondition andIdCodeGe(Object value) {
        ew.ge("id_code", value);
        return this;
    }

    public MerchantInfoCondition orIdCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id_code", value);
        return this;
    }

    public MerchantInfoCondition andIdCodeLt(Object value) {
        ew.lt("id_code", value);
        return this;
    }

    public MerchantInfoCondition orIdCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id_code", value);
        return this;
    }

    public MerchantInfoCondition andIdCodeLe(Object value) {
        ew.le("id_code", value);
        return this;
    }

    public MerchantInfoCondition orIdCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id_code", value);
        return this;
    }

    public MerchantInfoCondition andIdCodeIn(Object... value) {
        ew.in("id_code", value);
        return this;
    }

    public MerchantInfoCondition orIdCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id_code", value);
        return this;
    }

    public MerchantInfoCondition andIdCodeNotIn(Object... value) {
        ew.notIn("id_code", value);
        return this;
    }

    public MerchantInfoCondition orIdCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id_code", value);
        return this;
    }

    public MerchantInfoCondition andIdCodeBetween(Object value, Object value1) {
        ew.between("id_code", value, value1);
        return this;
    }

    public MerchantInfoCondition orIdCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id_code", value, value1);
        return this;
    }

    public MerchantInfoCondition andIdCodeNotBetween(Object value, Object value1) {
        ew.notBetween("id_code", value, value1);
        return this;
    }

    public MerchantInfoCondition orIdCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id_code", value, value1);
        return this;
    }

    public MerchantInfoCondition andIdCodeLike(String value) {
        ew.like("id_code", value);
        return this;
    }

    public MerchantInfoCondition orIdCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id_code", value);
        return this;
    }

    public MerchantInfoCondition andIdCodeNotLike(String value) {
        ew.notLike("id_code", value);
        return this;
    }

    public MerchantInfoCondition orIdCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id_code", value);
        return this;
    }

    public MerchantInfoCondition andRealNameIsNull() {
        ew.isNull("real_name");
        return this;
    }

    public MerchantInfoCondition orRealNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("real_name");
        return this;
    }

    public MerchantInfoCondition andRealNameIsNotNull() {
        ew.isNotNull("real_name");
        return this;
    }

    public MerchantInfoCondition orRealNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("real_name");
        return this;
    }

    public MerchantInfoCondition andRealNameEq(Object value) {
        ew.eq("real_name", value);
        return this;
    }

    public MerchantInfoCondition orRealNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("real_name", value);
        return this;
    }

    public MerchantInfoCondition andRealNameNe(Object value) {
        ew.ne("real_name", value);
        return this;
    }

    public MerchantInfoCondition orRealNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("real_name", value);
        return this;
    }

    public MerchantInfoCondition andRealNameGt(Object value) {
        ew.gt("real_name", value);
        return this;
    }

    public MerchantInfoCondition orRealNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("real_name", value);
        return this;
    }

    public MerchantInfoCondition andRealNameGe(Object value) {
        ew.ge("real_name", value);
        return this;
    }

    public MerchantInfoCondition orRealNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("real_name", value);
        return this;
    }

    public MerchantInfoCondition andRealNameLt(Object value) {
        ew.lt("real_name", value);
        return this;
    }

    public MerchantInfoCondition orRealNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("real_name", value);
        return this;
    }

    public MerchantInfoCondition andRealNameLe(Object value) {
        ew.le("real_name", value);
        return this;
    }

    public MerchantInfoCondition orRealNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("real_name", value);
        return this;
    }

    public MerchantInfoCondition andRealNameIn(Object... value) {
        ew.in("real_name", value);
        return this;
    }

    public MerchantInfoCondition orRealNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("real_name", value);
        return this;
    }

    public MerchantInfoCondition andRealNameNotIn(Object... value) {
        ew.notIn("real_name", value);
        return this;
    }

    public MerchantInfoCondition orRealNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("real_name", value);
        return this;
    }

    public MerchantInfoCondition andRealNameBetween(Object value, Object value1) {
        ew.between("real_name", value, value1);
        return this;
    }

    public MerchantInfoCondition orRealNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("real_name", value, value1);
        return this;
    }

    public MerchantInfoCondition andRealNameNotBetween(Object value, Object value1) {
        ew.notBetween("real_name", value, value1);
        return this;
    }

    public MerchantInfoCondition orRealNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("real_name", value, value1);
        return this;
    }

    public MerchantInfoCondition andRealNameLike(String value) {
        ew.like("real_name", value);
        return this;
    }

    public MerchantInfoCondition orRealNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("real_name", value);
        return this;
    }

    public MerchantInfoCondition andRealNameNotLike(String value) {
        ew.notLike("real_name", value);
        return this;
    }

    public MerchantInfoCondition orRealNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("real_name", value);
        return this;
    }

    public MerchantInfoCondition andBusLicCodeIsNull() {
        ew.isNull("bus_lic_code");
        return this;
    }

    public MerchantInfoCondition orBusLicCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("bus_lic_code");
        return this;
    }

    public MerchantInfoCondition andBusLicCodeIsNotNull() {
        ew.isNotNull("bus_lic_code");
        return this;
    }

    public MerchantInfoCondition orBusLicCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("bus_lic_code");
        return this;
    }

    public MerchantInfoCondition andBusLicCodeEq(Object value) {
        ew.eq("bus_lic_code", value);
        return this;
    }

    public MerchantInfoCondition orBusLicCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("bus_lic_code", value);
        return this;
    }

    public MerchantInfoCondition andBusLicCodeNe(Object value) {
        ew.ne("bus_lic_code", value);
        return this;
    }

    public MerchantInfoCondition orBusLicCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("bus_lic_code", value);
        return this;
    }

    public MerchantInfoCondition andBusLicCodeGt(Object value) {
        ew.gt("bus_lic_code", value);
        return this;
    }

    public MerchantInfoCondition orBusLicCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("bus_lic_code", value);
        return this;
    }

    public MerchantInfoCondition andBusLicCodeGe(Object value) {
        ew.ge("bus_lic_code", value);
        return this;
    }

    public MerchantInfoCondition orBusLicCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("bus_lic_code", value);
        return this;
    }

    public MerchantInfoCondition andBusLicCodeLt(Object value) {
        ew.lt("bus_lic_code", value);
        return this;
    }

    public MerchantInfoCondition orBusLicCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("bus_lic_code", value);
        return this;
    }

    public MerchantInfoCondition andBusLicCodeLe(Object value) {
        ew.le("bus_lic_code", value);
        return this;
    }

    public MerchantInfoCondition orBusLicCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("bus_lic_code", value);
        return this;
    }

    public MerchantInfoCondition andBusLicCodeIn(Object... value) {
        ew.in("bus_lic_code", value);
        return this;
    }

    public MerchantInfoCondition orBusLicCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("bus_lic_code", value);
        return this;
    }

    public MerchantInfoCondition andBusLicCodeNotIn(Object... value) {
        ew.notIn("bus_lic_code", value);
        return this;
    }

    public MerchantInfoCondition orBusLicCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("bus_lic_code", value);
        return this;
    }

    public MerchantInfoCondition andBusLicCodeBetween(Object value, Object value1) {
        ew.between("bus_lic_code", value, value1);
        return this;
    }

    public MerchantInfoCondition orBusLicCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("bus_lic_code", value, value1);
        return this;
    }

    public MerchantInfoCondition andBusLicCodeNotBetween(Object value, Object value1) {
        ew.notBetween("bus_lic_code", value, value1);
        return this;
    }

    public MerchantInfoCondition orBusLicCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("bus_lic_code", value, value1);
        return this;
    }

    public MerchantInfoCondition andBusLicCodeLike(String value) {
        ew.like("bus_lic_code", value);
        return this;
    }

    public MerchantInfoCondition orBusLicCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("bus_lic_code", value);
        return this;
    }

    public MerchantInfoCondition andBusLicCodeNotLike(String value) {
        ew.notLike("bus_lic_code", value);
        return this;
    }

    public MerchantInfoCondition orBusLicCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("bus_lic_code", value);
        return this;
    }

    public MerchantInfoCondition andEntNameIsNull() {
        ew.isNull("ent_name");
        return this;
    }

    public MerchantInfoCondition orEntNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ent_name");
        return this;
    }

    public MerchantInfoCondition andEntNameIsNotNull() {
        ew.isNotNull("ent_name");
        return this;
    }

    public MerchantInfoCondition orEntNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ent_name");
        return this;
    }

    public MerchantInfoCondition andEntNameEq(Object value) {
        ew.eq("ent_name", value);
        return this;
    }

    public MerchantInfoCondition orEntNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ent_name", value);
        return this;
    }

    public MerchantInfoCondition andEntNameNe(Object value) {
        ew.ne("ent_name", value);
        return this;
    }

    public MerchantInfoCondition orEntNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ent_name", value);
        return this;
    }

    public MerchantInfoCondition andEntNameGt(Object value) {
        ew.gt("ent_name", value);
        return this;
    }

    public MerchantInfoCondition orEntNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ent_name", value);
        return this;
    }

    public MerchantInfoCondition andEntNameGe(Object value) {
        ew.ge("ent_name", value);
        return this;
    }

    public MerchantInfoCondition orEntNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ent_name", value);
        return this;
    }

    public MerchantInfoCondition andEntNameLt(Object value) {
        ew.lt("ent_name", value);
        return this;
    }

    public MerchantInfoCondition orEntNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ent_name", value);
        return this;
    }

    public MerchantInfoCondition andEntNameLe(Object value) {
        ew.le("ent_name", value);
        return this;
    }

    public MerchantInfoCondition orEntNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ent_name", value);
        return this;
    }

    public MerchantInfoCondition andEntNameIn(Object... value) {
        ew.in("ent_name", value);
        return this;
    }

    public MerchantInfoCondition orEntNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ent_name", value);
        return this;
    }

    public MerchantInfoCondition andEntNameNotIn(Object... value) {
        ew.notIn("ent_name", value);
        return this;
    }

    public MerchantInfoCondition orEntNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ent_name", value);
        return this;
    }

    public MerchantInfoCondition andEntNameBetween(Object value, Object value1) {
        ew.between("ent_name", value, value1);
        return this;
    }

    public MerchantInfoCondition orEntNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ent_name", value, value1);
        return this;
    }

    public MerchantInfoCondition andEntNameNotBetween(Object value, Object value1) {
        ew.notBetween("ent_name", value, value1);
        return this;
    }

    public MerchantInfoCondition orEntNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ent_name", value, value1);
        return this;
    }

    public MerchantInfoCondition andEntNameLike(String value) {
        ew.like("ent_name", value);
        return this;
    }

    public MerchantInfoCondition orEntNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ent_name", value);
        return this;
    }

    public MerchantInfoCondition andEntNameNotLike(String value) {
        ew.notLike("ent_name", value);
        return this;
    }

    public MerchantInfoCondition orEntNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ent_name", value);
        return this;
    }

    public MerchantInfoCondition andAuthStatusIsNull() {
        ew.isNull("auth_status");
        return this;
    }

    public MerchantInfoCondition orAuthStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("auth_status");
        return this;
    }

    public MerchantInfoCondition andAuthStatusIsNotNull() {
        ew.isNotNull("auth_status");
        return this;
    }

    public MerchantInfoCondition orAuthStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("auth_status");
        return this;
    }

    public MerchantInfoCondition andAuthStatusEq(Object value) {
        ew.eq("auth_status", value);
        return this;
    }

    public MerchantInfoCondition orAuthStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("auth_status", value);
        return this;
    }

    public MerchantInfoCondition andAuthStatusNe(Object value) {
        ew.ne("auth_status", value);
        return this;
    }

    public MerchantInfoCondition orAuthStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("auth_status", value);
        return this;
    }

    public MerchantInfoCondition andAuthStatusGt(Object value) {
        ew.gt("auth_status", value);
        return this;
    }

    public MerchantInfoCondition orAuthStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("auth_status", value);
        return this;
    }

    public MerchantInfoCondition andAuthStatusGe(Object value) {
        ew.ge("auth_status", value);
        return this;
    }

    public MerchantInfoCondition orAuthStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("auth_status", value);
        return this;
    }

    public MerchantInfoCondition andAuthStatusLt(Object value) {
        ew.lt("auth_status", value);
        return this;
    }

    public MerchantInfoCondition orAuthStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("auth_status", value);
        return this;
    }

    public MerchantInfoCondition andAuthStatusLe(Object value) {
        ew.le("auth_status", value);
        return this;
    }

    public MerchantInfoCondition orAuthStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("auth_status", value);
        return this;
    }

    public MerchantInfoCondition andAuthStatusIn(Object... value) {
        ew.in("auth_status", value);
        return this;
    }

    public MerchantInfoCondition orAuthStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("auth_status", value);
        return this;
    }

    public MerchantInfoCondition andAuthStatusNotIn(Object... value) {
        ew.notIn("auth_status", value);
        return this;
    }

    public MerchantInfoCondition orAuthStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("auth_status", value);
        return this;
    }

    public MerchantInfoCondition andAuthStatusBetween(Object value, Object value1) {
        ew.between("auth_status", value, value1);
        return this;
    }

    public MerchantInfoCondition orAuthStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("auth_status", value, value1);
        return this;
    }

    public MerchantInfoCondition andAuthStatusNotBetween(Object value, Object value1) {
        ew.notBetween("auth_status", value, value1);
        return this;
    }

    public MerchantInfoCondition orAuthStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("auth_status", value, value1);
        return this;
    }

    public MerchantInfoCondition andAuthStatusLike(String value) {
        ew.like("auth_status", value);
        return this;
    }

    public MerchantInfoCondition orAuthStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("auth_status", value);
        return this;
    }

    public MerchantInfoCondition andAuthStatusNotLike(String value) {
        ew.notLike("auth_status", value);
        return this;
    }

    public MerchantInfoCondition orAuthStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("auth_status", value);
        return this;
    }

    public MerchantInfoCondition andAuthCallBackIsNull() {
        ew.isNull("auth_call_back");
        return this;
    }

    public MerchantInfoCondition orAuthCallBackIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("auth_call_back");
        return this;
    }

    public MerchantInfoCondition andAuthCallBackIsNotNull() {
        ew.isNotNull("auth_call_back");
        return this;
    }

    public MerchantInfoCondition orAuthCallBackIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("auth_call_back");
        return this;
    }

    public MerchantInfoCondition andAuthCallBackEq(Object value) {
        ew.eq("auth_call_back", value);
        return this;
    }

    public MerchantInfoCondition orAuthCallBackEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("auth_call_back", value);
        return this;
    }

    public MerchantInfoCondition andAuthCallBackNe(Object value) {
        ew.ne("auth_call_back", value);
        return this;
    }

    public MerchantInfoCondition orAuthCallBackNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("auth_call_back", value);
        return this;
    }

    public MerchantInfoCondition andAuthCallBackGt(Object value) {
        ew.gt("auth_call_back", value);
        return this;
    }

    public MerchantInfoCondition orAuthCallBackGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("auth_call_back", value);
        return this;
    }

    public MerchantInfoCondition andAuthCallBackGe(Object value) {
        ew.ge("auth_call_back", value);
        return this;
    }

    public MerchantInfoCondition orAuthCallBackGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("auth_call_back", value);
        return this;
    }

    public MerchantInfoCondition andAuthCallBackLt(Object value) {
        ew.lt("auth_call_back", value);
        return this;
    }

    public MerchantInfoCondition orAuthCallBackLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("auth_call_back", value);
        return this;
    }

    public MerchantInfoCondition andAuthCallBackLe(Object value) {
        ew.le("auth_call_back", value);
        return this;
    }

    public MerchantInfoCondition orAuthCallBackLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("auth_call_back", value);
        return this;
    }

    public MerchantInfoCondition andAuthCallBackIn(Object... value) {
        ew.in("auth_call_back", value);
        return this;
    }

    public MerchantInfoCondition orAuthCallBackIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("auth_call_back", value);
        return this;
    }

    public MerchantInfoCondition andAuthCallBackNotIn(Object... value) {
        ew.notIn("auth_call_back", value);
        return this;
    }

    public MerchantInfoCondition orAuthCallBackNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("auth_call_back", value);
        return this;
    }

    public MerchantInfoCondition andAuthCallBackBetween(Object value, Object value1) {
        ew.between("auth_call_back", value, value1);
        return this;
    }

    public MerchantInfoCondition orAuthCallBackBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("auth_call_back", value, value1);
        return this;
    }

    public MerchantInfoCondition andAuthCallBackNotBetween(Object value, Object value1) {
        ew.notBetween("auth_call_back", value, value1);
        return this;
    }

    public MerchantInfoCondition orAuthCallBackNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("auth_call_back", value, value1);
        return this;
    }

    public MerchantInfoCondition andAuthCallBackLike(String value) {
        ew.like("auth_call_back", value);
        return this;
    }

    public MerchantInfoCondition orAuthCallBackLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("auth_call_back", value);
        return this;
    }

    public MerchantInfoCondition andAuthCallBackNotLike(String value) {
        ew.notLike("auth_call_back", value);
        return this;
    }

    public MerchantInfoCondition orAuthCallBackNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("auth_call_back", value);
        return this;
    }

    public MerchantInfoCondition andAuthRemarkIsNull() {
        ew.isNull("auth_remark");
        return this;
    }

    public MerchantInfoCondition orAuthRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("auth_remark");
        return this;
    }

    public MerchantInfoCondition andAuthRemarkIsNotNull() {
        ew.isNotNull("auth_remark");
        return this;
    }

    public MerchantInfoCondition orAuthRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("auth_remark");
        return this;
    }

    public MerchantInfoCondition andAuthRemarkEq(Object value) {
        ew.eq("auth_remark", value);
        return this;
    }

    public MerchantInfoCondition orAuthRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("auth_remark", value);
        return this;
    }

    public MerchantInfoCondition andAuthRemarkNe(Object value) {
        ew.ne("auth_remark", value);
        return this;
    }

    public MerchantInfoCondition orAuthRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("auth_remark", value);
        return this;
    }

    public MerchantInfoCondition andAuthRemarkGt(Object value) {
        ew.gt("auth_remark", value);
        return this;
    }

    public MerchantInfoCondition orAuthRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("auth_remark", value);
        return this;
    }

    public MerchantInfoCondition andAuthRemarkGe(Object value) {
        ew.ge("auth_remark", value);
        return this;
    }

    public MerchantInfoCondition orAuthRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("auth_remark", value);
        return this;
    }

    public MerchantInfoCondition andAuthRemarkLt(Object value) {
        ew.lt("auth_remark", value);
        return this;
    }

    public MerchantInfoCondition orAuthRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("auth_remark", value);
        return this;
    }

    public MerchantInfoCondition andAuthRemarkLe(Object value) {
        ew.le("auth_remark", value);
        return this;
    }

    public MerchantInfoCondition orAuthRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("auth_remark", value);
        return this;
    }

    public MerchantInfoCondition andAuthRemarkIn(Object... value) {
        ew.in("auth_remark", value);
        return this;
    }

    public MerchantInfoCondition orAuthRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("auth_remark", value);
        return this;
    }

    public MerchantInfoCondition andAuthRemarkNotIn(Object... value) {
        ew.notIn("auth_remark", value);
        return this;
    }

    public MerchantInfoCondition orAuthRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("auth_remark", value);
        return this;
    }

    public MerchantInfoCondition andAuthRemarkBetween(Object value, Object value1) {
        ew.between("auth_remark", value, value1);
        return this;
    }

    public MerchantInfoCondition orAuthRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("auth_remark", value, value1);
        return this;
    }

    public MerchantInfoCondition andAuthRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("auth_remark", value, value1);
        return this;
    }

    public MerchantInfoCondition orAuthRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("auth_remark", value, value1);
        return this;
    }

    public MerchantInfoCondition andAuthRemarkLike(String value) {
        ew.like("auth_remark", value);
        return this;
    }

    public MerchantInfoCondition orAuthRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("auth_remark", value);
        return this;
    }

    public MerchantInfoCondition andAuthRemarkNotLike(String value) {
        ew.notLike("auth_remark", value);
        return this;
    }

    public MerchantInfoCondition orAuthRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("auth_remark", value);
        return this;
    }

    public MerchantInfoCondition andSexIsNull() {
        ew.isNull("sex");
        return this;
    }

    public MerchantInfoCondition orSexIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("sex");
        return this;
    }

    public MerchantInfoCondition andSexIsNotNull() {
        ew.isNotNull("sex");
        return this;
    }

    public MerchantInfoCondition orSexIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("sex");
        return this;
    }

    public MerchantInfoCondition andSexEq(Object value) {
        ew.eq("sex", value);
        return this;
    }

    public MerchantInfoCondition orSexEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("sex", value);
        return this;
    }

    public MerchantInfoCondition andSexNe(Object value) {
        ew.ne("sex", value);
        return this;
    }

    public MerchantInfoCondition orSexNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("sex", value);
        return this;
    }

    public MerchantInfoCondition andSexGt(Object value) {
        ew.gt("sex", value);
        return this;
    }

    public MerchantInfoCondition orSexGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("sex", value);
        return this;
    }

    public MerchantInfoCondition andSexGe(Object value) {
        ew.ge("sex", value);
        return this;
    }

    public MerchantInfoCondition orSexGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("sex", value);
        return this;
    }

    public MerchantInfoCondition andSexLt(Object value) {
        ew.lt("sex", value);
        return this;
    }

    public MerchantInfoCondition orSexLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("sex", value);
        return this;
    }

    public MerchantInfoCondition andSexLe(Object value) {
        ew.le("sex", value);
        return this;
    }

    public MerchantInfoCondition orSexLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("sex", value);
        return this;
    }

    public MerchantInfoCondition andSexIn(Object... value) {
        ew.in("sex", value);
        return this;
    }

    public MerchantInfoCondition orSexIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("sex", value);
        return this;
    }

    public MerchantInfoCondition andSexNotIn(Object... value) {
        ew.notIn("sex", value);
        return this;
    }

    public MerchantInfoCondition orSexNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("sex", value);
        return this;
    }

    public MerchantInfoCondition andSexBetween(Object value, Object value1) {
        ew.between("sex", value, value1);
        return this;
    }

    public MerchantInfoCondition orSexBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("sex", value, value1);
        return this;
    }

    public MerchantInfoCondition andSexNotBetween(Object value, Object value1) {
        ew.notBetween("sex", value, value1);
        return this;
    }

    public MerchantInfoCondition orSexNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("sex", value, value1);
        return this;
    }

    public MerchantInfoCondition andSexLike(String value) {
        ew.like("sex", value);
        return this;
    }

    public MerchantInfoCondition orSexLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("sex", value);
        return this;
    }

    public MerchantInfoCondition andSexNotLike(String value) {
        ew.notLike("sex", value);
        return this;
    }

    public MerchantInfoCondition orSexNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("sex", value);
        return this;
    }

    public MerchantInfoCondition andCountryIsNull() {
        ew.isNull("country");
        return this;
    }

    public MerchantInfoCondition orCountryIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("country");
        return this;
    }

    public MerchantInfoCondition andCountryIsNotNull() {
        ew.isNotNull("country");
        return this;
    }

    public MerchantInfoCondition orCountryIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("country");
        return this;
    }

    public MerchantInfoCondition andCountryEq(Object value) {
        ew.eq("country", value);
        return this;
    }

    public MerchantInfoCondition orCountryEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("country", value);
        return this;
    }

    public MerchantInfoCondition andCountryNe(Object value) {
        ew.ne("country", value);
        return this;
    }

    public MerchantInfoCondition orCountryNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("country", value);
        return this;
    }

    public MerchantInfoCondition andCountryGt(Object value) {
        ew.gt("country", value);
        return this;
    }

    public MerchantInfoCondition orCountryGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("country", value);
        return this;
    }

    public MerchantInfoCondition andCountryGe(Object value) {
        ew.ge("country", value);
        return this;
    }

    public MerchantInfoCondition orCountryGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("country", value);
        return this;
    }

    public MerchantInfoCondition andCountryLt(Object value) {
        ew.lt("country", value);
        return this;
    }

    public MerchantInfoCondition orCountryLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("country", value);
        return this;
    }

    public MerchantInfoCondition andCountryLe(Object value) {
        ew.le("country", value);
        return this;
    }

    public MerchantInfoCondition orCountryLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("country", value);
        return this;
    }

    public MerchantInfoCondition andCountryIn(Object... value) {
        ew.in("country", value);
        return this;
    }

    public MerchantInfoCondition orCountryIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("country", value);
        return this;
    }

    public MerchantInfoCondition andCountryNotIn(Object... value) {
        ew.notIn("country", value);
        return this;
    }

    public MerchantInfoCondition orCountryNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("country", value);
        return this;
    }

    public MerchantInfoCondition andCountryBetween(Object value, Object value1) {
        ew.between("country", value, value1);
        return this;
    }

    public MerchantInfoCondition orCountryBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("country", value, value1);
        return this;
    }

    public MerchantInfoCondition andCountryNotBetween(Object value, Object value1) {
        ew.notBetween("country", value, value1);
        return this;
    }

    public MerchantInfoCondition orCountryNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("country", value, value1);
        return this;
    }

    public MerchantInfoCondition andCountryLike(String value) {
        ew.like("country", value);
        return this;
    }

    public MerchantInfoCondition orCountryLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("country", value);
        return this;
    }

    public MerchantInfoCondition andCountryNotLike(String value) {
        ew.notLike("country", value);
        return this;
    }

    public MerchantInfoCondition orCountryNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("country", value);
        return this;
    }

    public MerchantInfoCondition andProsessionIsNull() {
        ew.isNull("prosession");
        return this;
    }

    public MerchantInfoCondition orProsessionIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("prosession");
        return this;
    }

    public MerchantInfoCondition andProsessionIsNotNull() {
        ew.isNotNull("prosession");
        return this;
    }

    public MerchantInfoCondition orProsessionIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("prosession");
        return this;
    }

    public MerchantInfoCondition andProsessionEq(Object value) {
        ew.eq("prosession", value);
        return this;
    }

    public MerchantInfoCondition orProsessionEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("prosession", value);
        return this;
    }

    public MerchantInfoCondition andProsessionNe(Object value) {
        ew.ne("prosession", value);
        return this;
    }

    public MerchantInfoCondition orProsessionNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("prosession", value);
        return this;
    }

    public MerchantInfoCondition andProsessionGt(Object value) {
        ew.gt("prosession", value);
        return this;
    }

    public MerchantInfoCondition orProsessionGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("prosession", value);
        return this;
    }

    public MerchantInfoCondition andProsessionGe(Object value) {
        ew.ge("prosession", value);
        return this;
    }

    public MerchantInfoCondition orProsessionGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("prosession", value);
        return this;
    }

    public MerchantInfoCondition andProsessionLt(Object value) {
        ew.lt("prosession", value);
        return this;
    }

    public MerchantInfoCondition orProsessionLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("prosession", value);
        return this;
    }

    public MerchantInfoCondition andProsessionLe(Object value) {
        ew.le("prosession", value);
        return this;
    }

    public MerchantInfoCondition orProsessionLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("prosession", value);
        return this;
    }

    public MerchantInfoCondition andProsessionIn(Object... value) {
        ew.in("prosession", value);
        return this;
    }

    public MerchantInfoCondition orProsessionIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("prosession", value);
        return this;
    }

    public MerchantInfoCondition andProsessionNotIn(Object... value) {
        ew.notIn("prosession", value);
        return this;
    }

    public MerchantInfoCondition orProsessionNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("prosession", value);
        return this;
    }

    public MerchantInfoCondition andProsessionBetween(Object value, Object value1) {
        ew.between("prosession", value, value1);
        return this;
    }

    public MerchantInfoCondition orProsessionBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("prosession", value, value1);
        return this;
    }

    public MerchantInfoCondition andProsessionNotBetween(Object value, Object value1) {
        ew.notBetween("prosession", value, value1);
        return this;
    }

    public MerchantInfoCondition orProsessionNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("prosession", value, value1);
        return this;
    }

    public MerchantInfoCondition andProsessionLike(String value) {
        ew.like("prosession", value);
        return this;
    }

    public MerchantInfoCondition orProsessionLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("prosession", value);
        return this;
    }

    public MerchantInfoCondition andProsessionNotLike(String value) {
        ew.notLike("prosession", value);
        return this;
    }

    public MerchantInfoCondition orProsessionNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("prosession", value);
        return this;
    }

    public MerchantInfoCondition andIdIndateIsNull() {
        ew.isNull("id_indate");
        return this;
    }

    public MerchantInfoCondition orIdIndateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id_indate");
        return this;
    }

    public MerchantInfoCondition andIdIndateIsNotNull() {
        ew.isNotNull("id_indate");
        return this;
    }

    public MerchantInfoCondition orIdIndateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id_indate");
        return this;
    }

    public MerchantInfoCondition andIdIndateEq(Object value) {
        ew.eq("id_indate", value);
        return this;
    }

    public MerchantInfoCondition orIdIndateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id_indate", value);
        return this;
    }

    public MerchantInfoCondition andIdIndateNe(Object value) {
        ew.ne("id_indate", value);
        return this;
    }

    public MerchantInfoCondition orIdIndateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id_indate", value);
        return this;
    }

    public MerchantInfoCondition andIdIndateGt(Object value) {
        ew.gt("id_indate", value);
        return this;
    }

    public MerchantInfoCondition orIdIndateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id_indate", value);
        return this;
    }

    public MerchantInfoCondition andIdIndateGe(Object value) {
        ew.ge("id_indate", value);
        return this;
    }

    public MerchantInfoCondition orIdIndateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id_indate", value);
        return this;
    }

    public MerchantInfoCondition andIdIndateLt(Object value) {
        ew.lt("id_indate", value);
        return this;
    }

    public MerchantInfoCondition orIdIndateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id_indate", value);
        return this;
    }

    public MerchantInfoCondition andIdIndateLe(Object value) {
        ew.le("id_indate", value);
        return this;
    }

    public MerchantInfoCondition orIdIndateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id_indate", value);
        return this;
    }

    public MerchantInfoCondition andIdIndateIn(Object... value) {
        ew.in("id_indate", value);
        return this;
    }

    public MerchantInfoCondition orIdIndateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id_indate", value);
        return this;
    }

    public MerchantInfoCondition andIdIndateNotIn(Object... value) {
        ew.notIn("id_indate", value);
        return this;
    }

    public MerchantInfoCondition orIdIndateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id_indate", value);
        return this;
    }

    public MerchantInfoCondition andIdIndateBetween(Object value, Object value1) {
        ew.between("id_indate", value, value1);
        return this;
    }

    public MerchantInfoCondition orIdIndateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id_indate", value, value1);
        return this;
    }

    public MerchantInfoCondition andIdIndateNotBetween(Object value, Object value1) {
        ew.notBetween("id_indate", value, value1);
        return this;
    }

    public MerchantInfoCondition orIdIndateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id_indate", value, value1);
        return this;
    }

    public MerchantInfoCondition andIdIndateLike(String value) {
        ew.like("id_indate", value);
        return this;
    }

    public MerchantInfoCondition orIdIndateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id_indate", value);
        return this;
    }

    public MerchantInfoCondition andIdIndateNotLike(String value) {
        ew.notLike("id_indate", value);
        return this;
    }

    public MerchantInfoCondition orIdIndateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id_indate", value);
        return this;
    }

    public MerchantInfoCondition andTelephoneIsNull() {
        ew.isNull("telephone");
        return this;
    }

    public MerchantInfoCondition orTelephoneIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("telephone");
        return this;
    }

    public MerchantInfoCondition andTelephoneIsNotNull() {
        ew.isNotNull("telephone");
        return this;
    }

    public MerchantInfoCondition orTelephoneIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("telephone");
        return this;
    }

    public MerchantInfoCondition andTelephoneEq(Object value) {
        ew.eq("telephone", value);
        return this;
    }

    public MerchantInfoCondition orTelephoneEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("telephone", value);
        return this;
    }

    public MerchantInfoCondition andTelephoneNe(Object value) {
        ew.ne("telephone", value);
        return this;
    }

    public MerchantInfoCondition orTelephoneNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("telephone", value);
        return this;
    }

    public MerchantInfoCondition andTelephoneGt(Object value) {
        ew.gt("telephone", value);
        return this;
    }

    public MerchantInfoCondition orTelephoneGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("telephone", value);
        return this;
    }

    public MerchantInfoCondition andTelephoneGe(Object value) {
        ew.ge("telephone", value);
        return this;
    }

    public MerchantInfoCondition orTelephoneGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("telephone", value);
        return this;
    }

    public MerchantInfoCondition andTelephoneLt(Object value) {
        ew.lt("telephone", value);
        return this;
    }

    public MerchantInfoCondition orTelephoneLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("telephone", value);
        return this;
    }

    public MerchantInfoCondition andTelephoneLe(Object value) {
        ew.le("telephone", value);
        return this;
    }

    public MerchantInfoCondition orTelephoneLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("telephone", value);
        return this;
    }

    public MerchantInfoCondition andTelephoneIn(Object... value) {
        ew.in("telephone", value);
        return this;
    }

    public MerchantInfoCondition orTelephoneIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("telephone", value);
        return this;
    }

    public MerchantInfoCondition andTelephoneNotIn(Object... value) {
        ew.notIn("telephone", value);
        return this;
    }

    public MerchantInfoCondition orTelephoneNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("telephone", value);
        return this;
    }

    public MerchantInfoCondition andTelephoneBetween(Object value, Object value1) {
        ew.between("telephone", value, value1);
        return this;
    }

    public MerchantInfoCondition orTelephoneBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("telephone", value, value1);
        return this;
    }

    public MerchantInfoCondition andTelephoneNotBetween(Object value, Object value1) {
        ew.notBetween("telephone", value, value1);
        return this;
    }

    public MerchantInfoCondition orTelephoneNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("telephone", value, value1);
        return this;
    }

    public MerchantInfoCondition andTelephoneLike(String value) {
        ew.like("telephone", value);
        return this;
    }

    public MerchantInfoCondition orTelephoneLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("telephone", value);
        return this;
    }

    public MerchantInfoCondition andTelephoneNotLike(String value) {
        ew.notLike("telephone", value);
        return this;
    }

    public MerchantInfoCondition orTelephoneNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("telephone", value);
        return this;
    }

    public MerchantInfoCondition andFileTypeIsNull() {
        ew.isNull("file_type");
        return this;
    }

    public MerchantInfoCondition orFileTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("file_type");
        return this;
    }

    public MerchantInfoCondition andFileTypeIsNotNull() {
        ew.isNotNull("file_type");
        return this;
    }

    public MerchantInfoCondition orFileTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("file_type");
        return this;
    }

    public MerchantInfoCondition andFileTypeEq(Object value) {
        ew.eq("file_type", value);
        return this;
    }

    public MerchantInfoCondition orFileTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("file_type", value);
        return this;
    }

    public MerchantInfoCondition andFileTypeNe(Object value) {
        ew.ne("file_type", value);
        return this;
    }

    public MerchantInfoCondition orFileTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("file_type", value);
        return this;
    }

    public MerchantInfoCondition andFileTypeGt(Object value) {
        ew.gt("file_type", value);
        return this;
    }

    public MerchantInfoCondition orFileTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("file_type", value);
        return this;
    }

    public MerchantInfoCondition andFileTypeGe(Object value) {
        ew.ge("file_type", value);
        return this;
    }

    public MerchantInfoCondition orFileTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("file_type", value);
        return this;
    }

    public MerchantInfoCondition andFileTypeLt(Object value) {
        ew.lt("file_type", value);
        return this;
    }

    public MerchantInfoCondition orFileTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("file_type", value);
        return this;
    }

    public MerchantInfoCondition andFileTypeLe(Object value) {
        ew.le("file_type", value);
        return this;
    }

    public MerchantInfoCondition orFileTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("file_type", value);
        return this;
    }

    public MerchantInfoCondition andFileTypeIn(Object... value) {
        ew.in("file_type", value);
        return this;
    }

    public MerchantInfoCondition orFileTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("file_type", value);
        return this;
    }

    public MerchantInfoCondition andFileTypeNotIn(Object... value) {
        ew.notIn("file_type", value);
        return this;
    }

    public MerchantInfoCondition orFileTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("file_type", value);
        return this;
    }

    public MerchantInfoCondition andFileTypeBetween(Object value, Object value1) {
        ew.between("file_type", value, value1);
        return this;
    }

    public MerchantInfoCondition orFileTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("file_type", value, value1);
        return this;
    }

    public MerchantInfoCondition andFileTypeNotBetween(Object value, Object value1) {
        ew.notBetween("file_type", value, value1);
        return this;
    }

    public MerchantInfoCondition orFileTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("file_type", value, value1);
        return this;
    }

    public MerchantInfoCondition andFileTypeLike(String value) {
        ew.like("file_type", value);
        return this;
    }

    public MerchantInfoCondition orFileTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("file_type", value);
        return this;
    }

    public MerchantInfoCondition andFileTypeNotLike(String value) {
        ew.notLike("file_type", value);
        return this;
    }

    public MerchantInfoCondition orFileTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("file_type", value);
        return this;
    }

    public MerchantInfoCondition andOtherFileTypeIsNull() {
        ew.isNull("other_file_type");
        return this;
    }

    public MerchantInfoCondition orOtherFileTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("other_file_type");
        return this;
    }

    public MerchantInfoCondition andOtherFileTypeIsNotNull() {
        ew.isNotNull("other_file_type");
        return this;
    }

    public MerchantInfoCondition orOtherFileTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("other_file_type");
        return this;
    }

    public MerchantInfoCondition andOtherFileTypeEq(Object value) {
        ew.eq("other_file_type", value);
        return this;
    }

    public MerchantInfoCondition orOtherFileTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("other_file_type", value);
        return this;
    }

    public MerchantInfoCondition andOtherFileTypeNe(Object value) {
        ew.ne("other_file_type", value);
        return this;
    }

    public MerchantInfoCondition orOtherFileTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("other_file_type", value);
        return this;
    }

    public MerchantInfoCondition andOtherFileTypeGt(Object value) {
        ew.gt("other_file_type", value);
        return this;
    }

    public MerchantInfoCondition orOtherFileTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("other_file_type", value);
        return this;
    }

    public MerchantInfoCondition andOtherFileTypeGe(Object value) {
        ew.ge("other_file_type", value);
        return this;
    }

    public MerchantInfoCondition orOtherFileTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("other_file_type", value);
        return this;
    }

    public MerchantInfoCondition andOtherFileTypeLt(Object value) {
        ew.lt("other_file_type", value);
        return this;
    }

    public MerchantInfoCondition orOtherFileTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("other_file_type", value);
        return this;
    }

    public MerchantInfoCondition andOtherFileTypeLe(Object value) {
        ew.le("other_file_type", value);
        return this;
    }

    public MerchantInfoCondition orOtherFileTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("other_file_type", value);
        return this;
    }

    public MerchantInfoCondition andOtherFileTypeIn(Object... value) {
        ew.in("other_file_type", value);
        return this;
    }

    public MerchantInfoCondition orOtherFileTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("other_file_type", value);
        return this;
    }

    public MerchantInfoCondition andOtherFileTypeNotIn(Object... value) {
        ew.notIn("other_file_type", value);
        return this;
    }

    public MerchantInfoCondition orOtherFileTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("other_file_type", value);
        return this;
    }

    public MerchantInfoCondition andOtherFileTypeBetween(Object value, Object value1) {
        ew.between("other_file_type", value, value1);
        return this;
    }

    public MerchantInfoCondition orOtherFileTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("other_file_type", value, value1);
        return this;
    }

    public MerchantInfoCondition andOtherFileTypeNotBetween(Object value, Object value1) {
        ew.notBetween("other_file_type", value, value1);
        return this;
    }

    public MerchantInfoCondition orOtherFileTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("other_file_type", value, value1);
        return this;
    }

    public MerchantInfoCondition andOtherFileTypeLike(String value) {
        ew.like("other_file_type", value);
        return this;
    }

    public MerchantInfoCondition orOtherFileTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("other_file_type", value);
        return this;
    }

    public MerchantInfoCondition andOtherFileTypeNotLike(String value) {
        ew.notLike("other_file_type", value);
        return this;
    }

    public MerchantInfoCondition orOtherFileTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("other_file_type", value);
        return this;
    }

    public MerchantInfoCondition andFileNumIsNull() {
        ew.isNull("file_num");
        return this;
    }

    public MerchantInfoCondition orFileNumIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("file_num");
        return this;
    }

    public MerchantInfoCondition andFileNumIsNotNull() {
        ew.isNotNull("file_num");
        return this;
    }

    public MerchantInfoCondition orFileNumIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("file_num");
        return this;
    }

    public MerchantInfoCondition andFileNumEq(Object value) {
        ew.eq("file_num", value);
        return this;
    }

    public MerchantInfoCondition orFileNumEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("file_num", value);
        return this;
    }

    public MerchantInfoCondition andFileNumNe(Object value) {
        ew.ne("file_num", value);
        return this;
    }

    public MerchantInfoCondition orFileNumNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("file_num", value);
        return this;
    }

    public MerchantInfoCondition andFileNumGt(Object value) {
        ew.gt("file_num", value);
        return this;
    }

    public MerchantInfoCondition orFileNumGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("file_num", value);
        return this;
    }

    public MerchantInfoCondition andFileNumGe(Object value) {
        ew.ge("file_num", value);
        return this;
    }

    public MerchantInfoCondition orFileNumGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("file_num", value);
        return this;
    }

    public MerchantInfoCondition andFileNumLt(Object value) {
        ew.lt("file_num", value);
        return this;
    }

    public MerchantInfoCondition orFileNumLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("file_num", value);
        return this;
    }

    public MerchantInfoCondition andFileNumLe(Object value) {
        ew.le("file_num", value);
        return this;
    }

    public MerchantInfoCondition orFileNumLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("file_num", value);
        return this;
    }

    public MerchantInfoCondition andFileNumIn(Object... value) {
        ew.in("file_num", value);
        return this;
    }

    public MerchantInfoCondition orFileNumIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("file_num", value);
        return this;
    }

    public MerchantInfoCondition andFileNumNotIn(Object... value) {
        ew.notIn("file_num", value);
        return this;
    }

    public MerchantInfoCondition orFileNumNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("file_num", value);
        return this;
    }

    public MerchantInfoCondition andFileNumBetween(Object value, Object value1) {
        ew.between("file_num", value, value1);
        return this;
    }

    public MerchantInfoCondition orFileNumBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("file_num", value, value1);
        return this;
    }

    public MerchantInfoCondition andFileNumNotBetween(Object value, Object value1) {
        ew.notBetween("file_num", value, value1);
        return this;
    }

    public MerchantInfoCondition orFileNumNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("file_num", value, value1);
        return this;
    }

    public MerchantInfoCondition andFileNumLike(String value) {
        ew.like("file_num", value);
        return this;
    }

    public MerchantInfoCondition orFileNumLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("file_num", value);
        return this;
    }

    public MerchantInfoCondition andFileNumNotLike(String value) {
        ew.notLike("file_num", value);
        return this;
    }

    public MerchantInfoCondition orFileNumNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("file_num", value);
        return this;
    }

    public MerchantInfoCondition andNatureIsNull() {
        ew.isNull("nature");
        return this;
    }

    public MerchantInfoCondition orNatureIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("nature");
        return this;
    }

    public MerchantInfoCondition andNatureIsNotNull() {
        ew.isNotNull("nature");
        return this;
    }

    public MerchantInfoCondition orNatureIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("nature");
        return this;
    }

    public MerchantInfoCondition andNatureEq(Object value) {
        ew.eq("nature", value);
        return this;
    }

    public MerchantInfoCondition orNatureEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("nature", value);
        return this;
    }

    public MerchantInfoCondition andNatureNe(Object value) {
        ew.ne("nature", value);
        return this;
    }

    public MerchantInfoCondition orNatureNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("nature", value);
        return this;
    }

    public MerchantInfoCondition andNatureGt(Object value) {
        ew.gt("nature", value);
        return this;
    }

    public MerchantInfoCondition orNatureGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("nature", value);
        return this;
    }

    public MerchantInfoCondition andNatureGe(Object value) {
        ew.ge("nature", value);
        return this;
    }

    public MerchantInfoCondition orNatureGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("nature", value);
        return this;
    }

    public MerchantInfoCondition andNatureLt(Object value) {
        ew.lt("nature", value);
        return this;
    }

    public MerchantInfoCondition orNatureLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("nature", value);
        return this;
    }

    public MerchantInfoCondition andNatureLe(Object value) {
        ew.le("nature", value);
        return this;
    }

    public MerchantInfoCondition orNatureLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("nature", value);
        return this;
    }

    public MerchantInfoCondition andNatureIn(Object... value) {
        ew.in("nature", value);
        return this;
    }

    public MerchantInfoCondition orNatureIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("nature", value);
        return this;
    }

    public MerchantInfoCondition andNatureNotIn(Object... value) {
        ew.notIn("nature", value);
        return this;
    }

    public MerchantInfoCondition orNatureNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("nature", value);
        return this;
    }

    public MerchantInfoCondition andNatureBetween(Object value, Object value1) {
        ew.between("nature", value, value1);
        return this;
    }

    public MerchantInfoCondition orNatureBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("nature", value, value1);
        return this;
    }

    public MerchantInfoCondition andNatureNotBetween(Object value, Object value1) {
        ew.notBetween("nature", value, value1);
        return this;
    }

    public MerchantInfoCondition orNatureNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("nature", value, value1);
        return this;
    }

    public MerchantInfoCondition andNatureLike(String value) {
        ew.like("nature", value);
        return this;
    }

    public MerchantInfoCondition orNatureLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("nature", value);
        return this;
    }

    public MerchantInfoCondition andNatureNotLike(String value) {
        ew.notLike("nature", value);
        return this;
    }

    public MerchantInfoCondition orNatureNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("nature", value);
        return this;
    }

    public MerchantInfoCondition andSettleAccountIsNull() {
        ew.isNull("settle_account");
        return this;
    }

    public MerchantInfoCondition orSettleAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("settle_account");
        return this;
    }

    public MerchantInfoCondition andSettleAccountIsNotNull() {
        ew.isNotNull("settle_account");
        return this;
    }

    public MerchantInfoCondition orSettleAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("settle_account");
        return this;
    }

    public MerchantInfoCondition andSettleAccountEq(Object value) {
        ew.eq("settle_account", value);
        return this;
    }

    public MerchantInfoCondition orSettleAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("settle_account", value);
        return this;
    }

    public MerchantInfoCondition andSettleAccountNe(Object value) {
        ew.ne("settle_account", value);
        return this;
    }

    public MerchantInfoCondition orSettleAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("settle_account", value);
        return this;
    }

    public MerchantInfoCondition andSettleAccountGt(Object value) {
        ew.gt("settle_account", value);
        return this;
    }

    public MerchantInfoCondition orSettleAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("settle_account", value);
        return this;
    }

    public MerchantInfoCondition andSettleAccountGe(Object value) {
        ew.ge("settle_account", value);
        return this;
    }

    public MerchantInfoCondition orSettleAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("settle_account", value);
        return this;
    }

    public MerchantInfoCondition andSettleAccountLt(Object value) {
        ew.lt("settle_account", value);
        return this;
    }

    public MerchantInfoCondition orSettleAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("settle_account", value);
        return this;
    }

    public MerchantInfoCondition andSettleAccountLe(Object value) {
        ew.le("settle_account", value);
        return this;
    }

    public MerchantInfoCondition orSettleAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("settle_account", value);
        return this;
    }

    public MerchantInfoCondition andSettleAccountIn(Object... value) {
        ew.in("settle_account", value);
        return this;
    }

    public MerchantInfoCondition orSettleAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("settle_account", value);
        return this;
    }

    public MerchantInfoCondition andSettleAccountNotIn(Object... value) {
        ew.notIn("settle_account", value);
        return this;
    }

    public MerchantInfoCondition orSettleAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("settle_account", value);
        return this;
    }

    public MerchantInfoCondition andSettleAccountBetween(Object value, Object value1) {
        ew.between("settle_account", value, value1);
        return this;
    }

    public MerchantInfoCondition orSettleAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("settle_account", value, value1);
        return this;
    }

    public MerchantInfoCondition andSettleAccountNotBetween(Object value, Object value1) {
        ew.notBetween("settle_account", value, value1);
        return this;
    }

    public MerchantInfoCondition orSettleAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("settle_account", value, value1);
        return this;
    }

    public MerchantInfoCondition andSettleAccountLike(String value) {
        ew.like("settle_account", value);
        return this;
    }

    public MerchantInfoCondition orSettleAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("settle_account", value);
        return this;
    }

    public MerchantInfoCondition andSettleAccountNotLike(String value) {
        ew.notLike("settle_account", value);
        return this;
    }

    public MerchantInfoCondition orSettleAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("settle_account", value);
        return this;
    }

    public MerchantInfoCondition andBusLicPicIsNull() {
        ew.isNull("bus_lic_pic");
        return this;
    }

    public MerchantInfoCondition orBusLicPicIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("bus_lic_pic");
        return this;
    }

    public MerchantInfoCondition andBusLicPicIsNotNull() {
        ew.isNotNull("bus_lic_pic");
        return this;
    }

    public MerchantInfoCondition orBusLicPicIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("bus_lic_pic");
        return this;
    }

    public MerchantInfoCondition andBusLicPicEq(Object value) {
        ew.eq("bus_lic_pic", value);
        return this;
    }

    public MerchantInfoCondition orBusLicPicEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("bus_lic_pic", value);
        return this;
    }

    public MerchantInfoCondition andBusLicPicNe(Object value) {
        ew.ne("bus_lic_pic", value);
        return this;
    }

    public MerchantInfoCondition orBusLicPicNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("bus_lic_pic", value);
        return this;
    }

    public MerchantInfoCondition andBusLicPicGt(Object value) {
        ew.gt("bus_lic_pic", value);
        return this;
    }

    public MerchantInfoCondition orBusLicPicGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("bus_lic_pic", value);
        return this;
    }

    public MerchantInfoCondition andBusLicPicGe(Object value) {
        ew.ge("bus_lic_pic", value);
        return this;
    }

    public MerchantInfoCondition orBusLicPicGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("bus_lic_pic", value);
        return this;
    }

    public MerchantInfoCondition andBusLicPicLt(Object value) {
        ew.lt("bus_lic_pic", value);
        return this;
    }

    public MerchantInfoCondition orBusLicPicLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("bus_lic_pic", value);
        return this;
    }

    public MerchantInfoCondition andBusLicPicLe(Object value) {
        ew.le("bus_lic_pic", value);
        return this;
    }

    public MerchantInfoCondition orBusLicPicLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("bus_lic_pic", value);
        return this;
    }

    public MerchantInfoCondition andBusLicPicIn(Object... value) {
        ew.in("bus_lic_pic", value);
        return this;
    }

    public MerchantInfoCondition orBusLicPicIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("bus_lic_pic", value);
        return this;
    }

    public MerchantInfoCondition andBusLicPicNotIn(Object... value) {
        ew.notIn("bus_lic_pic", value);
        return this;
    }

    public MerchantInfoCondition orBusLicPicNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("bus_lic_pic", value);
        return this;
    }

    public MerchantInfoCondition andBusLicPicBetween(Object value, Object value1) {
        ew.between("bus_lic_pic", value, value1);
        return this;
    }

    public MerchantInfoCondition orBusLicPicBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("bus_lic_pic", value, value1);
        return this;
    }

    public MerchantInfoCondition andBusLicPicNotBetween(Object value, Object value1) {
        ew.notBetween("bus_lic_pic", value, value1);
        return this;
    }

    public MerchantInfoCondition orBusLicPicNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("bus_lic_pic", value, value1);
        return this;
    }

    public MerchantInfoCondition andBusLicPicLike(String value) {
        ew.like("bus_lic_pic", value);
        return this;
    }

    public MerchantInfoCondition orBusLicPicLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("bus_lic_pic", value);
        return this;
    }

    public MerchantInfoCondition andBusLicPicNotLike(String value) {
        ew.notLike("bus_lic_pic", value);
        return this;
    }

    public MerchantInfoCondition orBusLicPicNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("bus_lic_pic", value);
        return this;
    }

    public MerchantInfoCondition andPersonPicIsNull() {
        ew.isNull("person_pic");
        return this;
    }

    public MerchantInfoCondition orPersonPicIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("person_pic");
        return this;
    }

    public MerchantInfoCondition andPersonPicIsNotNull() {
        ew.isNotNull("person_pic");
        return this;
    }

    public MerchantInfoCondition orPersonPicIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("person_pic");
        return this;
    }

    public MerchantInfoCondition andPersonPicEq(Object value) {
        ew.eq("person_pic", value);
        return this;
    }

    public MerchantInfoCondition orPersonPicEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("person_pic", value);
        return this;
    }

    public MerchantInfoCondition andPersonPicNe(Object value) {
        ew.ne("person_pic", value);
        return this;
    }

    public MerchantInfoCondition orPersonPicNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("person_pic", value);
        return this;
    }

    public MerchantInfoCondition andPersonPicGt(Object value) {
        ew.gt("person_pic", value);
        return this;
    }

    public MerchantInfoCondition orPersonPicGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("person_pic", value);
        return this;
    }

    public MerchantInfoCondition andPersonPicGe(Object value) {
        ew.ge("person_pic", value);
        return this;
    }

    public MerchantInfoCondition orPersonPicGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("person_pic", value);
        return this;
    }

    public MerchantInfoCondition andPersonPicLt(Object value) {
        ew.lt("person_pic", value);
        return this;
    }

    public MerchantInfoCondition orPersonPicLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("person_pic", value);
        return this;
    }

    public MerchantInfoCondition andPersonPicLe(Object value) {
        ew.le("person_pic", value);
        return this;
    }

    public MerchantInfoCondition orPersonPicLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("person_pic", value);
        return this;
    }

    public MerchantInfoCondition andPersonPicIn(Object... value) {
        ew.in("person_pic", value);
        return this;
    }

    public MerchantInfoCondition orPersonPicIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("person_pic", value);
        return this;
    }

    public MerchantInfoCondition andPersonPicNotIn(Object... value) {
        ew.notIn("person_pic", value);
        return this;
    }

    public MerchantInfoCondition orPersonPicNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("person_pic", value);
        return this;
    }

    public MerchantInfoCondition andPersonPicBetween(Object value, Object value1) {
        ew.between("person_pic", value, value1);
        return this;
    }

    public MerchantInfoCondition orPersonPicBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("person_pic", value, value1);
        return this;
    }

    public MerchantInfoCondition andPersonPicNotBetween(Object value, Object value1) {
        ew.notBetween("person_pic", value, value1);
        return this;
    }

    public MerchantInfoCondition orPersonPicNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("person_pic", value, value1);
        return this;
    }

    public MerchantInfoCondition andPersonPicLike(String value) {
        ew.like("person_pic", value);
        return this;
    }

    public MerchantInfoCondition orPersonPicLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("person_pic", value);
        return this;
    }

    public MerchantInfoCondition andPersonPicNotLike(String value) {
        ew.notLike("person_pic", value);
        return this;
    }

    public MerchantInfoCondition orPersonPicNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("person_pic", value);
        return this;
    }

    public MerchantInfoCondition andPersonReversePicIsNull() {
        ew.isNull("person_reverse_pic");
        return this;
    }

    public MerchantInfoCondition orPersonReversePicIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("person_reverse_pic");
        return this;
    }

    public MerchantInfoCondition andPersonReversePicIsNotNull() {
        ew.isNotNull("person_reverse_pic");
        return this;
    }

    public MerchantInfoCondition orPersonReversePicIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("person_reverse_pic");
        return this;
    }

    public MerchantInfoCondition andPersonReversePicEq(Object value) {
        ew.eq("person_reverse_pic", value);
        return this;
    }

    public MerchantInfoCondition orPersonReversePicEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("person_reverse_pic", value);
        return this;
    }

    public MerchantInfoCondition andPersonReversePicNe(Object value) {
        ew.ne("person_reverse_pic", value);
        return this;
    }

    public MerchantInfoCondition orPersonReversePicNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("person_reverse_pic", value);
        return this;
    }

    public MerchantInfoCondition andPersonReversePicGt(Object value) {
        ew.gt("person_reverse_pic", value);
        return this;
    }

    public MerchantInfoCondition orPersonReversePicGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("person_reverse_pic", value);
        return this;
    }

    public MerchantInfoCondition andPersonReversePicGe(Object value) {
        ew.ge("person_reverse_pic", value);
        return this;
    }

    public MerchantInfoCondition orPersonReversePicGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("person_reverse_pic", value);
        return this;
    }

    public MerchantInfoCondition andPersonReversePicLt(Object value) {
        ew.lt("person_reverse_pic", value);
        return this;
    }

    public MerchantInfoCondition orPersonReversePicLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("person_reverse_pic", value);
        return this;
    }

    public MerchantInfoCondition andPersonReversePicLe(Object value) {
        ew.le("person_reverse_pic", value);
        return this;
    }

    public MerchantInfoCondition orPersonReversePicLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("person_reverse_pic", value);
        return this;
    }

    public MerchantInfoCondition andPersonReversePicIn(Object... value) {
        ew.in("person_reverse_pic", value);
        return this;
    }

    public MerchantInfoCondition orPersonReversePicIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("person_reverse_pic", value);
        return this;
    }

    public MerchantInfoCondition andPersonReversePicNotIn(Object... value) {
        ew.notIn("person_reverse_pic", value);
        return this;
    }

    public MerchantInfoCondition orPersonReversePicNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("person_reverse_pic", value);
        return this;
    }

    public MerchantInfoCondition andPersonReversePicBetween(Object value, Object value1) {
        ew.between("person_reverse_pic", value, value1);
        return this;
    }

    public MerchantInfoCondition orPersonReversePicBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("person_reverse_pic", value, value1);
        return this;
    }

    public MerchantInfoCondition andPersonReversePicNotBetween(Object value, Object value1) {
        ew.notBetween("person_reverse_pic", value, value1);
        return this;
    }

    public MerchantInfoCondition orPersonReversePicNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("person_reverse_pic", value, value1);
        return this;
    }

    public MerchantInfoCondition andPersonReversePicLike(String value) {
        ew.like("person_reverse_pic", value);
        return this;
    }

    public MerchantInfoCondition orPersonReversePicLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("person_reverse_pic", value);
        return this;
    }

    public MerchantInfoCondition andPersonReversePicNotLike(String value) {
        ew.notLike("person_reverse_pic", value);
        return this;
    }

    public MerchantInfoCondition orPersonReversePicNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("person_reverse_pic", value);
        return this;
    }

    public MerchantInfoCondition andLicensePicIsNull() {
        ew.isNull("license_pic");
        return this;
    }

    public MerchantInfoCondition orLicensePicIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("license_pic");
        return this;
    }

    public MerchantInfoCondition andLicensePicIsNotNull() {
        ew.isNotNull("license_pic");
        return this;
    }

    public MerchantInfoCondition orLicensePicIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("license_pic");
        return this;
    }

    public MerchantInfoCondition andLicensePicEq(Object value) {
        ew.eq("license_pic", value);
        return this;
    }

    public MerchantInfoCondition orLicensePicEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("license_pic", value);
        return this;
    }

    public MerchantInfoCondition andLicensePicNe(Object value) {
        ew.ne("license_pic", value);
        return this;
    }

    public MerchantInfoCondition orLicensePicNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("license_pic", value);
        return this;
    }

    public MerchantInfoCondition andLicensePicGt(Object value) {
        ew.gt("license_pic", value);
        return this;
    }

    public MerchantInfoCondition orLicensePicGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("license_pic", value);
        return this;
    }

    public MerchantInfoCondition andLicensePicGe(Object value) {
        ew.ge("license_pic", value);
        return this;
    }

    public MerchantInfoCondition orLicensePicGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("license_pic", value);
        return this;
    }

    public MerchantInfoCondition andLicensePicLt(Object value) {
        ew.lt("license_pic", value);
        return this;
    }

    public MerchantInfoCondition orLicensePicLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("license_pic", value);
        return this;
    }

    public MerchantInfoCondition andLicensePicLe(Object value) {
        ew.le("license_pic", value);
        return this;
    }

    public MerchantInfoCondition orLicensePicLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("license_pic", value);
        return this;
    }

    public MerchantInfoCondition andLicensePicIn(Object... value) {
        ew.in("license_pic", value);
        return this;
    }

    public MerchantInfoCondition orLicensePicIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("license_pic", value);
        return this;
    }

    public MerchantInfoCondition andLicensePicNotIn(Object... value) {
        ew.notIn("license_pic", value);
        return this;
    }

    public MerchantInfoCondition orLicensePicNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("license_pic", value);
        return this;
    }

    public MerchantInfoCondition andLicensePicBetween(Object value, Object value1) {
        ew.between("license_pic", value, value1);
        return this;
    }

    public MerchantInfoCondition orLicensePicBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("license_pic", value, value1);
        return this;
    }

    public MerchantInfoCondition andLicensePicNotBetween(Object value, Object value1) {
        ew.notBetween("license_pic", value, value1);
        return this;
    }

    public MerchantInfoCondition orLicensePicNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("license_pic", value, value1);
        return this;
    }

    public MerchantInfoCondition andLicensePicLike(String value) {
        ew.like("license_pic", value);
        return this;
    }

    public MerchantInfoCondition orLicensePicLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("license_pic", value);
        return this;
    }

    public MerchantInfoCondition andLicensePicNotLike(String value) {
        ew.notLike("license_pic", value);
        return this;
    }

    public MerchantInfoCondition orLicensePicNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("license_pic", value);
        return this;
    }
}