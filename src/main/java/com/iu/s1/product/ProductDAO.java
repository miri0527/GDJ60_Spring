package com.iu.s1.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.util.*;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
//	어느 mapper을 쓸꺼냐를 NAMESPACE로 구분
	private final String NAMESPACE="com.iu.s1.product.ProductDAO.";
	
	//DAO -> 총알
	public Long getProductNum() throws Exception {
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		Long num =  rs.getLong(1); //Long???엯?쑝濡? ?떞?븘二쇨린
		
		DBConnection.disConnection(rs, st, con);
		
		return num;
		
	}
	
	public List<ProductOptionDTO> getProductOptionList() throws Exception {
		List<ProductOptionDTO> ar = new ArrayList<ProductOptionDTO>();
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT * FROM PRODUCTOPTION";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductOptionDTO productOptionDTO = new ProductOptionDTO();
			productOptionDTO.setOption_num(rs.getLong("OPTION_NUM"));
			productOptionDTO.setProduct_num(rs.getLong("PRODUCT_NUM"));
			productOptionDTO.setOption_name(rs.getString("OPTION_NAME"));
			productOptionDTO.setOption_price(rs.getLong("OPTION_PRICE"));
			productOptionDTO.setOption_stock(rs.getLong("OPTION_STOCK"));
		}
		DBConnection.disConnection(rs, st, con);
		return ar;
	}
	
	public int setAddProductOption(ProductOptionDTO productOptionDTO) throws Exception {
		Connection con = DBConnection.getConnection();
		
		String sql = "INSERT INTO PRODUCTOPTION (OPTION_NUM, PRODUCT_NUM, OPTION_NAME, OPTION_PRICE, OPTION_STOCK) "
				+ "VALUES (PRODUCT_SEQ.NEXTVAL,?,?,?,?)";
		
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, productOptionDTO.getOption_num());
		st.setLong(2, productOptionDTO.getProduct_num());
		st.setString(3, productOptionDTO.getOption_name());
		st.setLong(4, productOptionDTO.getOption_price());
		st.setLong(5, productOptionDTO.getOption_stock());
		
		int result = st.executeUpdate();
		DBConnection.disConnection(st, con);
		
		return result;
		
	}

	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception {
		
		//이 mapper의 id를 실행 , 결과값이 한 개기 때문에 selectOne을 쓴다 -> 결과값이 여러 개면 에러
		return sqlSession.selectOne(NAMESPACE + "getProductDetail", productDTO);
	}
	
	public List<ProductDTO> getProductList() throws Exception {
		//매개변수가 없어서 보내는게 없다
		return sqlSession.selectList(NAMESPACE + "getProductList");
	}
	
	public int setAddProduct(ProductDTO productDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE + "setAddProduct", productDTO);
		
	}
	
	public int setProductDelete(Long product_num) throws Exception {
		
		return sqlSession.delete(NAMESPACE + "setProductDelete", product_num);
	}
	
//	public static void main(String[] args) {
//		ProductDAO productDAO = new ProductDAO();
//		ProductOptionDTO productOptionDTO = new ProductOptionDTO();
//		
//		try {
//			int result = productDAO.setProductOption(productOptionDTO);
//			System.out.println(result !=0);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	//}
}
