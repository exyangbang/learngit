package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class BlackListCondition {
    private PlusEntityWrapper<BlackList> ew;

    public BlackListCondition() {
        this.ew = new PlusEntityWrapper(BlackList.class);
    }

    public static BlackListCondition builder() {
        return new BlackListCondition();
    }

    public PlusEntityWrapper<BlackList> build() {
        return this.ew;
    }

    public BlackListCondition or() {
        this.ew.orNew();
        return this;
    }

    public BlackListCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(BlackList.class);
    }

    public BlackListCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public BlackListCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public BlackListCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public BlackListCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> BlackListCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> BlackListCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> BlackListCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public BlackListCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public BlackListCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public BlackListCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public BlackListCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public BlackListCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public BlackListCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public BlackListCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public BlackListCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public BlackListCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public BlackListCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public BlackListCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public BlackListCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public BlackListCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public BlackListCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public BlackListCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public BlackListCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public BlackListCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public BlackListCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public BlackListCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public BlackListCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public BlackListCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public BlackListCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public BlackListCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public BlackListCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public BlackListCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public BlackListCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public BlackListCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public BlackListCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public BlackListCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public BlackListCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public BlackListCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public BlackListCondition andNameIsNull() {
        ew.isNull("name");
        return this;
    }

    public BlackListCondition orNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("name");
        return this;
    }

    public BlackListCondition andNameIsNotNull() {
        ew.isNotNull("name");
        return this;
    }

    public BlackListCondition orNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("name");
        return this;
    }

    public BlackListCondition andNameEq(Object value) {
        ew.eq("name", value);
        return this;
    }

    public BlackListCondition orNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("name", value);
        return this;
    }

    public BlackListCondition andNameNe(Object value) {
        ew.ne("name", value);
        return this;
    }

    public BlackListCondition orNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("name", value);
        return this;
    }

    public BlackListCondition andNameGt(Object value) {
        ew.gt("name", value);
        return this;
    }

    public BlackListCondition orNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("name", value);
        return this;
    }

    public BlackListCondition andNameGe(Object value) {
        ew.ge("name", value);
        return this;
    }

    public BlackListCondition orNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("name", value);
        return this;
    }

    public BlackListCondition andNameLt(Object value) {
        ew.lt("name", value);
        return this;
    }

    public BlackListCondition orNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("name", value);
        return this;
    }

    public BlackListCondition andNameLe(Object value) {
        ew.le("name", value);
        return this;
    }

    public BlackListCondition orNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("name", value);
        return this;
    }

    public BlackListCondition andNameIn(Object... value) {
        ew.in("name", value);
        return this;
    }

    public BlackListCondition orNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("name", value);
        return this;
    }

    public BlackListCondition andNameNotIn(Object... value) {
        ew.notIn("name", value);
        return this;
    }

    public BlackListCondition orNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("name", value);
        return this;
    }

    public BlackListCondition andNameBetween(Object value, Object value1) {
        ew.between("name", value, value1);
        return this;
    }

    public BlackListCondition orNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("name", value, value1);
        return this;
    }

    public BlackListCondition andNameNotBetween(Object value, Object value1) {
        ew.notBetween("name", value, value1);
        return this;
    }

    public BlackListCondition orNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("name", value, value1);
        return this;
    }

    public BlackListCondition andNameLike(String value) {
        ew.like("name", value);
        return this;
    }

    public BlackListCondition orNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("name", value);
        return this;
    }

    public BlackListCondition andNameNotLike(String value) {
        ew.notLike("name", value);
        return this;
    }

    public BlackListCondition orNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("name", value);
        return this;
    }

    public BlackListCondition andIdCodeIsNull() {
        ew.isNull("id_code");
        return this;
    }

    public BlackListCondition orIdCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id_code");
        return this;
    }

    public BlackListCondition andIdCodeIsNotNull() {
        ew.isNotNull("id_code");
        return this;
    }

    public BlackListCondition orIdCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id_code");
        return this;
    }

    public BlackListCondition andIdCodeEq(Object value) {
        ew.eq("id_code", value);
        return this;
    }

    public BlackListCondition orIdCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id_code", value);
        return this;
    }

    public BlackListCondition andIdCodeNe(Object value) {
        ew.ne("id_code", value);
        return this;
    }

    public BlackListCondition orIdCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id_code", value);
        return this;
    }

    public BlackListCondition andIdCodeGt(Object value) {
        ew.gt("id_code", value);
        return this;
    }

    public BlackListCondition orIdCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id_code", value);
        return this;
    }

    public BlackListCondition andIdCodeGe(Object value) {
        ew.ge("id_code", value);
        return this;
    }

    public BlackListCondition orIdCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id_code", value);
        return this;
    }

    public BlackListCondition andIdCodeLt(Object value) {
        ew.lt("id_code", value);
        return this;
    }

    public BlackListCondition orIdCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id_code", value);
        return this;
    }

    public BlackListCondition andIdCodeLe(Object value) {
        ew.le("id_code", value);
        return this;
    }

    public BlackListCondition orIdCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id_code", value);
        return this;
    }

    public BlackListCondition andIdCodeIn(Object... value) {
        ew.in("id_code", value);
        return this;
    }

    public BlackListCondition orIdCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id_code", value);
        return this;
    }

    public BlackListCondition andIdCodeNotIn(Object... value) {
        ew.notIn("id_code", value);
        return this;
    }

    public BlackListCondition orIdCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id_code", value);
        return this;
    }

    public BlackListCondition andIdCodeBetween(Object value, Object value1) {
        ew.between("id_code", value, value1);
        return this;
    }

    public BlackListCondition orIdCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id_code", value, value1);
        return this;
    }

    public BlackListCondition andIdCodeNotBetween(Object value, Object value1) {
        ew.notBetween("id_code", value, value1);
        return this;
    }

    public BlackListCondition orIdCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id_code", value, value1);
        return this;
    }

    public BlackListCondition andIdCodeLike(String value) {
        ew.like("id_code", value);
        return this;
    }

    public BlackListCondition orIdCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id_code", value);
        return this;
    }

    public BlackListCondition andIdCodeNotLike(String value) {
        ew.notLike("id_code", value);
        return this;
    }

    public BlackListCondition orIdCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id_code", value);
        return this;
    }

    public BlackListCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public BlackListCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public BlackListCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public BlackListCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public BlackListCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public BlackListCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public BlackListCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public BlackListCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public BlackListCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public BlackListCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public BlackListCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public BlackListCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public BlackListCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public BlackListCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public BlackListCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public BlackListCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public BlackListCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public BlackListCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public BlackListCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public BlackListCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public BlackListCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public BlackListCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public BlackListCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public BlackListCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public BlackListCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public BlackListCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public BlackListCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public BlackListCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }

    public BlackListCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public BlackListCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public BlackListCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public BlackListCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public BlackListCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public BlackListCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public BlackListCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public BlackListCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public BlackListCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public BlackListCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public BlackListCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public BlackListCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public BlackListCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public BlackListCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public BlackListCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public BlackListCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public BlackListCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public BlackListCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public BlackListCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public BlackListCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public BlackListCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public BlackListCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public BlackListCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public BlackListCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public BlackListCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public BlackListCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public BlackListCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public BlackListCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public BlackListCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public BlackListCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public BlackListCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public BlackListCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public BlackListCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public BlackListCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public BlackListCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public BlackListCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public BlackListCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public BlackListCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public BlackListCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public BlackListCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public BlackListCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public BlackListCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public BlackListCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public BlackListCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public BlackListCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public BlackListCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public BlackListCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public BlackListCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public BlackListCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public BlackListCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public BlackListCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public BlackListCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public BlackListCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public BlackListCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public BlackListCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public BlackListCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public BlackListCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public BlackListCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public BlackListCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public BlackListCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public BlackListCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public BlackListCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public BlackListCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public BlackListCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public BlackListCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public BlackListCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public BlackListCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public BlackListCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public BlackListCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public BlackListCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public BlackListCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public BlackListCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public BlackListCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public BlackListCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public BlackListCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public BlackListCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public BlackListCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public BlackListCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public BlackListCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public BlackListCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public BlackListCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public BlackListCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public BlackListCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public BlackListCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public BlackListCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public BlackListCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public BlackListCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public BlackListCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public BlackListCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public BlackListCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public BlackListCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public BlackListCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public BlackListCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public BlackListCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public BlackListCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public BlackListCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public BlackListCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public BlackListCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public BlackListCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public BlackListCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public BlackListCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public BlackListCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public BlackListCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public BlackListCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public BlackListCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public BlackListCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public BlackListCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public BlackListCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public BlackListCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public BlackListCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public BlackListCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public BlackListCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public BlackListCondition andObjTypeIsNull() {
        ew.isNull("obj_type");
        return this;
    }

    public BlackListCondition orObjTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("obj_type");
        return this;
    }

    public BlackListCondition andObjTypeIsNotNull() {
        ew.isNotNull("obj_type");
        return this;
    }

    public BlackListCondition orObjTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("obj_type");
        return this;
    }

    public BlackListCondition andObjTypeEq(Object value) {
        ew.eq("obj_type", value);
        return this;
    }

    public BlackListCondition orObjTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("obj_type", value);
        return this;
    }

    public BlackListCondition andObjTypeNe(Object value) {
        ew.ne("obj_type", value);
        return this;
    }

    public BlackListCondition orObjTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("obj_type", value);
        return this;
    }

    public BlackListCondition andObjTypeGt(Object value) {
        ew.gt("obj_type", value);
        return this;
    }

    public BlackListCondition orObjTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("obj_type", value);
        return this;
    }

    public BlackListCondition andObjTypeGe(Object value) {
        ew.ge("obj_type", value);
        return this;
    }

    public BlackListCondition orObjTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("obj_type", value);
        return this;
    }

    public BlackListCondition andObjTypeLt(Object value) {
        ew.lt("obj_type", value);
        return this;
    }

    public BlackListCondition orObjTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("obj_type", value);
        return this;
    }

    public BlackListCondition andObjTypeLe(Object value) {
        ew.le("obj_type", value);
        return this;
    }

    public BlackListCondition orObjTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("obj_type", value);
        return this;
    }

    public BlackListCondition andObjTypeIn(Object... value) {
        ew.in("obj_type", value);
        return this;
    }

    public BlackListCondition orObjTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("obj_type", value);
        return this;
    }

    public BlackListCondition andObjTypeNotIn(Object... value) {
        ew.notIn("obj_type", value);
        return this;
    }

    public BlackListCondition orObjTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("obj_type", value);
        return this;
    }

    public BlackListCondition andObjTypeBetween(Object value, Object value1) {
        ew.between("obj_type", value, value1);
        return this;
    }

    public BlackListCondition orObjTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("obj_type", value, value1);
        return this;
    }

    public BlackListCondition andObjTypeNotBetween(Object value, Object value1) {
        ew.notBetween("obj_type", value, value1);
        return this;
    }

    public BlackListCondition orObjTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("obj_type", value, value1);
        return this;
    }

    public BlackListCondition andObjTypeLike(String value) {
        ew.like("obj_type", value);
        return this;
    }

    public BlackListCondition orObjTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("obj_type", value);
        return this;
    }

    public BlackListCondition andObjTypeNotLike(String value) {
        ew.notLike("obj_type", value);
        return this;
    }

    public BlackListCondition orObjTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("obj_type", value);
        return this;
    }

    public BlackListCondition andBusLicCodeIsNull() {
        ew.isNull("bus_lic_code");
        return this;
    }

    public BlackListCondition orBusLicCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("bus_lic_code");
        return this;
    }

    public BlackListCondition andBusLicCodeIsNotNull() {
        ew.isNotNull("bus_lic_code");
        return this;
    }

    public BlackListCondition orBusLicCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("bus_lic_code");
        return this;
    }

    public BlackListCondition andBusLicCodeEq(Object value) {
        ew.eq("bus_lic_code", value);
        return this;
    }

    public BlackListCondition orBusLicCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("bus_lic_code", value);
        return this;
    }

    public BlackListCondition andBusLicCodeNe(Object value) {
        ew.ne("bus_lic_code", value);
        return this;
    }

    public BlackListCondition orBusLicCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("bus_lic_code", value);
        return this;
    }

    public BlackListCondition andBusLicCodeGt(Object value) {
        ew.gt("bus_lic_code", value);
        return this;
    }

    public BlackListCondition orBusLicCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("bus_lic_code", value);
        return this;
    }

    public BlackListCondition andBusLicCodeGe(Object value) {
        ew.ge("bus_lic_code", value);
        return this;
    }

    public BlackListCondition orBusLicCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("bus_lic_code", value);
        return this;
    }

    public BlackListCondition andBusLicCodeLt(Object value) {
        ew.lt("bus_lic_code", value);
        return this;
    }

    public BlackListCondition orBusLicCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("bus_lic_code", value);
        return this;
    }

    public BlackListCondition andBusLicCodeLe(Object value) {
        ew.le("bus_lic_code", value);
        return this;
    }

    public BlackListCondition orBusLicCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("bus_lic_code", value);
        return this;
    }

    public BlackListCondition andBusLicCodeIn(Object... value) {
        ew.in("bus_lic_code", value);
        return this;
    }

    public BlackListCondition orBusLicCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("bus_lic_code", value);
        return this;
    }

    public BlackListCondition andBusLicCodeNotIn(Object... value) {
        ew.notIn("bus_lic_code", value);
        return this;
    }

    public BlackListCondition orBusLicCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("bus_lic_code", value);
        return this;
    }

    public BlackListCondition andBusLicCodeBetween(Object value, Object value1) {
        ew.between("bus_lic_code", value, value1);
        return this;
    }

    public BlackListCondition orBusLicCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("bus_lic_code", value, value1);
        return this;
    }

    public BlackListCondition andBusLicCodeNotBetween(Object value, Object value1) {
        ew.notBetween("bus_lic_code", value, value1);
        return this;
    }

    public BlackListCondition orBusLicCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("bus_lic_code", value, value1);
        return this;
    }

    public BlackListCondition andBusLicCodeLike(String value) {
        ew.like("bus_lic_code", value);
        return this;
    }

    public BlackListCondition orBusLicCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("bus_lic_code", value);
        return this;
    }

    public BlackListCondition andBusLicCodeNotLike(String value) {
        ew.notLike("bus_lic_code", value);
        return this;
    }

    public BlackListCondition orBusLicCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("bus_lic_code", value);
        return this;
    }

    public BlackListCondition andEntNameIsNull() {
        ew.isNull("ent_name");
        return this;
    }

    public BlackListCondition orEntNameIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("ent_name");
        return this;
    }

    public BlackListCondition andEntNameIsNotNull() {
        ew.isNotNull("ent_name");
        return this;
    }

    public BlackListCondition orEntNameIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("ent_name");
        return this;
    }

    public BlackListCondition andEntNameEq(Object value) {
        ew.eq("ent_name", value);
        return this;
    }

    public BlackListCondition orEntNameEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("ent_name", value);
        return this;
    }

    public BlackListCondition andEntNameNe(Object value) {
        ew.ne("ent_name", value);
        return this;
    }

    public BlackListCondition orEntNameNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("ent_name", value);
        return this;
    }

    public BlackListCondition andEntNameGt(Object value) {
        ew.gt("ent_name", value);
        return this;
    }

    public BlackListCondition orEntNameGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("ent_name", value);
        return this;
    }

    public BlackListCondition andEntNameGe(Object value) {
        ew.ge("ent_name", value);
        return this;
    }

    public BlackListCondition orEntNameGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("ent_name", value);
        return this;
    }

    public BlackListCondition andEntNameLt(Object value) {
        ew.lt("ent_name", value);
        return this;
    }

    public BlackListCondition orEntNameLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("ent_name", value);
        return this;
    }

    public BlackListCondition andEntNameLe(Object value) {
        ew.le("ent_name", value);
        return this;
    }

    public BlackListCondition orEntNameLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("ent_name", value);
        return this;
    }

    public BlackListCondition andEntNameIn(Object... value) {
        ew.in("ent_name", value);
        return this;
    }

    public BlackListCondition orEntNameIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("ent_name", value);
        return this;
    }

    public BlackListCondition andEntNameNotIn(Object... value) {
        ew.notIn("ent_name", value);
        return this;
    }

    public BlackListCondition orEntNameNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("ent_name", value);
        return this;
    }

    public BlackListCondition andEntNameBetween(Object value, Object value1) {
        ew.between("ent_name", value, value1);
        return this;
    }

    public BlackListCondition orEntNameBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("ent_name", value, value1);
        return this;
    }

    public BlackListCondition andEntNameNotBetween(Object value, Object value1) {
        ew.notBetween("ent_name", value, value1);
        return this;
    }

    public BlackListCondition orEntNameNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("ent_name", value, value1);
        return this;
    }

    public BlackListCondition andEntNameLike(String value) {
        ew.like("ent_name", value);
        return this;
    }

    public BlackListCondition orEntNameLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("ent_name", value);
        return this;
    }

    public BlackListCondition andEntNameNotLike(String value) {
        ew.notLike("ent_name", value);
        return this;
    }

    public BlackListCondition orEntNameNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("ent_name", value);
        return this;
    }
}