
package com.zs.demo.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;

/**
 * <pre>
 *    通过shiro.ini读取用户信息
 * </pre>
 *
 * @author zhaishuo
 * @version $Id: SecurityTest.java, v1.0 2019/11/4 13:52 zhaishuo Exp $
 */
public class SecurityTest {
  public static void main(String[] args) {
    //1.加载配置文件获取Factory对象
    Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro/shiro.ini");
    //2.获取SecurityManager对象
    SecurityManager securityManager =factory.getInstance();
    //3.将SecurityManager添加到系统
    SecurityUtils.setSecurityManager(securityManager);
    //4.通过SecurityManager获取Subject对象
    Subject subject=SecurityUtils.getSubject();
    //账号密码是客户端提交的数据
    AuthenticationToken token=new UsernamePasswordToken("root","123456");
    //5.实现认证操作
    try{
      subject.login(token);
      System.out.println("认证成功");
    }catch(UnknownAccountException e){
      System.out.println("账号输入错误。，，，");
    }catch (IncorrectCredentialsException e) {
      System.out.println("密码输入错误。。。");
    }

  }
}
