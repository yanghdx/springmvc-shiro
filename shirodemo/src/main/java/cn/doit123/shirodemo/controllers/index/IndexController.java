package cn.doit123.shirodemo.controllers.index;

import org.apache.shiro.SecurityUtils;
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
		return "index";
	}
	
	@RequestMapping(value = "/unauthenticated", method = RequestMethod.GET)
	public String unauthenticated() {
		return "unauthenticated";
	}
}
