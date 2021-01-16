package cn.kingnet.utp.service.persistence.mapper;

import cn.kingnet.utp.service.persistence.entity.OutsideTransOrder;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

public interface OutsideTransOrderCustomMapper extends BaseMapper<OutsideTransOrder> {

    Integer insertBatch(List<OutsideTransOrder> list);
}
