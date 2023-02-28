package com.iu.s1.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class TestFilter
 */
//DispatcherServlet 앞에 실행되는 클래스
//톰캣이 호출 -> web.xml
public class TestFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TestFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// 해당 필터 객체가 소멸 시 실행하는 메서드
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		System.out.println("TestFilter In");
		
		HttpServletRequest req = (HttpServletRequest) request;
		//null만 아니면 되기 때문에 굳이 MemberDTO타입으로 바꿔서 형변환 해 줄 필요가 없다
		Object obj = req.getSession().getAttribute("member");
		
		req.getRequestURI(); //   /qna/list
		
		if(obj !=null) {
			// 다음 필터가 있으면 다음 필터로 이동하고, 다음 필터가 없으면 Dispatcher로 이동
			chain.doFilter(request, response);
		}else {
//			HttpServletResponse res = (HttpServletResponse) response;
//			res.sendRedirect("../member/memberLogin");
			
			request.setAttribute("result", "권한이 없습니다");
			request.setAttribute("url", "../member/memberLogin");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
			
			
		}
		
		
		
		// 응답 시 실행 되는 영역
		System.out.println("TestFilter Out");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// Filter 객체가 생성 시 실행되는 메서드
	}

}
