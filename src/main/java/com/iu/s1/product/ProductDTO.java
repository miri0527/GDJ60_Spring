package com.iu.s1.product;

public class ProductDTO {
	//DTO�� �ʿ��Ҷ� ������ �����ߵǴµ� Annotation�� ��ü���α׷����� �� ���� ��������� ������ Annotation ���� x
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
