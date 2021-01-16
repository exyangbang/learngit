package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class ElectronicReceiptCondition {
    private PlusEntityWrapper<ElectronicReceipt> ew;

    public ElectronicReceiptCondition() {
        this.ew = new PlusEntityWrapper(ElectronicReceipt.class);
    }

    public static ElectronicReceiptCondition builder() {
        return new ElectronicReceiptCondition();
    }

    public PlusEntityWrapper<ElectronicReceipt> build() {
        return this.ew;
    }

    public ElectronicReceiptCondition or() {
        this.ew.orNew();
        return this;
    }

    public ElectronicReceiptCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(ElectronicReceipt.class);
    }

    public ElectronicReceiptCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public ElectronicReceiptCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public ElectronicReceiptCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public ElectronicReceiptCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> ElectronicReceiptCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> ElectronicReceiptCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> ElectronicReceiptCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public ElectronicReceiptCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public ElectronicReceiptCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public ElectronicReceiptCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public ElectronicReceiptCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public ElectronicReceiptCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public ElectronicReceiptCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public ElectronicReceiptCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public ElectronicReceiptCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public ElectronicReceiptCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public ElectronicReceiptCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public ElectronicReceiptCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public ElectronicReceiptCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public ElectronicReceiptCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public ElectronicReceiptCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public ElectronicReceiptCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public ElectronicReceiptCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public ElectronicReceiptCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public ElectronicReceiptCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public ElectronicReceiptCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public ElectronicReceiptCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public ElectronicReceiptCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public ElectronicReceiptCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public ElectronicReceiptCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public ElectronicReceiptCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public ElectronicReceiptCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public ElectronicReceiptCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public ElectronicReceiptCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public ElectronicReceiptCondition andOrderNoIsNull() {
        ew.isNull("order_no");
        return this;
    }

    public ElectronicReceiptCondition orOrderNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("order_no");
        return this;
    }

    public ElectronicReceiptCondition andOrderNoIsNotNull() {
        ew.isNotNull("order_no");
        return this;
    }

    public ElectronicReceiptCondition orOrderNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("order_no");
        return this;
    }

    public ElectronicReceiptCondition andOrderNoEq(Object value) {
        ew.eq("order_no", value);
        return this;
    }

    public ElectronicReceiptCondition orOrderNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("order_no", value);
        return this;
    }

    public ElectronicReceiptCondition andOrderNoNe(Object value) {
        ew.ne("order_no", value);
        return this;
    }

    public ElectronicReceiptCondition orOrderNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("order_no", value);
        return this;
    }

    public ElectronicReceiptCondition andOrderNoGt(Object value) {
        ew.gt("order_no", value);
        return this;
    }

    public ElectronicReceiptCondition orOrderNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("order_no", value);
        return this;
    }

    public ElectronicReceiptCondition andOrderNoGe(Object value) {
        ew.ge("order_no", value);
        return this;
    }

    public ElectronicReceiptCondition orOrderNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("order_no", value);
        return this;
    }

    public ElectronicReceiptCondition andOrderNoLt(Object value) {
        ew.lt("order_no", value);
        return this;
    }

    public ElectronicReceiptCondition orOrderNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("order_no", value);
        return this;
    }

    public ElectronicReceiptCondition andOrderNoLe(Object value) {
        ew.le("order_no", value);
        return this;
    }

    public ElectronicReceiptCondition orOrderNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("order_no", value);
        return this;
    }

    public ElectronicReceiptCondition andOrderNoIn(Object... value) {
        ew.in("order_no", value);
        return this;
    }

    public ElectronicReceiptCondition orOrderNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("order_no", value);
        return this;
    }

    public ElectronicReceiptCondition andOrderNoNotIn(Object... value) {
        ew.notIn("order_no", value);
        return this;
    }

    public ElectronicReceiptCondition orOrderNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("order_no", value);
        return this;
    }

    public ElectronicReceiptCondition andOrderNoBetween(Object value, Object value1) {
        ew.between("order_no", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orOrderNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("order_no", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andOrderNoNotBetween(Object value, Object value1) {
        ew.notBetween("order_no", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orOrderNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("order_no", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andOrderNoLike(String value) {
        ew.like("order_no", value);
        return this;
    }

    public ElectronicReceiptCondition orOrderNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("order_no", value);
        return this;
    }

    public ElectronicReceiptCondition andOrderNoNotLike(String value) {
        ew.notLike("order_no", value);
        return this;
    }

    public ElectronicReceiptCondition orOrderNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("order_no", value);
        return this;
    }

    public ElectronicReceiptCondition andMd5HexIsNull() {
        ew.isNull("md5_hex");
        return this;
    }

    public ElectronicReceiptCondition orMd5HexIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("md5_hex");
        return this;
    }

    public ElectronicReceiptCondition andMd5HexIsNotNull() {
        ew.isNotNull("md5_hex");
        return this;
    }

    public ElectronicReceiptCondition orMd5HexIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("md5_hex");
        return this;
    }

    public ElectronicReceiptCondition andMd5HexEq(Object value) {
        ew.eq("md5_hex", value);
        return this;
    }

    public ElectronicReceiptCondition orMd5HexEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("md5_hex", value);
        return this;
    }

    public ElectronicReceiptCondition andMd5HexNe(Object value) {
        ew.ne("md5_hex", value);
        return this;
    }

    public ElectronicReceiptCondition orMd5HexNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("md5_hex", value);
        return this;
    }

    public ElectronicReceiptCondition andMd5HexGt(Object value) {
        ew.gt("md5_hex", value);
        return this;
    }

    public ElectronicReceiptCondition orMd5HexGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("md5_hex", value);
        return this;
    }

    public ElectronicReceiptCondition andMd5HexGe(Object value) {
        ew.ge("md5_hex", value);
        return this;
    }

    public ElectronicReceiptCondition orMd5HexGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("md5_hex", value);
        return this;
    }

    public ElectronicReceiptCondition andMd5HexLt(Object value) {
        ew.lt("md5_hex", value);
        return this;
    }

    public ElectronicReceiptCondition orMd5HexLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("md5_hex", value);
        return this;
    }

    public ElectronicReceiptCondition andMd5HexLe(Object value) {
        ew.le("md5_hex", value);
        return this;
    }

    public ElectronicReceiptCondition orMd5HexLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("md5_hex", value);
        return this;
    }

    public ElectronicReceiptCondition andMd5HexIn(Object... value) {
        ew.in("md5_hex", value);
        return this;
    }

    public ElectronicReceiptCondition orMd5HexIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("md5_hex", value);
        return this;
    }

    public ElectronicReceiptCondition andMd5HexNotIn(Object... value) {
        ew.notIn("md5_hex", value);
        return this;
    }

    public ElectronicReceiptCondition orMd5HexNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("md5_hex", value);
        return this;
    }

    public ElectronicReceiptCondition andMd5HexBetween(Object value, Object value1) {
        ew.between("md5_hex", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orMd5HexBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("md5_hex", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andMd5HexNotBetween(Object value, Object value1) {
        ew.notBetween("md5_hex", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orMd5HexNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("md5_hex", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andMd5HexLike(String value) {
        ew.like("md5_hex", value);
        return this;
    }

    public ElectronicReceiptCondition orMd5HexLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("md5_hex", value);
        return this;
    }

    public ElectronicReceiptCondition andMd5HexNotLike(String value) {
        ew.notLike("md5_hex", value);
        return this;
    }

    public ElectronicReceiptCondition orMd5HexNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("md5_hex", value);
        return this;
    }

    public ElectronicReceiptCondition andParamsIsNull() {
        ew.isNull("params");
        return this;
    }

    public ElectronicReceiptCondition orParamsIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("params");
        return this;
    }

    public ElectronicReceiptCondition andParamsIsNotNull() {
        ew.isNotNull("params");
        return this;
    }

    public ElectronicReceiptCondition orParamsIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("params");
        return this;
    }

    public ElectronicReceiptCondition andParamsEq(Object value) {
        ew.eq("params", value);
        return this;
    }

    public ElectronicReceiptCondition orParamsEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("params", value);
        return this;
    }

    public ElectronicReceiptCondition andParamsNe(Object value) {
        ew.ne("params", value);
        return this;
    }

    public ElectronicReceiptCondition orParamsNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("params", value);
        return this;
    }

    public ElectronicReceiptCondition andParamsGt(Object value) {
        ew.gt("params", value);
        return this;
    }

    public ElectronicReceiptCondition orParamsGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("params", value);
        return this;
    }

    public ElectronicReceiptCondition andParamsGe(Object value) {
        ew.ge("params", value);
        return this;
    }

    public ElectronicReceiptCondition orParamsGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("params", value);
        return this;
    }

    public ElectronicReceiptCondition andParamsLt(Object value) {
        ew.lt("params", value);
        return this;
    }

    public ElectronicReceiptCondition orParamsLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("params", value);
        return this;
    }

    public ElectronicReceiptCondition andParamsLe(Object value) {
        ew.le("params", value);
        return this;
    }

    public ElectronicReceiptCondition orParamsLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("params", value);
        return this;
    }

    public ElectronicReceiptCondition andParamsIn(Object... value) {
        ew.in("params", value);
        return this;
    }

    public ElectronicReceiptCondition orParamsIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("params", value);
        return this;
    }

    public ElectronicReceiptCondition andParamsNotIn(Object... value) {
        ew.notIn("params", value);
        return this;
    }

    public ElectronicReceiptCondition orParamsNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("params", value);
        return this;
    }

    public ElectronicReceiptCondition andParamsBetween(Object value, Object value1) {
        ew.between("params", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orParamsBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("params", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andParamsNotBetween(Object value, Object value1) {
        ew.notBetween("params", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orParamsNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("params", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andParamsLike(String value) {
        ew.like("params", value);
        return this;
    }

    public ElectronicReceiptCondition orParamsLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("params", value);
        return this;
    }

    public ElectronicReceiptCondition andParamsNotLike(String value) {
        ew.notLike("params", value);
        return this;
    }

    public ElectronicReceiptCondition orParamsNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("params", value);
        return this;
    }

    public ElectronicReceiptCondition andFilePathIsNull() {
        ew.isNull("file_path");
        return this;
    }

    public ElectronicReceiptCondition orFilePathIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("file_path");
        return this;
    }

    public ElectronicReceiptCondition andFilePathIsNotNull() {
        ew.isNotNull("file_path");
        return this;
    }

    public ElectronicReceiptCondition orFilePathIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("file_path");
        return this;
    }

    public ElectronicReceiptCondition andFilePathEq(Object value) {
        ew.eq("file_path", value);
        return this;
    }

    public ElectronicReceiptCondition orFilePathEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("file_path", value);
        return this;
    }

    public ElectronicReceiptCondition andFilePathNe(Object value) {
        ew.ne("file_path", value);
        return this;
    }

    public ElectronicReceiptCondition orFilePathNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("file_path", value);
        return this;
    }

    public ElectronicReceiptCondition andFilePathGt(Object value) {
        ew.gt("file_path", value);
        return this;
    }

    public ElectronicReceiptCondition orFilePathGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("file_path", value);
        return this;
    }

    public ElectronicReceiptCondition andFilePathGe(Object value) {
        ew.ge("file_path", value);
        return this;
    }

    public ElectronicReceiptCondition orFilePathGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("file_path", value);
        return this;
    }

    public ElectronicReceiptCondition andFilePathLt(Object value) {
        ew.lt("file_path", value);
        return this;
    }

    public ElectronicReceiptCondition orFilePathLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("file_path", value);
        return this;
    }

    public ElectronicReceiptCondition andFilePathLe(Object value) {
        ew.le("file_path", value);
        return this;
    }

    public ElectronicReceiptCondition orFilePathLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("file_path", value);
        return this;
    }

    public ElectronicReceiptCondition andFilePathIn(Object... value) {
        ew.in("file_path", value);
        return this;
    }

    public ElectronicReceiptCondition orFilePathIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("file_path", value);
        return this;
    }

    public ElectronicReceiptCondition andFilePathNotIn(Object... value) {
        ew.notIn("file_path", value);
        return this;
    }

    public ElectronicReceiptCondition orFilePathNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("file_path", value);
        return this;
    }

    public ElectronicReceiptCondition andFilePathBetween(Object value, Object value1) {
        ew.between("file_path", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orFilePathBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("file_path", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andFilePathNotBetween(Object value, Object value1) {
        ew.notBetween("file_path", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orFilePathNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("file_path", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andFilePathLike(String value) {
        ew.like("file_path", value);
        return this;
    }

    public ElectronicReceiptCondition orFilePathLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("file_path", value);
        return this;
    }

    public ElectronicReceiptCondition andFilePathNotLike(String value) {
        ew.notLike("file_path", value);
        return this;
    }

    public ElectronicReceiptCondition orFilePathNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("file_path", value);
        return this;
    }

    public ElectronicReceiptCondition andServerTransIdIsNull() {
        ew.isNull("server_trans_id");
        return this;
    }

    public ElectronicReceiptCondition orServerTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_trans_id");
        return this;
    }

    public ElectronicReceiptCondition andServerTransIdIsNotNull() {
        ew.isNotNull("server_trans_id");
        return this;
    }

    public ElectronicReceiptCondition orServerTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_trans_id");
        return this;
    }

    public ElectronicReceiptCondition andServerTransIdEq(Object value) {
        ew.eq("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition orServerTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition andServerTransIdNe(Object value) {
        ew.ne("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition orServerTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition andServerTransIdGt(Object value) {
        ew.gt("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition orServerTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition andServerTransIdGe(Object value) {
        ew.ge("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition orServerTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition andServerTransIdLt(Object value) {
        ew.lt("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition orServerTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition andServerTransIdLe(Object value) {
        ew.le("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition orServerTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition andServerTransIdIn(Object... value) {
        ew.in("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition orServerTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition andServerTransIdNotIn(Object... value) {
        ew.notIn("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition orServerTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition andServerTransIdBetween(Object value, Object value1) {
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orServerTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andServerTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orServerTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andServerTransIdLike(String value) {
        ew.like("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition orServerTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition andServerTransIdNotLike(String value) {
        ew.notLike("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition orServerTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition andTradeTypeIsNull() {
        ew.isNull("trade_type");
        return this;
    }

    public ElectronicReceiptCondition orTradeTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trade_type");
        return this;
    }

    public ElectronicReceiptCondition andTradeTypeIsNotNull() {
        ew.isNotNull("trade_type");
        return this;
    }

    public ElectronicReceiptCondition orTradeTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trade_type");
        return this;
    }

    public ElectronicReceiptCondition andTradeTypeEq(Object value) {
        ew.eq("trade_type", value);
        return this;
    }

    public ElectronicReceiptCondition orTradeTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trade_type", value);
        return this;
    }

    public ElectronicReceiptCondition andTradeTypeNe(Object value) {
        ew.ne("trade_type", value);
        return this;
    }

    public ElectronicReceiptCondition orTradeTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trade_type", value);
        return this;
    }

    public ElectronicReceiptCondition andTradeTypeGt(Object value) {
        ew.gt("trade_type", value);
        return this;
    }

    public ElectronicReceiptCondition orTradeTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trade_type", value);
        return this;
    }

    public ElectronicReceiptCondition andTradeTypeGe(Object value) {
        ew.ge("trade_type", value);
        return this;
    }

    public ElectronicReceiptCondition orTradeTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trade_type", value);
        return this;
    }

    public ElectronicReceiptCondition andTradeTypeLt(Object value) {
        ew.lt("trade_type", value);
        return this;
    }

    public ElectronicReceiptCondition orTradeTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trade_type", value);
        return this;
    }

    public ElectronicReceiptCondition andTradeTypeLe(Object value) {
        ew.le("trade_type", value);
        return this;
    }

    public ElectronicReceiptCondition orTradeTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trade_type", value);
        return this;
    }

    public ElectronicReceiptCondition andTradeTypeIn(Object... value) {
        ew.in("trade_type", value);
        return this;
    }

    public ElectronicReceiptCondition orTradeTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trade_type", value);
        return this;
    }

    public ElectronicReceiptCondition andTradeTypeNotIn(Object... value) {
        ew.notIn("trade_type", value);
        return this;
    }

    public ElectronicReceiptCondition orTradeTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trade_type", value);
        return this;
    }

    public ElectronicReceiptCondition andTradeTypeBetween(Object value, Object value1) {
        ew.between("trade_type", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orTradeTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trade_type", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andTradeTypeNotBetween(Object value, Object value1) {
        ew.notBetween("trade_type", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orTradeTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trade_type", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andTradeTypeLike(String value) {
        ew.like("trade_type", value);
        return this;
    }

    public ElectronicReceiptCondition orTradeTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trade_type", value);
        return this;
    }

    public ElectronicReceiptCondition andTradeTypeNotLike(String value) {
        ew.notLike("trade_type", value);
        return this;
    }

    public ElectronicReceiptCondition orTradeTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trade_type", value);
        return this;
    }

    public ElectronicReceiptCondition andClientTransIdIsNull() {
        ew.isNull("client_trans_id");
        return this;
    }

    public ElectronicReceiptCondition orClientTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("client_trans_id");
        return this;
    }

    public ElectronicReceiptCondition andClientTransIdIsNotNull() {
        ew.isNotNull("client_trans_id");
        return this;
    }

    public ElectronicReceiptCondition orClientTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("client_trans_id");
        return this;
    }

    public ElectronicReceiptCondition andClientTransIdEq(Object value) {
        ew.eq("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition orClientTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition andClientTransIdNe(Object value) {
        ew.ne("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition orClientTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition andClientTransIdGt(Object value) {
        ew.gt("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition orClientTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition andClientTransIdGe(Object value) {
        ew.ge("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition orClientTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition andClientTransIdLt(Object value) {
        ew.lt("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition orClientTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition andClientTransIdLe(Object value) {
        ew.le("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition orClientTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition andClientTransIdIn(Object... value) {
        ew.in("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition orClientTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition andClientTransIdNotIn(Object... value) {
        ew.notIn("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition orClientTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition andClientTransIdBetween(Object value, Object value1) {
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orClientTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andClientTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orClientTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andClientTransIdLike(String value) {
        ew.like("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition orClientTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition andClientTransIdNotLike(String value) {
        ew.notLike("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition orClientTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public ElectronicReceiptCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public ElectronicReceiptCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public ElectronicReceiptCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public ElectronicReceiptCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public ElectronicReceiptCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public ElectronicReceiptCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public ElectronicReceiptCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public ElectronicReceiptCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public ElectronicReceiptCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public ElectronicReceiptCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public ElectronicReceiptCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public ElectronicReceiptCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public ElectronicReceiptCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public ElectronicReceiptCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public ElectronicReceiptCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public ElectronicReceiptCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public ElectronicReceiptCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public ElectronicReceiptCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public ElectronicReceiptCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public ElectronicReceiptCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public ElectronicReceiptCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public ElectronicReceiptCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public ElectronicReceiptCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public ElectronicReceiptCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public ElectronicReceiptCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public ElectronicReceiptCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public ElectronicReceiptCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public ElectronicReceiptCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public ElectronicReceiptCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public ElectronicReceiptCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public ElectronicReceiptCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public ElectronicReceiptCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public ElectronicReceiptCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public ElectronicReceiptCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public ElectronicReceiptCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public ElectronicReceiptCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public ElectronicReceiptCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public ElectronicReceiptCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public ElectronicReceiptCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public ElectronicReceiptCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public ElectronicReceiptCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public ElectronicReceiptCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public ElectronicReceiptCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public ElectronicReceiptCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public ElectronicReceiptCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public ElectronicReceiptCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public ElectronicReceiptCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public ElectronicReceiptCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public ElectronicReceiptCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public ElectronicReceiptCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public ElectronicReceiptCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public ElectronicReceiptCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public ElectronicReceiptCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public ElectronicReceiptCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public ElectronicReceiptCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public ElectronicReceiptCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public ElectronicReceiptCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public ElectronicReceiptCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public ElectronicReceiptCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public ElectronicReceiptCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public ElectronicReceiptCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public ElectronicReceiptCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public ElectronicReceiptCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public ElectronicReceiptCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public ElectronicReceiptCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public ElectronicReceiptCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public ElectronicReceiptCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public ElectronicReceiptCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public ElectronicReceiptCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public ElectronicReceiptCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public ElectronicReceiptCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public ElectronicReceiptCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public ElectronicReceiptCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public ElectronicReceiptCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public ElectronicReceiptCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public ElectronicReceiptCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public ElectronicReceiptCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public ElectronicReceiptCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public ElectronicReceiptCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public ElectronicReceiptCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public ElectronicReceiptCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public ElectronicReceiptCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public ElectronicReceiptCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public ElectronicReceiptCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public ElectronicReceiptCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public ElectronicReceiptCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public ElectronicReceiptCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public ElectronicReceiptCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public ElectronicReceiptCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public ElectronicReceiptCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public ElectronicReceiptCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public ElectronicReceiptCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public ElectronicReceiptCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public ElectronicReceiptCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public ElectronicReceiptCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public ElectronicReceiptCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public ElectronicReceiptCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public ElectronicReceiptCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public ElectronicReceiptCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public ElectronicReceiptCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptCondition andFileContentIsNull() {
        ew.isNull("file_content");
        return this;
    }

    public ElectronicReceiptCondition orFileContentIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("file_content");
        return this;
    }

    public ElectronicReceiptCondition andFileContentIsNotNull() {
        ew.isNotNull("file_content");
        return this;
    }

    public ElectronicReceiptCondition orFileContentIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("file_content");
        return this;
    }

    public ElectronicReceiptCondition andFileContentEq(Object value) {
        ew.eq("file_content", value);
        return this;
    }

    public ElectronicReceiptCondition orFileContentEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("file_content", value);
        return this;
    }

    public ElectronicReceiptCondition andFileContentNe(Object value) {
        ew.ne("file_content", value);
        return this;
    }

    public ElectronicReceiptCondition orFileContentNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("file_content", value);
        return this;
    }

    public ElectronicReceiptCondition andFileContentGt(Object value) {
        ew.gt("file_content", value);
        return this;
    }

    public ElectronicReceiptCondition orFileContentGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("file_content", value);
        return this;
    }

    public ElectronicReceiptCondition andFileContentGe(Object value) {
        ew.ge("file_content", value);
        return this;
    }

    public ElectronicReceiptCondition orFileContentGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("file_content", value);
        return this;
    }

    public ElectronicReceiptCondition andFileContentLt(Object value) {
        ew.lt("file_content", value);
        return this;
    }

    public ElectronicReceiptCondition orFileContentLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("file_content", value);
        return this;
    }

    public ElectronicReceiptCondition andFileContentLe(Object value) {
        ew.le("file_content", value);
        return this;
    }

    public ElectronicReceiptCondition orFileContentLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("file_content", value);
        return this;
    }

    public ElectronicReceiptCondition andFileContentIn(Object... value) {
        ew.in("file_content", value);
        return this;
    }

    public ElectronicReceiptCondition orFileContentIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("file_content", value);
        return this;
    }

    public ElectronicReceiptCondition andFileContentNotIn(Object... value) {
        ew.notIn("file_content", value);
        return this;
    }

    public ElectronicReceiptCondition orFileContentNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("file_content", value);
        return this;
    }

    public ElectronicReceiptCondition andFileContentBetween(Object value, Object value1) {
        ew.between("file_content", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orFileContentBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("file_content", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andFileContentNotBetween(Object value, Object value1) {
        ew.notBetween("file_content", value, value1);
        return this;
    }

    public ElectronicReceiptCondition orFileContentNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("file_content", value, value1);
        return this;
    }

    public ElectronicReceiptCondition andFileContentLike(String value) {
        ew.like("file_content", value);
        return this;
    }

    public ElectronicReceiptCondition orFileContentLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("file_content", value);
        return this;
    }

    public ElectronicReceiptCondition andFileContentNotLike(String value) {
        ew.notLike("file_content", value);
        return this;
    }

    public ElectronicReceiptCondition orFileContentNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("file_content", value);
        return this;
    }
}