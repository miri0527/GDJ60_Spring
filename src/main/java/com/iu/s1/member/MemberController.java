package com.iu.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "memberAdd", method = RequestMethod.GET)
	public ModelAndView setMemberAdd()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/member/memberAdd");
		return mv;
	}
	
	@RequestMapping(value = "memberAdd", method = RequestMethod.POST)
	public ModelAndView setMemberAdd(MemberDTO memberDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = memberService.setMemberAdd(memberDTO);
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@RequestMapping(value = "memberLogin", method=RequestMethod.GET)
	public ModelAndView getMemberLogin(ModelAndView modelAndView) throws Exception {
		modelAndView.setViewName("/member/memberLogin");
		return modelAndView;
	}
	
	@RequestMapping(value="memberLogin", method = RequestMethod.POST)
	public ModelAndView getMemberLogin(ModelAndView modelAndView , MemberDTO memberDTO) throws Exception {
		memberDTO= memberService.getMemberLogin(memberDTO);
		modelAndView.setViewName("redirect:../");
		return modelAndView;
	}
}
