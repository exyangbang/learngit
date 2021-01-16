package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class AccountElectronicReceiptCondition {
    private PlusEntityWrapper<AccountElectronicReceipt> ew;

    public AccountElectronicReceiptCondition() {
        this.ew = new PlusEntityWrapper(AccountElectronicReceipt.class);
    }

    public static AccountElectronicReceiptCondition builder() {
        return new AccountElectronicReceiptCondition();
    }

    public PlusEntityWrapper<AccountElectronicReceipt> build() {
        return this.ew;
    }

    public AccountElectronicReceiptCondition or() {
        this.ew.orNew();
        return this;
    }

    public AccountElectronicReceiptCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(AccountElectronicReceipt.class);
    }

    public AccountElectronicReceiptCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public AccountElectronicReceiptCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public AccountElectronicReceiptCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public AccountElectronicReceiptCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> AccountElectronicReceiptCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> AccountElectronicReceiptCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> AccountElectronicReceiptCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public AccountElectronicReceiptCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public AccountElectronicReceiptCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public AccountElectronicReceiptCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public AccountElectronicReceiptCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public AccountElectronicReceiptCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public AccountElectronicReceiptCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public AccountElectronicReceiptCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public AccountElectronicReceiptCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public AccountElectronicReceiptCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public AccountElectronicReceiptCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public AccountElectronicReceiptCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public AccountElectronicReceiptCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public AccountElectronicReceiptCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public AccountElectronicReceiptCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public AccountElectronicReceiptCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public AccountElectronicReceiptCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public AccountElectronicReceiptCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public AccountElectronicReceiptCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public AccountElectronicReceiptCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public AccountElectronicReceiptCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public AccountElectronicReceiptCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public AccountElectronicReceiptCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public AccountElectronicReceiptCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public AccountElectronicReceiptCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public AccountElectronicReceiptCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public AccountElectronicReceiptCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public AccountElectronicReceiptCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public AccountElectronicReceiptCondition andReceiptNoIsNull() {
        ew.isNull("receipt_no");
        return this;
    }

    public AccountElectronicReceiptCondition orReceiptNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("receipt_no");
        return this;
    }

    public AccountElectronicReceiptCondition andReceiptNoIsNotNull() {
        ew.isNotNull("receipt_no");
        return this;
    }

    public AccountElectronicReceiptCondition orReceiptNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("receipt_no");
        return this;
    }

    public AccountElectronicReceiptCondition andReceiptNoEq(Object value) {
        ew.eq("receipt_no", value);
        return this;
    }

    public AccountElectronicReceiptCondition orReceiptNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("receipt_no", value);
        return this;
    }

    public AccountElectronicReceiptCondition andReceiptNoNe(Object value) {
        ew.ne("receipt_no", value);
        return this;
    }

    public AccountElectronicReceiptCondition orReceiptNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("receipt_no", value);
        return this;
    }

    public AccountElectronicReceiptCondition andReceiptNoGt(Object value) {
        ew.gt("receipt_no", value);
        return this;
    }

    public AccountElectronicReceiptCondition orReceiptNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("receipt_no", value);
        return this;
    }

    public AccountElectronicReceiptCondition andReceiptNoGe(Object value) {
        ew.ge("receipt_no", value);
        return this;
    }

    public AccountElectronicReceiptCondition orReceiptNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("receipt_no", value);
        return this;
    }

    public AccountElectronicReceiptCondition andReceiptNoLt(Object value) {
        ew.lt("receipt_no", value);
        return this;
    }

    public AccountElectronicReceiptCondition orReceiptNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("receipt_no", value);
        return this;
    }

    public AccountElectronicReceiptCondition andReceiptNoLe(Object value) {
        ew.le("receipt_no", value);
        return this;
    }

    public AccountElectronicReceiptCondition orReceiptNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("receipt_no", value);
        return this;
    }

    public AccountElectronicReceiptCondition andReceiptNoIn(Object... value) {
        ew.in("receipt_no", value);
        return this;
    }

    public AccountElectronicReceiptCondition orReceiptNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("receipt_no", value);
        return this;
    }

    public AccountElectronicReceiptCondition andReceiptNoNotIn(Object... value) {
        ew.notIn("receipt_no", value);
        return this;
    }

    public AccountElectronicReceiptCondition orReceiptNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("receipt_no", value);
        return this;
    }

    public AccountElectronicReceiptCondition andReceiptNoBetween(Object value, Object value1) {
        ew.between("receipt_no", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition orReceiptNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("receipt_no", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition andReceiptNoNotBetween(Object value, Object value1) {
        ew.notBetween("receipt_no", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition orReceiptNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("receipt_no", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition andReceiptNoLike(String value) {
        ew.like("receipt_no", value);
        return this;
    }

    public AccountElectronicReceiptCondition orReceiptNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("receipt_no", value);
        return this;
    }

    public AccountElectronicReceiptCondition andReceiptNoNotLike(String value) {
        ew.notLike("receipt_no", value);
        return this;
    }

    public AccountElectronicReceiptCondition orReceiptNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("receipt_no", value);
        return this;
    }

    public AccountElectronicReceiptCondition andMd5HexIsNull() {
        ew.isNull("md5_hex");
        return this;
    }

    public AccountElectronicReceiptCondition orMd5HexIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("md5_hex");
        return this;
    }

    public AccountElectronicReceiptCondition andMd5HexIsNotNull() {
        ew.isNotNull("md5_hex");
        return this;
    }

    public AccountElectronicReceiptCondition orMd5HexIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("md5_hex");
        return this;
    }

    public AccountElectronicReceiptCondition andMd5HexEq(Object value) {
        ew.eq("md5_hex", value);
        return this;
    }

    public AccountElectronicReceiptCondition orMd5HexEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("md5_hex", value);
        return this;
    }

    public AccountElectronicReceiptCondition andMd5HexNe(Object value) {
        ew.ne("md5_hex", value);
        return this;
    }

    public AccountElectronicReceiptCondition orMd5HexNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("md5_hex", value);
        return this;
    }

    public AccountElectronicReceiptCondition andMd5HexGt(Object value) {
        ew.gt("md5_hex", value);
        return this;
    }

    public AccountElectronicReceiptCondition orMd5HexGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("md5_hex", value);
        return this;
    }

    public AccountElectronicReceiptCondition andMd5HexGe(Object value) {
        ew.ge("md5_hex", value);
        return this;
    }

    public AccountElectronicReceiptCondition orMd5HexGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("md5_hex", value);
        return this;
    }

    public AccountElectronicReceiptCondition andMd5HexLt(Object value) {
        ew.lt("md5_hex", value);
        return this;
    }

    public AccountElectronicReceiptCondition orMd5HexLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("md5_hex", value);
        return this;
    }

    public AccountElectronicReceiptCondition andMd5HexLe(Object value) {
        ew.le("md5_hex", value);
        return this;
    }

    public AccountElectronicReceiptCondition orMd5HexLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("md5_hex", value);
        return this;
    }

    public AccountElectronicReceiptCondition andMd5HexIn(Object... value) {
        ew.in("md5_hex", value);
        return this;
    }

    public AccountElectronicReceiptCondition orMd5HexIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("md5_hex", value);
        return this;
    }

    public AccountElectronicReceiptCondition andMd5HexNotIn(Object... value) {
        ew.notIn("md5_hex", value);
        return this;
    }

    public AccountElectronicReceiptCondition orMd5HexNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("md5_hex", value);
        return this;
    }

    public AccountElectronicReceiptCondition andMd5HexBetween(Object value, Object value1) {
        ew.between("md5_hex", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition orMd5HexBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("md5_hex", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition andMd5HexNotBetween(Object value, Object value1) {
        ew.notBetween("md5_hex", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition orMd5HexNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("md5_hex", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition andMd5HexLike(String value) {
        ew.like("md5_hex", value);
        return this;
    }

    public AccountElectronicReceiptCondition orMd5HexLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("md5_hex", value);
        return this;
    }

    public AccountElectronicReceiptCondition andMd5HexNotLike(String value) {
        ew.notLike("md5_hex", value);
        return this;
    }

    public AccountElectronicReceiptCondition orMd5HexNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("md5_hex", value);
        return this;
    }

    public AccountElectronicReceiptCondition andFilePathIsNull() {
        ew.isNull("file_path");
        return this;
    }

    public AccountElectronicReceiptCondition orFilePathIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("file_path");
        return this;
    }

    public AccountElectronicReceiptCondition andFilePathIsNotNull() {
        ew.isNotNull("file_path");
        return this;
    }

    public AccountElectronicReceiptCondition orFilePathIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("file_path");
        return this;
    }

    public AccountElectronicReceiptCondition andFilePathEq(Object value) {
        ew.eq("file_path", value);
        return this;
    }

    public AccountElectronicReceiptCondition orFilePathEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("file_path", value);
        return this;
    }

    public AccountElectronicReceiptCondition andFilePathNe(Object value) {
        ew.ne("file_path", value);
        return this;
    }

    public AccountElectronicReceiptCondition orFilePathNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("file_path", value);
        return this;
    }

    public AccountElectronicReceiptCondition andFilePathGt(Object value) {
        ew.gt("file_path", value);
        return this;
    }

    public AccountElectronicReceiptCondition orFilePathGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("file_path", value);
        return this;
    }

    public AccountElectronicReceiptCondition andFilePathGe(Object value) {
        ew.ge("file_path", value);
        return this;
    }

    public AccountElectronicReceiptCondition orFilePathGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("file_path", value);
        return this;
    }

    public AccountElectronicReceiptCondition andFilePathLt(Object value) {
        ew.lt("file_path", value);
        return this;
    }

    public AccountElectronicReceiptCondition orFilePathLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("file_path", value);
        return this;
    }

    public AccountElectronicReceiptCondition andFilePathLe(Object value) {
        ew.le("file_path", value);
        return this;
    }

    public AccountElectronicReceiptCondition orFilePathLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("file_path", value);
        return this;
    }

    public AccountElectronicReceiptCondition andFilePathIn(Object... value) {
        ew.in("file_path", value);
        return this;
    }

    public AccountElectronicReceiptCondition orFilePathIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("file_path", value);
        return this;
    }

    public AccountElectronicReceiptCondition andFilePathNotIn(Object... value) {
        ew.notIn("file_path", value);
        return this;
    }

    public AccountElectronicReceiptCondition orFilePathNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("file_path", value);
        return this;
    }

    public AccountElectronicReceiptCondition andFilePathBetween(Object value, Object value1) {
        ew.between("file_path", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition orFilePathBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("file_path", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition andFilePathNotBetween(Object value, Object value1) {
        ew.notBetween("file_path", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition orFilePathNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("file_path", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition andFilePathLike(String value) {
        ew.like("file_path", value);
        return this;
    }

    public AccountElectronicReceiptCondition orFilePathLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("file_path", value);
        return this;
    }

    public AccountElectronicReceiptCondition andFilePathNotLike(String value) {
        ew.notLike("file_path", value);
        return this;
    }

    public AccountElectronicReceiptCondition orFilePathNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("file_path", value);
        return this;
    }

    public AccountElectronicReceiptCondition andAccountIsNull() {
        ew.isNull("account");
        return this;
    }

    public AccountElectronicReceiptCondition orAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("account");
        return this;
    }

    public AccountElectronicReceiptCondition andAccountIsNotNull() {
        ew.isNotNull("account");
        return this;
    }

    public AccountElectronicReceiptCondition orAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("account");
        return this;
    }

    public AccountElectronicReceiptCondition andAccountEq(Object value) {
        ew.eq("account", value);
        return this;
    }

    public AccountElectronicReceiptCondition orAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("account", value);
        return this;
    }

    public AccountElectronicReceiptCondition andAccountNe(Object value) {
        ew.ne("account", value);
        return this;
    }

    public AccountElectronicReceiptCondition orAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("account", value);
        return this;
    }

    public AccountElectronicReceiptCondition andAccountGt(Object value) {
        ew.gt("account", value);
        return this;
    }

    public AccountElectronicReceiptCondition orAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("account", value);
        return this;
    }

    public AccountElectronicReceiptCondition andAccountGe(Object value) {
        ew.ge("account", value);
        return this;
    }

    public AccountElectronicReceiptCondition orAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("account", value);
        return this;
    }

    public AccountElectronicReceiptCondition andAccountLt(Object value) {
        ew.lt("account", value);
        return this;
    }

    public AccountElectronicReceiptCondition orAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("account", value);
        return this;
    }

    public AccountElectronicReceiptCondition andAccountLe(Object value) {
        ew.le("account", value);
        return this;
    }

    public AccountElectronicReceiptCondition orAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("account", value);
        return this;
    }

    public AccountElectronicReceiptCondition andAccountIn(Object... value) {
        ew.in("account", value);
        return this;
    }

    public AccountElectronicReceiptCondition orAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("account", value);
        return this;
    }

    public AccountElectronicReceiptCondition andAccountNotIn(Object... value) {
        ew.notIn("account", value);
        return this;
    }

    public AccountElectronicReceiptCondition orAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("account", value);
        return this;
    }

    public AccountElectronicReceiptCondition andAccountBetween(Object value, Object value1) {
        ew.between("account", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition orAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("account", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition andAccountNotBetween(Object value, Object value1) {
        ew.notBetween("account", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition orAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("account", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition andAccountLike(String value) {
        ew.like("account", value);
        return this;
    }

    public AccountElectronicReceiptCondition orAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("account", value);
        return this;
    }

    public AccountElectronicReceiptCondition andAccountNotLike(String value) {
        ew.notLike("account", value);
        return this;
    }

    public AccountElectronicReceiptCondition orAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("account", value);
        return this;
    }

    public AccountElectronicReceiptCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public AccountElectronicReceiptCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public AccountElectronicReceiptCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public AccountElectronicReceiptCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public AccountElectronicReceiptCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public AccountElectronicReceiptCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public AccountElectronicReceiptCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public AccountElectronicReceiptCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public AccountElectronicReceiptCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public AccountElectronicReceiptCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public AccountElectronicReceiptCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public AccountElectronicReceiptCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public AccountElectronicReceiptCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public AccountElectronicReceiptCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public AccountElectronicReceiptCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public AccountElectronicReceiptCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public AccountElectronicReceiptCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public AccountElectronicReceiptCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }

    public AccountElectronicReceiptCondition andFileContentIsNull() {
        ew.isNull("file_content");
        return this;
    }

    public AccountElectronicReceiptCondition orFileContentIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("file_content");
        return this;
    }

    public AccountElectronicReceiptCondition andFileContentIsNotNull() {
        ew.isNotNull("file_content");
        return this;
    }

    public AccountElectronicReceiptCondition orFileContentIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("file_content");
        return this;
    }

    public AccountElectronicReceiptCondition andFileContentEq(Object value) {
        ew.eq("file_content", value);
        return this;
    }

    public AccountElectronicReceiptCondition orFileContentEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("file_content", value);
        return this;
    }

    public AccountElectronicReceiptCondition andFileContentNe(Object value) {
        ew.ne("file_content", value);
        return this;
    }

    public AccountElectronicReceiptCondition orFileContentNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("file_content", value);
        return this;
    }

    public AccountElectronicReceiptCondition andFileContentGt(Object value) {
        ew.gt("file_content", value);
        return this;
    }

    public AccountElectronicReceiptCondition orFileContentGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("file_content", value);
        return this;
    }

    public AccountElectronicReceiptCondition andFileContentGe(Object value) {
        ew.ge("file_content", value);
        return this;
    }

    public AccountElectronicReceiptCondition orFileContentGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("file_content", value);
        return this;
    }

    public AccountElectronicReceiptCondition andFileContentLt(Object value) {
        ew.lt("file_content", value);
        return this;
    }

    public AccountElectronicReceiptCondition orFileContentLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("file_content", value);
        return this;
    }

    public AccountElectronicReceiptCondition andFileContentLe(Object value) {
        ew.le("file_content", value);
        return this;
    }

    public AccountElectronicReceiptCondition orFileContentLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("file_content", value);
        return this;
    }

    public AccountElectronicReceiptCondition andFileContentIn(Object... value) {
        ew.in("file_content", value);
        return this;
    }

    public AccountElectronicReceiptCondition orFileContentIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("file_content", value);
        return this;
    }

    public AccountElectronicReceiptCondition andFileContentNotIn(Object... value) {
        ew.notIn("file_content", value);
        return this;
    }

    public AccountElectronicReceiptCondition orFileContentNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("file_content", value);
        return this;
    }

    public AccountElectronicReceiptCondition andFileContentBetween(Object value, Object value1) {
        ew.between("file_content", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition orFileContentBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("file_content", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition andFileContentNotBetween(Object value, Object value1) {
        ew.notBetween("file_content", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition orFileContentNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("file_content", value, value1);
        return this;
    }

    public AccountElectronicReceiptCondition andFileContentLike(String value) {
        ew.like("file_content", value);
        return this;
    }

    public AccountElectronicReceiptCondition orFileContentLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("file_content", value);
        return this;
    }

    public AccountElectronicReceiptCondition andFileContentNotLike(String value) {
        ew.notLike("file_content", value);
        return this;
    }

    public AccountElectronicReceiptCondition orFileContentNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("file_content", value);
        return this;
    }
}