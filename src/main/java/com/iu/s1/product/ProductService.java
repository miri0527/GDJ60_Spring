package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	//Service -> 총
	@Autowired
	private ProductDAO productDAO;
	
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception {
		ProductDTO productDTO2= productDAO.getProductDetail(productDTO);
		return productDTO2;
	}
	
	public List<ProductDTO> getProductList() throws Exception {
		List<ProductDTO> ar =productDAO.getProductList();
		return ar;
	}
	
	public int setProductAdd(ProductDTO productDTO, List<ProductOptionDTO> ar) throws Exception {
		//product, option 
		Long productNum = productDAO.getProductNum();
		productDTO.setProductNum(productNum);
		int result = productDAO.setProductAdd(productDTO);
		
		if(ar !=null) {
		
			for (ProductOptionDTO productOptionDTO : ar) {
				productOptionDTO.setProductNum(productNum);
			    result = productDAO.setAddProductOption(productOptionDTO);
			}
		}	
		
		return result;
	}
	
//
//	public static void main(String[] args) {
//		ProductDAO productDAO = new ProductDAO();
//		
//		ProductDTO productDTO = new ProductDTO();
//		productDTO.setProduct_name("product1");
//		productDTO.setProduct_detail("detail1");
//		
//		ProductOptionDTO productOptionDTO = new ProductOptionDTO(); 
//		productOptionDTO.setOption_name("optionName1");
//		productOptionDTO.setOption_price(100L);
//		productOptionDTO.setOption_stock(10L);
//		productOptionDTO.setProduct_num(null);
//		
//		try {
//			
//			Long num = productDAO.getProductNum();
//			
//			productDTO.setProduct_num(num);
//			
//			int result = productDAO.setAddProduct(productDTO);
//			
//			productOptionDTO.setProduct_num(num);
//			
//			if(result > 0) {
//				productDAO.setAddProductOption(productOptionDTO);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//
//	}

}
