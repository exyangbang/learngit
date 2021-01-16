package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.mybatis.mapper.Fn;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;

public final class UploadSubAccountSettleSplitDetailCondition {
    private PlusEntityWrapper<UploadSubAccountSettleSplitDetail> ew;

    public UploadSubAccountSettleSplitDetailCondition() {
        this.ew = new PlusEntityWrapper(UploadSubAccountSettleSplitDetail.class);
    }

    public static UploadSubAccountSettleSplitDetailCondition builder() {
        return new UploadSubAccountSettleSplitDetailCondition();
    }

    public PlusEntityWrapper<UploadSubAccountSettleSplitDetail> build() {
        return this.ew;
    }

    public UploadSubAccountSettleSplitDetailCondition or() {
        this.ew.orNew();
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition and() {
        this.ew.andNew();
        return this;
    }

    private boolean isAndOr() {
        return ew.originalSql() == null || "".equals(ew.originalSql()) ? true : ew.originalSql().endsWith("AND ()") || ew.originalSql().endsWith("OR ()");
    }

    public void clear() {
        this.ew = null;
        this.ew = new PlusEntityWrapper(UploadSubAccountSettleSplitDetail.class);
    }

    public UploadSubAccountSettleSplitDetailCondition setSqlSelect(String sqlStr) {
        ew.setSqlSelect(sqlStr);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orderAsc(String column) {
        ew.orderBy(true, column, true);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orderDesc(String column) {
        ew.orderBy(true, column, false);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition groupBy(String column) {
        ew.groupBy(column);
        return this;
    }

    public <E, R> UploadSubAccountSettleSplitDetailCondition orderAsc(Fn<E, R> fn) {
        ew.orderAsc(fn);
        return this;
    }

    public <E, R> UploadSubAccountSettleSplitDetailCondition orderDesc(Fn<E, R> fn) {
        ew.orderDesc(fn);
        return this;
    }

    public <E, R> UploadSubAccountSettleSplitDetailCondition groupBy(Fn<E, R> fn) {
        ew.groupBy(fn);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition exists(String sqlStr) {
        ew.exists(sqlStr);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition notExists(String sqlStr) {
        ew.notExists(sqlStr);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition having(String sqlStr, Object... params) {
        ew.having(sqlStr, params);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIdIsNull() {
        ew.isNull("id");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("id");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIdIsNotNull() {
        ew.isNotNull("id");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("id");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIdEq(Object value) {
        ew.eq("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIdNe(Object value) {
        ew.ne("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIdGt(Object value) {
        ew.gt("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIdGe(Object value) {
        ew.ge("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIdLt(Object value) {
        ew.lt("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIdLe(Object value) {
        ew.le("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIdIn(Object... value) {
        ew.in("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIdNotIn(Object... value) {
        ew.notIn("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIdBetween(Object value, Object value1) {
        ew.between("id", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("id", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIdNotBetween(Object value, Object value1) {
        ew.notBetween("id", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("id", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIdLike(String value) {
        ew.like("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIdNotLike(String value) {
        ew.notLike("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserAccountIsNull() {
        ew.isNull("user_account");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_account");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserAccountIsNotNull() {
        ew.isNotNull("user_account");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_account");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserAccountEq(Object value) {
        ew.eq("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserAccountNe(Object value) {
        ew.ne("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserAccountGt(Object value) {
        ew.gt("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserAccountGe(Object value) {
        ew.ge("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserAccountLt(Object value) {
        ew.lt("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserAccountLe(Object value) {
        ew.le("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserAccountIn(Object... value) {
        ew.in("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserAccountNotIn(Object... value) {
        ew.notIn("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserAccountBetween(Object value, Object value1) {
        ew.between("user_account", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_account", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserAccountNotBetween(Object value, Object value1) {
        ew.notBetween("user_account", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_account", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserAccountLike(String value) {
        ew.like("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserAccountNotLike(String value) {
        ew.notLike("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andBatchNoIsNull() {
        ew.isNull("batch_no");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orBatchNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("batch_no");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andBatchNoIsNotNull() {
        ew.isNotNull("batch_no");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orBatchNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("batch_no");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andBatchNoEq(Object value) {
        ew.eq("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orBatchNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andBatchNoNe(Object value) {
        ew.ne("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orBatchNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andBatchNoGt(Object value) {
        ew.gt("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orBatchNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andBatchNoGe(Object value) {
        ew.ge("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orBatchNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andBatchNoLt(Object value) {
        ew.lt("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orBatchNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andBatchNoLe(Object value) {
        ew.le("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orBatchNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andBatchNoIn(Object... value) {
        ew.in("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orBatchNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andBatchNoNotIn(Object... value) {
        ew.notIn("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orBatchNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andBatchNoBetween(Object value, Object value1) {
        ew.between("batch_no", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orBatchNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("batch_no", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andBatchNoNotBetween(Object value, Object value1) {
        ew.notBetween("batch_no", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orBatchNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("batch_no", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andBatchNoLike(String value) {
        ew.like("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orBatchNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andBatchNoNotLike(String value) {
        ew.notLike("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orBatchNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("batch_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSeqNoIsNull() {
        ew.isNull("seq_no");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSeqNoIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("seq_no");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSeqNoIsNotNull() {
        ew.isNotNull("seq_no");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSeqNoIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("seq_no");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSeqNoEq(Object value) {
        ew.eq("seq_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSeqNoEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("seq_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSeqNoNe(Object value) {
        ew.ne("seq_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSeqNoNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("seq_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSeqNoGt(Object value) {
        ew.gt("seq_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSeqNoGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("seq_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSeqNoGe(Object value) {
        ew.ge("seq_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSeqNoGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("seq_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSeqNoLt(Object value) {
        ew.lt("seq_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSeqNoLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("seq_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSeqNoLe(Object value) {
        ew.le("seq_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSeqNoLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("seq_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSeqNoIn(Object... value) {
        ew.in("seq_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSeqNoIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("seq_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSeqNoNotIn(Object... value) {
        ew.notIn("seq_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSeqNoNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("seq_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSeqNoBetween(Object value, Object value1) {
        ew.between("seq_no", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSeqNoBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("seq_no", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSeqNoNotBetween(Object value, Object value1) {
        ew.notBetween("seq_no", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSeqNoNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("seq_no", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSeqNoLike(String value) {
        ew.like("seq_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSeqNoLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("seq_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSeqNoNotLike(String value) {
        ew.notLike("seq_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSeqNoNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("seq_no", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleDateIsNull() {
        ew.isNull("settle_date");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("settle_date");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleDateIsNotNull() {
        ew.isNotNull("settle_date");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("settle_date");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleDateEq(Object value) {
        ew.eq("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleDateNe(Object value) {
        ew.ne("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleDateGt(Object value) {
        ew.gt("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleDateGe(Object value) {
        ew.ge("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleDateLt(Object value) {
        ew.lt("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleDateLe(Object value) {
        ew.le("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleDateIn(Object... value) {
        ew.in("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleDateNotIn(Object... value) {
        ew.notIn("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleDateBetween(Object value, Object value1) {
        ew.between("settle_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("settle_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleDateNotBetween(Object value, Object value1) {
        ew.notBetween("settle_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("settle_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleDateLike(String value) {
        ew.like("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleDateNotLike(String value) {
        ew.notLike("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("settle_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andClientTransIdIsNull() {
        ew.isNull("client_trans_id");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orClientTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("client_trans_id");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andClientTransIdIsNotNull() {
        ew.isNotNull("client_trans_id");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orClientTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("client_trans_id");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andClientTransIdEq(Object value) {
        ew.eq("client_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orClientTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("client_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andClientTransIdNe(Object value) {
        ew.ne("client_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orClientTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("client_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andClientTransIdGt(Object value) {
        ew.gt("client_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orClientTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("client_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andClientTransIdGe(Object value) {
        ew.ge("client_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orClientTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("client_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andClientTransIdLt(Object value) {
        ew.lt("client_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orClientTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("client_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andClientTransIdLe(Object value) {
        ew.le("client_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orClientTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("client_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andClientTransIdIn(Object... value) {
        ew.in("client_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orClientTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("client_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andClientTransIdNotIn(Object... value) {
        ew.notIn("client_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orClientTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("client_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andClientTransIdBetween(Object value, Object value1) {
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orClientTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("client_trans_id", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andClientTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orClientTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("client_trans_id", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andClientTransIdLike(String value) {
        ew.like("client_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orClientTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("client_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andClientTransIdNotLike(String value) {
        ew.notLike("client_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orClientTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("client_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubAccountIsNull() {
        ew.isNull("sub_account");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubAccountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("sub_account");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubAccountIsNotNull() {
        ew.isNotNull("sub_account");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubAccountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("sub_account");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubAccountEq(Object value) {
        ew.eq("sub_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubAccountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("sub_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubAccountNe(Object value) {
        ew.ne("sub_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubAccountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("sub_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubAccountGt(Object value) {
        ew.gt("sub_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubAccountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("sub_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubAccountGe(Object value) {
        ew.ge("sub_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubAccountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("sub_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubAccountLt(Object value) {
        ew.lt("sub_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubAccountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("sub_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubAccountLe(Object value) {
        ew.le("sub_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubAccountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("sub_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubAccountIn(Object... value) {
        ew.in("sub_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubAccountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("sub_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubAccountNotIn(Object... value) {
        ew.notIn("sub_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubAccountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("sub_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubAccountBetween(Object value, Object value1) {
        ew.between("sub_account", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubAccountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("sub_account", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubAccountNotBetween(Object value, Object value1) {
        ew.notBetween("sub_account", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubAccountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("sub_account", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubAccountLike(String value) {
        ew.like("sub_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubAccountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("sub_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubAccountNotLike(String value) {
        ew.notLike("sub_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubAccountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("sub_account", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andAmountIsNull() {
        ew.isNull("amount");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orAmountIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("amount");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andAmountIsNotNull() {
        ew.isNotNull("amount");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orAmountIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("amount");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andAmountEq(Object value) {
        ew.eq("amount", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orAmountEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("amount", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andAmountNe(Object value) {
        ew.ne("amount", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orAmountNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("amount", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andAmountGt(Object value) {
        ew.gt("amount", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orAmountGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("amount", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andAmountGe(Object value) {
        ew.ge("amount", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orAmountGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("amount", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andAmountLt(Object value) {
        ew.lt("amount", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orAmountLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("amount", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andAmountLe(Object value) {
        ew.le("amount", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orAmountLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("amount", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andAmountIn(Object... value) {
        ew.in("amount", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orAmountIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("amount", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andAmountNotIn(Object... value) {
        ew.notIn("amount", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orAmountNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("amount", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andAmountBetween(Object value, Object value1) {
        ew.between("amount", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orAmountBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("amount", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andAmountNotBetween(Object value, Object value1) {
        ew.notBetween("amount", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orAmountNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("amount", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andAmountLike(String value) {
        ew.like("amount", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orAmountLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("amount", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andAmountNotLike(String value) {
        ew.notLike("amount", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orAmountNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("amount", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleModeIsNull() {
        ew.isNull("settle_mode");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleModeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("settle_mode");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleModeIsNotNull() {
        ew.isNotNull("settle_mode");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleModeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("settle_mode");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleModeEq(Object value) {
        ew.eq("settle_mode", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleModeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("settle_mode", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleModeNe(Object value) {
        ew.ne("settle_mode", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleModeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("settle_mode", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleModeGt(Object value) {
        ew.gt("settle_mode", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleModeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("settle_mode", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleModeGe(Object value) {
        ew.ge("settle_mode", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleModeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("settle_mode", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleModeLt(Object value) {
        ew.lt("settle_mode", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleModeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("settle_mode", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleModeLe(Object value) {
        ew.le("settle_mode", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleModeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("settle_mode", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleModeIn(Object... value) {
        ew.in("settle_mode", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleModeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("settle_mode", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleModeNotIn(Object... value) {
        ew.notIn("settle_mode", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleModeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("settle_mode", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleModeBetween(Object value, Object value1) {
        ew.between("settle_mode", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleModeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("settle_mode", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleModeNotBetween(Object value, Object value1) {
        ew.notBetween("settle_mode", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleModeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("settle_mode", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleModeLike(String value) {
        ew.like("settle_mode", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleModeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("settle_mode", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSettleModeNotLike(String value) {
        ew.notLike("settle_mode", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSettleModeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("settle_mode", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andPeriodIsNull() {
        ew.isNull("period");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orPeriodIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("period");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andPeriodIsNotNull() {
        ew.isNotNull("period");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orPeriodIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("period");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andPeriodEq(Object value) {
        ew.eq("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orPeriodEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andPeriodNe(Object value) {
        ew.ne("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orPeriodNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andPeriodGt(Object value) {
        ew.gt("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orPeriodGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andPeriodGe(Object value) {
        ew.ge("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orPeriodGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andPeriodLt(Object value) {
        ew.lt("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orPeriodLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andPeriodLe(Object value) {
        ew.le("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orPeriodLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andPeriodIn(Object... value) {
        ew.in("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orPeriodIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andPeriodNotIn(Object... value) {
        ew.notIn("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orPeriodNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andPeriodBetween(Object value, Object value1) {
        ew.between("period", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orPeriodBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("period", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andPeriodNotBetween(Object value, Object value1) {
        ew.notBetween("period", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orPeriodNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("period", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andPeriodLike(String value) {
        ew.like("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orPeriodLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andPeriodNotLike(String value) {
        ew.notLike("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orPeriodNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("period", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSplitDateIsNull() {
        ew.isNull("split_date");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSplitDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("split_date");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSplitDateIsNotNull() {
        ew.isNotNull("split_date");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSplitDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("split_date");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSplitDateEq(Object value) {
        ew.eq("split_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSplitDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("split_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSplitDateNe(Object value) {
        ew.ne("split_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSplitDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("split_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSplitDateGt(Object value) {
        ew.gt("split_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSplitDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("split_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSplitDateGe(Object value) {
        ew.ge("split_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSplitDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("split_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSplitDateLt(Object value) {
        ew.lt("split_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSplitDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("split_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSplitDateLe(Object value) {
        ew.le("split_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSplitDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("split_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSplitDateIn(Object... value) {
        ew.in("split_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSplitDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("split_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSplitDateNotIn(Object... value) {
        ew.notIn("split_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSplitDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("split_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSplitDateBetween(Object value, Object value1) {
        ew.between("split_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSplitDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("split_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSplitDateNotBetween(Object value, Object value1) {
        ew.notBetween("split_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSplitDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("split_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSplitDateLike(String value) {
        ew.like("split_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSplitDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("split_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSplitDateNotLike(String value) {
        ew.notLike("split_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSplitDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("split_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andRemarkIsNull() {
        ew.isNull("remark");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orRemarkIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("remark");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andRemarkIsNotNull() {
        ew.isNotNull("remark");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orRemarkIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("remark");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andRemarkEq(Object value) {
        ew.eq("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orRemarkEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andRemarkNe(Object value) {
        ew.ne("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orRemarkNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andRemarkGt(Object value) {
        ew.gt("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orRemarkGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andRemarkGe(Object value) {
        ew.ge("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orRemarkGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andRemarkLt(Object value) {
        ew.lt("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orRemarkLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andRemarkLe(Object value) {
        ew.le("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orRemarkLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andRemarkIn(Object... value) {
        ew.in("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orRemarkIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andRemarkNotIn(Object... value) {
        ew.notIn("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orRemarkNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andRemarkBetween(Object value, Object value1) {
        ew.between("remark", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orRemarkBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("remark", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andRemarkNotBetween(Object value, Object value1) {
        ew.notBetween("remark", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orRemarkNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("remark", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andRemarkLike(String value) {
        ew.like("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orRemarkLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andRemarkNotLike(String value) {
        ew.notLike("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orRemarkNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("remark", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransOrderIdsIsNull() {
        ew.isNull("trans_order_ids");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransOrderIdsIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_order_ids");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransOrderIdsIsNotNull() {
        ew.isNotNull("trans_order_ids");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransOrderIdsIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_order_ids");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransOrderIdsEq(Object value) {
        ew.eq("trans_order_ids", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransOrderIdsEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_order_ids", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransOrderIdsNe(Object value) {
        ew.ne("trans_order_ids", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransOrderIdsNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_order_ids", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransOrderIdsGt(Object value) {
        ew.gt("trans_order_ids", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransOrderIdsGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_order_ids", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransOrderIdsGe(Object value) {
        ew.ge("trans_order_ids", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransOrderIdsGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_order_ids", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransOrderIdsLt(Object value) {
        ew.lt("trans_order_ids", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransOrderIdsLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_order_ids", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransOrderIdsLe(Object value) {
        ew.le("trans_order_ids", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransOrderIdsLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_order_ids", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransOrderIdsIn(Object... value) {
        ew.in("trans_order_ids", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransOrderIdsIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_order_ids", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransOrderIdsNotIn(Object... value) {
        ew.notIn("trans_order_ids", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransOrderIdsNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_order_ids", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransOrderIdsBetween(Object value, Object value1) {
        ew.between("trans_order_ids", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransOrderIdsBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_order_ids", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransOrderIdsNotBetween(Object value, Object value1) {
        ew.notBetween("trans_order_ids", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransOrderIdsNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_order_ids", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransOrderIdsLike(String value) {
        ew.like("trans_order_ids", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransOrderIdsLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_order_ids", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransOrderIdsNotLike(String value) {
        ew.notLike("trans_order_ids", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransOrderIdsNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_order_ids", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend2IsNull() {
        ew.isNull("extend_2");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend2IsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("extend_2");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend2IsNotNull() {
        ew.isNotNull("extend_2");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend2IsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("extend_2");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend2Eq(Object value) {
        ew.eq("extend_2", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend2Eq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("extend_2", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend2Ne(Object value) {
        ew.ne("extend_2", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend2Ne(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("extend_2", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend2Gt(Object value) {
        ew.gt("extend_2", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend2Gt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("extend_2", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend2Ge(Object value) {
        ew.ge("extend_2", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend2Ge(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("extend_2", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend2Lt(Object value) {
        ew.lt("extend_2", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend2Lt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("extend_2", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend2Le(Object value) {
        ew.le("extend_2", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend2Le(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("extend_2", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend2In(Object... value) {
        ew.in("extend_2", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend2In(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("extend_2", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend2NotIn(Object... value) {
        ew.notIn("extend_2", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend2NotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("extend_2", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend2Between(Object value, Object value1) {
        ew.between("extend_2", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend2Between(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("extend_2", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend2NotBetween(Object value, Object value1) {
        ew.notBetween("extend_2", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend2NotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("extend_2", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend2Like(String value) {
        ew.like("extend_2", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend2Like(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("extend_2", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend2NotLike(String value) {
        ew.notLike("extend_2", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend2NotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("extend_2", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend3IsNull() {
        ew.isNull("extend_3");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend3IsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("extend_3");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend3IsNotNull() {
        ew.isNotNull("extend_3");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend3IsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("extend_3");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend3Eq(Object value) {
        ew.eq("extend_3", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend3Eq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("extend_3", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend3Ne(Object value) {
        ew.ne("extend_3", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend3Ne(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("extend_3", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend3Gt(Object value) {
        ew.gt("extend_3", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend3Gt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("extend_3", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend3Ge(Object value) {
        ew.ge("extend_3", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend3Ge(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("extend_3", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend3Lt(Object value) {
        ew.lt("extend_3", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend3Lt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("extend_3", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend3Le(Object value) {
        ew.le("extend_3", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend3Le(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("extend_3", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend3In(Object... value) {
        ew.in("extend_3", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend3In(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("extend_3", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend3NotIn(Object... value) {
        ew.notIn("extend_3", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend3NotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("extend_3", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend3Between(Object value, Object value1) {
        ew.between("extend_3", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend3Between(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("extend_3", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend3NotBetween(Object value, Object value1) {
        ew.notBetween("extend_3", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend3NotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("extend_3", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend3Like(String value) {
        ew.like("extend_3", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend3Like(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("extend_3", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andExtend3NotLike(String value) {
        ew.notLike("extend_3", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orExtend3NotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("extend_3", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andStatusIsNull() {
        ew.isNull("status");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("status");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andStatusIsNotNull() {
        ew.isNotNull("status");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("status");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andStatusEq(Object value) {
        ew.eq("status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andStatusNe(Object value) {
        ew.ne("status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andStatusGt(Object value) {
        ew.gt("status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andStatusGe(Object value) {
        ew.ge("status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andStatusLt(Object value) {
        ew.lt("status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andStatusLe(Object value) {
        ew.le("status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andStatusIn(Object... value) {
        ew.in("status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andStatusNotIn(Object... value) {
        ew.notIn("status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andStatusBetween(Object value, Object value1) {
        ew.between("status", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("status", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andStatusNotBetween(Object value, Object value1) {
        ew.notBetween("status", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("status", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andStatusLike(String value) {
        ew.like("status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andStatusNotLike(String value) {
        ew.notLike("status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDateIsNull() {
        ew.isNull("trans_date");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_date");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDateIsNotNull() {
        ew.isNotNull("trans_date");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_date");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDateEq(Object value) {
        ew.eq("trans_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDateNe(Object value) {
        ew.ne("trans_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDateGt(Object value) {
        ew.gt("trans_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDateGe(Object value) {
        ew.ge("trans_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDateLt(Object value) {
        ew.lt("trans_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDateLe(Object value) {
        ew.le("trans_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDateIn(Object... value) {
        ew.in("trans_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDateNotIn(Object... value) {
        ew.notIn("trans_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDateBetween(Object value, Object value1) {
        ew.between("trans_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDateNotBetween(Object value, Object value1) {
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDateLike(String value) {
        ew.like("trans_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDateNotLike(String value) {
        ew.notLike("trans_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransTimeIsNull() {
        ew.isNull("trans_time");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransTimeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_time");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransTimeIsNotNull() {
        ew.isNotNull("trans_time");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransTimeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_time");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransTimeEq(Object value) {
        ew.eq("trans_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransTimeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransTimeNe(Object value) {
        ew.ne("trans_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransTimeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransTimeGt(Object value) {
        ew.gt("trans_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransTimeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransTimeGe(Object value) {
        ew.ge("trans_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransTimeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransTimeLt(Object value) {
        ew.lt("trans_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransTimeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransTimeLe(Object value) {
        ew.le("trans_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransTimeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransTimeIn(Object... value) {
        ew.in("trans_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransTimeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransTimeNotIn(Object... value) {
        ew.notIn("trans_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransTimeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransTimeBetween(Object value, Object value1) {
        ew.between("trans_time", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransTimeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_time", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransTimeNotBetween(Object value, Object value1) {
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransTimeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_time", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransTimeLike(String value) {
        ew.like("trans_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransTimeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransTimeNotLike(String value) {
        ew.notLike("trans_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransTimeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_time", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andServerTransIdIsNull() {
        ew.isNull("server_trans_id");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orServerTransIdIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("server_trans_id");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andServerTransIdIsNotNull() {
        ew.isNotNull("server_trans_id");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orServerTransIdIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("server_trans_id");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andServerTransIdEq(Object value) {
        ew.eq("server_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orServerTransIdEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("server_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andServerTransIdNe(Object value) {
        ew.ne("server_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orServerTransIdNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("server_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andServerTransIdGt(Object value) {
        ew.gt("server_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orServerTransIdGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("server_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andServerTransIdGe(Object value) {
        ew.ge("server_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orServerTransIdGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("server_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andServerTransIdLt(Object value) {
        ew.lt("server_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orServerTransIdLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("server_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andServerTransIdLe(Object value) {
        ew.le("server_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orServerTransIdLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("server_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andServerTransIdIn(Object... value) {
        ew.in("server_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orServerTransIdIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("server_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andServerTransIdNotIn(Object... value) {
        ew.notIn("server_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orServerTransIdNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("server_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andServerTransIdBetween(Object value, Object value1) {
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orServerTransIdBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("server_trans_id", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andServerTransIdNotBetween(Object value, Object value1) {
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orServerTransIdNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("server_trans_id", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andServerTransIdLike(String value) {
        ew.like("server_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orServerTransIdLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("server_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andServerTransIdNotLike(String value) {
        ew.notLike("server_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orServerTransIdNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("server_trans_id", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransStatusIsNull() {
        ew.isNull("trans_status");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransStatusIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_status");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransStatusIsNotNull() {
        ew.isNotNull("trans_status");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransStatusIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_status");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransStatusEq(Object value) {
        ew.eq("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransStatusEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransStatusNe(Object value) {
        ew.ne("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransStatusNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransStatusGt(Object value) {
        ew.gt("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransStatusGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransStatusGe(Object value) {
        ew.ge("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransStatusGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransStatusLt(Object value) {
        ew.lt("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransStatusLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransStatusLe(Object value) {
        ew.le("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransStatusLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransStatusIn(Object... value) {
        ew.in("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransStatusIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransStatusNotIn(Object... value) {
        ew.notIn("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransStatusNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransStatusBetween(Object value, Object value1) {
        ew.between("trans_status", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransStatusBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_status", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransStatusNotBetween(Object value, Object value1) {
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransStatusNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_status", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransStatusLike(String value) {
        ew.like("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransStatusLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransStatusNotLike(String value) {
        ew.notLike("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransStatusNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_status", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andQueryTimesIsNull() {
        ew.isNull("query_times");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orQueryTimesIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("query_times");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andQueryTimesIsNotNull() {
        ew.isNotNull("query_times");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orQueryTimesIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("query_times");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andQueryTimesEq(Object value) {
        ew.eq("query_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orQueryTimesEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("query_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andQueryTimesNe(Object value) {
        ew.ne("query_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orQueryTimesNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("query_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andQueryTimesGt(Object value) {
        ew.gt("query_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orQueryTimesGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("query_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andQueryTimesGe(Object value) {
        ew.ge("query_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orQueryTimesGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("query_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andQueryTimesLt(Object value) {
        ew.lt("query_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orQueryTimesLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("query_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andQueryTimesLe(Object value) {
        ew.le("query_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orQueryTimesLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("query_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andQueryTimesIn(Object... value) {
        ew.in("query_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orQueryTimesIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("query_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andQueryTimesNotIn(Object... value) {
        ew.notIn("query_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orQueryTimesNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("query_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andQueryTimesBetween(Object value, Object value1) {
        ew.between("query_times", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orQueryTimesBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("query_times", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andQueryTimesNotBetween(Object value, Object value1) {
        ew.notBetween("query_times", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orQueryTimesNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("query_times", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andQueryTimesLike(String value) {
        ew.like("query_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orQueryTimesLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("query_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andQueryTimesNotLike(String value) {
        ew.notLike("query_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orQueryTimesNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("query_times", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDescIsNull() {
        ew.isNull("trans_desc");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDescIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("trans_desc");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDescIsNotNull() {
        ew.isNotNull("trans_desc");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDescIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("trans_desc");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDescEq(Object value) {
        ew.eq("trans_desc", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDescEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("trans_desc", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDescNe(Object value) {
        ew.ne("trans_desc", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDescNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("trans_desc", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDescGt(Object value) {
        ew.gt("trans_desc", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDescGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("trans_desc", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDescGe(Object value) {
        ew.ge("trans_desc", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDescGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("trans_desc", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDescLt(Object value) {
        ew.lt("trans_desc", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDescLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("trans_desc", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDescLe(Object value) {
        ew.le("trans_desc", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDescLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("trans_desc", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDescIn(Object... value) {
        ew.in("trans_desc", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDescIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("trans_desc", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDescNotIn(Object... value) {
        ew.notIn("trans_desc", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDescNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("trans_desc", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDescBetween(Object value, Object value1) {
        ew.between("trans_desc", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDescBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("trans_desc", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDescNotBetween(Object value, Object value1) {
        ew.notBetween("trans_desc", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDescNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("trans_desc", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDescLike(String value) {
        ew.like("trans_desc", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDescLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("trans_desc", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andTransDescNotLike(String value) {
        ew.notLike("trans_desc", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orTransDescNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("trans_desc", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubjectIsNull() {
        ew.isNull("subject");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubjectIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("subject");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubjectIsNotNull() {
        ew.isNotNull("subject");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubjectIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("subject");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubjectEq(Object value) {
        ew.eq("subject", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubjectEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("subject", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubjectNe(Object value) {
        ew.ne("subject", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubjectNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("subject", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubjectGt(Object value) {
        ew.gt("subject", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubjectGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("subject", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubjectGe(Object value) {
        ew.ge("subject", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubjectGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("subject", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubjectLt(Object value) {
        ew.lt("subject", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubjectLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("subject", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubjectLe(Object value) {
        ew.le("subject", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubjectLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("subject", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubjectIn(Object... value) {
        ew.in("subject", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubjectIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("subject", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubjectNotIn(Object... value) {
        ew.notIn("subject", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubjectNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("subject", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubjectBetween(Object value, Object value1) {
        ew.between("subject", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubjectBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("subject", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubjectNotBetween(Object value, Object value1) {
        ew.notBetween("subject", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubjectNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("subject", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubjectLike(String value) {
        ew.like("subject", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubjectLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("subject", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andSubjectNotLike(String value) {
        ew.notLike("subject", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orSubjectNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("subject", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andReconcileDateIsNull() {
        ew.isNull("reconcile_date");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orReconcileDateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("reconcile_date");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andReconcileDateIsNotNull() {
        ew.isNotNull("reconcile_date");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orReconcileDateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("reconcile_date");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andReconcileDateEq(Object value) {
        ew.eq("reconcile_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orReconcileDateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("reconcile_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andReconcileDateNe(Object value) {
        ew.ne("reconcile_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orReconcileDateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("reconcile_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andReconcileDateGt(Object value) {
        ew.gt("reconcile_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orReconcileDateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("reconcile_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andReconcileDateGe(Object value) {
        ew.ge("reconcile_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orReconcileDateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("reconcile_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andReconcileDateLt(Object value) {
        ew.lt("reconcile_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orReconcileDateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("reconcile_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andReconcileDateLe(Object value) {
        ew.le("reconcile_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orReconcileDateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("reconcile_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andReconcileDateIn(Object... value) {
        ew.in("reconcile_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orReconcileDateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("reconcile_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andReconcileDateNotIn(Object... value) {
        ew.notIn("reconcile_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orReconcileDateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("reconcile_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andReconcileDateBetween(Object value, Object value1) {
        ew.between("reconcile_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orReconcileDateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("reconcile_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andReconcileDateNotBetween(Object value, Object value1) {
        ew.notBetween("reconcile_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orReconcileDateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("reconcile_date", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andReconcileDateLike(String value) {
        ew.like("reconcile_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orReconcileDateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("reconcile_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andReconcileDateNotLike(String value) {
        ew.notLike("reconcile_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orReconcileDateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("reconcile_date", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIndustryCodeIsNull() {
        ew.isNull("industry_code");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIndustryCodeIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("industry_code");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIndustryCodeIsNotNull() {
        ew.isNotNull("industry_code");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIndustryCodeIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("industry_code");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIndustryCodeEq(Object value) {
        ew.eq("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIndustryCodeEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIndustryCodeNe(Object value) {
        ew.ne("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIndustryCodeNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIndustryCodeGt(Object value) {
        ew.gt("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIndustryCodeGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIndustryCodeGe(Object value) {
        ew.ge("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIndustryCodeGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIndustryCodeLt(Object value) {
        ew.lt("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIndustryCodeLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIndustryCodeLe(Object value) {
        ew.le("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIndustryCodeLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIndustryCodeIn(Object... value) {
        ew.in("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIndustryCodeIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIndustryCodeNotIn(Object... value) {
        ew.notIn("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIndustryCodeNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIndustryCodeBetween(Object value, Object value1) {
        ew.between("industry_code", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIndustryCodeBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("industry_code", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIndustryCodeNotBetween(Object value, Object value1) {
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIndustryCodeNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("industry_code", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIndustryCodeLike(String value) {
        ew.like("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIndustryCodeLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andIndustryCodeNotLike(String value) {
        ew.notLike("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orIndustryCodeNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("industry_code", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserCreateIsNull() {
        ew.isNull("user_create");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_create");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserCreateIsNotNull() {
        ew.isNotNull("user_create");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_create");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserCreateEq(Object value) {
        ew.eq("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserCreateNe(Object value) {
        ew.ne("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserCreateGt(Object value) {
        ew.gt("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserCreateGe(Object value) {
        ew.ge("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserCreateLt(Object value) {
        ew.lt("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserCreateLe(Object value) {
        ew.le("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserCreateIn(Object... value) {
        ew.in("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserCreateNotIn(Object... value) {
        ew.notIn("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserCreateBetween(Object value, Object value1) {
        ew.between("user_create", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_create", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserCreateNotBetween(Object value, Object value1) {
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_create", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserCreateLike(String value) {
        ew.like("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserCreateNotLike(String value) {
        ew.notLike("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtCreateIsNull() {
        ew.isNull("gmt_create");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtCreateIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_create");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtCreateIsNotNull() {
        ew.isNotNull("gmt_create");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtCreateIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_create");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtCreateEq(Object value) {
        ew.eq("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtCreateEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtCreateNe(Object value) {
        ew.ne("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtCreateNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtCreateGt(Object value) {
        ew.gt("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtCreateGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtCreateGe(Object value) {
        ew.ge("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtCreateGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtCreateLt(Object value) {
        ew.lt("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtCreateLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtCreateLe(Object value) {
        ew.le("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtCreateLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtCreateIn(Object... value) {
        ew.in("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtCreateIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtCreateNotIn(Object... value) {
        ew.notIn("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtCreateNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtCreateBetween(Object value, Object value1) {
        ew.between("gmt_create", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtCreateBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_create", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtCreateNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtCreateNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_create", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtCreateLike(String value) {
        ew.like("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtCreateLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtCreateNotLike(String value) {
        ew.notLike("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtCreateNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_create", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserModifiedIsNull() {
        ew.isNull("user_modified");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("user_modified");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserModifiedIsNotNull() {
        ew.isNotNull("user_modified");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("user_modified");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserModifiedEq(Object value) {
        ew.eq("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserModifiedNe(Object value) {
        ew.ne("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserModifiedGt(Object value) {
        ew.gt("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserModifiedGe(Object value) {
        ew.ge("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserModifiedLt(Object value) {
        ew.lt("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserModifiedLe(Object value) {
        ew.le("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserModifiedIn(Object... value) {
        ew.in("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserModifiedNotIn(Object... value) {
        ew.notIn("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserModifiedBetween(Object value, Object value1) {
        ew.between("user_modified", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("user_modified", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("user_modified", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserModifiedLike(String value) {
        ew.like("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andUserModifiedNotLike(String value) {
        ew.notLike("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orUserModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("user_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtModifiedIsNull() {
        ew.isNull("gmt_modified");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtModifiedIsNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNull("gmt_modified");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtModifiedIsNotNull() {
        ew.isNotNull("gmt_modified");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtModifiedIsNotNull() {
        if(!isAndOr()){
            ew.or();
        }
        ew.isNotNull("gmt_modified");
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtModifiedEq(Object value) {
        ew.eq("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtModifiedEq(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.eq("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtModifiedNe(Object value) {
        ew.ne("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtModifiedNe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ne("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtModifiedGt(Object value) {
        ew.gt("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtModifiedGt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.gt("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtModifiedGe(Object value) {
        ew.ge("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtModifiedGe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.ge("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtModifiedLt(Object value) {
        ew.lt("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtModifiedLt(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.lt("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtModifiedLe(Object value) {
        ew.le("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtModifiedLe(Object value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.le("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtModifiedIn(Object... value) {
        ew.in("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtModifiedIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.in("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtModifiedNotIn(Object... value) {
        ew.notIn("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtModifiedNotIn(Object... value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notIn("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtModifiedBetween(Object value, Object value1) {
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtModifiedBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.between("gmt_modified", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtModifiedNotBetween(Object value, Object value1) {
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtModifiedNotBetween(Object value, Object value1) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notBetween("gmt_modified", value, value1);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtModifiedLike(String value) {
        ew.like("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtModifiedLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.like("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition andGmtModifiedNotLike(String value) {
        ew.notLike("gmt_modified", value);
        return this;
    }

    public UploadSubAccountSettleSplitDetailCondition orGmtModifiedNotLike(String value) {
        if(!isAndOr()){
            ew.or();
        }
        ew.notLike("gmt_modified", value);
        return this;
    }
}