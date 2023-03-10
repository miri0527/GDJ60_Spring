package com.iu.s1.bankBook;

public class BankBookDTO {
	private Long bookNum;
	private String bookName;
	private String bookDetail;
	private Double bookRate;
	private Long bookSale;
	private BankBookImgDTO bankBookImgDTO;
	
	
	
	public BankBookImgDTO getBankBookImgDTO() {
		return bankBookImgDTO;
	}
	public void setBankBookImgDTO(BankBookImgDTO bankBookImgDTO) {
		this.bankBookImgDTO = bankBookImgDTO;
	}
	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookDetail() {
		return bookDetail;
	}
	public void setBookDetail(String bookDetail) {
		this.bookDetail = bookDetail;
	}
	public Double getBookRate() {
		return bookRate;
	}
	public void setBookRate(Double bookRate) {
		this.bookRate = bookRate;
	}
	public Long getBookSale() {
		return bookSale;
	}
	public void setBookSale(Long bookSale) {
		if(bookSale == null || bookSale !=1) {
			this.bookSale = bookSale;
		}
		
	}
	
	
}
