package dao;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dto.buyerRequest;
import dto.buyerResponse;
import utils.ConnectionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class buyerDAOClass implements buyerDao {
		
    private static final Logger logger = LoggerFactory.getLogger(buyerDAOClass.class);
	public buyerResponse getBuyerById(int buyerId) {
    	
    	String sql= "SELECT * FROM buyer WHERE buyerId =?";
		try(Connection con = ConnectionFactory.getConnectionFactory().getConnection();
				PreparedStatement stmt= con.prepareStatement(sql))
		{
			
			stmt.setInt(1, buyerId);
			
			logger.trace("product retreived");
			
			try(ResultSet rs= stmt.executeQuery())
			{
				while(rs.next()) {
					   return new buyerResponse(rs.getInt("buyerId"),
							                    rs.getString("buyerName"),
							                    rs.getString("email"),
							                    rs.getString("password"),
							                    rs.getLong("phoneNo"),
					                            rs.getString("address"),
					                            rs.getString("date"));
					
				}
			}
		}
		catch (SQLException e) {
			logger.error("unable to fetch the product");
			e.printStackTrace();
		}
		return null;
	}

	
    public boolean createbuyer(buyerRequest buyerrequest) {
String sql= "INSERT INTO buyer(buyerName,email,password, phoneNo,address) VALUES(?,?,?,?,?)";
		
		try(Connection con = ConnectionFactory.getConnectionFactory().getConnection();
				PreparedStatement stmt= con.prepareStatement(sql))
		{
			stmt.setString(1, buyerrequest.getBuyerName());
			stmt.setString(2, buyerrequest.getEmail());
			stmt.setString(3, buyerrequest.getPassword());
			stmt.setLong(4, buyerrequest.getPhoneNo());
			stmt.setString(5, buyerrequest.getAddress());
			//stmt.setString(6, buyerrequest.getDate());
			
			logger.trace("product inserted");
			
			int result= stmt.executeUpdate();
			
			if(result> 0) {
				return true;
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			logger.error("unable to add product");
		}
		
		
		return false;
	}
    public boolean updatebuyer(buyerRequest buyerrequest, int buyerId) {
    	String sql="UPDATE buyer SET buyerName=?,email=?,password=?, phoneNo=?,address=? where buyerId =?";
		try(Connection con = ConnectionFactory.getConnectionFactory().getConnection();
				PreparedStatement stmt= con.prepareStatement(sql))
		{
			stmt.setString(1, buyerrequest.getBuyerName());
			stmt.setString(2, buyerrequest.getEmail());
			stmt.setString(3, buyerrequest.getPassword());
			stmt.setLong(4, buyerrequest.getPhoneNo());
			stmt.setString(5, buyerrequest.getAddress());
			stmt.setInt(6, buyerId);
			logger.trace("product updated");
				
		int result=	stmt.executeUpdate();
		if(result > 0) {
			return true;
		}
			
		}catch (SQLException e) {
			e.printStackTrace();
			logger.error("product not updated");
		}
		return false;
	}
		
    public boolean deletebuyer(int buyerId) {
		return false;
	}
    public List<buyerResponse> getAllProducts() {
		return null;
	}

}

