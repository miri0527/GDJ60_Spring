package com.iu.s1.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankBookService {
	@Autowired
	private BankBookDAO bankBookDAO;
	
	public List<BankBookDTO> getBankBookList() throws Exception {
		List<BankBookDTO> ar= bankBookDAO.getBankBookList();
		return ar;
	}
	
	public BankBookDTO getBankBookDetail(BankBookDTO bankBookDTO) throws Exception {
		bankBookDTO =  bankBookDAO.getBankBookDetail(bankBookDTO);
		return bankBookDTO;
	}
	
	public int setBankBookAdd(BankBookDTO bankBookDTO) throws Exception {
		int result =  bankBookDAO.setBankBookAdd(bankBookDTO);
		return result;
	}
	
	public int setBankBookUpdate(BankBookDTO bankBookDTO) throws Exception {
		int result= bankBookDAO.setBankBookUpdate(bankBookDTO);
		return result;
	}
	
	public int setBankBookDelete(BankBookDTO bankBookDTO) throws Exception {
		int result =  bankBookDAO.setBankBookDelete(bankBookDTO);
		return result;
	}
	
}
