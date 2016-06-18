package cn.doit123.shirodemo.core.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 
 * 密码加密帮助类
 * @author yanghdx
 *
 */
public class PasswordUtils {

	private static final String algorithmName = "md5"; 
	
    private static final int hashIterations = 2; 
    
    /**
     * 加盐加密密码
     * @param password
     * @param salt
     * @return
     */
    public static String  encryptPassword(String password, String salt) {  
       String newPassword = new SimpleHash(  
                algorithmName,  
                password,  
                ByteSource.Util.bytes(salt),  
                hashIterations).toHex();  
       return newPassword; 
    }
    
    
    
}
