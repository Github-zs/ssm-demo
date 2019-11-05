/**
 * Talcloud.com Inc. Copyright (c) 2018-2020 All Rights Reserved.
 */

package com.zs.demo.test.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <pre>
 *    描述信息
 * </pre>
 *
 * @author zhaishuo
 * @version $Id: LoginController.java, v1.0 2019/11/5 13:43 zhaishuo Exp $
 */
@Controller
public class LoginController {
  
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  @ResponseBody
  public String login (String username, String password) {
    Subject currentuser = SecurityUtils.getSubject();
    if (currentuser.isAuthenticated()) {
      return "has get authenticated";
    }
    return "be protected page!";
  }
}
