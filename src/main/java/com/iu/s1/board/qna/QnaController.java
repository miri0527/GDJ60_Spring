package com.iu.s1.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BbsService;
import com.iu.s1.board.BoardDTO;
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
		//notice와 같은 곳으로 가기 때문에 notice jsp에서 받아주는 list라는 이름으로 보내줘야된다 
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	@GetMapping("add")
	public ModelAndView setBoardAdd() throws Exception {
		ModelAndView mv = new  ModelAndView();
		
		mv.setViewName("board/add");
		
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView setBoardAdd(QnaDTO  qnaDTO, MultipartFile[] files, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result =  qnaService.setBoardAdd(qnaDTO,files,session );
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

}
