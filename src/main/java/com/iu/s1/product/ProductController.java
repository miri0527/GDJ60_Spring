package com.iu.s1.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	//Controller -> 군인
	@Autowired
	private ProductService productService;
	
	// /product/list: 리스트 조회> WEB-INF/views/product/productList.jsp
    // /product/productAdd : 상품 등록 -> WEB-INF/views/product/productAdd.jsp
    // /product/update: 상품 수정->WEB-INF/views/product/productUpdate.jsp
    // /product/delete: 상품 삭제
    // /product/detail: 상품 상세보기 
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getProductList(ModelAndView mv) throws Exception {
		//뷰로 보낼때 크게 3가지 -> String, void,ModelAndView
		//void -> url경로와 파일명이 같을 떄 가능
		
		List<ProductDTO> ar =  productService.getProductList();
		
		System.out.println(ar.size() > 0);
		mv.setViewName("product/productList");
		mv.addObject("list", ar);
		return mv;
	}
	
	//getProductDetail
	@RequestMapping(value = "detail")
	
	//DispacherServlet에 request,response 객체가 들어있기 때문에  controller로 request,response를 받을 수 있다
	//1.(매개변수로 선언) HttpServletRequest request, HttpServletResponse response
	//required: 기본 값은 true, 필수가 아닌 파라미터는 false를 주면 됨 , 필수가 아닌 파라미터가 존재 하지 않을 경우는 null값 반환
	//하지만 null값이 들어올 수 없는 기본데이터타입이라면 에러 발생
	public String getProductDetail(ProductDTO productDTO, Model model ) throws Exception {
		//Model -> request처럼 jsp까지 데이터를 보내는 역할, 응답이 나가면 사라진다
		//파라미터 이름과 setter이름이 같아야함
		
		System.out.println("Product Detail");
		//String num =  request.getParameter("num");
		
		//ProductDTO productDTO = new ProductDTO();
		//productDTO.setProduct_num(Long.parseLong(num));
		//productDTO.setProduct_num(num);
		
		productDTO= productService.getProductDetail(productDTO);
		
		model.addAttribute("dto", productDTO);
		
		System.out.println(productDTO !=null);
		//System.out.println(age !=0);
		//System.out.println(name !=null);
		
		return "product/productDetail";
	}
	
	//uri 경로가 같으먄 리턴을 해주지 않아도 자동으로 이름이 같은 jsp파일로 찾아가준다
	@RequestMapping(value = "productAdd", method = RequestMethod.GET)
	public void setProductAdd() {
		
	}
	
	//입력을 받아주는 역할
	@RequestMapping(value = "productAdd", method = RequestMethod.POST)
	public String setProductAdd(ProductDTO productDTO) throws Exception {
		int result= productService.setProductAdd(productDTO,null);
		System.out.println(result == 1);
		//redirect : 사용자가 list로 다시 안가도 자동으로 list로 요청해주는 것
		String re = "redirect:./list";
		return re;
	}
	//String이나 void로 리턴하면 뭘로 받아주는 지 잘 모른다 -> 그럴 때 ModelAndView로 리턴
	//Controller에서 리턴하는 것이 ModelAndView
	@RequestMapping(value = "update")
	public ModelAndView update() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/productUpdate");
		return mv;
	}
	
}
