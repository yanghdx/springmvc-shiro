package cn.doit123.shirodemo.controllers.index;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.doit123.shirodemo.pojo.entity.SysUser;
import cn.doit123.shirodemo.services.sysuser.SysUserService;

@Controller
public class IndexController {

	@Autowired
	private SysUserService userService;
	
	//private ResService resService;
	
	@RequestMapping(value = "/index")
	public String index(SysUser user, Model model) {
		
		Set<String> menus = userService.findPermissions(user.getId());
		
		model.addAttribute("menus", menus);
		
		return "index";
	}
}
