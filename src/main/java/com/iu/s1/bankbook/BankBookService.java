package com.iu.s1.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.util.Pager;

@Service
public class BankBookService {
	@Autowired
	private BankBookDAO bankBookDAO;
	
	//리스트에서 보기 때문에 Service에서는 dao list로 호출
	public List<BankBookDTO> getBankBookList(Pager pager) throws Exception {
		
		Long totalCount = bankBookDAO.getBankBookCount();
		
		pager.makeNum(totalCount);
		pager.makeRow();
		
		List<BankBookDTO> ar= bankBookDAO.getBankBookList(pager);
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
