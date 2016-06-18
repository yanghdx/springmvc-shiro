package cn.doit123.shirodemo.controllers.login;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login(HttpServletRequest request, Model model) {

		return "login";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String doLogin(@RequestParam("username") String username, 
						  @RequestParam("password") String password,
						  Model model) {
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		token.setRememberMe(false);
		
		String error = null;
		try {
			subject.login(token);
		} catch (UnknownAccountException e) {
			error = "用户名错误";
		} catch (IncorrectCredentialsException e) {
			error = "用户名密码错误";
		} catch (LockedAccountException e) {
			error = "用户被锁定";
		} catch (AuthenticationException e) {
			error = "认证失败";
		} catch (Exception e) {
			error = "登录失败";
		}
		if (error != null) {
			model.addAttribute("error", error);
			return "login";
		} 
		return "redirect:/index";
		
	}
}
