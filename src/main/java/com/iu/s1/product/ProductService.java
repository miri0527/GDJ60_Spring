package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception {
		return productDAO.getProductDetail(productDTO);
	}
	
	public List<ProductDTO> getProductList() throws Exception {
		return productDAO.getProductList();
	}
	
	public int setAddProduct(ProductDTO productDTO, List<ProductOptionDTO> ar) throws Exception {
		//product, option 
		Long product_num = productDAO.getProductNum();
		productDTO.setProduct_num(product_num);
		int result = productDAO.setAddProduct(productDTO);
		
		for (ProductOptionDTO productOptionDTO : ar) {
			productOptionDTO.setProduct_num(product_num);
		    result = productDAO.setAddProductOption(productOptionDTO);

		}
		
		return result;
	}
	

	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProduct_name("product1");
		productDTO.setProduct_detail("detail1");
		
		ProductOptionDTO productOptionDTO = new ProductOptionDTO(); //product_num占쏙옙 占쎈뻻占쏙옙占쎈뮞嚥∽옙 獄쏆룇釉섆빳�덈┛ 占쎈르�눧紐꾨퓠 set占쎈툧占쎈퉸餓μ꼶猷꾬옙留�
		productOptionDTO.setOption_name("optionName1");
		productOptionDTO.setOption_price(100L);
		productOptionDTO.setOption_stock(10L);
		productOptionDTO.setProduct_num(null);
		
		try {
			
			Long num = productDAO.getProductNum();
			
			productDTO.setProduct_num(num);
			
			int result = productDAO.setAddProduct(productDTO);
			
			productOptionDTO.setProduct_num(num);
			
			if(result > 0) {
				productDAO.setAddProductOption(productOptionDTO);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
