package com.iu.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	
	public int setMemberAdd(MemberDTO memberDTO)throws Exception{
		int result= memberDAO.setMemberAdd(memberDTO);
		result = memberDAO.setMemberRoleAdd(memberDTO);
		return result;
	}
	
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
		//memberDTO= memberDAO.getMemberLogin(memberDTO);
		//return memberDTO;
		
		//memberDTO : Client와 입력한 ID,PW
		MemberDTO result = memberDAO.getMemberLogin(memberDTO);
		//result : ID와 일치하는 모든 정보
		
		//pw check
		if(result !=null && memberDTO.getPw().equals(result.getPw())) {
			memberDTO.setPw(null); //입력한거에 null -> id는 있음
			return memberDTO;
		}else {
			return null;
		}
		
	}
	
	public MemberDTO getMemberPage(MemberDTO memberDTO) throws Exception {
		memberDTO =  memberDAO.getMemberLogin(memberDTO);
		return memberDTO;
	}
	
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception {
		int result =  memberDAO.setMemberUpdate(memberDTO);
		return result;
	}
}
