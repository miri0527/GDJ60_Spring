package com.iu.s1.board.qna;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BbsService;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.board.BoardService;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	
	//list.jsp에 qna를 뿌려주고 싶을 때
	@ModelAttribute("boardName") //보내 줄 속성 이름
	public String getBoardName() {
		return "qna";
	}
	
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBoardList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BbsDTO > ar =  qnaService.getBoardList(pager);
		
//		ar = null;
//		ar.size();
		
		//notice와 같은 곳으로 가기 때문에 notice jsp에서 받아주는 list라는 이름으로 보내줘야된다 
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		
		RestTemplate restTemplate = new RestTemplate();
		
		//URL, Method, parameter, header
		
		
		//Header
		HttpHeaders headers = new HttpHeaders();
		//add와 set 저 방식이 같음
		
		//headers.add("header명", "header값");
		headers.add("Content-Type", "application/x-www-form-urlencoded");
		//headers.set헤더명("header값");
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		//parameter(get) -> url뒤에 넣기
		//parameter(post)
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		//params.add("파라미터명", "파라미터값");
		params.add("grant_type", "authorization_code");
		params.add("client_id", "${REST_API_KEY}");
		
		//header, params 하나의 객체로 생성
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String,String>>(params, headers);
		
		
		//String result = restTemplate.getForObject("https://dummyjson.com/products/1", String.class, request);
		String result =  restTemplate.postForObject("https://dummyjson.com/products/1", request, String.class);
		System.out.println(result);
		
		
		return mv;
	}
	
	@GetMapping("add")
	public ModelAndView setBoardAdd() throws Exception {
		ModelAndView mv = new  ModelAndView();
		
		mv.setViewName("board/add");
		
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView setBoardAdd(QnaDTO  qnaDTO, MultipartFile[] addFiles, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result =  qnaService.setBoardAdd(qnaDTO,addFiles,session );
		String message = "등록 실패";
		
		if(result > 0) {
			message = "글이 등록되었습니다";
		}
		
		mv.addObject("result",message);
		mv.setViewName("common/result");
		mv.addObject("url", "./list");
		
		return mv;
		
	}
	
	@GetMapping("detail")
	public ModelAndView getBoardDetail(QnaDTO  qnaDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		BoardDTO boardDTO =  qnaService.getBoardDetail(qnaDTO);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/detail");
		
		return mv;
	}
	
	@GetMapping("replay")
	public ModelAndView setReplayAdd(BoardDTO qnaDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		
		mv.setViewName("board/replay");
		mv.addObject("dto", qnaDTO);
		return mv;
	}
	
	@PostMapping("replay")
	public ModelAndView setReplayAdd(QnaDTO qnaDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result =  qnaService.setReplyAdd(qnaDTO);
		String msg = "등록 실패";
		
		if(result > 0) {
			msg = "글이 등록되었습니다";
		}
		
		mv.addObject("result", msg);
		mv.addObject("url", "./detail?num=" + qnaDTO.getNum());
		mv.setViewName("common/result");
		return mv;
	}
	
	@PostMapping("delete")
	//뭐로 받은 num만 있으면 됨
	public ModelAndView setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/result");
		
		int result =  qnaService.setBoardDelete(bbsDTO,session);
		
		String message="삭제가 실패 하였습니다";

		if(result > 0) {
			message="삭제가 성공되었습니다";
		}
		
		mv.addObject("result", message);
		mv.addObject("url", "./list");
		return mv;
	}
	
	@GetMapping("fileDown")
	public ModelAndView getFileDown(BoardFileDTO boardFileDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardFileDTO =  qnaService.getBoardFileDetail(boardFileDTO);
		
		mv.addObject("boardFile", boardFileDTO);
		//fileDownView라는 이름의 bean의 객체가 있는지 찾아봄 -> 없으면 원래대로 jsp를 찾으러감
		//있으면 fileDownView라는 객체를 가진 class로 감
		mv.setViewName("fileDownView");
		
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView setBoardUpdate(BoardDTO boardDTO) throws Exception {
		 ModelAndView mv = new ModelAndView();
		 boardDTO =  qnaService.getBoardDetail(boardDTO);
		 
		 mv.addObject("dto", boardDTO);
		 
		 mv.setViewName("board/update");
		 
		 return mv;
		 
		 
	}
	
	@PostMapping("update")
	public ModelAndView setBoardUpdate(BoardDTO boardDTO, MultipartFile [] addFiles, HttpSession session, Long [] fileNum) throws Exception {
		 ModelAndView mv = new ModelAndView();
//		 System.out.println("FileNum 출력");
//		 for(Long fn : fileNum) {
//			 System.out.println(fn);
//		 }
		 
		 int result =  qnaService.setBoardUpdate(boardDTO, addFiles, session, fileNum);
		 
		 mv.setViewName("common/result");
		 mv.addObject("result", "수정 성공");
		 mv.addObject("url", "./list");
		 
		 return mv;
		 
		 
	}
	
	//---------------------------------------------------------------------------------
	
//	@ExceptionHandler(NullPointerException.class)
//	public ModelAndView fixException() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("message", "잘못된 접근입니다<br>관리자에게 문의 하세요");
//		mv.setViewName("common/error_500");
//		
//		return mv;
//	}
//	
//	@ExceptionHandler(Exception.class)
//	public ModelAndView fix2Exception() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("message", "잘못된 접근입니다<br>관리자에게 문의 하세요");
//		mv.setViewName("common/error_500");
//		
//		return mv;
//	}
	
	
	
	

}
