package cn.doit123.shirodemo.controllers.user;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/users")
public class UserController {

	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@RequiresPermissions("user:view")
	public String users() {
		return "users";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@RequiresPermissions("user:add")
	public String userAdd() {
		return "user-add";
	}
}
