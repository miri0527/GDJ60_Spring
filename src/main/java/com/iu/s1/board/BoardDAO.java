package com.iu.s1.board;

import com.iu.s1.util.Pager;

public interface BoardDAO extends BbsDAO{
	
	public BoardDTO getBoardDetail (BoardDTO boardDTO) throws Exception;
	
	
}
