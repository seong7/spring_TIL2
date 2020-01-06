package com.bit.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	
	@RequestMapping(value="member/loginForm")
	public String loginForm(HttpServletRequest req, Model model) {  // req : 요청에 사용 |  model : 응답에 사용
		String id = req.getParameter("id");
		return "member/loginForm";   // .jsp 가 생략됨
	}
	
	@RequestMapping(value="member/confirmId")
	public String confirmId(HttpServletRequest req, Model model) {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		model.addAttribute("id", id);
		model.addAttribute("pwd", pwd);
		return "member/confirmId";  // member/confirmId.jsp 확인
	}
	
	@RequestMapping(value="member/confirmId1")
	public String confirmId1(@RequestParam("id") String id, @RequestParam("pwd") String pwd, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pwd", pwd);
		return "member/confirmId";  // member/confirmId.jsp 확인
	}
	
	@RequestMapping(value="member/joinForm")
	public ModelAndView joinForm() {
		ModelAndView model = new ModelAndView("member/joinForm");
		return model;
	}
}
