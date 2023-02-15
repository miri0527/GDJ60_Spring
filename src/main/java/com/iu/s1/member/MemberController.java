package com.iu.s1.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;
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
	public ModelAndView getMemberLogin(ModelAndView modelAndView , MemberDTO memberDTO, HttpServletRequest request) throws Exception {
		memberDTO= memberService.getMemberLogin(memberDTO);
		if(memberDTO !=null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", memberDTO);
		}
		modelAndView.setViewName("redirect:../");
		return modelAndView;
	}
	
	//request로 굳이 꺼내지 않고 session으로 바로 꺼낼 수도 있다
	@RequestMapping(value="memberLogout", method = RequestMethod.GET)
	public ModelAndView getMemeberLogout(HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		session.invalidate();
		modelAndView.setViewName("redirect:../");
		return modelAndView;
	}
	
	@RequestMapping(value="memberPage", method =  RequestMethod.GET)
	public ModelAndView getMemberPage(HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		
		//id가 담겨져 있다 -> 주소
		memberDTO =  memberService.getMemberPage(memberDTO);
		
		modelAndView.addObject("dto", memberDTO);
		modelAndView.setViewName("/member/memberPage");
		return modelAndView;
	}
	
	@RequestMapping(value = "memberUpdate" , method = RequestMethod.GET)
	public ModelAndView setMemberUpdate(HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		memberDTO =  memberService.getMemberPage(memberDTO);
		modelAndView.addObject("dto", memberDTO);
		modelAndView.setViewName("/member/memberUpdate");
		return modelAndView;
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	//다른 사람이 수정을 하지 못하도록 session으로 꺼낸다
	public ModelAndView setMemberUpdate(MemberDTO memberDTO, ModelAndView modelAndView,HttpSession session) throws Exception {
		//덮어씌우면 안된다
		MemberDTO sessionMemberDTO = (MemberDTO) session.getAttribute("member");
		memberDTO.setId(sessionMemberDTO.getId());
		int result =  memberService.setMemberUpdate(memberDTO);
		//DB를 수정하기 때문에 session을 수정 해줘야한다
		
		//로그인이 되면 새로운 memberDTO로 세션을 수정 해줘야된다
//		if(result > 0) {
//			session.setAttribute("member", memberDTO);
//		}
		modelAndView.setViewName("redirect:./memberPage");
		return modelAndView;
	}
}
