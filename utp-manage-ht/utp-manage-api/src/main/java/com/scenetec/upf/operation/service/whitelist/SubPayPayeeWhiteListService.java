package com.scenetec.upf.operation.service.whitelist;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.subpaypayeewhitelist.SubPayPayeeWhiteListDO;
import com.scenetec.upf.operation.model.vo.whitelist.SubPayPayeeWhiteListVO;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.web.multipart.MultipartFile;

public interface SubPayPayeeWhiteListService {
    /**
     * 创建
     *
     * @param obj
     * @return
     */
     long create(MultipartFile file, Long id);

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
    void update(SubPayPayeeWhiteListVO obj);

    /**
     * 查询详细
     *
     * @param id
     * @return
     */
    SubPayPayeeWhiteListDO getById(Long id);

    /**
     * 查询列表
     *
     * @param
     * @return
     */
    PageInfo<SubPayPayeeWhiteListDO> list(Query query);
}
