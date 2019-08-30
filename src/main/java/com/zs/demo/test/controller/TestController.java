package com.zs.demo.test.controller;/**
 * Talcloud.com Inc.
 * Copyright (c) 2018-2020 All Rights Reserved.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <pre>
 *    描述信息
 * </pre>
 *
 * @version $Id: TestController.java, v1.0 2019/8/30 11:36 86130 Exp $
 */
@Controller
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        return "hello wordld!";
    }

}
