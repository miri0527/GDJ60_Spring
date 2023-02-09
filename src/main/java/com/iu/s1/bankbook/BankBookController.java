package com.iu.s1.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/bankBook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView getBankBookList(ModelAndView modelAndView) throws Exception {
		List<BankBookDTO> ar =  bankBookService.getBankBookList();
		modelAndView.setViewName("bankBook/list");
		modelAndView.addObject("list",ar);
		return modelAndView;
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	//parameter로 bookNum이지만, 한번에 bankBookDTO로 받아온다
	public ModelAndView getBankBookDetail(ModelAndView modelAndView,BankBookDTO bankBookDTO) throws Exception {
		bankBookDTO =  bankBookService.getBankBookDetail(bankBookDTO);
		modelAndView.setViewName("bankBook/detail");
		modelAndView.addObject("dto", bankBookDTO);
		return modelAndView;
		
	}
	
	@RequestMapping(value="add", method = RequestMethod.GET)
	public ModelAndView setBankBookAdd(ModelAndView modelAndView) throws Exception {
		modelAndView.setViewName("bankBook/add");
		return modelAndView;
	}
	
//	@RequestMapping(value="add", method=RequestMethod.POST)
//	public String setBankBookAdd(BankBookDTO bankBookDTO) throws Exception {
//		int result =  bankBookService.setBankBookAdd(bankBookDTO);
//		return "redirect:./list";
//	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public ModelAndView setBankBookAdd(ModelAndView modelAndView, BankBookDTO bankBookDTO) throws Exception {
		int result= bankBookService.setBankBookAdd(bankBookDTO);
		modelAndView.setViewName("redirect:./list");
		modelAndView.addObject("dto", bankBookDTO);
		return modelAndView;
	}
	
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public ModelAndView setBankBookDelete(ModelAndView modelAndView, BankBookDTO bankBookDTO) throws Exception {
		int result =  bankBookService.setBankBookDelete(bankBookDTO);
		modelAndView.setViewName("redirect:./list");
		
		return modelAndView;
	}
	
	//수정 폼 이동
	@RequestMapping(value="update", method = RequestMethod.GET)
	public ModelAndView setBankBookUpdate(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		bankBookDTO= bankBookService.getBankBookDetail(bankBookDTO);
		modelAndView.setViewName("bankBook/update");
		modelAndView.addObject("dto",bankBookDTO);
		return modelAndView;
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST )
	public ModelAndView setBankBookUpdate(BankBookDTO bankBookDTO, ModelAndView modelAndView) throws Exception {
		int result= bankBookService.setBankBookUpdate(bankBookDTO);
		modelAndView.setViewName("redirect:./list");
		modelAndView.addObject("dto", bankBookDTO);
		return modelAndView;
	}
	
}
