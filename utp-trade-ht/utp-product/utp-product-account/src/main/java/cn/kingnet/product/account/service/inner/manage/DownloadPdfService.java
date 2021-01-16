package cn.kingnet.product.account.service.inner.manage;

import cn.kingnet.utp.product.common.dto.manage.DownloadPdfReqDTO;
import cn.kingnet.utp.product.common.dto.manage.DownloadPdfRespDTO;
import cn.kingnet.utp.product.common.tools.SHA1;
import cn.kingnet.utp.service.persistence.api.IAccountElectronicReceiptHandler;
import cn.kingnet.utp.service.persistence.api.IElectronicReceiptHandler;
import cn.kingnet.utp.service.persistence.api.IOutsideTransOrderHandler;
import cn.kingnet.utp.service.persistence.entity.OutsideTransOrder;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.utils.DataUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Description: 下载PDF
 * @Author sheqingquan@scenetec.com
 * @Create 2020/6/3 13:01
 */
@Slf4j
@Service
public class DownloadPdfService {

    @Resource
    private IOutsideTransOrderHandler outsideTransOrderHandler;
    @Resource
    private IElectronicReceiptHandler electronicReceiptHandler;
    @Resource
    private IAccountElectronicReceiptHandler accountElectronicReceiptHandler;

    /**
     * 下载
     * @param req
     * @return
     */
    public DownloadPdfRespDTO download(DownloadPdfReqDTO req) {
        if (null == req) {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, "请求报文不能为空");
        }
        //参数校验
        ValidateUtils.notNull(req.getId(), "参数[id]不能为空");
        ValidateUtils.hasText(req.getType(), "请求类型");
        if (!(req.getType().equals("1") || req.getType().equals("2") || req.getType().equals("3"))) {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, String.format("请求类型[%s]不正确", req.getType()));
        }
        //签名校验
        if (!SHA1.genWithAmple(req.toSHA1()).equals(req.getSign())) {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, "签名信息校验失败");
        }

        byte[] bytes;
        if (req.getType().equals("1")) {
            bytes = getFileBytes(req, outsideTransOrderHandler.queryFilePathById(req.getId()));
        } else if (req.getType().equals("2")) {
            bytes = getFileBytes(req, electronicReceiptHandler.queryFilePathById(req.getId()));
        } else if (req.getType().equals("3")) {
            bytes = getFileBytes(req, accountElectronicReceiptHandler.queryFilePathById(req.getId()));
        } else {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, "无效的请求类型");
        }
        DownloadPdfRespDTO respDTO = new DownloadPdfRespDTO();
        respDTO.setContent(bytes);
        respDTO.setStatus(HttpRespStatus.OK.valueStr());
        return respDTO;
    }

    /**
     * 根据路径获取PDF文件
     * @param filePath
     * @return
     */
    private byte[] getFileBytes(DownloadPdfReqDTO req, String filePath) {
        try {
            if (StringUtil.isBlank(filePath)) {
                throw new ManageException(HttpRespStatus.BAD_REQUEST, "文件不存在");
            }
            if (!DataUtil.isFilePath(filePath)) {
                throw new ManageException(HttpRespStatus.BAD_REQUEST, "文件不存在");
            }
            return Files.readAllBytes(Paths.get(filePath));
        } catch (Exception e) {
            log.error("id==>{}，请求类型==>{}，后管获取PDF文件异常==>{}", req.getId(), req.getType(), e.getMessage(), e);
            throw new ManageException(HttpRespStatus.BAD_REQUEST, "获取PDF文件异常");
        }
    }
}