package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	// /product/list: 리스트조회 -> WEB-INF/views/product/productList.jsp
    // /product/productAdd : 상품등록 -> WEB-INF/views/product/productAdd.jsp
    // /product/update: 상품수정->WEB-INF/views/product/productUpdate.jsp
    // /product/delete: 상품삭제 
    // /product/detail: 상품하나조회 -> WEB-INF/views/product/productDetail.jsp
	
	@RequestMapping(value = "list")
	public String getProductList() throws Exception {
		List<ProductDTO> ar =  productService.getProductList();
		
		System.out.println(ar.size() > 0);
		return "product/productList";
	}
	
	//getProductDetail
	@RequestMapping(value = "detail")
	public String getProductDetail() {
		System.out.println("Product Detail");
		return "product/productDetail";
	}
	
	//uri경로가 같으면 리턴을 하지 않아도 자동으로 이름이 같은 jsp로 찾아가준다
	@RequestMapping(value = "productAdd")
	public void productAdd() {
		System.out.println("Product Add");
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
