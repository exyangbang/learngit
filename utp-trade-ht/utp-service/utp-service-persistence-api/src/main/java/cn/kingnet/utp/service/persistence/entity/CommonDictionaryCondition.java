package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class CommonDictionaryCondition {
    private PlusEntityWrapper<CommonDictionary> ew;

    public CommonDictionaryCondition() {
        this.ew = new PlusEntityWrapper(CommonDictionary.class);
    }

    public static CommonDictionaryCondition builder() {
        return new CommonDictionaryCondition();
    }

    public PlusEntityWrapper<CommonDictionary> build() {
        return this.ew;
    }

    public CommonDictionaryCondition or() {
        this.ew.orNew();
        return this;
    }

    public CommonDictionaryCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(CommonDictionary.class);
    }

    public CommonDictionaryCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public CommonDictionaryCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public CommonDictionaryCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public CommonDictionaryCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> CommonDictionaryCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> CommonDictionaryCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> CommonDictionaryCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public CommonDictionaryCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public CommonDictionaryCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public CommonDictionaryCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public CommonDictionaryCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public CommonDictionaryCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public CommonDictionaryCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public CommonDictionaryCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public CommonDictionaryCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public CommonDictionaryCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public CommonDictionaryCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public CommonDictionaryCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public CommonDictionaryCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public CommonDictionaryCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public CommonDictionaryCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public CommonDictionaryCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public CommonDictionaryCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public CommonDictionaryCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public CommonDictionaryCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public CommonDictionaryCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public CommonDictionaryCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public CommonDictionaryCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public CommonDictionaryCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public CommonDictionaryCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public CommonDictionaryCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public CommonDictionaryCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public CommonDictionaryCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public CommonDictionaryCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public CommonDictionaryCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public CommonDictionaryCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public CommonDictionaryCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public CommonDictionaryCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public CommonDictionaryCondition andTypeIsNull() {
        ew.isNull("type");
        return this;
    }

    public CommonDictionaryCondition orTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("type");
        return this;
    }

    public CommonDictionaryCondition andTypeIsNotNull() {
        ew.isNotNull("type");
        return this;
    }

    public CommonDictionaryCondition orTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("type");
        return this;
    }

    public CommonDictionaryCondition andTypeEq(Object value) {
        ew.eq("type", value);
        return this;
    }

    public CommonDictionaryCondition orTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("type", value);
        return this;
    }

    public CommonDictionaryCondition andTypeNe(Object value) {
        ew.ne("type", value);
        return this;
    }

    public CommonDictionaryCondition orTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("type", value);
        return this;
    }

    public CommonDictionaryCondition andTypeGt(Object value) {
        ew.gt("type", value);
        return this;
    }

    public CommonDictionaryCondition orTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("type", value);
        return this;
    }

    public CommonDictionaryCondition andTypeGe(Object value) {
        ew.ge("type", value);
        return this;
    }

    public CommonDictionaryCondition orTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("type", value);
        return this;
    }

    public CommonDictionaryCondition andTypeLt(Object value) {
        ew.lt("type", value);
        return this;
    }

    public CommonDictionaryCondition orTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("type", value);
        return this;
    }

    public CommonDictionaryCondition andTypeLe(Object value) {
        ew.le("type", value);
        return this;
    }

    public CommonDictionaryCondition orTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("type", value);
        return this;
    }

    public CommonDictionaryCondition andTypeIn(Object... value) {
        ew.in("type", value);
        return this;
    }

    public CommonDictionaryCondition orTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("type", value);
        return this;
    }

    public CommonDictionaryCondition andTypeNotIn(Object... value) {
        ew.notIn("type", value);
        return this;
    }

    public CommonDictionaryCondition orTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("type", value);
        return this;
    }

    public CommonDictionaryCondition andTypeBetween(Object value, Object value1) {
        ew.between("type", value, value1);
        return this;
    }

    public CommonDictionaryCondition orTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("type", value, value1);
        return this;
    }

    public CommonDictionaryCondition andTypeNotBetween(Object value, Object value1) {
        ew.notBetween("type", value, value1);
        return this;
    }

    public CommonDictionaryCondition orTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("type", value, value1);
        return this;
    }

    public CommonDictionaryCondition andTypeLike(String value) {
        ew.like("type", value);
        return this;
    }

    public CommonDictionaryCondition orTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("type", value);
        return this;
    }

    public CommonDictionaryCondition andTypeNotLike(String value) {
        ew.notLike("type", value);
        return this;
    }

    public CommonDictionaryCondition orTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("type", value);
        return this;
    }

    public CommonDictionaryCondition andDescriptionIsNull() {
        ew.isNull("description");
        return this;
    }

    public CommonDictionaryCondition orDescriptionIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("description");
        return this;
    }

    public CommonDictionaryCondition andDescriptionIsNotNull() {
        ew.isNotNull("description");
        return this;
    }

    public CommonDictionaryCondition orDescriptionIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("description");
        return this;
    }

    public CommonDictionaryCondition andDescriptionEq(Object value) {
        ew.eq("description", value);
        return this;
    }

    public CommonDictionaryCondition orDescriptionEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("description", value);
        return this;
    }

    public CommonDictionaryCondition andDescriptionNe(Object value) {
        ew.ne("description", value);
        return this;
    }

    public CommonDictionaryCondition orDescriptionNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("description", value);
        return this;
    }

    public CommonDictionaryCondition andDescriptionGt(Object value) {
        ew.gt("description", value);
        return this;
    }

    public CommonDictionaryCondition orDescriptionGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("description", value);
        return this;
    }

    public CommonDictionaryCondition andDescriptionGe(Object value) {
        ew.ge("description", value);
        return this;
    }

    public CommonDictionaryCondition orDescriptionGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("description", value);
        return this;
    }

    public CommonDictionaryCondition andDescriptionLt(Object value) {
        ew.lt("description", value);
        return this;
    }

    public CommonDictionaryCondition orDescriptionLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("description", value);
        return this;
    }

    public CommonDictionaryCondition andDescriptionLe(Object value) {
        ew.le("description", value);
        return this;
    }

    public CommonDictionaryCondition orDescriptionLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("description", value);
        return this;
    }

    public CommonDictionaryCondition andDescriptionIn(Object... value) {
        ew.in("description", value);
        return this;
    }

    public CommonDictionaryCondition orDescriptionIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("description", value);
        return this;
    }

    public CommonDictionaryCondition andDescriptionNotIn(Object... value) {
        ew.notIn("description", value);
        return this;
    }

    public CommonDictionaryCondition orDescriptionNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("description", value);
        return this;
    }

    public CommonDictionaryCondition andDescriptionBetween(Object value, Object value1) {
        ew.between("description", value, value1);
        return this;
    }

    public CommonDictionaryCondition orDescriptionBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("description", value, value1);
        return this;
    }

    public CommonDictionaryCondition andDescriptionNotBetween(Object value, Object value1) {
        ew.notBetween("description", value, value1);
        return this;
    }

    public CommonDictionaryCondition orDescriptionNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("description", value, value1);
        return this;
    }

    public CommonDictionaryCondition andDescriptionLike(String value) {
        ew.like("description", value);
        return this;
    }

    public CommonDictionaryCondition orDescriptionLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("description", value);
        return this;
    }

    public CommonDictionaryCondition andDescriptionNotLike(String value) {
        ew.notLike("description", value);
        return this;
    }

    public CommonDictionaryCondition orDescriptionNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("description", value);
        return this;
    }

    public CommonDictionaryCondition andSystemIdIsNull() {
        ew.isNull("system_id");
        return this;
    }

    public CommonDictionaryCondition orSystemIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("system_id");
        return this;
    }

    public CommonDictionaryCondition andSystemIdIsNotNull() {
        ew.isNotNull("system_id");
        return this;
    }

    public CommonDictionaryCondition orSystemIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("system_id");
        return this;
    }

    public CommonDictionaryCondition andSystemIdEq(Object value) {
        ew.eq("system_id", value);
        return this;
    }

    public CommonDictionaryCondition orSystemIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("system_id", value);
        return this;
    }

    public CommonDictionaryCondition andSystemIdNe(Object value) {
        ew.ne("system_id", value);
        return this;
    }

    public CommonDictionaryCondition orSystemIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("system_id", value);
        return this;
    }

    public CommonDictionaryCondition andSystemIdGt(Object value) {
        ew.gt("system_id", value);
        return this;
    }

    public CommonDictionaryCondition orSystemIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("system_id", value);
        return this;
    }

    public CommonDictionaryCondition andSystemIdGe(Object value) {
        ew.ge("system_id", value);
        return this;
    }

    public CommonDictionaryCondition orSystemIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("system_id", value);
        return this;
    }

    public CommonDictionaryCondition andSystemIdLt(Object value) {
        ew.lt("system_id", value);
        return this;
    }

    public CommonDictionaryCondition orSystemIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("system_id", value);
        return this;
    }

    public CommonDictionaryCondition andSystemIdLe(Object value) {
        ew.le("system_id", value);
        return this;
    }

    public CommonDictionaryCondition orSystemIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("system_id", value);
        return this;
    }

    public CommonDictionaryCondition andSystemIdIn(Object... value) {
        ew.in("system_id", value);
        return this;
    }

    public CommonDictionaryCondition orSystemIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("system_id", value);
        return this;
    }

    public CommonDictionaryCondition andSystemIdNotIn(Object... value) {
        ew.notIn("system_id", value);
        return this;
    }

    public CommonDictionaryCondition orSystemIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("system_id", value);
        return this;
    }

    public CommonDictionaryCondition andSystemIdBetween(Object value, Object value1) {
        ew.between("system_id", value, value1);
        return this;
    }

    public CommonDictionaryCondition orSystemIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("system_id", value, value1);
        return this;
    }

    public CommonDictionaryCondition andSystemIdNotBetween(Object value, Object value1) {
        ew.notBetween("system_id", value, value1);
        return this;
    }

    public CommonDictionaryCondition orSystemIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("system_id", value, value1);
        return this;
    }

    public CommonDictionaryCondition andSystemIdLike(String value) {
        ew.like("system_id", value);
        return this;
    }

    public CommonDictionaryCondition orSystemIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("system_id", value);
        return this;
    }

    public CommonDictionaryCondition andSystemIdNotLike(String value) {
        ew.notLike("system_id", value);
        return this;
    }

    public CommonDictionaryCondition orSystemIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("system_id", value);
        return this;
    }

    public CommonDictionaryCondition andKeyIsNull() {
        ew.isNull("key");
        return this;
    }

    public CommonDictionaryCondition orKeyIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("key");
        return this;
    }

    public CommonDictionaryCondition andKeyIsNotNull() {
        ew.isNotNull("key");
        return this;
    }

    public CommonDictionaryCondition orKeyIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("key");
        return this;
    }

    public CommonDictionaryCondition andKeyEq(Object value) {
        ew.eq("key", value);
        return this;
    }

    public CommonDictionaryCondition orKeyEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("key", value);
        return this;
    }

    public CommonDictionaryCondition andKeyNe(Object value) {
        ew.ne("key", value);
        return this;
    }

    public CommonDictionaryCondition orKeyNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("key", value);
        return this;
    }

    public CommonDictionaryCondition andKeyGt(Object value) {
        ew.gt("key", value);
        return this;
    }

    public CommonDictionaryCondition orKeyGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("key", value);
        return this;
    }

    public CommonDictionaryCondition andKeyGe(Object value) {
        ew.ge("key", value);
        return this;
    }

    public CommonDictionaryCondition orKeyGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("key", value);
        return this;
    }

    public CommonDictionaryCondition andKeyLt(Object value) {
        ew.lt("key", value);
        return this;
    }

    public CommonDictionaryCondition orKeyLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("key", value);
        return this;
    }

    public CommonDictionaryCondition andKeyLe(Object value) {
        ew.le("key", value);
        return this;
    }

    public CommonDictionaryCondition orKeyLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("key", value);
        return this;
    }

    public CommonDictionaryCondition andKeyIn(Object... value) {
        ew.in("key", value);
        return this;
    }

    public CommonDictionaryCondition orKeyIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("key", value);
        return this;
    }

    public CommonDictionaryCondition andKeyNotIn(Object... value) {
        ew.notIn("key", value);
        return this;
    }

    public CommonDictionaryCondition orKeyNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("key", value);
        return this;
    }

    public CommonDictionaryCondition andKeyBetween(Object value, Object value1) {
        ew.between("key", value, value1);
        return this;
    }

    public CommonDictionaryCondition orKeyBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("key", value, value1);
        return this;
    }

    public CommonDictionaryCondition andKeyNotBetween(Object value, Object value1) {
        ew.notBetween("key", value, value1);
        return this;
    }

    public CommonDictionaryCondition orKeyNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("key", value, value1);
        return this;
    }

    public CommonDictionaryCondition andKeyLike(String value) {
        ew.like("key", value);
        return this;
    }

    public CommonDictionaryCondition orKeyLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("key", value);
        return this;
    }

    public CommonDictionaryCondition andKeyNotLike(String value) {
        ew.notLike("key", value);
        return this;
    }

    public CommonDictionaryCondition orKeyNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("key", value);
        return this;
    }

    public CommonDictionaryCondition andValueIsNull() {
        ew.isNull("value");
        return this;
    }

    public CommonDictionaryCondition orValueIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("value");
        return this;
    }

    public CommonDictionaryCondition andValueIsNotNull() {
        ew.isNotNull("value");
        return this;
    }

    public CommonDictionaryCondition orValueIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("value");
        return this;
    }

    public CommonDictionaryCondition andValueEq(Object value) {
        ew.eq("value", value);
        return this;
    }

    public CommonDictionaryCondition orValueEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("value", value);
        return this;
    }

    public CommonDictionaryCondition andValueNe(Object value) {
        ew.ne("value", value);
        return this;
    }

    public CommonDictionaryCondition orValueNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("value", value);
        return this;
    }

    public CommonDictionaryCondition andValueGt(Object value) {
        ew.gt("value", value);
        return this;
    }

    public CommonDictionaryCondition orValueGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("value", value);
        return this;
    }

    public CommonDictionaryCondition andValueGe(Object value) {
        ew.ge("value", value);
        return this;
    }

    public CommonDictionaryCondition orValueGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("value", value);
        return this;
    }

    public CommonDictionaryCondition andValueLt(Object value) {
        ew.lt("value", value);
        return this;
    }

    public CommonDictionaryCondition orValueLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("value", value);
        return this;
    }

    public CommonDictionaryCondition andValueLe(Object value) {
        ew.le("value", value);
        return this;
    }

    public CommonDictionaryCondition orValueLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("value", value);
        return this;
    }

    public CommonDictionaryCondition andValueIn(Object... value) {
        ew.in("value", value);
        return this;
    }

    public CommonDictionaryCondition orValueIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("value", value);
        return this;
    }

    public CommonDictionaryCondition andValueNotIn(Object... value) {
        ew.notIn("value", value);
        return this;
    }

    public CommonDictionaryCondition orValueNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("value", value);
        return this;
    }

    public CommonDictionaryCondition andValueBetween(Object value, Object value1) {
        ew.between("value", value, value1);
        return this;
    }

    public CommonDictionaryCondition orValueBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("value", value, value1);
        return this;
    }

    public CommonDictionaryCondition andValueNotBetween(Object value, Object value1) {
        ew.notBetween("value", value, value1);
        return this;
    }

    public CommonDictionaryCondition orValueNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("value", value, value1);
        return this;
    }

    public CommonDictionaryCondition andValueLike(String value) {
        ew.like("value", value);
        return this;
    }

    public CommonDictionaryCondition orValueLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("value", value);
        return this;
    }

    public CommonDictionaryCondition andValueNotLike(String value) {
        ew.notLike("value", value);
        return this;
    }

    public CommonDictionaryCondition orValueNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("value", value);
        return this;
    }
}