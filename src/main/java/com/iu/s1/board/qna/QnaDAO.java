package com.iu.s1.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.board.BbsDAO;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BoardDAO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.util.Pager;

@Repository
public class QnaDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPLACE="com.iu.s1.board.qna.QnaDAO.";

	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		Long l =  sqlSession.selectOne(NAMESPLACE + "getTotalCount", pager);
		return l;
	}

	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		List<BbsDTO> ar =  sqlSession.selectList(NAMESPLACE + "getBoardList", pager);
		return ar;
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception {
		int result =  sqlSession.insert(NAMESPLACE + "setBoardAdd", bbsDTO);
		return result;
	}
	
	

	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBoardDelete(BbsDTO bbsDTO) throws Exception {
		return sqlSession.delete(NAMESPLACE + "setBoardDelete", bbsDTO);
	}

	
	
	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPLACE + "getBoardDetail", boardDTO);
	}
	
	public int setStepUpdate(QnaDTO qnaDTO) throws Exception {
		return sqlSession.update(NAMESPLACE + "setStepUpdate", qnaDTO);
	}

	
	public int setReply (QnaDTO qnaDTO) throws Exception {
		return sqlSession.insert(NAMESPLACE + "setReplay", qnaDTO);
	}

	@Override
	public int setBoardFileAdd(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.insert(NAMESPLACE + "setBoardFileAdd", boardFileDTO);
	}

	@Override
	public List<BoardFileDTO> getBoardFileList(BbsDTO bbsDTO) throws Exception {
		return sqlSession.selectList(NAMESPLACE + "getBoardFileList", bbsDTO);
	}

	
	
}
