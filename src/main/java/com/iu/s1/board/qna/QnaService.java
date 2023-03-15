package com.iu.s1.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.board.BbsDAO;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.board.BoardService;
import com.iu.s1.util.FileManager;
import com.iu.s1.util.Pager;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private FileManager fileManager;
	
	

	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		pager.makeRow();
		
		pager.makeNum(qnaDAO.getTotalCount(pager));
		
		List<BbsDTO> ar =  qnaDAO.getBoardList(pager);
		return ar;
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile[] multipartFiles, HttpSession session) throws Exception {
		int result =  qnaDAO.setBoardAdd(bbsDTO);
		
		//file HDD에 저장
		String realPath =  session.getServletContext().getRealPath("resources/upload/qna/");
		System.out.println(realPath);
		
		for(MultipartFile multipartFile : multipartFiles) {
			if(multipartFile.isEmpty()) {
				continue;
				
			}
			String fileName =  fileManager.fileSave(multipartFile, realPath);
		
		
		
		//DB INSERT
		BoardFileDTO boardFileDTO = new BoardFileDTO();
		boardFileDTO.setNum(bbsDTO.getNum());
		boardFileDTO.setFileName(fileName);
		boardFileDTO.setOriName(multipartFile.getOriginalFilename());
		
		result = qnaDAO.setBoardFileAdd(boardFileDTO);
	  }
		
		return result;
	}

	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		
		return 0;
	}
	
	@Override
	public int setBoardUpdate(BbsDTO bbsDTO, MultipartFile[] multipartFiles, HttpSession session, Long[] fileNums)
			throws Exception {
		//qna update
		int result = qnaDAO.setBoardUpdate(bbsDTO);
		
		//qnaFiles Delete
		for (Long fileNum : fileNums) {
			qnaDAO.setBoardFileDelete(fileNum);
		}
		
		//qnaFiles Insert
		
		//file HDD에 저장
		String realPath =  session.getServletContext().getRealPath("resources/upload/qna/");
		System.out.println(realPath);
		
		for(MultipartFile multipartFile : multipartFiles) {
			if(multipartFile.isEmpty()) {
				continue;
				
			}
			String fileName =  fileManager.fileSave(multipartFile, realPath);
		
		
		
		//DB INSERT
		BoardFileDTO boardFileDTO = new BoardFileDTO();
		boardFileDTO.setNum(bbsDTO.getNum());
		boardFileDTO.setFileName(fileName);
		boardFileDTO.setOriName(multipartFile.getOriginalFilename());
		
		result = qnaDAO.setBoardFileAdd(boardFileDTO);

		
	}
		return result;
}		
	
	

	@Override
	public int setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		
		//cascading을 걸어놓으면 file이 지워지기 때문에 미리 조회를 함
		List<BoardFileDTO> ar= qnaDAO.getBoardFileList(bbsDTO);
		int result =  qnaDAO.setBoardDelete(bbsDTO);
		
		//하드디스크에 있는 파일을 삭제
		if(result > 0) {
			
			String realPath = session.getServletContext().getRealPath("resources/upload/qna/");
			
			for (BoardFileDTO boardFileDTO : ar) {
				boolean check =  fileManager.fileDelete(realPath,boardFileDTO.getFileName() );
			}
			
			
		}
		return result;
	}

	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		boardDTO =  qnaDAO.getBoardDetail(boardDTO);
		return boardDTO;
	}
	
	public int setReplyAdd(QnaDTO qnaDTO) throws Exception {
		//QnaDTO
		//num : 부모의 글번호
		//writer,title,contents: 답글로 입력한 값
		//ref : null
		//step " null
		//depth ;null
		//1.부모의 정보를 조회
		
		QnaDTO parent = (QnaDTO) qnaDAO.getBoardDetail(qnaDTO);
		
		//ref : 부모의 ref
		qnaDTO.setRef(parent.getRef());
		
		//step : 부모의 step+1
		qnaDTO.setStep(parent.getStep());
		
		//depth : 부모의 depth+1
		qnaDTO.setDepth(parent.getDepth() + 1);
		
		//2.Step update
		int result =  qnaDAO.setStepUpdate(parent);
		
		//3.답글 insert
		result =  qnaDAO.setReply(qnaDTO);
		
		return result;
		
	}

	@Override
	public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO) throws Exception {
		boardFileDTO =  qnaDAO.getBoardFileDetail(boardFileDTO);
		return boardFileDTO;
	}
	
	
}