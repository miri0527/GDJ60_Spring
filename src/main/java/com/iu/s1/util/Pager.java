package com.iu.s1.util;

public class Pager {
	
	//검색 종류 (사용할 column)
	private String kind;
	//검색어
	private String search;
	
	//한 페이지에 들어갈 Row의 개수
	private Long perPage;
	
	//한 블럭당 출력할 	번호의 갯수
	private Long perBlock;
	
	//전체 page의 갯수
	private Long totalPage;
	
	//Client가 보고싶은 페이지의 번호(parameter)
	private Long page;
	
	//테이블에 출력되는 Row의 시작번호
	private Long startRow;
	//Table에 출력되는 Row의 마지막 번호
	private Long lastRow;
	
	//전체 row의 갯수를 담을 변수
	//private Long totalCount;
	
	//페이지에 보여질 시작번호
	private Long startNum;
	//페이지에 보여질 마지막 번호
	private Long lastNum;
	
	private boolean before;
	private boolean after;

	
	//startNum, lastNum
	public void makeNum(Long totalCount) {
		
		//1.전체 Row의 갯수 구하기
		//2.총 page의 갯수 구하기
		
		//null이 들어올 수 있기 때문에 getter 호출
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() !=0) {
			//totalPage = totalPage + 1;
			totalPage++;
		}
		
		if(this.getPage() > totalPage) {
			this.setPage(totalPage);
		}
		
		//3.한 블럭에 들어갈 번호의 갯수 ( 1-5, 6-10)
		Long perBlock = 5L;
		
		//4.총 블럭의 수 구하기
		Long totalBlock = totalPage/ perBlock;
		if(totalPage % perBlock !=0) {
			totalBlock ++;
		}
		
		//5. page번호로 햔재 블럭 번호 구하기
		//page 1-5 curBlock=1 6-10 curBlock=2
		Long curBlock = this.getPage() / perBlock;
		if(this.getPage() % perBlock !=0) {
			curBlock++;
		}
		
		//6. curBlock의 시작 번호와 끝 번호 계산
		//curBlock      startNum    lastNum
		//  1              1          5  
		//  2              6          10
		//  3              11         15
		//  4              16         20
		
		this.startNum = (curBlock-1) * perBlock + 1;
		this.lastNum = curBlock * perBlock;
		
		this.after= true;
		//마지막 블럭
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
	//startRow, lastRow 계산하는 메서드
	public void makeRow() {
		this.startRow = (this.getPage()-1) * this.getPerPage() + 1;
		this.lastRow = this.getPage() * this.getPerPage();
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
