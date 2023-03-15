package com.iu.s1.bankBook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.util.Pager;

@Controller
@RequestMapping(value = "/bankBook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView getBankBookList(ModelAndView modelAndView, Pager pager) throws Exception {
		
		                                                        //pager��� �������� �ּҸ� ����
		List<BankBookDTO> ar =  bankBookService.getBankBookList(pager);
		
		
		modelAndView.setViewName("bankBook/list");
		modelAndView.addObject("list",ar);
		//여기도 자동 생성되기 때문에 굳이 model에 담고 pager를 보내 줄 필요가 없다
		modelAndView.addObject("pager", pager);
		return modelAndView;
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
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
	
	//add DB Insert
   @RequestMapping(value = "add", method = RequestMethod.POST)
   public ModelAndView setBankbookAdd(BankBookDTO bankbookDTO, MultipartFile pic, HttpSession Session) throws Exception {
      ModelAndView modelAndView = new ModelAndView();
      
      System.out.println("Name : " + pic.getName());
      System.out.println("Original File Name : " + pic.getOriginalFilename());
      System.out.println("Size : " + pic.getSize());
      System.out.println(Session.getServletContext());
      
      int result = bankBookService.setBankBookAdd(bankbookDTO, pic);
      modelAndView.setViewName("redirect:./list");
      return modelAndView;
   }
	
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public ModelAndView setBankBookDelete(ModelAndView modelAndView, BankBookDTO bankBookDTO) throws Exception {
		int result =  bankBookService.setBankBookDelete(bankBookDTO);
		modelAndView.setViewName("redirect:./list");
		
		return modelAndView;
	}
	
	//���� �� �̵�
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
