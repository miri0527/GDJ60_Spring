package com.iu.s1.board;

import java.util.List;

import com.iu.s1.util.Pager;

public interface BbsService {
	//list
	public List<BbsDTO> getBoardList(Pager pager) throws Exception;
	
	//insert
	public int setBoardAdd(Pager pager) throws Exception;
	
	//update
	public int setBoardUpdate(Pager pager) throws Exception;
	
	//delete
	public int setBoardDelete(Pager pager) throws Exception;
}
