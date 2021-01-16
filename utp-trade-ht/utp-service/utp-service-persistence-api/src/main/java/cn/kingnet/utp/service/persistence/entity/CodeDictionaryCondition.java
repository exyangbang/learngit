package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class CodeDictionaryCondition {
    private PlusEntityWrapper<CodeDictionary> ew;

    public CodeDictionaryCondition() {
        this.ew = new PlusEntityWrapper(CodeDictionary.class);
    }

    public static CodeDictionaryCondition builder() {
        return new CodeDictionaryCondition();
    }

    public PlusEntityWrapper<CodeDictionary> build() {
        return this.ew;
    }

    public CodeDictionaryCondition or() {
        this.ew.orNew();
        return this;
    }

    public CodeDictionaryCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(CodeDictionary.class);
    }

    public CodeDictionaryCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public CodeDictionaryCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public CodeDictionaryCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public CodeDictionaryCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> CodeDictionaryCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> CodeDictionaryCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> CodeDictionaryCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public CodeDictionaryCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public CodeDictionaryCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public CodeDictionaryCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public CodeDictionaryCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public CodeDictionaryCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public CodeDictionaryCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public CodeDictionaryCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public CodeDictionaryCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public CodeDictionaryCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public CodeDictionaryCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public CodeDictionaryCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public CodeDictionaryCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public CodeDictionaryCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public CodeDictionaryCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public CodeDictionaryCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public CodeDictionaryCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public CodeDictionaryCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public CodeDictionaryCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public CodeDictionaryCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public CodeDictionaryCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public CodeDictionaryCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public CodeDictionaryCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public CodeDictionaryCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public CodeDictionaryCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public CodeDictionaryCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public CodeDictionaryCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public CodeDictionaryCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public CodeDictionaryCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public CodeDictionaryCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public CodeDictionaryCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public CodeDictionaryCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public CodeDictionaryCondition andTypeIsNull() {
        ew.isNull("type");
        return this;
    }

    public CodeDictionaryCondition orTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("type");
        return this;
    }

    public CodeDictionaryCondition andTypeIsNotNull() {
        ew.isNotNull("type");
        return this;
    }

    public CodeDictionaryCondition orTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("type");
        return this;
    }

    public CodeDictionaryCondition andTypeEq(Object value) {
        ew.eq("type", value);
        return this;
    }

    public CodeDictionaryCondition orTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("type", value);
        return this;
    }

    public CodeDictionaryCondition andTypeNe(Object value) {
        ew.ne("type", value);
        return this;
    }

    public CodeDictionaryCondition orTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("type", value);
        return this;
    }

    public CodeDictionaryCondition andTypeGt(Object value) {
        ew.gt("type", value);
        return this;
    }

    public CodeDictionaryCondition orTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("type", value);
        return this;
    }

    public CodeDictionaryCondition andTypeGe(Object value) {
        ew.ge("type", value);
        return this;
    }

    public CodeDictionaryCondition orTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("type", value);
        return this;
    }

    public CodeDictionaryCondition andTypeLt(Object value) {
        ew.lt("type", value);
        return this;
    }

    public CodeDictionaryCondition orTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("type", value);
        return this;
    }

    public CodeDictionaryCondition andTypeLe(Object value) {
        ew.le("type", value);
        return this;
    }

    public CodeDictionaryCondition orTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("type", value);
        return this;
    }

    public CodeDictionaryCondition andTypeIn(Object... value) {
        ew.in("type", value);
        return this;
    }

    public CodeDictionaryCondition orTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("type", value);
        return this;
    }

    public CodeDictionaryCondition andTypeNotIn(Object... value) {
        ew.notIn("type", value);
        return this;
    }

    public CodeDictionaryCondition orTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("type", value);
        return this;
    }

    public CodeDictionaryCondition andTypeBetween(Object value, Object value1) {
        ew.between("type", value, value1);
        return this;
    }

    public CodeDictionaryCondition orTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("type", value, value1);
        return this;
    }

    public CodeDictionaryCondition andTypeNotBetween(Object value, Object value1) {
        ew.notBetween("type", value, value1);
        return this;
    }

    public CodeDictionaryCondition orTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("type", value, value1);
        return this;
    }

    public CodeDictionaryCondition andTypeLike(String value) {
        ew.like("type", value);
        return this;
    }

    public CodeDictionaryCondition orTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("type", value);
        return this;
    }

    public CodeDictionaryCondition andTypeNotLike(String value) {
        ew.notLike("type", value);
        return this;
    }

    public CodeDictionaryCondition orTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("type", value);
        return this;
    }

    public CodeDictionaryCondition andCodeIsNull() {
        ew.isNull("code");
        return this;
    }

    public CodeDictionaryCondition orCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("code");
        return this;
    }

    public CodeDictionaryCondition andCodeIsNotNull() {
        ew.isNotNull("code");
        return this;
    }

    public CodeDictionaryCondition orCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("code");
        return this;
    }

    public CodeDictionaryCondition andCodeEq(Object value) {
        ew.eq("code", value);
        return this;
    }

    public CodeDictionaryCondition orCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("code", value);
        return this;
    }

    public CodeDictionaryCondition andCodeNe(Object value) {
        ew.ne("code", value);
        return this;
    }

    public CodeDictionaryCondition orCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("code", value);
        return this;
    }

    public CodeDictionaryCondition andCodeGt(Object value) {
        ew.gt("code", value);
        return this;
    }

    public CodeDictionaryCondition orCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("code", value);
        return this;
    }

    public CodeDictionaryCondition andCodeGe(Object value) {
        ew.ge("code", value);
        return this;
    }

    public CodeDictionaryCondition orCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("code", value);
        return this;
    }

    public CodeDictionaryCondition andCodeLt(Object value) {
        ew.lt("code", value);
        return this;
    }

    public CodeDictionaryCondition orCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("code", value);
        return this;
    }

    public CodeDictionaryCondition andCodeLe(Object value) {
        ew.le("code", value);
        return this;
    }

    public CodeDictionaryCondition orCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("code", value);
        return this;
    }

    public CodeDictionaryCondition andCodeIn(Object... value) {
        ew.in("code", value);
        return this;
    }

    public CodeDictionaryCondition orCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("code", value);
        return this;
    }

    public CodeDictionaryCondition andCodeNotIn(Object... value) {
        ew.notIn("code", value);
        return this;
    }

    public CodeDictionaryCondition orCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("code", value);
        return this;
    }

    public CodeDictionaryCondition andCodeBetween(Object value, Object value1) {
        ew.between("code", value, value1);
        return this;
    }

    public CodeDictionaryCondition orCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("code", value, value1);
        return this;
    }

    public CodeDictionaryCondition andCodeNotBetween(Object value, Object value1) {
        ew.notBetween("code", value, value1);
        return this;
    }

    public CodeDictionaryCondition orCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("code", value, value1);
        return this;
    }

    public CodeDictionaryCondition andCodeLike(String value) {
        ew.like("code", value);
        return this;
    }

    public CodeDictionaryCondition orCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("code", value);
        return this;
    }

    public CodeDictionaryCondition andCodeNotLike(String value) {
        ew.notLike("code", value);
        return this;
    }

    public CodeDictionaryCondition orCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("code", value);
        return this;
    }

    public CodeDictionaryCondition andValueIsNull() {
        ew.isNull("value");
        return this;
    }

    public CodeDictionaryCondition orValueIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("value");
        return this;
    }

    public CodeDictionaryCondition andValueIsNotNull() {
        ew.isNotNull("value");
        return this;
    }

    public CodeDictionaryCondition orValueIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("value");
        return this;
    }

    public CodeDictionaryCondition andValueEq(Object value) {
        ew.eq("value", value);
        return this;
    }

    public CodeDictionaryCondition orValueEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("value", value);
        return this;
    }

    public CodeDictionaryCondition andValueNe(Object value) {
        ew.ne("value", value);
        return this;
    }

    public CodeDictionaryCondition orValueNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("value", value);
        return this;
    }

    public CodeDictionaryCondition andValueGt(Object value) {
        ew.gt("value", value);
        return this;
    }

    public CodeDictionaryCondition orValueGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("value", value);
        return this;
    }

    public CodeDictionaryCondition andValueGe(Object value) {
        ew.ge("value", value);
        return this;
    }

    public CodeDictionaryCondition orValueGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("value", value);
        return this;
    }

    public CodeDictionaryCondition andValueLt(Object value) {
        ew.lt("value", value);
        return this;
    }

    public CodeDictionaryCondition orValueLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("value", value);
        return this;
    }

    public CodeDictionaryCondition andValueLe(Object value) {
        ew.le("value", value);
        return this;
    }

    public CodeDictionaryCondition orValueLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("value", value);
        return this;
    }

    public CodeDictionaryCondition andValueIn(Object... value) {
        ew.in("value", value);
        return this;
    }

    public CodeDictionaryCondition orValueIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("value", value);
        return this;
    }

    public CodeDictionaryCondition andValueNotIn(Object... value) {
        ew.notIn("value", value);
        return this;
    }

    public CodeDictionaryCondition orValueNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("value", value);
        return this;
    }

    public CodeDictionaryCondition andValueBetween(Object value, Object value1) {
        ew.between("value", value, value1);
        return this;
    }

    public CodeDictionaryCondition orValueBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("value", value, value1);
        return this;
    }

    public CodeDictionaryCondition andValueNotBetween(Object value, Object value1) {
        ew.notBetween("value", value, value1);
        return this;
    }

    public CodeDictionaryCondition orValueNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("value", value, value1);
        return this;
    }

    public CodeDictionaryCondition andValueLike(String value) {
        ew.like("value", value);
        return this;
    }

    public CodeDictionaryCondition orValueLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("value", value);
        return this;
    }

    public CodeDictionaryCondition andValueNotLike(String value) {
        ew.notLike("value", value);
        return this;
    }

    public CodeDictionaryCondition orValueNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("value", value);
        return this;
    }

    public CodeDictionaryCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public CodeDictionaryCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public CodeDictionaryCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public CodeDictionaryCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public CodeDictionaryCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public CodeDictionaryCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public CodeDictionaryCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public CodeDictionaryCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public CodeDictionaryCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public CodeDictionaryCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public CodeDictionaryCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public CodeDictionaryCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public CodeDictionaryCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public CodeDictionaryCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public CodeDictionaryCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public CodeDictionaryCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public CodeDictionaryCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public CodeDictionaryCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public CodeDictionaryCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public CodeDictionaryCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public CodeDictionaryCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public CodeDictionaryCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public CodeDictionaryCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public CodeDictionaryCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public CodeDictionaryCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public CodeDictionaryCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public CodeDictionaryCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public CodeDictionaryCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public CodeDictionaryCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public CodeDictionaryCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public CodeDictionaryCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public CodeDictionaryCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public CodeDictionaryCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public CodeDictionaryCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public CodeDictionaryCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public CodeDictionaryCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public CodeDictionaryCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public CodeDictionaryCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public CodeDictionaryCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public CodeDictionaryCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public CodeDictionaryCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public CodeDictionaryCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public CodeDictionaryCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public CodeDictionaryCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public CodeDictionaryCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public CodeDictionaryCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public CodeDictionaryCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public CodeDictionaryCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public CodeDictionaryCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public CodeDictionaryCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public CodeDictionaryCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public CodeDictionaryCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public CodeDictionaryCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public CodeDictionaryCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public CodeDictionaryCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public CodeDictionaryCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public CodeDictionaryCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public CodeDictionaryCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public CodeDictionaryCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public CodeDictionaryCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public CodeDictionaryCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public CodeDictionaryCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public CodeDictionaryCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public CodeDictionaryCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public CodeDictionaryCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public CodeDictionaryCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public CodeDictionaryCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public CodeDictionaryCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public CodeDictionaryCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public CodeDictionaryCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public CodeDictionaryCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public CodeDictionaryCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public CodeDictionaryCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public CodeDictionaryCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public CodeDictionaryCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public CodeDictionaryCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public CodeDictionaryCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public CodeDictionaryCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public CodeDictionaryCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public CodeDictionaryCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public CodeDictionaryCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public CodeDictionaryCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public CodeDictionaryCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public CodeDictionaryCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public CodeDictionaryCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public CodeDictionaryCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public CodeDictionaryCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public CodeDictionaryCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public CodeDictionaryCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public CodeDictionaryCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public CodeDictionaryCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public CodeDictionaryCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public CodeDictionaryCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public CodeDictionaryCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public CodeDictionaryCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public CodeDictionaryCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public CodeDictionaryCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public CodeDictionaryCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public CodeDictionaryCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public CodeDictionaryCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public CodeDictionaryCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public CodeDictionaryCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public CodeDictionaryCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public CodeDictionaryCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public CodeDictionaryCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public CodeDictionaryCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public CodeDictionaryCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public CodeDictionaryCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public CodeDictionaryCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public CodeDictionaryCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public CodeDictionaryCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public CodeDictionaryCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public CodeDictionaryCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public CodeDictionaryCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public CodeDictionaryCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public CodeDictionaryCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public CodeDictionaryCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public CodeDictionaryCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public CodeDictionaryCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public CodeDictionaryCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public CodeDictionaryCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public CodeDictionaryCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public CodeDictionaryCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public CodeDictionaryCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public CodeDictionaryCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public CodeDictionaryCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public CodeDictionaryCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public CodeDictionaryCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public CodeDictionaryCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public CodeDictionaryCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public CodeDictionaryCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public CodeDictionaryCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public CodeDictionaryCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public CodeDictionaryCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public CodeDictionaryCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public CodeDictionaryCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public CodeDictionaryCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public CodeDictionaryCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public CodeDictionaryCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public CodeDictionaryCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }
}