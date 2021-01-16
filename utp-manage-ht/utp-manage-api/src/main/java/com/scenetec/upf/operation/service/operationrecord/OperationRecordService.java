package com.scenetec.upf.operation.service.operationrecord;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.operationrecord.OperationRecordDO;
import com.scenetec.upf.operation.model.domain.whitelist.WhiteListDO;
import com.scenetec.upf.operation.model.vo.operationrecord.OperationRecordBatchVO;
import com.scenetec.upf.operation.model.vo.operationrecord.OperationRecordVO;
import com.scenetec.upf.operation.model.vo.whitelist.WhiteListVO;
import com.scenetec.zeus.daogenerator.model.Query;

public interface OperationRecordService {
    /**
     * 创建
     *
     * @param obj
     * @return
     */
    long create(OperationRecordDO obj);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 更新
     *
     * @param obj
     */
    void update(OperationRecordDO obj);

    /**
     * 查询详细
     *
     * @param id
     * @return
     */
    OperationRecordDO getById(Long id);

    /**
     * 查询列表
     *
     * @param
     * @return
     */
    PageInfo<OperationRecordVO> list(Query query);

    /**
     * 批量审核
     * @param operationRecordBatchVO
     */
    int batchAudit(OperationRecordBatchVO operationRecordBatchVO);
}
