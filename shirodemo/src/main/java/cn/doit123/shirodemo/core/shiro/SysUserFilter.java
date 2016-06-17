package cn.doit123.shirodemo.core.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import cn.doit123.shirodemo.services.sysuser.SysUserService;

public class SysUserFilter extends PathMatchingFilter {

	@Autowired
	private SysUserService userService;

	@Override
	protected boolean onPreHandle(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {

		String username = (String) SecurityUtils.getSubject().getPrincipal();
		request.setAttribute("CURRENT_USER",
				userService.findByUsername(username));
		return true;
	}
}
