package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.entity.CommonDictionary;
import cn.kingnet.utp.trade.common.utils.CommonConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Description
 * @Author WJH
 * @Date 2018年11月08日
 */
@Service
@Slf4j
public class CommonDictionaryService {


    /**
     * 按类型 取字典值
     *
     * @param type
     * @return
     */
    public List<CommonDictionary> getCommonDictionaryByType(String type) {
        return MybatisDaoImpl.run().selectList(CommonDictionary.builder().type(type).build());
    }

    public CommonDictionary getDefaultOrg() {
        List<CommonDictionary> list = getCommonDictionaryByType(CommonConstants.DEFAULT_ORG_CODE);
        return CollectionUtils.isEmpty(list) ? new CommonDictionary() : list.get(0);
    }

}
