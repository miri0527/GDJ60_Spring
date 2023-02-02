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
	
	// /product/list: ����Ʈ��ȸ -> WEB-INF/views/product/productList.jsp
    // /product/productAdd : ��ǰ��� -> WEB-INF/views/product/productAdd.jsp
    // /product/update: ��ǰ����->WEB-INF/views/product/productUpdate.jsp
    // /product/delete: ��ǰ���� 
    // /product/detail: ��ǰ�ϳ���ȸ -> WEB-INF/views/product/productDetail.jsp
	
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
	
	//uri��ΰ� ������ ������ ���� �ʾƵ� �ڵ����� �̸��� ���� jsp�� ã�ư��ش�
	@RequestMapping(value = "productAdd")
	public void productAdd() {
		System.out.println("Product Add");
	}
	
	//String�� void �� �� �����ϸ� ���� �޾ƾ����� �𸥴� ->  �� �� modelAndView��� Ÿ������ �޴´�
	//Controller���� �����ϴ°� modelAndView
	@RequestMapping(value = "update")
	public ModelAndView update() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/productUpdate");
		return mv;
	}
	
}
