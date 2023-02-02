package com.iu.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConnection;

@Repository
public class MemberDAO {
	
	
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		Connection con = DBConnection.getConnection();
		
		String sql = "INSERT INTO MEMBER  (MEMBER_ID,MEMBER_PASSWORD,MEMBER_NAME,MEMBER_ADDRESS,MEMBER_PHONE,MEMBER_EMAIL) "
				+ "VALUES (?,?,?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getMember_id());
		st.setString(2, memberDTO.getMember_password());
		st.setString(3, memberDTO.getMember_name());
		st.setString(4, memberDTO.getMember_address());
		st.setString(5, memberDTO.getMember_phone());
		st.setString(6, memberDTO.getMember_email());
		
		int result = st.executeUpdate();
		DBConnection.disConnection(st, con);
		
		return result;
	}
}
