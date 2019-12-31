
package com.zs.demo.security;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * <pre>
 *    描述信息
 * </pre>
 *
 * @author zhaishuo
 * @version $Id: SecurityRealm.java, v1.0 2019/11/4 14:11 zhaishuo Exp $
 */
public class SecurityRealm extends AuthorizingRealm {
  
  
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    return null;
  }

  
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    UsernamePasswordToken t=(UsernamePasswordToken) token;
    //获取登录的账号
    String username=t.getUsername();
    System.out.println("登录的账号:"+username);
    //通过jdbc去数据库中查询该账号对应的记录
    if(!"root".equals(username)){
      //账号不存在
      return null;
    }
    //数据库中查询的密码是123456
    String password="123456";
    //身份信息（可以是账号也可以是对象） 密码 realmName(自定义)
    return new SimpleAuthenticationInfo(username,password,"realName");
    
  }
}
