package cn.doit123.shirodemo.core.handlers;

import org.apache.log4j.Logger;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class AuthExceptionHandler {

	private static final Logger logger = Logger.getLogger(CommonExceptionHandler.class);
	
	@ExceptionHandler({UnauthorizedException.class})  
    @ResponseStatus(HttpStatus.UNAUTHORIZED)  
	public ModelAndView processUnauthenticatedException(
			NativeWebRequest request, UnauthorizedException e) {
		if (logger.isDebugEnabled()) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("errormsg", "Unauthorized");
		mv.setViewName("unauthorized");
		return mv;
	}
}
