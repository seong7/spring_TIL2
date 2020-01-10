package com.bit.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.myapp.dto.MemberDto;

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
	
///////////////////////////////////아래는 공부 필요//////	
///////////////////////////////////아래는 공부 필요//////	
///////////////////////////////////아래는 공부 필요//////	

	
	@RequestMapping("member/join")
	public String join(@RequestParam("id") String id,
			@RequestParam("pwd")String pwd,
			@RequestParam("name")String name,
			@RequestParam("email")String email, 
			Model model) {
		MemberDto dto = new MemberDto();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setName(name);
		dto.setEmail(email);
		model.addAttribute("member", dto);
		return "member/join";//member/join.jsp
	}
	
	@RequestMapping(value = "member/join1")
	/*1.	JSP에서 MemberDto 가져온다.(자동적으로 setter 호출 값이 저장)
	 * 2. model.addAttribute("member", member)
	 * */
	public String join1(@ModelAttribute("member") 
				MemberDto member) {
		return "member/join";
	}
	
	//member/student/aaa/9123033   : "?studentID="  / "?num=" 표시 안하는 방법  ***********
	@RequestMapping(value = "member/student/{studentId}/{num}")
	public String student(@PathVariable String studentId,
			@PathVariable int num, Model model) {
		model.addAttribute("studentId", studentId);
		model.addAttribute("num", num);
		return "member/student";//member/student.jsp
	}
	
	@RequestMapping("member/getPostForm")
	public String getPostForm() {
		//WEB-INf/views/member/getPostForm.jsp 호출
		return "member/getPostForm";
	}
	
	@RequestMapping(value = "member/goGet", method=RequestMethod.GET)
	public String goStudent(HttpServletRequest req,
			Model model) {
		String id = req.getParameter("id");
		model.addAttribute("id", id);
		return "member/goGet";
	}
	
	@RequestMapping(value = "member/goPost", method = RequestMethod.POST)
	public ModelAndView goStudent(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String id = req.getParameter("id");
		mv.addObject("id", id);
		mv.setViewName("member/getGet");
		return mv;
	}
}
