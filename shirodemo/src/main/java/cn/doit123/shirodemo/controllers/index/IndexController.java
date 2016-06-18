package cn.doit123.shirodemo.controllers.index;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.doit123.shirodemo.services.sysuser.SysUserService;

@Controller
public class IndexController {

	@Autowired
	private SysUserService userService;
	
	//private ResService resService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		
		String username = (String)SecurityUtils.getSubject().getPrincipal();
		model.addAttribute("username", username);
		
		Session session = SecurityUtils.getSubject().getSession();
		String sid = session.getId().toString();
		String host = session.getHost();
		model.addAttribute("sid", sid);
		model.addAttribute("host", host);
		
		return "index";
	}
	
	@RequestMapping(value = "/unauthenticated", method = RequestMethod.GET)
	public String unauthenticated() {
		return "unauthenticated";
	}
}
