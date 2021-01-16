package cn.kingnet.utp.reconciliation.batch.onebank.support;

import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.file.separator.SimpleRecordSeparatorPolicy;

/**
 * @Description : 描述
 * @Author : linkaigui
 * @Create : 2019/3/26 18:03
 */
@Slf4j
public class CustomRecordSeparatorPolicy extends SimpleRecordSeparatorPolicy {

    public CustomRecordSeparatorPolicy() {
    }

    @Override
    public String postProcess(String record) {
        if(StringUtil.isNotBlank(record)){
            String[] strs = record.split("\\|");
            if(strs != null){
                log.debug("文件内容:{},长度:{}",record,strs.length);
                if(strs.length > 10) return null;
            }
        }
        return super.postProcess(record);
    }
}
