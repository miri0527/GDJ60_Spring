package com.iu.s1.board;

import java.util.List;

import com.iu.s1.util.Pager;

public interface BbsDAO {
	
	//totalCount
	public Long getTotalCount(Pager pager) throws Exception;
	
	//list -> 모든 것들의 부모는 BbsDTO이기 때문에(Bbs 타입) Bbs타입으로 list  
	public List<BbsDTO> getBoardList(Pager pager) throws Exception;
	
	//insert(add)
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception;
	
	//update
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception;
	
	//delete
	public int setBoardDelete(BbsDTO bbsDTO) throws Exception;

	
	
}
