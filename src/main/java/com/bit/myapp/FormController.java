package com.bit.myapp;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FormController {

	@RequestMapping(value="/list")   // method 부분은 get 방식일 경우 생략 가능
	public String list(HttpServletRequest req, Model model) {
		String name = req.getParameter("name");
		model.addAttribute("name", name);
		return "list"; //  views/list.jsp 호출함
	}

}
