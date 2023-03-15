package com.iu.s1.product;

public class ProductDTO {
	//DTO는 필요할 때 여러개 만들어야하는데 Annotation은 천체 프로그램에서 한 개만 만들어지기 떄문에 Annotation 선연 x
	private Long productNum;
	private String productName;
	private String productDetail;
	private double productJumsu;
	
	
	public Long getProductNum() {
		return productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	public double getProductJumsu() {
		return productJumsu;
	}
	public void setProductJumsu(double productJumsu) {
		this.productJumsu = productJumsu;
	}
	
	
	
	
	
}
