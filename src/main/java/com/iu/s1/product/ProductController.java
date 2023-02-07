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
	
	//Controller -> ����
	@Autowired
	private ProductService productService;
	
	// /product/list: ����Ʈ��ȸ -> WEB-INF/views/product/productList.jsp
    // /product/productAdd : ��ǰ��� -> WEB-INF/views/product/productAdd.jsp
    // /product/update: ��ǰ����->WEB-INF/views/product/productUpdate.jsp
    // /product/delete: ��ǰ���� 
    // /product/detail: ��ǰ�ϳ���ȸ -> WEB-INF/views/product/productDetail.jsp
	
	@RequestMapping(value = "list")
	public ModelAndView getProductList(ModelAndView mv) throws Exception {
		//ModelAndView mv = new ModelAndView(); -> ��ü�� ���� �ǰ� �Ű������� �޾Ƶ��ȴ�
		
		List<ProductDTO> ar =  productService.getProductList();
		
		System.out.println(ar.size() > 0);
		mv.setViewName("product/productList");
		mv.addObject("list", ar);
		return mv;
	}
	
	//getProductDetail
	@RequestMapping(value = "detail")
	//DispacherServlet�� request, response�� ������ �ֱ� ������ controller�� request,response�� ���� �� �ִ�
	/*(�Ű������� ����) 1.HttpServletRequest request, HttpServletResponse response*/
	//required :false -> ���� �ȵ����� defaultValue ���� �ް�, �ȵ����� �ȹް�, true�� ���� �ȵ����� defaultValue���� �ް�, ������ null���� ����ִ´�
	//(�Ű������� ����) 2.long num,@RequestParam(value = "n")String name, @RequestParam(value="a",defaultValue="1",int age required = false
	public String getProductDetail(ProductDTO productDTO, Model model ) throws Exception {
		//Model -> requestó�� jsp���� �����͸� ������ ����, ������ ������ �������
		//�Ķ������ �̸��� setter�� �̸��� ���ƾ� ��
		
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
	
	//uri��ΰ� ������ ������ ���� �ʾƵ� �ڵ����� �̸��� ���� jsp�� ã�ư��ش�
	@RequestMapping(value = "productAdd", method = RequestMethod.GET)
	public void setProductAdd() {
		
	}
	
	//�Է��������� �޾��ִ� ����
	@RequestMapping(value = "productAdd", method = RequestMethod.POST)
	public String setProductAdd(ProductDTO productDTO) throws Exception {
		int result= productService.setProductAdd(productDTO, null);
		System.out.println(result == 1);
		//redirect : ����ڰ� list�� �ٽ� ���ص� �ڵ����� list�� ��û���ִ� ��
		String re = "redirect:./list";
		return re;
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
