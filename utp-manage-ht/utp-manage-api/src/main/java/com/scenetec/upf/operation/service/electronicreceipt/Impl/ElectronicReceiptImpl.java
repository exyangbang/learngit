package com.scenetec.upf.operation.service.electronicreceipt.Impl;

import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.electronicreceipt.ElectronicReceiptDO;
import com.scenetec.upf.operation.repository.electronicreceipt.ElectronicReceiptMapper;
import com.scenetec.upf.operation.service.electronicreceipt.ElectronicReceiptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class ElectronicReceiptImpl implements ElectronicReceiptService {
    @Resource
    ElectronicReceiptMapper mapper;
    @Override
    public ElectronicReceiptDO getOne(ElectronicReceiptDO el) {
//        String serverTransId = el.getServerTransId();
//        if (serverTransId == null){
//            throw new SystemRuntimeException(ErrorCode.BSMUM005);
//        }
        return mapper.selectOne(el);
    }
}
