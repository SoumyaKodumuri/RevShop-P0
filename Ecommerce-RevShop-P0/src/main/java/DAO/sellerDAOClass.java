package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.sellerRequest;
import dto.sellerResponse;
import utils.ConnectionFactory;

public class sellerDAOClass implements sellerDao{

	@Override
	public boolean createSeller(sellerRequest sellerrequest) {
		String sql= "INSERT INTO seller(sellerName,email,password,phoneno,address) values(?,?,?,?,?)";
		try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
				PreparedStatement stmt= con.prepareStatement(sql))
		{
			//stmt.setInt(1, sellerrequest.getSellerId());
			stmt.setString(1, sellerrequest.getSellerName());
			stmt.setString(2, sellerrequest.getEmail());
			stmt.setString(3, sellerrequest.getPassword());
			stmt.setInt(4, sellerrequest.getPhoneno());
			stmt.setString(5, sellerrequest.getAddress());
			
			   int result = stmt.executeUpdate();
			   if(result> 0)
			   {
					return true;
				}
			} 
		catch (SQLException e) 
		{
				e.printStackTrace();
			}
		return false;
			   
		}
			
		

	@Override
	public boolean updateSeller(sellerRequest sellerrequest, int sellerId) {
		String sql= "UPDATE seller SET sellerName=?, email=?, password=?, phoneno=?, address=? WHERE sellerId=?";
		try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
				PreparedStatement stmt= con.prepareStatement(sql))
		{
			stmt.setString(1, sellerrequest.getSellerName());
			stmt.setString(2, sellerrequest.getEmail());
			stmt.setString(3, sellerrequest.getPassword());
			stmt.setInt(4, sellerrequest.getPhoneno());
			stmt.setString(5, sellerrequest.getAddress());
			stmt.setInt(6, sellerId);
			
			   int result = stmt.executeUpdate();
			   if(result> 0)
			   {
					return true;
				}
			} 
		catch (SQLException e) 
		{
				e.printStackTrace();
			}
		return false;
			   
		}
		

	@Override
	public boolean deleteSeller(int sellerId) {
    String sql = "DELETE FROM seller WHERE sellerId = ?";
	    
	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        
	        stmt.setInt(1, sellerId); 
	        
	        int result = stmt.executeUpdate();
	        return result > 0;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return false;
	}

	@Override
	public sellerResponse getSellerById(int sellerId) {
		String sql= "SELECT * FROM seller WHERE sellerId =?";
		try(Connection con = ConnectionFactory.getConnectionFactory().getConnection();
				PreparedStatement stmt= con.prepareStatement(sql))
		{
			stmt.setInt(1, sellerId);
			try (ResultSet rs= stmt.executeQuery())
			{
				if(rs.next()) {
					return new sellerResponse(rs.getInt("sellerId"),
							                  rs.getString("sellerName"),
							                  rs.getString("email"), 
							                  rs.getString("password"),
							                  rs.getInt("phoneno"),
							                  rs.getString("address"));
				}
			}
				} 
			catch (SQLException e) 
			{
			e.printStackTrace();
		    }
		return null;
	}

}
