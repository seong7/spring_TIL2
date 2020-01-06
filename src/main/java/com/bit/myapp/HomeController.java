package com.bit.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	/**
	 *  구동방식 : 
	 *  Web에서 요청이 들어오면 DispatcherServlet으로 들어온다.
	 *  DispatcherServlet에서 HandlerMapping에 컨트롤러 검색을 요청한다.
	 *  요청 url을 이용해서 처리할 Controller 객체를 찾아서 DispatcherServlet에 리턴해준다.
	 *  HandlerAdapter 객체에게 요청 처리를 위임한다.
	 *  RequestMapping에서 알맞은 메소드를 찾아서 요청을 처리한다
	 *  그 후 결과를 ModelAndView객체(현재는 연습으로 명시적으로 위치를 지정했음)에 담아서 DispatcherServlet에 리턴해준다.
	 *  Dispatcher에서 ViewResolver로 객체를 보낸다.
	 *   ViewResolver는 ModelAndView객체에 담겨있는 뷰 이름을 이용해서 View객체를 찾거나 없으면 생성해서 리턴해준다.
	 *   DispatcherServlet으로 리턴 되고 나서 리턴받은 View객체에 응답 결과 생성을 요청한다.(이때 jsp가 컴파일 됌)
	 *  
	 */
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
