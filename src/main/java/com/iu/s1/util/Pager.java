package com.iu.s1.util;

public class Pager {
	
	private Long bookNum;
	private Long num;
	
	//�˻� ����(����� column)
	private String kind;
	//�˻���
	private String search;
	
	//���������� ����� ROW�� ����
	private Long perPage;
	
	//�Ѻ��� ����� ��ȣ�� ����
	private Long perBlock;
	
	//��ü page ����
	private Long totalPage;
	
	//Client�� ������� ������ ��ȣ(parameter)
	private Long page;
	
	//Table���� ��ȸ�� ���۹�ȣ
	private Long startRow;
	//Table���� ��ȸ�� ����ȣ
	private Long lastRow;
	
	//��ü row�� ������ ���� ����
	//private Long totalCount;
	
	private Long startNum;
	private Long lastNum;
	
	private boolean before;
	private boolean after;

	
	//startNum, lastNum
	public void makeNum(Long totalCount) {
		
		//1. ��ü row�� ���� ���ϱ�
		//2. �� page�� ���� ���ϱ�
		
		//null�� ���� ���� �ֱ� ������ getter ȣ��
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() !=0) {
			//totalPage = totalPage + 1;
			totalPage++;
		}
		
		if(this.getPage() > totalPage) {
			this.setPage(totalPage);
		}
		
		//3.�� ���� ����� ��ȣ�� ���� (1-5, 6-10)
		Long perBlock = 5L;
		
		//4.�� ���� �� ���ϱ�
		Long totalBlock = totalPage/ perBlock;
		if(totalPage % perBlock !=0) {
			totalBlock ++;
		}
		
		//5. page ��ȣ�� ���� �� ��ȣ ���ϱ�
		//page 1-5 curBlock=1 6-10 curBlock=2
		Long curBlock = this.getPage() / perBlock;
		if(this.getPage() % perBlock !=0) {
			curBlock++;
		}
		
		//6. curBlock�� ���� ��ȣ�� �� ��ȣ ���
		//curBlock      startNum    lastNum
		//  1              1          5  
		//  2              6          10
		//  3              11         15
		//  4              16         20
		
		this.startNum = (curBlock-1) * perBlock + 1;
		this.lastNum = curBlock * perBlock;
		
		this.after= true;
		//������ ��
		if(curBlock == totalBlock) {
			lastNum = totalPage;
			this.after = false;
		}
		
		if(curBlock == 1) {
			this.before= true;
		}
	}
	
//	public Long getTotalCount() {
//		return totalCount;
//	}
//	public void setTotalCount(Long totalCount) {
//		this.totalCount = totalCount;
//	}
	public Pager() {
		this.perPage = 10L;
	}
	//startRow, lastRow ��� �ϴ� �޼���
	public void makeRow() {
		this.startRow = (this.getPage()-1) * this.getPerPage() + 1;
		this.lastRow = this.getPage() * this.getPerPage();
	}
	
	
	
	
	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Long getBookNum() {
		return bookNum;
	}

	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}

	public Long getPerBlock() {
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public boolean isBefore() {
		return before;
	}

	public void setBefore(boolean before) {
		this.before = before;
	}

	public boolean isAfter() {
		return after;
	}

	public void setAfter(boolean after) {
		this.after = after;
	}

	public Long getStartRow() {
		if(this.perPage == null || this.perPage == 0) {
			this.perPage = 10L;
		}
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getPerPage() {
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getPage() {
		if(this.page == null || this.page <1) {
			this.page=1L;
		}
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	
	
	
}
