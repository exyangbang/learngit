package com.scenetec.upf.operation.service.imageHanlder;

import com.scenetec.upf.operation.model.domain.merchant.MerchantInfoDO;
import com.scenetec.upf.operation.model.vo.AccountInfoVO;
import com.scenetec.upf.operation.model.vo.DownloadPdfReqDTO;
import com.scenetec.upf.operation.model.vo.DownloadPdfRespDTO;
import com.scenetec.upf.operation.model.vo.UploadIndustryMerchantImagesRespDTO;

import java.util.Map;

public interface ImageHanlderService {
    MerchantInfoDO getImage(Map obj);

    UploadIndustryMerchantImagesRespDTO uploadImageReque(AccountInfoVO accountInfoVO);


    DownloadPdfRespDTO uploadPDFReque(DownloadPdfReqDTO downloadPdfReqDTO);
}
