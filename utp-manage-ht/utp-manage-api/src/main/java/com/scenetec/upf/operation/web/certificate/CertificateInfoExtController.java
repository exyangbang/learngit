package com.scenetec.upf.operation.web.certificate;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.certificate.CertificateInfoDO;
import com.scenetec.upf.operation.model.vo.certificate.CertificateInfoVO;
import com.scenetec.upf.operation.model.vo.certificate.CertificateVO;
import com.scenetec.upf.operation.model.vo.certificate.SecretInfoVo;
import com.scenetec.upf.operation.service.certificate.CertificateIndustryInfoExtService;
import com.scenetec.upf.operation.service.certificate.CertificateInfoExtService;
import com.scenetec.upf.operation.utils.StringUtil;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shendunyuan@scenetec.com
 * @date 2018/07/22
 */
@Api(value="证书信息模块",tags={"证书信息扩展"})
@RestController
public class CertificateInfoExtController {

    @Resource
    CertificateInfoExtService service;

    @Resource
    CertificateIndustryInfoExtService certificateIndustryInfoExtService;

    @RequestMapping(value = "/api/certificateInfo/{id}", method = RequestMethod.GET)
    public CertificateInfoVO getByIdWithOutCertFile(@PathVariable Long id){

        return service.getByIdWithOutCertFile(id);
    }

    @RequestMapping(value = "/api/certificateInfo/list", method = RequestMethod.POST)
	public PageInfo<CertificateInfoVO> queryListWithOutCertFile(@RequestBody Query query){
        PageInfo<CertificateInfoVO> vo = service.queryListWithOutCertFile(query);
        return vo;
    }

    @RequestMapping(value = "/certificateInfo/querySecretListByMerNo/{merNo}", method = RequestMethod.GET)
	public List<SecretInfoVo> querySecretListByMerNo(@PathVariable String merNo) {
        return service.querySecretListByMerNo(merNo);
    }

    @RequestMapping(value = "/api/certificateInfo/uploadMerPublicKey", method = RequestMethod.POST)
    public void uploadMerPublicKey(@RequestParam("file") MultipartFile file, CertificateVO obj) {
        if (file == null) {
            throw new SystemRuntimeException(ErrorCode.BSMCE004);
        }

        service.uploadMerPublicKey(file, obj);
    }

    @RequestMapping(value = "/api/certificateInfo/uploadUpPrivateKey", method = RequestMethod.POST)
    public void uploadUpPrivateKey(@RequestParam("file") MultipartFile file, CertificateVO obj) {
        if (file == null) {
            throw new SystemRuntimeException(ErrorCode.BSMCE005);
        }

        service.uploadUpPrivateKey(file, obj);
    }

    @RequestMapping(value = "/api/certificateInfo/{id}", method = RequestMethod.DELETE)
    public void deleteCertificate(@PathVariable Long id){
        if(certificateIndustryInfoExtService.countRefOfCertId(id)!=0){
            throw new SystemRuntimeException(ErrorCode.BSMCE007);
        }
        service.deleteCertificate(id);
    }

    @RequestMapping(value = "/api/certificateInfo/update/merPublicKey", method = RequestMethod.PUT)
    public void updateMerPublicKey(@RequestParam(value="file", required = false) MultipartFile file, CertificateVO obj) {
        // 修改obj的对象中"null"
        obj.convertStringNullToNull();
        // 修改公钥信息
        service.updateMerPublicKey(file, obj);
    }

    @RequestMapping(value = "/api/certificateInfo/update/upPrivateKey", method = RequestMethod.PUT)
    public void updateUpPrivateKey(@RequestParam(value="file", required = false) MultipartFile file, CertificateVO obj) {
        // 修改obj的对象中"null"
        obj.convertStringNullToNull();
        // 修改私钥钥信息
        service.updateUpPrivateKey(file, obj);
    }
}
