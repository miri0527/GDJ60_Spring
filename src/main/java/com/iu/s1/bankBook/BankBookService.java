package com.iu.s1.bankBook;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.util.FileManager;
import com.iu.s1.util.Pager;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	//testcase �׽�Ʈ�� Null�� ����
	//API �߰�
	//@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private FileManager fileManager;
	
	public List<BankBookDTO> getBankBookList(Pager pager)throws Exception{
		
		Long totalCount = bankBookDAO.getBankBookCount(pager);//30
		
		pager.makeNum(totalCount);
		pager.makeRow();
		
		return bankBookDAO.getBankBookList(pager);
	}
	
	public BankBookDTO getBankBookDetail(BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.getBankBookDetail(bankBookDTO);
	}
	
	public int setBankBookAdd(BankBookDTO bankBookDTO, MultipartFile pic )throws Exception{
		int result= bankBookDAO.setBankBookAdd(bankBookDTO);
		
		if(pic.isEmpty()) { //pic.getSize() !=0
		
		
		String realPath = servletContext.getRealPath("resources/upload/bankBook");
		System.out.println(realPath);
		String fileName = fileManager.fileSave(pic, realPath);
		
		
		BankBookImgDTO bankBookImgDTO = new BankBookImgDTO();
		bankBookImgDTO.setFileName(fileName);
		bankBookImgDTO.setOriName(pic.getOriginalFilename());
		bankBookImgDTO.setBookNum(bankBookDTO.getBookNum());
		
		result = bankBookDAO.setBankBookImgAdd(bankBookImgDTO);
		}		
		
		return result;//bankBookDAO.setBankBookAdd(bankBookDTO);
	}
	
	public int setBankBookUpdate(BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.setBankBookUpdate(bankBookDTO);
	}
	
	public int setBankBookDelete(BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.setBankBookDelete(bankBookDTO);
	}

}