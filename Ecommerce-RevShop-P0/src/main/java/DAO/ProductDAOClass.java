package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.productRequest;
import dto.productResponse;
import utils.ConnectionFactory;

public class ProductDAOClass implements ProductDao{
	
	private static final Logger logger=LoggerFactory.getLogger(ProductDAOClass.class);
	
	

	@Override
	public productResponse getProductById(int productId) {
		
		String sql= "SELECT * FROM product_details WHERE productId =?";
		try(Connection con = ConnectionFactory.getConnectionFactory().getConnection();
				PreparedStatement stmt= con.prepareStatement(sql))
		{
			
			stmt.setInt(1, productId);	
			
			try(ResultSet rs= stmt.executeQuery())
			{
				if(rs.next()) {
					logger.trace("Product Retrieved");
					   return new productResponse(rs.getInt("productId"),
							                      rs.getString("productName"),
							                      rs.getInt("categoryId"),
				                                  rs.getFloat("price"),
							                      rs.getString("productDescription"),
							                      rs.getInt("sellerId"),
				                                  rs.getInt("productQuantity"),
						                          rs.getString("user_review"));
					
				}
				else {
					logger.warn("unable to fetch");
				}
			}
		}
		catch (SQLException e) {
			logger.error("unable to retrieve the product: ",  e);
		//	e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean createProduct(productRequest productrequest) {
		String sql= "INSERT INTO product_details(productName, categoryId, price,productDescription, sellerId,productQuantity,user_review) VALUES(?,?,?,?,?,?,?)";
		
		
		try(Connection con = ConnectionFactory.getConnectionFactory().getConnection();
				PreparedStatement stmt= con.prepareStatement(sql))
		{
			//stmt.setInt(1, productrequest.getProductId());
			stmt.setString(1, productrequest.getProductName());
			stmt.setInt(2, productrequest.getCategoryId());
			stmt.setFloat(3, productrequest.getPrice());
			stmt.setString(4, productrequest.getProductDescription());
			stmt.setInt(5, productrequest.getSellerId());
			stmt.setInt(6, productrequest.getProductQuantity());
			stmt.setString(7, productrequest.getUser_review());
			
			int result= stmt.executeUpdate();
						
			if(result> 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateProduct(productRequest productrequest, int productId) {
		
		
		String sql="UPDATE product_details SET productName=?, categoryId=?, price=?,productDescription=?, sellerId=?,productQuantity=?,user_review=? where productId =?";
		try(Connection con = ConnectionFactory.getConnectionFactory().getConnection();
				PreparedStatement stmt= con.prepareStatement(sql))
		{
			stmt.setString(1, productrequest.getProductName());
			stmt.setInt(2, productrequest.getCategoryId());
			stmt.setFloat(3, productrequest.getPrice());
			stmt.setString(4, productrequest.getProductDescription());
			stmt.setInt(5, productrequest.getSellerId());
			stmt.setInt(6, productrequest.getProductQuantity());
			stmt.setString(7, productrequest.getUser_review());
			stmt.setInt(8, productId);
				
		int result=	stmt.executeUpdate();
		if(result > 0) {
			return true;
		}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
    @Override
	public boolean deleteProduct(int productId) {
     String sql = "DELETE FROM product_details WHERE ProductId = ?";
	    
	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        
	        stmt.setInt(1, productId); 
	        
	        int result = stmt.executeUpdate();
	        return result > 0;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
    	
		return false;
	}

    
	@Override
	public productResponse getProductByName(String productName) {
		return null;
	}

	@Override
	public List<productResponse> getAllCategories() {
		List<productResponse> products = new ArrayList<>();
        String sql = "SELECT * FROM product_details"; 

        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
   	         PreparedStatement stmt = con.prepareStatement(sql);
   	         ResultSet rs = stmt.executeQuery()) {
 

            while (rs.next()) {
            	products.add(new productResponse(
            			rs.getInt("productId"),
	                    rs.getString("productName"),
	                    rs.getInt("categoryId"),
                        rs.getFloat("price"),
	                    rs.getString("productDescription"),
	                    rs.getInt("sellerId"),
                        rs.getInt("productQuantity"),
                        rs.getString("user_review") )
                );
            }
        } 
          catch (SQLException e) {
            e.printStackTrace(); 
        }

        return products;
	}

	@Override
	public productResponse getProductDescriptionById(int productId) {
		return null;
	}

	@Override
	public productResponse getProductReviewsById(int productId) {
		productResponse product = null;
	  //  String sql = "SELECT productId, productName, price, productDescription, sellerId, productQuantity, user_review, categoryId FROM Product_details WHERE productId = ?";
	    String sql= "SELECT productName FROM Product_details WHERE productId = ?";
	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        
	        stmt.setInt(1, productId);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                product = new productResponse(
	                		rs.getInt("productId"),
		                    rs.getString("productName"),
		                    rs.getInt("categoryId"),
                            rs.getFloat("price"),
		                    rs.getString("productDescription"),
		                    rs.getInt("sellerId"),
                            rs.getInt("productQuantity"),
	                        rs.getString("user_review")
	                );
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return product;
	}
	
	

	@Override
	public productResponse getCategoryById(int categoryId) {
	    productResponse category = null;
	    String sql = "SELECT * FROM Product_details WHERE categoryId = ?";
	    
	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        
	        stmt.setInt(1, categoryId);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                category = new productResponse(
	                		rs.getInt("productId"),
		                    rs.getString("productName"),
		                    rs.getInt("categoryId"),
                            rs.getFloat("price"),
		                    rs.getString("productDescription"),
		                    rs.getInt("sellerId"),
                            rs.getInt("productQuantity"),
	                        rs.getString("user_review") );
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return category;

	}

	@Override
	public productResponse getProductPriceById(int productId) {
		 productResponse product = null;
		    String sql = "SELECT productId, productName, price, productDescription, sellerId, productQuantity, user_review, categoryId FROM Product_details WHERE productId = ?";
		    
		    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
		         PreparedStatement stmt = con.prepareStatement(sql)) {
		        
		        stmt.setInt(1, productId);
		        try (ResultSet rs = stmt.executeQuery()) {
		            if (rs.next()) {
		                product = new productResponse(
		                		rs.getInt("productId"),
			                    rs.getString("productName"),
			                    rs.getInt("categoryId"),
	                            rs.getFloat("price"),
			                    rs.getString("productDescription"),
			                    rs.getInt("sellerId"),
	                            rs.getInt("productQuantity"),
		                        rs.getString("user_review")
		                );
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    
		    return product;
		}

	@Override
	public List<productResponse> getAllProducts() {
		   List<productResponse> products = new ArrayList<>();
		    String sql = "SELECT * FROM Product_details";
		    
		    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
		         PreparedStatement stmt = con.prepareStatement(sql);
		         ResultSet rs = stmt.executeQuery()) {
		        
		        while (rs.next()) {
		            products.add(new productResponse(
		                rs.getInt("productId"),
		                rs.getString("productName"),
		                rs.getInt("categoryId"),
		                rs.getFloat("price"),
		                rs.getString("productDescription"),
		                rs.getInt("sellerId"),
		                rs.getInt("productQuantity"),
		                rs.getString("user_review")
		            ));
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    
		    return products;
		}
	}

	
