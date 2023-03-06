package com.iu.s1.bankBook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.board.BbsDAO;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BbsService;
import com.iu.s1.util.Pager;

@Service
public class BankBookCommentService implements BbsService{
	
	@Autowired
	//어떤 클래스든 BbsDAO 를 상속받는 모든 것들도 다 가능 -> 변화가 많을 때
	private BbsDAO bankBookCommentDAO;
	
	
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		pager.makeRow();
		
		Long l =  bankBookCommentDAO.getTotalCount(pager);
		pager.makeNum(l);
		
		List<BbsDTO> ar =  bankBookCommentDAO.getBoardList(pager);
		
		return ar;
	}



	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		return bankBookCommentDAO.setBoardUpdate(bbsDTO);
	}


	@Override
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile[] multipartFiles, HttpSession session) throws Exception {
		return bankBookCommentDAO.setBoardAdd(bbsDTO);
	}

	@Override
	public int setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		return bankBookCommentDAO.setBoardDelete(bbsDTO);
	}	
	
	
}
