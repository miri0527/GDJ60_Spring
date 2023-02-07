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
	
	// /product/list: 리스트조회 -> WEB-INF/views/product/productList.jsp
    // /product/productAdd : 상품등록 -> WEB-INF/views/product/productAdd.jsp
    // /product/update: 상품수정->WEB-INF/views/product/productUpdate.jsp
    // /product/delete: 상품삭제 
    // /product/detail: 상품하나조회 -> WEB-INF/views/product/productDetail.jsp
	
	@RequestMapping(value = "list")
	public ModelAndView getProductList(ModelAndView mv) throws Exception {
		//ModelAndView mv = new ModelAndView(); -> 객체를 만들어도 되고 매개변수로 받아도된다
		
		List<ProductDTO> ar =  productService.getProductList();
		
		System.out.println(ar.size() > 0);
		mv.setViewName("product/productList");
		mv.addObject("list", ar);
		return mv;
	}
	
	//getProductDetail
	@RequestMapping(value = "detail")
	//DispacherServlet에 request, response를 가지고 있기 때문에 controller로 request,response를 받을 수 있다
	/*(매개변수로 선언) 1.HttpServletRequest request, HttpServletResponse response*/
	//required :false -> 값이 안들어오면 defaultValue 값을 받고, 안들어오면 안받고, true면 값이 안들어오염 defaultValue값을 받고, 없으면 null값을 집어넣는다
	//(매개변수로 선언) 2.long num,@RequestParam(value = "n")String name, @RequestParam(value="a",defaultValue="1",int age required = false
	public String getProductDetail(ProductDTO productDTO, Model model ) throws Exception {
		//Model -> request처럼 jsp까지 데이터를 보내는 역할, 응답이 나가면 사라진다
		//파라미터의 이름과 setter의 이름이 값아야 함
		
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
	
	//uri경로가 같으면 리턴을 하지 않아도 자동으로 이름이 같은 jsp로 찾아가준다
	@RequestMapping(value = "productAdd", method = RequestMethod.GET)
	public void setProductAdd() {
		
	}
	
	//입력페이지를 받아주는 역할
	@RequestMapping(value = "productAdd", method = RequestMethod.POST)
	public String setProductAdd(ProductDTO productDTO) throws Exception {
		int result= productService.setProductAdd(productDTO, null);
		System.out.println(result == 1);
		//redirect : 사용자가 list로 다시 안해도 자동으로 list를 요청해주는 것
		String re = "redirect:./list";
		return re;
	}
	
	//String과 void 둘 다 리턴하면 뭘로 받아야할지 모른다 ->  그 때 modelAndView라는 타입으로 받는다
	//Controller에서 리턴하는게 modelAndView
	@RequestMapping(value = "update")
	public ModelAndView update() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/productUpdate");
		return mv;
	}
	
}
