package com.iu.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class BankBookDAOTest extends MyTestCase {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Test
	public void getBankBookListTest() throws Exception {
		List<BankBookDTO> ar =  bankBookDAO.getBankBookList();
		
		assertNotEquals(0, ar.size());
	}
	
	@Test
	public void getBankBookDetailTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNum(10L);
		bankBookDTO = bankBookDAO.getBankBookDetail(bankBookDTO);
		
		assertNull(bankBookDTO);
	}

	@Test
	public void setBankBookAddTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNum(20L);
		bankBookDTO.setBookName("testbook");
		bankBookDTO.setBookDetail("testtest");
		bankBookDTO.setBookRate(1.2);
		bankBookDTO.setBookSale(0L);
		
		int result = bankBookDAO.setBankBookAdd(bankBookDTO);
		
		assertNotEquals(0, result);
	}
}
