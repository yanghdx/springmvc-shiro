package cn.doit123.shirodemo.controllers.user;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	
	@RequestMapping(value = "/users")
	@RequiresPermissions("user:view")
	public String users() {
		return "users";
	}
}
