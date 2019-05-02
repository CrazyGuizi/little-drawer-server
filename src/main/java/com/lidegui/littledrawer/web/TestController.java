package com.lidegui.littledrawer.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lidegui
 * @Date:Created in 9:32 2019/4/17
 */

@RestController
@RequestMapping("api")
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testGet() {
        return "成功";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String testPost() {
        return "成功";
    }
}
