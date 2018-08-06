package com.OoJou.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.OoJou.pojo.JSONResult;

/**
 * 可以和AJAXHandler类互换测试下，把@ControllerAdvice和@ExceptionHandler注释掉就不起作用了
 * @author www34
 *
 */
//@ControllerAdvice
public class ExceptionHandler {

	public static final String IMOOC_ERROR_VIEW = "error";

	/**
	 * @Description:@ControllerAdvice和@ExceptionHandler实现全局处理controller类异常
	 * 
	 * @param reqest
	 * @param response
	 * @param e
	 * @return
	 * @throws Exception
	 */
//	@ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest reqest, 
    		HttpServletResponse response, Exception e) throws Exception {
    	
    	e.printStackTrace();
    	
    	//以下就是整合ajax和web异常的方法，旧方法没有if判断
    	if (isAjax(reqest)) {
    		return JSONResult.errorException(e.getMessage());
    	} else {
    		ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", reqest.getRequestURL());
            mav.setViewName(IMOOC_ERROR_VIEW);
            return mav;
    	}
    }
	
	/**
	 * @Description: 判断是否是ajax请求
	 */
	public static boolean isAjax(HttpServletRequest httpRequest){
		return  (httpRequest.getHeader("X-Requested-With") != null  
					&& "XMLHttpRequest"
						.equals( httpRequest.getHeader("X-Requested-With").toString()) );
	}
}
