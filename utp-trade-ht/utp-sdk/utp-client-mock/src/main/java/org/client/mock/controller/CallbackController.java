package org.client.mock.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("callback")
public class CallbackController {
    Logger log = LoggerFactory.getLogger(CallbackController.class);

    @RequestMapping("/show")
    public Object show(@RequestBody Object obj) {
        log.info("回调内容：{}", JSON.toJSONString(obj));
        return obj;
    }

    @RequestMapping("/success")
    public Object success(@RequestBody Object obj) {
        log.info("回调内容：{}", JSON.toJSONString(obj));
        return "success";
    }

    @RequestMapping("/success200")
    public Object success200(@RequestBody Object obj) {
        log.info("回调内容：{}", JSON.toJSONString(obj));
        return new HashMap() {{
            put("status", 200);
        }};
    }
}
