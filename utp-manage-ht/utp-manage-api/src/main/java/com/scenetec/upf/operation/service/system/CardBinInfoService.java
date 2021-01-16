package com.scenetec.upf.operation.service.system;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.system.CardBinInfoDO;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/11/08
 */
public interface CardBinInfoService {

	/**
	 * 创建
	 * @param obj
	 * @return
	 */
	long create(CardBinInfoDO obj);

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int delete(Long id);

	/**
	 * 更新
	 * @param obj
	 */
	void update(CardBinInfoDO obj);

	/**
	 * 查询详细
	 * @param id
	 * @return
	 */
	CardBinInfoDO getById(Long id);

	/**
	 * 查询列表(分页)
	 * @param query
	 * @return
	 */
	PageInfo<CardBinInfoDO> pageList(Query query);

    /**
    * 查询列表(无分页)
    * @param query
    * @return
    */
    List<CardBinInfoDO> list(Map<String, Object> params);


    void runSql(MultipartFile file);
}
