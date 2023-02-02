package com.iu.s1.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	//Controller -> Service -> Service는 DAO에 의존적 -> DAO 호출 -> 다시 역순
	private MemberService memberService;
	private MemberDTO memberDTO;
	
	@RequestMapping(value = "/memberJoin")
	public String memberJoin() throws Exception {
		int result= memberService.memberJoin(memberDTO);
		return "member/memberJoin";
	}
	
	@RequestMapping(value = "/memberLogin")
	public void memberLogin() {
		
	}
	
	@RequestMapping(value = "/memberPage")
	public ModelAndView memberPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberPage");
		return mv;
	}
	
	
	
}
