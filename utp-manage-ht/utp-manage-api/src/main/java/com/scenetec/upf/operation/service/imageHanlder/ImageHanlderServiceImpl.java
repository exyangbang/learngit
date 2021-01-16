package com.scenetec.upf.operation.service.imageHanlder;

import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.account.status.AccountEnum;
import com.scenetec.upf.operation.model.domain.merchant.MerchantInfoDO;
import com.scenetec.upf.operation.model.vo.*;
import com.scenetec.upf.operation.utils.SHA1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class ImageHanlderServiceImpl implements ImageHanlderService {

    @Value("${account.flow.queryIndustryMerchantImages.url}")
    private String imageurl;
    @Value("${account.flow.uploadIndustryMerchantImages.url}")
    private String uploadIndustryMerchantImages;
    @Value("${account.flow.downloadPdf.url}")
    private String downloadPdfurl;

    /**
     * 参数
     * account 虚拟账户
     * objType 账户类型
     *
     * @param obj
     * @return
     */
    @Override
    public MerchantInfoDO getImage(Map obj) {
        String account = obj.get("account").toString();
        QueryIndustryMerchantImagesReqDTO imagesReqDTO = new QueryIndustryMerchantImagesReqDTO();
        imagesReqDTO.setCode(account);
        String objType = Objects.toString(obj.get("objType"), null);
        switch (objType) {
            // 平台账户
            case "1":
            // 手续费收益账户
            case "4":
            // 手续费支出账户
            case "5":
            // 归集账户
            case "6":
            // 小额打款支出账户
            case "10":
                imagesReqDTO.setQueryType("1");
                break;
            default:
                imagesReqDTO.setQueryType("2");
                break;
        }
        imagesReqDTO.setImageType("2");
        try {
            imagesReqDTO.setSign(SHA1.genWithAmple(imagesReqDTO.toSHA1()));
        } catch (NoSuchAlgorithmException e) {
            log.error("SHA1签名异常", e);
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "SHA1签名错误");
        }
        RestTemplate restTemplate = new RestTemplate();
        QueryIndustryMerchantImagesRespDTO resultMap = restTemplate.postForObject(imageurl, imagesReqDTO, QueryIndustryMerchantImagesRespDTO.class);
        if (resultMap == null) {

            throw new SystemRuntimeException(ErrorCode.BSMPS001, "联机问题。返回空" + imageurl);
        }
        if (!"200".equals(resultMap.getStatus())) {
            if (resultMap.getMessage() != null) {
                throw new SystemRuntimeException(ErrorCode.BSMPS001, resultMap.getMessage());
            }
            log.error("获取图片失败,参数：{},失败原因:{}",imagesReqDTO,resultMap.getMessage());
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "图片获取失败");
        }

        MerchantInfoDO merchantInfoDO = new MerchantInfoDO();
        BeanUtils.copyProperties(resultMap, merchantInfoDO);
        return merchantInfoDO;
    }

    /**
     * 上传图片
     *
     * @param accountInfoVO
     * @return
     */
    @Override
    public UploadIndustryMerchantImagesRespDTO uploadImageReque(AccountInfoVO accountInfoVO) {
        UploadIndustryMerchantImagesReqDTO imagesReqDTO = new UploadIndustryMerchantImagesReqDTO();
        imagesReqDTO.setAccount(accountInfoVO.getAccount());
        imagesReqDTO.setIndustryCode(accountInfoVO.getIndustryCode());
        imagesReqDTO.setBusLicPic(accountInfoVO.getBusLicPic());
        imagesReqDTO.setLicensePic(accountInfoVO.getLicensePic());
        imagesReqDTO.setPersonPic(accountInfoVO.getPersonPic());
        imagesReqDTO.setPersonReversePic(accountInfoVO.getPersonReversePic());
        try {
            imagesReqDTO.setSign(SHA1.genWithAmple(imagesReqDTO.toSHA1()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        RestTemplate restTemplate = new RestTemplate();
        UploadIndustryMerchantImagesRespDTO resultMap = restTemplate.postForObject(uploadIndustryMerchantImages, imagesReqDTO, UploadIndustryMerchantImagesRespDTO.class);
        if (resultMap == null) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "联机问题。返回空" + uploadIndustryMerchantImages);
        }
        if (!"200".equals(resultMap.getStatus())) {
            if (resultMap.getMessage() != null) {
                throw new SystemRuntimeException(ErrorCode.BSMPS001,  resultMap.getMessage());
            }
            log.error("图片上传失败,参数：{},失败原因:{}",imagesReqDTO,resultMap.getMessage());
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "图片上传失败");
        }
        return resultMap;
    }

    /**
     * 获取pdf
     */
    @Override
    public DownloadPdfRespDTO uploadPDFReque(DownloadPdfReqDTO downloadPdfReqDTO) {
        try {
            downloadPdfReqDTO.setSign(SHA1.genWithAmple(downloadPdfReqDTO.toSHA1()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        RestTemplate restTemplate = new RestTemplate();
        DownloadPdfRespDTO resultMap = restTemplate.postForObject(downloadPdfurl, downloadPdfReqDTO, DownloadPdfRespDTO.class);
        if (resultMap == null) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "联机问题。返回空" + downloadPdfurl);
        }
        if (!"200".equals(resultMap.getStatus())) {
            if (resultMap.getMessage() != null) {
                throw new SystemRuntimeException(ErrorCode.BSMPS001, resultMap.getMessage());
            }
            log.error("pdf获取失败,参数：{},失败原因:{}",downloadPdfReqDTO,resultMap.getMessage());
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "pdf获取失败");
        }
        return resultMap;
    }


}
