package com.scenetec.upf.operation.service.channel;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.channel.ChannelInfoDO;
import com.scenetec.upf.operation.model.vo.ChannelInfoVO;
import com.scenetec.upf.operation.model.vo.industryamtlimit.IndustryAmtLimitApprovalVO;
import com.scenetec.zeus.daogenerator.model.Query;

import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/09/05
 */
public interface ChannelInfoService {

	/**
	 * 创建
	 * @param channelInfoVO
	 * @return
	 */
	ChannelInfoDO create(ChannelInfoVO channelInfoVO);

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
	void update(ChannelInfoVO channelInfoVO);

	/**
	 * 查询详细
	 * @param id
	 * @return
	 */
	ChannelInfoDO getById(Long id);

	/**
	 * 查询列表
	 * @param query
	 * @return
	 */
	PageInfo<ChannelInfoDO> pageList(Query query);


	/**
	 * 查询列表
	 * @param parameters
	 * @return
	 */
	List<ChannelInfoDO> list(Map<String, Object> parameters);

	List<ChannelInfoDO> filterList(Query query);

	List<ChannelInfoDO> channelMerNoList(Query query);



	void updateToOnlineReuqest(ChannelInfoDO obj,String operateType);
}
