package com.iu.s1.member;

import java.util.Iterator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	
	@RequestMapping(value = "memberAgree", method = RequestMethod.GET)
	public void setMemberAgree() throws Exception {
		
	}
	
	
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
	public ModelAndView getMemberLogin(ModelAndView modelAndView, HttpServletRequest request) throws Exception {
		modelAndView.setViewName("/member/memberLogin");
		
		Cookie [] cookies =  request.getCookies();
		
//		for(Cookie cookie : cookies) {
//			System.out.println(cookie.getName());
//			System.out.println(cookie.getValue());
//			System.out.println(cookie.getDomain());
//			System.out.println(cookie.getPath());
//			System.out.println("----------------------");
//			
//			if(cookie.getName().equals("rememberId")) {
//				modelAndView.addObject("rememberId", cookie.getValue());
//				break;
//			}
//		}
		
		return modelAndView;
	}
	
	@RequestMapping(value="memberLogin", method = RequestMethod.POST)
	public ModelAndView getMemberLogin(ModelAndView modelAndView , MemberDTO memberDTO, HttpServletRequest request, HttpServletResponse response, String remember) throws Exception {
		//로그인 유뮤와 상관없이 체크만 할 때
		//로그인 하고 기억하면 service갔따오고 넣어주면됨
		if(remember!=null && remember.equals("remember")) {
			Cookie cookie = new Cookie("rememberId", memberDTO.getId());
			cookie.setMaxAge(60*60*24*7); //초 단위
			//쿠기도 응답에 담아서 보내야되기 때문에 response로 담아서 보내줌
			response.addCookie(cookie);
			
		}else {
			Cookie cookie = new Cookie("rememberId", "");
			//setMaxAge(-1) => 영구히 저장
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
//		memberDTO= memberService.getMemberLogin(memberDTO);
//		if(memberDTO !=null) {
//			HttpSession session = request.getSession();
//			session.setAttribute("member", memberDTO);
//		}
		modelAndView.setViewName("redirect:../");
		return modelAndView;
	}
	
	
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
	
	public ModelAndView setMemberUpdate(MemberDTO memberDTO, ModelAndView modelAndView,HttpSession session) throws Exception {
		
		MemberDTO sessionMemberDTO = (MemberDTO) session.getAttribute("member");
		memberDTO.setId(sessionMemberDTO.getId());
		int result =  memberService.setMemberUpdate(memberDTO);
		//DB�� �����ϱ� ������ session�� ���� ������Ѵ�
		
		//�α����� �Ǹ� ���ο� memberDTO�� ������ ���� ����ߵȴ�
//		if(result > 0) {
//			session.setAttribute("member", memberDTO);
//		}
		modelAndView.setViewName("redirect:./memberPage");
		return modelAndView;
	}
}
