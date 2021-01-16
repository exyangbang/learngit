package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class CountryCondition {
    private PlusEntityWrapper<Country> ew;

    public CountryCondition() {
        this.ew = new PlusEntityWrapper(Country.class);
    }

    public static CountryCondition builder() {
        return new CountryCondition();
    }

    public PlusEntityWrapper<Country> build() {
        return this.ew;
    }

    public CountryCondition or() {
        this.ew.orNew();
        return this;
    }

    public CountryCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(Country.class);
    }

    public CountryCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public CountryCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public CountryCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public CountryCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> CountryCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> CountryCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> CountryCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public CountryCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public CountryCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public CountryCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public CountryCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public CountryCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public CountryCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public CountryCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public CountryCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public CountryCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public CountryCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public CountryCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public CountryCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public CountryCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public CountryCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public CountryCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public CountryCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public CountryCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public CountryCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public CountryCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public CountryCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public CountryCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public CountryCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public CountryCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public CountryCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public CountryCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public CountryCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public CountryCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public CountryCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public CountryCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public CountryCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public CountryCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public CountryCondition andTwoBitLettersIsNull() {
        ew.isNull("two_bit_letters");
        return this;
    }

    public CountryCondition orTwoBitLettersIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("two_bit_letters");
        return this;
    }

    public CountryCondition andTwoBitLettersIsNotNull() {
        ew.isNotNull("two_bit_letters");
        return this;
    }

    public CountryCondition orTwoBitLettersIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("two_bit_letters");
        return this;
    }

    public CountryCondition andTwoBitLettersEq(Object value) {
        ew.eq("two_bit_letters", value);
        return this;
    }

    public CountryCondition orTwoBitLettersEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("two_bit_letters", value);
        return this;
    }

    public CountryCondition andTwoBitLettersNe(Object value) {
        ew.ne("two_bit_letters", value);
        return this;
    }

    public CountryCondition orTwoBitLettersNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("two_bit_letters", value);
        return this;
    }

    public CountryCondition andTwoBitLettersGt(Object value) {
        ew.gt("two_bit_letters", value);
        return this;
    }

    public CountryCondition orTwoBitLettersGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("two_bit_letters", value);
        return this;
    }

    public CountryCondition andTwoBitLettersGe(Object value) {
        ew.ge("two_bit_letters", value);
        return this;
    }

    public CountryCondition orTwoBitLettersGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("two_bit_letters", value);
        return this;
    }

    public CountryCondition andTwoBitLettersLt(Object value) {
        ew.lt("two_bit_letters", value);
        return this;
    }

    public CountryCondition orTwoBitLettersLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("two_bit_letters", value);
        return this;
    }

    public CountryCondition andTwoBitLettersLe(Object value) {
        ew.le("two_bit_letters", value);
        return this;
    }

    public CountryCondition orTwoBitLettersLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("two_bit_letters", value);
        return this;
    }

    public CountryCondition andTwoBitLettersIn(Object... value) {
        ew.in("two_bit_letters", value);
        return this;
    }

    public CountryCondition orTwoBitLettersIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("two_bit_letters", value);
        return this;
    }

    public CountryCondition andTwoBitLettersNotIn(Object... value) {
        ew.notIn("two_bit_letters", value);
        return this;
    }

    public CountryCondition orTwoBitLettersNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("two_bit_letters", value);
        return this;
    }

    public CountryCondition andTwoBitLettersBetween(Object value, Object value1) {
        ew.between("two_bit_letters", value, value1);
        return this;
    }

    public CountryCondition orTwoBitLettersBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("two_bit_letters", value, value1);
        return this;
    }

    public CountryCondition andTwoBitLettersNotBetween(Object value, Object value1) {
        ew.notBetween("two_bit_letters", value, value1);
        return this;
    }

    public CountryCondition orTwoBitLettersNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("two_bit_letters", value, value1);
        return this;
    }

    public CountryCondition andTwoBitLettersLike(String value) {
        ew.like("two_bit_letters", value);
        return this;
    }

    public CountryCondition orTwoBitLettersLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("two_bit_letters", value);
        return this;
    }

    public CountryCondition andTwoBitLettersNotLike(String value) {
        ew.notLike("two_bit_letters", value);
        return this;
    }

    public CountryCondition orTwoBitLettersNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("two_bit_letters", value);
        return this;
    }

    public CountryCondition andThreeBitLettersIsNull() {
        ew.isNull("three_bit_letters");
        return this;
    }

    public CountryCondition orThreeBitLettersIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("three_bit_letters");
        return this;
    }

    public CountryCondition andThreeBitLettersIsNotNull() {
        ew.isNotNull("three_bit_letters");
        return this;
    }

    public CountryCondition orThreeBitLettersIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("three_bit_letters");
        return this;
    }

    public CountryCondition andThreeBitLettersEq(Object value) {
        ew.eq("three_bit_letters", value);
        return this;
    }

    public CountryCondition orThreeBitLettersEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("three_bit_letters", value);
        return this;
    }

    public CountryCondition andThreeBitLettersNe(Object value) {
        ew.ne("three_bit_letters", value);
        return this;
    }

    public CountryCondition orThreeBitLettersNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("three_bit_letters", value);
        return this;
    }

    public CountryCondition andThreeBitLettersGt(Object value) {
        ew.gt("three_bit_letters", value);
        return this;
    }

    public CountryCondition orThreeBitLettersGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("three_bit_letters", value);
        return this;
    }

    public CountryCondition andThreeBitLettersGe(Object value) {
        ew.ge("three_bit_letters", value);
        return this;
    }

    public CountryCondition orThreeBitLettersGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("three_bit_letters", value);
        return this;
    }

    public CountryCondition andThreeBitLettersLt(Object value) {
        ew.lt("three_bit_letters", value);
        return this;
    }

    public CountryCondition orThreeBitLettersLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("three_bit_letters", value);
        return this;
    }

    public CountryCondition andThreeBitLettersLe(Object value) {
        ew.le("three_bit_letters", value);
        return this;
    }

    public CountryCondition orThreeBitLettersLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("three_bit_letters", value);
        return this;
    }

    public CountryCondition andThreeBitLettersIn(Object... value) {
        ew.in("three_bit_letters", value);
        return this;
    }

    public CountryCondition orThreeBitLettersIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("three_bit_letters", value);
        return this;
    }

    public CountryCondition andThreeBitLettersNotIn(Object... value) {
        ew.notIn("three_bit_letters", value);
        return this;
    }

    public CountryCondition orThreeBitLettersNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("three_bit_letters", value);
        return this;
    }

    public CountryCondition andThreeBitLettersBetween(Object value, Object value1) {
        ew.between("three_bit_letters", value, value1);
        return this;
    }

    public CountryCondition orThreeBitLettersBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("three_bit_letters", value, value1);
        return this;
    }

    public CountryCondition andThreeBitLettersNotBetween(Object value, Object value1) {
        ew.notBetween("three_bit_letters", value, value1);
        return this;
    }

    public CountryCondition orThreeBitLettersNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("three_bit_letters", value, value1);
        return this;
    }

    public CountryCondition andThreeBitLettersLike(String value) {
        ew.like("three_bit_letters", value);
        return this;
    }

    public CountryCondition orThreeBitLettersLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("three_bit_letters", value);
        return this;
    }

    public CountryCondition andThreeBitLettersNotLike(String value) {
        ew.notLike("three_bit_letters", value);
        return this;
    }

    public CountryCondition orThreeBitLettersNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("three_bit_letters", value);
        return this;
    }

    public CountryCondition andNumCodeIsNull() {
        ew.isNull("num_code");
        return this;
    }

    public CountryCondition orNumCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("num_code");
        return this;
    }

    public CountryCondition andNumCodeIsNotNull() {
        ew.isNotNull("num_code");
        return this;
    }

    public CountryCondition orNumCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("num_code");
        return this;
    }

    public CountryCondition andNumCodeEq(Object value) {
        ew.eq("num_code", value);
        return this;
    }

    public CountryCondition orNumCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("num_code", value);
        return this;
    }

    public CountryCondition andNumCodeNe(Object value) {
        ew.ne("num_code", value);
        return this;
    }

    public CountryCondition orNumCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("num_code", value);
        return this;
    }

    public CountryCondition andNumCodeGt(Object value) {
        ew.gt("num_code", value);
        return this;
    }

    public CountryCondition orNumCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("num_code", value);
        return this;
    }

    public CountryCondition andNumCodeGe(Object value) {
        ew.ge("num_code", value);
        return this;
    }

    public CountryCondition orNumCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("num_code", value);
        return this;
    }

    public CountryCondition andNumCodeLt(Object value) {
        ew.lt("num_code", value);
        return this;
    }

    public CountryCondition orNumCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("num_code", value);
        return this;
    }

    public CountryCondition andNumCodeLe(Object value) {
        ew.le("num_code", value);
        return this;
    }

    public CountryCondition orNumCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("num_code", value);
        return this;
    }

    public CountryCondition andNumCodeIn(Object... value) {
        ew.in("num_code", value);
        return this;
    }

    public CountryCondition orNumCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("num_code", value);
        return this;
    }

    public CountryCondition andNumCodeNotIn(Object... value) {
        ew.notIn("num_code", value);
        return this;
    }

    public CountryCondition orNumCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("num_code", value);
        return this;
    }

    public CountryCondition andNumCodeBetween(Object value, Object value1) {
        ew.between("num_code", value, value1);
        return this;
    }

    public CountryCondition orNumCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("num_code", value, value1);
        return this;
    }

    public CountryCondition andNumCodeNotBetween(Object value, Object value1) {
        ew.notBetween("num_code", value, value1);
        return this;
    }

    public CountryCondition orNumCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("num_code", value, value1);
        return this;
    }

    public CountryCondition andNumCodeLike(String value) {
        ew.like("num_code", value);
        return this;
    }

    public CountryCondition orNumCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("num_code", value);
        return this;
    }

    public CountryCondition andNumCodeNotLike(String value) {
        ew.notLike("num_code", value);
        return this;
    }

    public CountryCondition orNumCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("num_code", value);
        return this;
    }

    public CountryCondition andEngNameIsNull() {
        ew.isNull("eng_name");
        return this;
    }

    public CountryCondition orEngNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("eng_name");
        return this;
    }

    public CountryCondition andEngNameIsNotNull() {
        ew.isNotNull("eng_name");
        return this;
    }

    public CountryCondition orEngNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("eng_name");
        return this;
    }

    public CountryCondition andEngNameEq(Object value) {
        ew.eq("eng_name", value);
        return this;
    }

    public CountryCondition orEngNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("eng_name", value);
        return this;
    }

    public CountryCondition andEngNameNe(Object value) {
        ew.ne("eng_name", value);
        return this;
    }

    public CountryCondition orEngNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("eng_name", value);
        return this;
    }

    public CountryCondition andEngNameGt(Object value) {
        ew.gt("eng_name", value);
        return this;
    }

    public CountryCondition orEngNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("eng_name", value);
        return this;
    }

    public CountryCondition andEngNameGe(Object value) {
        ew.ge("eng_name", value);
        return this;
    }

    public CountryCondition orEngNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("eng_name", value);
        return this;
    }

    public CountryCondition andEngNameLt(Object value) {
        ew.lt("eng_name", value);
        return this;
    }

    public CountryCondition orEngNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("eng_name", value);
        return this;
    }

    public CountryCondition andEngNameLe(Object value) {
        ew.le("eng_name", value);
        return this;
    }

    public CountryCondition orEngNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("eng_name", value);
        return this;
    }

    public CountryCondition andEngNameIn(Object... value) {
        ew.in("eng_name", value);
        return this;
    }

    public CountryCondition orEngNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("eng_name", value);
        return this;
    }

    public CountryCondition andEngNameNotIn(Object... value) {
        ew.notIn("eng_name", value);
        return this;
    }

    public CountryCondition orEngNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("eng_name", value);
        return this;
    }

    public CountryCondition andEngNameBetween(Object value, Object value1) {
        ew.between("eng_name", value, value1);
        return this;
    }

    public CountryCondition orEngNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("eng_name", value, value1);
        return this;
    }

    public CountryCondition andEngNameNotBetween(Object value, Object value1) {
        ew.notBetween("eng_name", value, value1);
        return this;
    }

    public CountryCondition orEngNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("eng_name", value, value1);
        return this;
    }

    public CountryCondition andEngNameLike(String value) {
        ew.like("eng_name", value);
        return this;
    }

    public CountryCondition orEngNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("eng_name", value);
        return this;
    }

    public CountryCondition andEngNameNotLike(String value) {
        ew.notLike("eng_name", value);
        return this;
    }

    public CountryCondition orEngNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("eng_name", value);
        return this;
    }

    public CountryCondition andChNameIsNull() {
        ew.isNull("ch_name");
        return this;
    }

    public CountryCondition orChNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ch_name");
        return this;
    }

    public CountryCondition andChNameIsNotNull() {
        ew.isNotNull("ch_name");
        return this;
    }

    public CountryCondition orChNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ch_name");
        return this;
    }

    public CountryCondition andChNameEq(Object value) {
        ew.eq("ch_name", value);
        return this;
    }

    public CountryCondition orChNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ch_name", value);
        return this;
    }

    public CountryCondition andChNameNe(Object value) {
        ew.ne("ch_name", value);
        return this;
    }

    public CountryCondition orChNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ch_name", value);
        return this;
    }

    public CountryCondition andChNameGt(Object value) {
        ew.gt("ch_name", value);
        return this;
    }

    public CountryCondition orChNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ch_name", value);
        return this;
    }

    public CountryCondition andChNameGe(Object value) {
        ew.ge("ch_name", value);
        return this;
    }

    public CountryCondition orChNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ch_name", value);
        return this;
    }

    public CountryCondition andChNameLt(Object value) {
        ew.lt("ch_name", value);
        return this;
    }

    public CountryCondition orChNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ch_name", value);
        return this;
    }

    public CountryCondition andChNameLe(Object value) {
        ew.le("ch_name", value);
        return this;
    }

    public CountryCondition orChNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ch_name", value);
        return this;
    }

    public CountryCondition andChNameIn(Object... value) {
        ew.in("ch_name", value);
        return this;
    }

    public CountryCondition orChNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ch_name", value);
        return this;
    }

    public CountryCondition andChNameNotIn(Object... value) {
        ew.notIn("ch_name", value);
        return this;
    }

    public CountryCondition orChNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ch_name", value);
        return this;
    }

    public CountryCondition andChNameBetween(Object value, Object value1) {
        ew.between("ch_name", value, value1);
        return this;
    }

    public CountryCondition orChNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ch_name", value, value1);
        return this;
    }

    public CountryCondition andChNameNotBetween(Object value, Object value1) {
        ew.notBetween("ch_name", value, value1);
        return this;
    }

    public CountryCondition orChNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ch_name", value, value1);
        return this;
    }

    public CountryCondition andChNameLike(String value) {
        ew.like("ch_name", value);
        return this;
    }

    public CountryCondition orChNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ch_name", value);
        return this;
    }

    public CountryCondition andChNameNotLike(String value) {
        ew.notLike("ch_name", value);
        return this;
    }

    public CountryCondition orChNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ch_name", value);
        return this;
    }
}