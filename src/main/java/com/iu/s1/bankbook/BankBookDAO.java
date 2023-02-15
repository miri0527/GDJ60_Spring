package com.iu.s1.bankBook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.member.MemberDTO;
import com.iu.s1.util.Pager;

@Repository
public class BankBookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s1.bankBook.BankBookDAO.";
	
	public Long getBankBookCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getBankBookCount");
	}
	
	public List<BankBookDTO> getBankBookList(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE + "getBankBookList", pager);
	}
	
	//상세정보를 보려면 num을 꺼내야함
	public BankBookDTO getBankBookDetail(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getBankBookDetail", bankBookDTO);
	}
	
	public int setBankBookAdd(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "setBankBookAdd", bankBookDTO);
	}
	
	public int setBankBookUpdate(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "setBankBookUpdate", bankBookDTO);
	}
	
	public int setBankBookDelete(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "setBankBookDelete", bankBookDTO);
	}
	
	
	
}
