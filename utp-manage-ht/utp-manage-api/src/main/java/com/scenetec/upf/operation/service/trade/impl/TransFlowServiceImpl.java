package com.scenetec.upf.operation.service.trade.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.Enum.TradeTypeEnum;
import com.scenetec.upf.operation.model.domain.trade.TransFlowDO;
import com.scenetec.upf.operation.repository.trade.TransFlowMapper;
import com.scenetec.upf.operation.service.trade.TransFlowService;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/09/12
 */
@Service
public class TransFlowServiceImpl implements TransFlowService {

    @Resource
    TransFlowMapper mapper;
    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public long create(TransFlowDO obj) {
        obj.setId(IdGenerate.getId());
        mapper.create(obj);
        return obj.getId();
    }

    @Override
    public int delete(Long id) {
        return mapper.delete(id);
    }

    @Override
    public void update(TransFlowDO obj) {
        mapper.update(obj);
    }

    @Override
    public TransFlowDO getCurrentById(Long id) {
        return mapper.getCurrentById(id);
    }

    @Override
    public PageInfo<TransFlowDO> listCurrent(Query query) {
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        Map map = query.getParameters();
        Page<TransFlowDO> page = mapper.listCurrent(map);
        return new PageInfo<>(page);
    }

    @Override
    public PageInfo<TransFlowDO> listCurrentDownload(Query query) {
        Map map = query.getParameters();
        Page<TransFlowDO> page = mapper.listCurrent(map);
        return new PageInfo<>(page);
    }

    @Override
    public Map<String, Long> countSum(Map<String, Object> parameters) {
        Map<String, Long> tem = mapper.totalCount(parameters);
        return tem;
    }

    @Override
    public Map<String, Long> countSumHistory(Map<String, Object> parameters) {
        return mapper.totalCountHistory(parameters);
    }


    @Override
    public TransFlowDO getHistoryById(Long id) {
        return mapper.getHistoryById(id);
    }

    @Override
    public TransFlowDO getHistorySelctOne(String ServerTransId) {
        return mapper.selectOneHistory(ServerTransId);
    }

    @Override
    public PageInfo<TransFlowDO> listHistory(Query query) {
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        Map map = query.getParameters();
        Page<TransFlowDO> page = mapper.listHistory(map);
        return new PageInfo<>(page);
    }

    @Override
    public PageInfo<TransFlowDO> listHistoryDownload(Query query) {
        Map map = query.getParameters();
        Page<TransFlowDO> page = mapper.listHistory(map);
        return new PageInfo<>(page);
    }


//    //链接url下载图片
//    private static void downloadPicture(String urlList) {
//        URL url = null;
//        int imageNumber = 0;
//
//        try {
//            url = new URL(urlList);
//            DataInputStream dataInputStream = new DataInputStream(url.openStream());
//
//            String imageName =  "test.jpg";
//
//            FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));
//            ByteArrayOutputStream output = new ByteArrayOutputStream();
//
//            byte[] buffer = new byte[1024];
//            int length;
//
//            while ((length = dataInputStream.read(buffer)) > 0) {
//                output.write(buffer, 0, length);
//            }
//            byte[] context=output.toByteArray();
//            fileOutputStream.write(output.toByteArray());
//            dataInputStream.close();
//            fileOutputStream.close();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
