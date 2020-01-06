package com.bit.myapp;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RandomController{
	
	@RequestMapping(value = "/random")
	public String random(Model model) {
		Random r = new Random();
		int lucky = r.nextInt(45)+1;
		model.addAttribute("Lucky", lucky);
		return "random";  // random.jsp 호출하는 코드
	}
	
}