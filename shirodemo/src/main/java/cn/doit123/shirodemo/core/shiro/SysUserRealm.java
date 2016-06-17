package cn.doit123.shirodemo.core.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import cn.doit123.shirodemo.pojo.entity.SysUser;
import cn.doit123.shirodemo.services.sysuser.SysUserService;

public class SysUserRealm extends AuthorizingRealm {

	//@Autowired
	private SysUserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		String username = (String)principals.getPrimaryPrincipal();
		
		SysUser user = userService.findByUsername(username);
		
		SimpleAuthorizationInfo authInfo = new SimpleAuthorizationInfo();
		authInfo.setRoles(userService.findRoles(user.getId()));
		authInfo.setStringPermissions(userService.findPermissions(user.getId()));
		
		return authInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		final String username = (String)token.getPrincipal();
		
		SysUser user = userService.findByUsername(username);
		
		if (user == null) {
			throw new UnknownAccountException();
		} else if (user.isLocked()) {
			throw new LockedAccountException();
		} else {
			SimpleAuthenticationInfo authInfo = new SimpleAuthenticationInfo(
					user.getUsername(), 
					user.getPassword(), 
					ByteSource.Util.bytes(user.getSalt()), 
					this.getName());
			return authInfo;
		}
	}

}