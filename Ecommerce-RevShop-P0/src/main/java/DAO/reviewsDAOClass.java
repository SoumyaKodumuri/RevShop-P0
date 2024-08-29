package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.reviewsRequest;
import dto.reviewsResponse;
import utils.ConnectionFactory;


public class reviewsDAOClass implements reviewsDao {

	@Override
	public reviewsResponse getreviewsById(int reviewId) {
	    String sql = "SELECT * FROM reviews WHERE prod_id = ?";
	    
	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        
	        stmt.setInt(1, reviewId);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	               return new reviewsResponse(
	                    rs.getInt("prod_Id"),
	                    rs.getInt("buyerId"),
	                    rs.getInt("sellerId"),
	                    rs.getInt("rating"),
	                    rs.getString("comments")
	                );
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return null;
	}
	@Override
	public boolean createReview(reviewsRequest reviewsrequest) {
	    String sql = "INSERT INTO reviews (prod_Id, buyerId, sellerId, rating, comments) VALUES (?, ?, ?, ?, ?)";
	    
	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        
	        stmt.setInt(1, reviewsrequest.getProd_ID());
	        stmt.setInt(2, reviewsrequest.getBuyerId());
	        stmt.setInt(3, reviewsrequest.getSellerId());
	        stmt.setInt(4, reviewsrequest.getRating());
	        stmt.setString(5, reviewsrequest.getComments());
	        
	        int result = stmt.executeUpdate();
	        return result > 0;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return false;
	}


	@Override
	
	public boolean updateReview(reviewsRequest reviewsrequest,int productId) {
	    String sql = "UPDATE reviews SET prod_Id = ?, buyerId = ?, sellerId = ?, rating = ?, comments = ? WHERE prod_Id = ?";
	    
	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        
	        stmt.setInt(1, reviewsrequest.getProd_ID());
	        stmt.setInt(2, reviewsrequest.getBuyerId());
	        stmt.setInt(3, reviewsrequest.getSellerId());
	        stmt.setInt(4, reviewsrequest.getRating());
	        stmt.setString(5, reviewsrequest.getComments());
	        stmt.setInt(6, productId);
	        
	        int result = stmt.executeUpdate();
	        return result > 0;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return false;
	}


	@Override	
	public boolean deleteReviewById(int productId) {
	    String sql = "DELETE FROM reviews WHERE prod_Id = ?";
	    
	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        
	        stmt.setInt(1, productId); // Use the reviewId from ReviewsRequest
	        
	        int result = stmt.executeUpdate();
	        return result > 0;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return false;
	}
	@Override
	public List<reviewsResponse> getAllReviews() {
        List<reviewsResponse> reviews = new ArrayList<>();
        String sql = "SELECT * FROM reviews";
        
        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
            	reviews.add(new reviewsResponse(
                    rs.getInt("prod_ID"),
                    rs.getInt("buyerId"),
                    rs.getInt("sellerId"),
                    rs.getInt("rating"),
                    rs.getString("comments")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return reviews;
    }

	
	@Override
	public reviewsResponse getRatingByProductId(int productId) {
//           String sql = "SELECT rating FROM reviews";
//        
//        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
//             PreparedStatement stmt = con.prepareStatement(sql);
//             ResultSet rs = stmt.executeQuery()) {
		return null;
	}
	@Override
	public reviewsResponse getCommentsByProductId(int productId) {
//            String sql = "SELECT comments FROM reviews";
//        
//        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
//             PreparedStatement stmt = con.prepareStatement(sql);
//        		{
//        		stmt.setInt(1, productId);
//    	        try (ResultSet rs = stmt.executeQuery()) {
//    	            if (rs.next()) {
//    	               return new reviewsResponse(
//    	                    rs.getString("comments"));
//      
		return null;
    	            }
}
