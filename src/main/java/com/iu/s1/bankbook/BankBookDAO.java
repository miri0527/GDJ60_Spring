package com.iu.s1.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.member.MemberDTO;

@Repository
public class BankBookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s1.bankbook.BankBookDAO.";
	
	public List<BankBookDTO> getBankBookList() throws Exception{
		return sqlSession.selectList(NAMESPACE + "getBankBookList");
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
	
	public int setBankBookDelelte(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "setBankDelete", bankBookDTO);
	}
	
}
