package com.iu.s1.board.qna;

import java.util.List;

import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardFileDTO;

public class QnaDTO extends BoardDTO{
	
	private Long ref;
	private Long step;
	private Long depth;
	//qna는 qnafile을 가지고 있다
	private List<BoardFileDTO> boardFileDTOs;
	
	
	
	public List<BoardFileDTO> getBoardFileDTOs() {
		return boardFileDTOs;
	}
	public void setBoardFileDTOs(List<BoardFileDTO> boardFileDTOs) {
		this.boardFileDTOs = boardFileDTOs;
	}
	public Long getRef() {
		return ref;
	}
	public void setRef(Long ref) {
		this.ref = ref;
	}
	public Long getStep() {
		return step;
	}
	public void setStep(Long step) {
		this.step = step;
	}
	public Long getDepth() {
		return depth;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
	
	
}
