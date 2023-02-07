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
//	��� mapper�� �����ĸ� NAMESPACE�� ����
	private final String NAMESPACE="com.iu.s1.product.ProductDAO.";
	
	//DAO -> �Ѿ�
	//������ �����ؼ� ó���� ����
	public Long getProductNum() throws Exception {
		
		return sqlSession.selectOne(NAMESPACE + "getProductNum");
		
	}
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception {
		
		//�� mapper�� id�� ���� , ������� �� ���� ������ selectOne�� ���� -> ������� ���� ���� ����
		productDTO =sqlSession.selectOne(NAMESPACE + "getProductDetail", productDTO);
		return productDTO;
	}
	
	public List<ProductDTO> getProductList() throws Exception {
		//�Ű������� ��� �����°� ����
		return sqlSession.selectList(NAMESPACE + "getProductList");
	}
	
	public int setProductAdd(ProductDTO productDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE + "setProductAdd", productDTO);
		
	}
	
	public int setProductDelete(Long productNum) throws Exception {
		
		return sqlSession.delete(NAMESPACE + "setProductDelete", productNum);
	}
	
	public List<ProductOptionDTO> getProductOptionList() throws Exception {
		List<ProductOptionDTO> ar = new ArrayList<ProductOptionDTO>();
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT * FROM PRODUCTOPTION";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductOptionDTO productOptionDTO = new ProductOptionDTO();
			productOptionDTO.setOptionNum(rs.getLong("OPTIONNUM"));
			productOptionDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productOptionDTO.setOptionName(rs.getString("OPTIONNAME"));
			productOptionDTO.setOptionPrice(rs.getLong("OPTIONPRICE"));
			productOptionDTO.setOptionStock(rs.getLong("OPTIONSTOCK"));
		}
		DBConnection.disConnection(rs, st, con);
		return ar;
	}
	
	public int setAddProductOption(ProductOptionDTO productOptionDTO) throws Exception {
		Connection con = DBConnection.getConnection();
		
		String sql = "INSERT INTO PRODUCTOPTION (OPTIONNUM, PRODUCTNUM, OPTIONNAME, OPTIONPRICE, OPTIONSTOCK) "
				+ "VALUES (PRODUCT_SEQ.NEXTVAL,?,?,?,?)";
		
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, productOptionDTO.getOptionNum());
		st.setLong(2, productOptionDTO.getProductNum());
		st.setString(3, productOptionDTO.getOptionName());
		st.setLong(4, productOptionDTO.getOptionPrice());
		st.setLong(5, productOptionDTO.getOptionStock());
		
		int result = st.executeUpdate();
		DBConnection.disConnection(st, con);
		
		return result;
		
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
