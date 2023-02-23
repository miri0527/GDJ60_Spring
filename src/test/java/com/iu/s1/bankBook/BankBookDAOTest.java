package com.iu.s1.bankBook;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.bankBook.BankBookDAO;
import com.iu.s1.bankBook.BankBookDTO;

public class BankBookDAOTest extends MyTestCase {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
//	@Test
	public void getBankBookListTest() throws Exception {
		List<BankBookDTO> ar =  bankBookDAO.getBankBookList(null);
		//Test������ ����ϴ� ar.size�� 0�� �ƴϸ� true
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void getBankBookDetailTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNum(10L);
		bankBookDTO = bankBookDAO.getBankBookDetail(bankBookDTO);
		
		assertNull(bankBookDTO);
	}

	@Test
	public void setBankBookAddTest() throws Exception {
		for(int i=0; i<30; i++) {
			Random r = new Random();
			double d =  r.nextDouble();
			int num = (int)d*1000;
			d = num/100.0;
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookName("īī����ũ" + i);
			bankBookDTO.setBookDetail("testtest"+ i);
			bankBookDTO.setBookRate(d);
			bankBookDTO.setBookSale(0L);
			
			int result =  bankBookDAO.setBankBookAdd(bankBookDTO);
			
			
		}
		
		
		
	}
}
