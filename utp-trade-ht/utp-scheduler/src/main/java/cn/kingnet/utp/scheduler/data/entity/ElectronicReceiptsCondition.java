package cn.kingnet.utp.scheduler.data.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class ElectronicReceiptsCondition {
    private PlusEntityWrapper<ElectronicReceipts> ew;

    public ElectronicReceiptsCondition() {
        this.ew = new PlusEntityWrapper(ElectronicReceipts.class);
    }

    public static ElectronicReceiptsCondition builder() {
        return new ElectronicReceiptsCondition();
    }

    public PlusEntityWrapper<ElectronicReceipts> build() {
        return this.ew;
    }

    public ElectronicReceiptsCondition or() {
        this.ew.orNew();
        return this;
    }

    public ElectronicReceiptsCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(ElectronicReceipts.class);
    }

    public ElectronicReceiptsCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public ElectronicReceiptsCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public ElectronicReceiptsCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public ElectronicReceiptsCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> ElectronicReceiptsCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> ElectronicReceiptsCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> ElectronicReceiptsCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public ElectronicReceiptsCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public ElectronicReceiptsCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public ElectronicReceiptsCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public ElectronicReceiptsCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public ElectronicReceiptsCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public ElectronicReceiptsCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public ElectronicReceiptsCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public ElectronicReceiptsCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public ElectronicReceiptsCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public ElectronicReceiptsCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public ElectronicReceiptsCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public ElectronicReceiptsCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public ElectronicReceiptsCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public ElectronicReceiptsCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public ElectronicReceiptsCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public ElectronicReceiptsCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public ElectronicReceiptsCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public ElectronicReceiptsCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public ElectronicReceiptsCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public ElectronicReceiptsCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public ElectronicReceiptsCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public ElectronicReceiptsCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public ElectronicReceiptsCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public ElectronicReceiptsCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public ElectronicReceiptsCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public ElectronicReceiptsCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public ElectronicReceiptsCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public ElectronicReceiptsCondition andOrderNoIsNull() {
        ew.isNull("order_no");
        return this;
    }

    public ElectronicReceiptsCondition orOrderNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("order_no");
        return this;
    }

    public ElectronicReceiptsCondition andOrderNoIsNotNull() {
        ew.isNotNull("order_no");
        return this;
    }

    public ElectronicReceiptsCondition orOrderNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("order_no");
        return this;
    }

    public ElectronicReceiptsCondition andOrderNoEq(Object value) {
        ew.eq("order_no", value);
        return this;
    }

    public ElectronicReceiptsCondition orOrderNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("order_no", value);
        return this;
    }

    public ElectronicReceiptsCondition andOrderNoNe(Object value) {
        ew.ne("order_no", value);
        return this;
    }

    public ElectronicReceiptsCondition orOrderNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("order_no", value);
        return this;
    }

    public ElectronicReceiptsCondition andOrderNoGt(Object value) {
        ew.gt("order_no", value);
        return this;
    }

    public ElectronicReceiptsCondition orOrderNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("order_no", value);
        return this;
    }

    public ElectronicReceiptsCondition andOrderNoGe(Object value) {
        ew.ge("order_no", value);
        return this;
    }

    public ElectronicReceiptsCondition orOrderNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("order_no", value);
        return this;
    }

    public ElectronicReceiptsCondition andOrderNoLt(Object value) {
        ew.lt("order_no", value);
        return this;
    }

    public ElectronicReceiptsCondition orOrderNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("order_no", value);
        return this;
    }

    public ElectronicReceiptsCondition andOrderNoLe(Object value) {
        ew.le("order_no", value);
        return this;
    }

    public ElectronicReceiptsCondition orOrderNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("order_no", value);
        return this;
    }

    public ElectronicReceiptsCondition andOrderNoIn(Object... value) {
        ew.in("order_no", value);
        return this;
    }

    public ElectronicReceiptsCondition orOrderNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("order_no", value);
        return this;
    }

    public ElectronicReceiptsCondition andOrderNoNotIn(Object... value) {
        ew.notIn("order_no", value);
        return this;
    }

    public ElectronicReceiptsCondition orOrderNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("order_no", value);
        return this;
    }

    public ElectronicReceiptsCondition andOrderNoBetween(Object value, Object value1) {
        ew.between("order_no", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orOrderNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("order_no", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andOrderNoNotBetween(Object value, Object value1) {
        ew.notBetween("order_no", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orOrderNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("order_no", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andOrderNoLike(String value) {
        ew.like("order_no", value);
        return this;
    }

    public ElectronicReceiptsCondition orOrderNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("order_no", value);
        return this;
    }

    public ElectronicReceiptsCondition andOrderNoNotLike(String value) {
        ew.notLike("order_no", value);
        return this;
    }

    public ElectronicReceiptsCondition orOrderNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("order_no", value);
        return this;
    }

    public ElectronicReceiptsCondition andMd5HexIsNull() {
        ew.isNull("md5_hex");
        return this;
    }

    public ElectronicReceiptsCondition orMd5HexIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("md5_hex");
        return this;
    }

    public ElectronicReceiptsCondition andMd5HexIsNotNull() {
        ew.isNotNull("md5_hex");
        return this;
    }

    public ElectronicReceiptsCondition orMd5HexIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("md5_hex");
        return this;
    }

    public ElectronicReceiptsCondition andMd5HexEq(Object value) {
        ew.eq("md5_hex", value);
        return this;
    }

    public ElectronicReceiptsCondition orMd5HexEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("md5_hex", value);
        return this;
    }

    public ElectronicReceiptsCondition andMd5HexNe(Object value) {
        ew.ne("md5_hex", value);
        return this;
    }

    public ElectronicReceiptsCondition orMd5HexNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("md5_hex", value);
        return this;
    }

    public ElectronicReceiptsCondition andMd5HexGt(Object value) {
        ew.gt("md5_hex", value);
        return this;
    }

    public ElectronicReceiptsCondition orMd5HexGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("md5_hex", value);
        return this;
    }

    public ElectronicReceiptsCondition andMd5HexGe(Object value) {
        ew.ge("md5_hex", value);
        return this;
    }

    public ElectronicReceiptsCondition orMd5HexGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("md5_hex", value);
        return this;
    }

    public ElectronicReceiptsCondition andMd5HexLt(Object value) {
        ew.lt("md5_hex", value);
        return this;
    }

    public ElectronicReceiptsCondition orMd5HexLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("md5_hex", value);
        return this;
    }

    public ElectronicReceiptsCondition andMd5HexLe(Object value) {
        ew.le("md5_hex", value);
        return this;
    }

    public ElectronicReceiptsCondition orMd5HexLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("md5_hex", value);
        return this;
    }

    public ElectronicReceiptsCondition andMd5HexIn(Object... value) {
        ew.in("md5_hex", value);
        return this;
    }

    public ElectronicReceiptsCondition orMd5HexIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("md5_hex", value);
        return this;
    }

    public ElectronicReceiptsCondition andMd5HexNotIn(Object... value) {
        ew.notIn("md5_hex", value);
        return this;
    }

    public ElectronicReceiptsCondition orMd5HexNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("md5_hex", value);
        return this;
    }

    public ElectronicReceiptsCondition andMd5HexBetween(Object value, Object value1) {
        ew.between("md5_hex", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orMd5HexBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("md5_hex", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andMd5HexNotBetween(Object value, Object value1) {
        ew.notBetween("md5_hex", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orMd5HexNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("md5_hex", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andMd5HexLike(String value) {
        ew.like("md5_hex", value);
        return this;
    }

    public ElectronicReceiptsCondition orMd5HexLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("md5_hex", value);
        return this;
    }

    public ElectronicReceiptsCondition andMd5HexNotLike(String value) {
        ew.notLike("md5_hex", value);
        return this;
    }

    public ElectronicReceiptsCondition orMd5HexNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("md5_hex", value);
        return this;
    }

    public ElectronicReceiptsCondition andParamsIsNull() {
        ew.isNull("params");
        return this;
    }

    public ElectronicReceiptsCondition orParamsIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("params");
        return this;
    }

    public ElectronicReceiptsCondition andParamsIsNotNull() {
        ew.isNotNull("params");
        return this;
    }

    public ElectronicReceiptsCondition orParamsIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("params");
        return this;
    }

    public ElectronicReceiptsCondition andParamsEq(Object value) {
        ew.eq("params", value);
        return this;
    }

    public ElectronicReceiptsCondition orParamsEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("params", value);
        return this;
    }

    public ElectronicReceiptsCondition andParamsNe(Object value) {
        ew.ne("params", value);
        return this;
    }

    public ElectronicReceiptsCondition orParamsNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("params", value);
        return this;
    }

    public ElectronicReceiptsCondition andParamsGt(Object value) {
        ew.gt("params", value);
        return this;
    }

    public ElectronicReceiptsCondition orParamsGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("params", value);
        return this;
    }

    public ElectronicReceiptsCondition andParamsGe(Object value) {
        ew.ge("params", value);
        return this;
    }

    public ElectronicReceiptsCondition orParamsGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("params", value);
        return this;
    }

    public ElectronicReceiptsCondition andParamsLt(Object value) {
        ew.lt("params", value);
        return this;
    }

    public ElectronicReceiptsCondition orParamsLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("params", value);
        return this;
    }

    public ElectronicReceiptsCondition andParamsLe(Object value) {
        ew.le("params", value);
        return this;
    }

    public ElectronicReceiptsCondition orParamsLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("params", value);
        return this;
    }

    public ElectronicReceiptsCondition andParamsIn(Object... value) {
        ew.in("params", value);
        return this;
    }

    public ElectronicReceiptsCondition orParamsIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("params", value);
        return this;
    }

    public ElectronicReceiptsCondition andParamsNotIn(Object... value) {
        ew.notIn("params", value);
        return this;
    }

    public ElectronicReceiptsCondition orParamsNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("params", value);
        return this;
    }

    public ElectronicReceiptsCondition andParamsBetween(Object value, Object value1) {
        ew.between("params", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orParamsBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("params", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andParamsNotBetween(Object value, Object value1) {
        ew.notBetween("params", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orParamsNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("params", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andParamsLike(String value) {
        ew.like("params", value);
        return this;
    }

    public ElectronicReceiptsCondition orParamsLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("params", value);
        return this;
    }

    public ElectronicReceiptsCondition andParamsNotLike(String value) {
        ew.notLike("params", value);
        return this;
    }

    public ElectronicReceiptsCondition orParamsNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("params", value);
        return this;
    }

    public ElectronicReceiptsCondition andFilePathIsNull() {
        ew.isNull("file_path");
        return this;
    }

    public ElectronicReceiptsCondition orFilePathIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("file_path");
        return this;
    }

    public ElectronicReceiptsCondition andFilePathIsNotNull() {
        ew.isNotNull("file_path");
        return this;
    }

    public ElectronicReceiptsCondition orFilePathIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("file_path");
        return this;
    }

    public ElectronicReceiptsCondition andFilePathEq(Object value) {
        ew.eq("file_path", value);
        return this;
    }

    public ElectronicReceiptsCondition orFilePathEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("file_path", value);
        return this;
    }

    public ElectronicReceiptsCondition andFilePathNe(Object value) {
        ew.ne("file_path", value);
        return this;
    }

    public ElectronicReceiptsCondition orFilePathNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("file_path", value);
        return this;
    }

    public ElectronicReceiptsCondition andFilePathGt(Object value) {
        ew.gt("file_path", value);
        return this;
    }

    public ElectronicReceiptsCondition orFilePathGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("file_path", value);
        return this;
    }

    public ElectronicReceiptsCondition andFilePathGe(Object value) {
        ew.ge("file_path", value);
        return this;
    }

    public ElectronicReceiptsCondition orFilePathGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("file_path", value);
        return this;
    }

    public ElectronicReceiptsCondition andFilePathLt(Object value) {
        ew.lt("file_path", value);
        return this;
    }

    public ElectronicReceiptsCondition orFilePathLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("file_path", value);
        return this;
    }

    public ElectronicReceiptsCondition andFilePathLe(Object value) {
        ew.le("file_path", value);
        return this;
    }

    public ElectronicReceiptsCondition orFilePathLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("file_path", value);
        return this;
    }

    public ElectronicReceiptsCondition andFilePathIn(Object... value) {
        ew.in("file_path", value);
        return this;
    }

    public ElectronicReceiptsCondition orFilePathIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("file_path", value);
        return this;
    }

    public ElectronicReceiptsCondition andFilePathNotIn(Object... value) {
        ew.notIn("file_path", value);
        return this;
    }

    public ElectronicReceiptsCondition orFilePathNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("file_path", value);
        return this;
    }

    public ElectronicReceiptsCondition andFilePathBetween(Object value, Object value1) {
        ew.between("file_path", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orFilePathBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("file_path", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andFilePathNotBetween(Object value, Object value1) {
        ew.notBetween("file_path", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orFilePathNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("file_path", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andFilePathLike(String value) {
        ew.like("file_path", value);
        return this;
    }

    public ElectronicReceiptsCondition orFilePathLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("file_path", value);
        return this;
    }

    public ElectronicReceiptsCondition andFilePathNotLike(String value) {
        ew.notLike("file_path", value);
        return this;
    }

    public ElectronicReceiptsCondition orFilePathNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("file_path", value);
        return this;
    }

    public ElectronicReceiptsCondition andServerTransIdIsNull() {
        ew.isNull("server_trans_id");
        return this;
    }

    public ElectronicReceiptsCondition orServerTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_trans_id");
        return this;
    }

    public ElectronicReceiptsCondition andServerTransIdIsNotNull() {
        ew.isNotNull("server_trans_id");
        return this;
    }

    public ElectronicReceiptsCondition orServerTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_trans_id");
        return this;
    }

    public ElectronicReceiptsCondition andServerTransIdEq(Object value) {
        ew.eq("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition orServerTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition andServerTransIdNe(Object value) {
        ew.ne("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition orServerTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition andServerTransIdGt(Object value) {
        ew.gt("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition orServerTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition andServerTransIdGe(Object value) {
        ew.ge("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition orServerTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition andServerTransIdLt(Object value) {
        ew.lt("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition orServerTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition andServerTransIdLe(Object value) {
        ew.le("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition orServerTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition andServerTransIdIn(Object... value) {
        ew.in("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition orServerTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition andServerTransIdNotIn(Object... value) {
        ew.notIn("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition orServerTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition andServerTransIdBetween(Object value, Object value1) {
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orServerTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andServerTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orServerTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andServerTransIdLike(String value) {
        ew.like("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition orServerTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition andServerTransIdNotLike(String value) {
        ew.notLike("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition orServerTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition andTradeTypeIsNull() {
        ew.isNull("trade_type");
        return this;
    }

    public ElectronicReceiptsCondition orTradeTypeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trade_type");
        return this;
    }

    public ElectronicReceiptsCondition andTradeTypeIsNotNull() {
        ew.isNotNull("trade_type");
        return this;
    }

    public ElectronicReceiptsCondition orTradeTypeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trade_type");
        return this;
    }

    public ElectronicReceiptsCondition andTradeTypeEq(Object value) {
        ew.eq("trade_type", value);
        return this;
    }

    public ElectronicReceiptsCondition orTradeTypeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trade_type", value);
        return this;
    }

    public ElectronicReceiptsCondition andTradeTypeNe(Object value) {
        ew.ne("trade_type", value);
        return this;
    }

    public ElectronicReceiptsCondition orTradeTypeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trade_type", value);
        return this;
    }

    public ElectronicReceiptsCondition andTradeTypeGt(Object value) {
        ew.gt("trade_type", value);
        return this;
    }

    public ElectronicReceiptsCondition orTradeTypeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trade_type", value);
        return this;
    }

    public ElectronicReceiptsCondition andTradeTypeGe(Object value) {
        ew.ge("trade_type", value);
        return this;
    }

    public ElectronicReceiptsCondition orTradeTypeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trade_type", value);
        return this;
    }

    public ElectronicReceiptsCondition andTradeTypeLt(Object value) {
        ew.lt("trade_type", value);
        return this;
    }

    public ElectronicReceiptsCondition orTradeTypeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trade_type", value);
        return this;
    }

    public ElectronicReceiptsCondition andTradeTypeLe(Object value) {
        ew.le("trade_type", value);
        return this;
    }

    public ElectronicReceiptsCondition orTradeTypeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trade_type", value);
        return this;
    }

    public ElectronicReceiptsCondition andTradeTypeIn(Object... value) {
        ew.in("trade_type", value);
        return this;
    }

    public ElectronicReceiptsCondition orTradeTypeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trade_type", value);
        return this;
    }

    public ElectronicReceiptsCondition andTradeTypeNotIn(Object... value) {
        ew.notIn("trade_type", value);
        return this;
    }

    public ElectronicReceiptsCondition orTradeTypeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trade_type", value);
        return this;
    }

    public ElectronicReceiptsCondition andTradeTypeBetween(Object value, Object value1) {
        ew.between("trade_type", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orTradeTypeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trade_type", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andTradeTypeNotBetween(Object value, Object value1) {
        ew.notBetween("trade_type", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orTradeTypeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trade_type", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andTradeTypeLike(String value) {
        ew.like("trade_type", value);
        return this;
    }

    public ElectronicReceiptsCondition orTradeTypeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trade_type", value);
        return this;
    }

    public ElectronicReceiptsCondition andTradeTypeNotLike(String value) {
        ew.notLike("trade_type", value);
        return this;
    }

    public ElectronicReceiptsCondition orTradeTypeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trade_type", value);
        return this;
    }

    public ElectronicReceiptsCondition andClientTransIdIsNull() {
        ew.isNull("client_trans_id");
        return this;
    }

    public ElectronicReceiptsCondition orClientTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("client_trans_id");
        return this;
    }

    public ElectronicReceiptsCondition andClientTransIdIsNotNull() {
        ew.isNotNull("client_trans_id");
        return this;
    }

    public ElectronicReceiptsCondition orClientTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("client_trans_id");
        return this;
    }

    public ElectronicReceiptsCondition andClientTransIdEq(Object value) {
        ew.eq("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition orClientTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition andClientTransIdNe(Object value) {
        ew.ne("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition orClientTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition andClientTransIdGt(Object value) {
        ew.gt("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition orClientTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition andClientTransIdGe(Object value) {
        ew.ge("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition orClientTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition andClientTransIdLt(Object value) {
        ew.lt("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition orClientTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition andClientTransIdLe(Object value) {
        ew.le("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition orClientTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition andClientTransIdIn(Object... value) {
        ew.in("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition orClientTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition andClientTransIdNotIn(Object... value) {
        ew.notIn("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition orClientTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition andClientTransIdBetween(Object value, Object value1) {
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orClientTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andClientTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orClientTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andClientTransIdLike(String value) {
        ew.like("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition orClientTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition andClientTransIdNotLike(String value) {
        ew.notLike("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition orClientTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("client_trans_id", value);
        return this;
    }

    public ElectronicReceiptsCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public ElectronicReceiptsCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public ElectronicReceiptsCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public ElectronicReceiptsCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public ElectronicReceiptsCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public ElectronicReceiptsCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public ElectronicReceiptsCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public ElectronicReceiptsCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public ElectronicReceiptsCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public ElectronicReceiptsCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public ElectronicReceiptsCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public ElectronicReceiptsCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public ElectronicReceiptsCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public ElectronicReceiptsCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public ElectronicReceiptsCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public ElectronicReceiptsCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public ElectronicReceiptsCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public ElectronicReceiptsCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public ElectronicReceiptsCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public ElectronicReceiptsCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public ElectronicReceiptsCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public ElectronicReceiptsCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public ElectronicReceiptsCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public ElectronicReceiptsCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public ElectronicReceiptsCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public ElectronicReceiptsCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public ElectronicReceiptsCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public ElectronicReceiptsCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public ElectronicReceiptsCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public ElectronicReceiptsCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public ElectronicReceiptsCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public ElectronicReceiptsCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public ElectronicReceiptsCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public ElectronicReceiptsCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public ElectronicReceiptsCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public ElectronicReceiptsCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public ElectronicReceiptsCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public ElectronicReceiptsCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public ElectronicReceiptsCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public ElectronicReceiptsCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public ElectronicReceiptsCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public ElectronicReceiptsCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public ElectronicReceiptsCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public ElectronicReceiptsCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public ElectronicReceiptsCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public ElectronicReceiptsCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public ElectronicReceiptsCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public ElectronicReceiptsCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public ElectronicReceiptsCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public ElectronicReceiptsCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public ElectronicReceiptsCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public ElectronicReceiptsCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public ElectronicReceiptsCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public ElectronicReceiptsCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public ElectronicReceiptsCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public ElectronicReceiptsCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public ElectronicReceiptsCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public ElectronicReceiptsCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public ElectronicReceiptsCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public ElectronicReceiptsCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public ElectronicReceiptsCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public ElectronicReceiptsCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public ElectronicReceiptsCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public ElectronicReceiptsCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public ElectronicReceiptsCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public ElectronicReceiptsCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public ElectronicReceiptsCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public ElectronicReceiptsCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public ElectronicReceiptsCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public ElectronicReceiptsCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public ElectronicReceiptsCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public ElectronicReceiptsCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public ElectronicReceiptsCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public ElectronicReceiptsCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public ElectronicReceiptsCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public ElectronicReceiptsCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public ElectronicReceiptsCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public ElectronicReceiptsCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public ElectronicReceiptsCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public ElectronicReceiptsCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public ElectronicReceiptsCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public ElectronicReceiptsCondition andFileContentIsNull() {
        ew.isNull("file_content");
        return this;
    }

    public ElectronicReceiptsCondition orFileContentIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("file_content");
        return this;
    }

    public ElectronicReceiptsCondition andFileContentIsNotNull() {
        ew.isNotNull("file_content");
        return this;
    }

    public ElectronicReceiptsCondition orFileContentIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("file_content");
        return this;
    }

    public ElectronicReceiptsCondition andFileContentEq(Object value) {
        ew.eq("file_content", value);
        return this;
    }

    public ElectronicReceiptsCondition orFileContentEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("file_content", value);
        return this;
    }

    public ElectronicReceiptsCondition andFileContentNe(Object value) {
        ew.ne("file_content", value);
        return this;
    }

    public ElectronicReceiptsCondition orFileContentNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("file_content", value);
        return this;
    }

    public ElectronicReceiptsCondition andFileContentGt(Object value) {
        ew.gt("file_content", value);
        return this;
    }

    public ElectronicReceiptsCondition orFileContentGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("file_content", value);
        return this;
    }

    public ElectronicReceiptsCondition andFileContentGe(Object value) {
        ew.ge("file_content", value);
        return this;
    }

    public ElectronicReceiptsCondition orFileContentGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("file_content", value);
        return this;
    }

    public ElectronicReceiptsCondition andFileContentLt(Object value) {
        ew.lt("file_content", value);
        return this;
    }

    public ElectronicReceiptsCondition orFileContentLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("file_content", value);
        return this;
    }

    public ElectronicReceiptsCondition andFileContentLe(Object value) {
        ew.le("file_content", value);
        return this;
    }

    public ElectronicReceiptsCondition orFileContentLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("file_content", value);
        return this;
    }

    public ElectronicReceiptsCondition andFileContentIn(Object... value) {
        ew.in("file_content", value);
        return this;
    }

    public ElectronicReceiptsCondition orFileContentIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("file_content", value);
        return this;
    }

    public ElectronicReceiptsCondition andFileContentNotIn(Object... value) {
        ew.notIn("file_content", value);
        return this;
    }

    public ElectronicReceiptsCondition orFileContentNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("file_content", value);
        return this;
    }

    public ElectronicReceiptsCondition andFileContentBetween(Object value, Object value1) {
        ew.between("file_content", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orFileContentBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("file_content", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andFileContentNotBetween(Object value, Object value1) {
        ew.notBetween("file_content", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition orFileContentNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("file_content", value, value1);
        return this;
    }

    public ElectronicReceiptsCondition andFileContentLike(String value) {
        ew.like("file_content", value);
        return this;
    }

    public ElectronicReceiptsCondition orFileContentLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("file_content", value);
        return this;
    }

    public ElectronicReceiptsCondition andFileContentNotLike(String value) {
        ew.notLike("file_content", value);
        return this;
    }

    public ElectronicReceiptsCondition orFileContentNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("file_content", value);
        return this;
    }
}