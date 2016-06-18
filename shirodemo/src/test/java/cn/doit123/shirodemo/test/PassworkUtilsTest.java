package cn.doit123.shirodemo.test;

import org.junit.Test;

import cn.doit123.shirodemo.core.utils.PasswordUtils;

public class PassworkUtilsTest {

	
	@Test
	public void testEnc() {
		String pwd = PasswordUtils.encryptPassword("123456", "admin");
		System.out.println(pwd);
		pwd = PasswordUtils.encryptPassword("123456", "user");
		System.out.println(pwd);
	}
}
