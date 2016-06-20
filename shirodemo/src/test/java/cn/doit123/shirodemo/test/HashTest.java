package cn.doit123.shirodemo.test;

import junit.framework.Assert;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class HashTest {

	
	@Test
	public void testBase64() {
		String str = "Hello world";
		
		String encodeStr = Base64.encodeToString(str.getBytes());
		
		System.out.println(encodeStr);
		
		String decodeStr = Base64.decodeToString(encodeStr.getBytes());
		
		Assert.assertEquals(str, decodeStr);
		
	}
	
	
	@Test
	public void testMd5() {
		String str = "Hello";
		String salt = "salt";
		
		String md5 = new Md5Hash(str, salt).toString();
		System.out.println(md5);
		
		String md5_2 = new Md5Hash(str, salt, 2).toString();
		System.out.println(md5_2);
		
	}
}
