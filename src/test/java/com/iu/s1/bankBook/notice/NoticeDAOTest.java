package com.iu.s1.bankBook.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.notice.NoticeDAO;
import com.iu.s1.board.notice.NoticeDTO;
import com.iu.s1.util.Pager;

import junit.framework.TestCase;

public class NoticeDAOTest extends MyTestCase{
	@Autowired
	private NoticeDAO noticeDAO;

	@Test
	public void getBoardList() throws Exception {
		Pager pager  = new Pager();
		pager.setNum(35L);
		pager.setKind("writer");
		pager.setSearch("관리자");
		
		pager.makeRow();
		//long count = noticeDAO.getTotalCount(pager);
		List<BbsDTO> ar =  noticeDAO.getBoardList(pager);
		assertNotEquals(0, ar.size());
		
		//assertNotEquals(0, count );
		
		
	}
	

}
