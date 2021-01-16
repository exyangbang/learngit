package com.scenetec.upf.operation.service.industry.impl;

import com.scenetec.upf.operation.model.domain.industry.IndustrySyncLogDO;
import com.scenetec.upf.operation.model.vo.industry.IndustrySyncLogVO;
import com.scenetec.upf.operation.repository.industry.IndustrySyncLogMapper;
import com.scenetec.upf.operation.service.industry.IndustrySyncLogService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Description : 描述
 * @Author : linkaigui@scenetec.com
 * @Create : 2019/1/22 12:02
 */
@Service
public class IndustrySyncLogServiceImpl implements IndustrySyncLogService {

    @Resource
    IndustrySyncLogMapper industrySyncLogMapper;

    @Resource
    UserService userService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateSyncLastDate(IndustrySyncLogVO industrySyncLogVO) {
        String username = userService.getUserContext().getUsername();
        IndustrySyncLogDO industrySyncLogDO = new IndustrySyncLogDO();
        industrySyncLogDO.setLastDate(industrySyncLogVO.getLastDate());
        industrySyncLogDO.setUserModified(username);
        industrySyncLogDO.setGmtModified(new Date());
        industrySyncLogDO.setIndustryCode(industrySyncLogVO.getIndustryCode());
        industrySyncLogDO.setFundAccountNo(industrySyncLogVO.getFundAccountNo());
        if (StringUtils.isNoneBlank(industrySyncLogDO.getIndustryCode())){
            return industrySyncLogMapper.updateByIndustryCode(industrySyncLogDO);
        }
        if (StringUtils.isNoneBlank(industrySyncLogVO.getFundAccountNo())){
            industrySyncLogDO.setLastTime("000000");
            return industrySyncLogMapper.updateByfundAccount(industrySyncLogDO);
        }
        return 0;
    }
}
