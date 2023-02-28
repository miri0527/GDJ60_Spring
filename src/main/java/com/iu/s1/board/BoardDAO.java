package com.iu.s1.board;

import java.util.List;

import com.iu.s1.util.Pager;

public interface BoardDAO extends BbsDAO{
	
	//detail
	public BoardDTO getBoardDetail (BoardDTO boardDTO) throws Exception;
	
	//fileAdd
	public int setBoardFileAdd(BoardFileDTO boardFileDTO) throws Exception;
	
	//update
	
	//delete
	
	//BoardFileList
	public List<BoardFileDTO> getBoardFileList(BbsDTO bbsDTO) throws Exception;
	
	//BoardFileDetail -> FileNum 한 개 조회
	public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO) throws Exception;
	
}
