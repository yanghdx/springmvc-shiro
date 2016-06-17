package cn.doit123.shirodemo.test;


import junit.framework.Assert;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class LoginLogoutTest {

	@Test
	public void testIniRealm () {
		Factory<SecurityManager> factory =
				new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager secMgr = factory.getInstance();
		
		SecurityUtils.setSecurityManager(secMgr);
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("wang", "1234");
		
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			//e.printStackTrace();
		}
		
		Assert.assertEquals(true, subject.isAuthenticated());
		
		subject.logout();
	}
	
	@Test
	public void testJdbcRealm() {
		
	}
}
