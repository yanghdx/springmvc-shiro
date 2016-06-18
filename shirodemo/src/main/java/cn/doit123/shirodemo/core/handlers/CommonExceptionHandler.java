package cn.doit123.shirodemo.core.handlers;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionHandler {

	private static final Logger logger = Logger.getLogger(CommonExceptionHandler.class);
	
	@ExceptionHandler({Exception.class})  
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  
	public ModelAndView processException(
			NativeWebRequest request, Exception e) {
		
		e.printStackTrace();
		logger.error(e.getMessage(), e);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("errormsg", "Server Error");
		mv.setViewName("error");
		return mv;
	}
}
