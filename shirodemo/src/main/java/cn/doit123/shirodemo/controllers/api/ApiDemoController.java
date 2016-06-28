package cn.doit123.shirodemo.controllers.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.doit123.shirodemo.pojo.entity.SysUser;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


@Api(value="Api-demo", description="This is api demo.", basePath="/api")
@Controller
@RequestMapping(value = "/api")
public class ApiDemoController {

	@ApiOperation(value="根据用户ID获取详细信息", httpMethod="GET", notes="根据用户ID获取详细信息")
	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public SysUser userDetail(
			@ApiParam(required = true, name = "userId", value = "用户ID")
			@PathVariable Integer userId) {
		return new SysUser();
	}
}
