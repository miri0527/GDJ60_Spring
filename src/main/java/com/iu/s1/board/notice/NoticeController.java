package com.iu.s1.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDAO;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BbsService;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.member.MemberDTO;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("boardName")
	public String getBoardName() {
		return "notice";
	}
	
	@GetMapping("listTop")
	public ModelAndView getBoardListTop(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		pager.setPerPage(5L);
		
		List<BbsDTO> ar =  noticeService.getBoardList(pager);
		mv.addObject("list", ar);
		mv.setViewName("common/noticeResult");
		
		return mv;
	}
	
	//Pager를 model에 넣어주고 보내주지 않았는데 작동되는 이유 :@ModelAttribute(noticeController)가 자동 생성
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBoardList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BbsDTO> ar = noticeService.getBoardList(pager);
		
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		return mv;
		
	}
	
	@PostMapping("delete")
	public ModelAndView setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("common/result");
		
		int result =  noticeService.setBoardDelete(bbsDTO,session);
		
		String message="삭제가 실패 하였습니다";

		if(result > 0) {
			message="삭제가 성공되었습니다";
		}
		
		mv.addObject("result", message);
		mv.addObject("url", "./list");
		return mv;
	}
	
	@GetMapping("add")
	public ModelAndView setBoardAdd() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/add");
		
		
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView setBoardAdd(NoticeDTO noticeDTO, MultipartFile [] files, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result =  noticeService.setBoardAdd(noticeDTO, files,session );
		
		String message = "등록 싫패";
		
		if(result > 0) {
			message = "글이 등록되었습니다";
		}
		
		mv.addObject("result", message);
		mv.setViewName("common/result");
		//현재위치에서 list로 
		mv.addObject("url", "./list");
		
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView getBoardDetail(NoticeDTO noticeDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		BoardDTO boardDTO = noticeService.getBoardDetail(noticeDTO);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@GetMapping("replay")
	public ModelAndView setReplayAdd(BoardDTO noticeDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/replay");
		mv.addObject("dto", noticeDTO);
		
		return mv;
		
	}
	
	@PostMapping("replay")
	public ModelAndView setReplayAdd(NoticeDTO noticeDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	
	@GetMapping("fileDown")
	public ModelAndView getFileDown(BoardFileDTO boardFileDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardFileDTO =  noticeService.getBoardFileDetail(boardFileDTO);
		
		mv.addObject("boardFile", boardFileDTO);
		//fileDownView라는 이름의 bean의 객체가 있는지 찾아봄 -> 없으면 원래대로 jsp를 찾으러감
		//있으면 fileDownView라는 객체를 가진 class로 감
		mv.setViewName("fileDownView");
		
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView setBoardUpdate(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO =  noticeService.getBoardDetail(boardDTO);
		
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/update");
		
		
		return mv;
	}
}
