package com.scenetec.upf.operation.service.certificate.impl;

import com.scenetec.upf.operation.model.domain.certificate.CertificateIndustryInfoDO;
import com.scenetec.upf.operation.model.domain.certificate.CertificateMerchantInfoDO;
import com.scenetec.upf.operation.repository.certificate.CertificateIndustryInfoExtMapper;
import com.scenetec.upf.operation.repository.certificate.CertificateMerchantInfoExtMapper;
import com.scenetec.upf.operation.repository.certificate.CertificateMerchantInfoMapper;
import com.scenetec.upf.operation.service.certificate.CertificateIndustryInfoExtService;
import com.scenetec.upf.operation.service.certificate.CertificateMerchantInfoExtService;
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
public class CertificateIndustryInfoServiceExtImpl implements CertificateIndustryInfoExtService {


    @Resource
    private CertificateIndustryInfoExtMapper certificateIndustryInfoExtMapper;


    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void certificateIndustryInfo(String certificateId, List<String> industryCodes) {

        certificateIndustryInfoExtMapper.deleteRefOfCertId(certificateId);

        if(!CollectionUtils.isEmpty(industryCodes)){

            List<CertificateIndustryInfoDO> list = new ArrayList<CertificateIndustryInfoDO>();

            for (String str: industryCodes) {

                CertificateIndustryInfoDO cmDo = new CertificateIndustryInfoDO();
                cmDo.setCertId(certificateId);
                cmDo.setIndustryCode(str);
                list.add(cmDo);

            }

            certificateIndustryInfoExtMapper.insertList(list);
        }


    }

    @Override
    public long countRefOfCertId(Long certificateId) {
        return certificateIndustryInfoExtMapper.countRefOfCertId(certificateId);
    }
}
