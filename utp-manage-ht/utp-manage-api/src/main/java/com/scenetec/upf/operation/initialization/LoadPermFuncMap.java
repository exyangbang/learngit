package com.scenetec.upf.operation.initialization;

import com.scenetec.upf.operation.model.domain.system.PermFunc;
import com.scenetec.upf.operation.repository.system.PermissionMapper;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author luoxianjun@scenetec.com
 * 2018/7/27 上午10:06
 */
@Component
@Slf4j
public class LoadPermFuncMap implements CommandLineRunner {

    @Resource
    private PermissionMapper permissionMapper;

    public static Map<Long, List<PermFunc>> permFuncMap = new HashMap<>();

    @Override
    public void run(String... args) {
        List<PermFunc> list = permissionMapper.findPermFunc();
        if (list == null) {
            return;
        }
        permFuncMap = list.stream().collect(Collectors.groupingBy(PermFunc::getPermissionId));
    }
}
