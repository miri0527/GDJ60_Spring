package com.iu.s1.interceptors;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.notice.NoticeDAO;
import com.iu.s1.board.notice.NoticeDTO;
import com.iu.s1.board.qna.QnaDAO;
import com.iu.s1.member.MemberDTO;

@Component
public class OwnerCheckInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private QnaDAO qnaDAO;

	@Autowired
	private NoticeDAO noticeDAO;
	
	//update에서만 사용할 것이 아니라 delete에서도 쓰기 위해서 pre로 함
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//String에서 Long타입으로 타입변경
		Long num = Long.parseLong(request.getParameter("num"));
		
		System.out.println("URI:"  + request.getRequestURI());
		System.out.println("PathInfo : " + request.getPathInfo());
		System.out.println("Servlet path : " +  request.getServletPath());
		
		String uri = request.getRequestURI();
		uri =  uri.substring(1, uri.lastIndexOf("/"));
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(num);
		
		if(uri.equals("notice")) {
			boardDTO = noticeDAO.getBoardDetail(boardDTO);
		}else {
			boardDTO = qnaDAO.getBoardDetail(boardDTO);
		}
		
		MemberDTO memberDTO = (MemberDTO) request.getSession().getAttribute("member");
		
		
		if(!memberDTO.getId().equals(boardDTO.getWriter())) {
			request.setAttribute("result", "작성자만 가능");
			request.setAttribute("url", "./list");
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
			
			return false;
		}
		
		return true;
	}
	
	//parameter는 num을 받는데, num만으로는 작성자를 찾을 수 없기 때문에 db를 거쳐서 return하여 DS로 와야지 작성자를 알 수 있기 때문에
	//pre가 아니라 post를 받는다
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		
//		System.out.println("Owner Check Interceptor");
//		
//		//1. 로그인
//		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
//		
//		//2. BoardDTO
//		Map<String, Object> map = modelAndView.getModel();
//		BoardDTO boardDTO = (BoardDTO)map.get("dto");
//		//map.keySet().iterator();
//		
//		//3. check
//		if(memberDTO==null ||  !boardDTO.getWriter().equals(memberDTO.getId())) {
//			modelAndView.setViewName("common/result");
//			modelAndView.addObject("result", "작성자만 가능");
//			modelAndView.addObject("url", "./list");
//		}
//		
//	}
}
