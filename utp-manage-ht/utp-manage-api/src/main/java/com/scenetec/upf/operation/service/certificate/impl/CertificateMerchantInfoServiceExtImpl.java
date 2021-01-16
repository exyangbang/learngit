package com.scenetec.upf.operation.service.certificate.impl;

import com.scenetec.upf.operation.model.domain.certificate.CertificateMerchantInfoDO;
import com.scenetec.upf.operation.repository.certificate.CertificateMerchantInfoExtMapper;
import com.scenetec.upf.operation.repository.certificate.CertificateMerchantInfoMapper;
import com.scenetec.upf.operation.service.certificate.CertificateMerchantInfoExtService;
import com.scenetec.upf.operation.utils.IdGenerate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author scenetec
 * @date 2018/07/23
 */
@Service
public class CertificateMerchantInfoServiceExtImpl implements CertificateMerchantInfoExtService{


    @Resource
    private CertificateMerchantInfoExtMapper certificateMerchantInfoExtMapper;

    @Resource
    private CertificateMerchantInfoMapper certificateMerchantInfoMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void certificateMerchantInfo(String certificateId, List<String> merchants) {

        certificateMerchantInfoExtMapper.deleteRefOfCertId(certificateId);

        if(!CollectionUtils.isEmpty(merchants)){

            List<CertificateMerchantInfoDO> list = new ArrayList<CertificateMerchantInfoDO>();

            for (String str: merchants) {

                CertificateMerchantInfoDO cmDo = new CertificateMerchantInfoDO();
                cmDo.setCertId(certificateId);
                cmDo.setMerNo(str);
                cmDo.setId(IdGenerate.getId());
                list.add(cmDo);

            }

            certificateMerchantInfoMapper.insertList(list);
        }


    }
}
