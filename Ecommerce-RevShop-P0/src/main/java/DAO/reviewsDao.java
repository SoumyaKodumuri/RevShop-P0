package DAO;

import java.util.List;

import dto.reviewsRequest;
import dto.reviewsResponse;

public interface reviewsDao {
		reviewsResponse getreviewsById(int productId);
		boolean createReview(reviewsRequest reviewsrequest);
		boolean updateReview(reviewsRequest reviewsrequest,int productId);
		boolean deleteReviewById(int productId );
		public List<reviewsResponse> getAllReviews();
		
		public reviewsResponse getRatingByProductId(int productId);
		public reviewsResponse getCommentsByProductId(int productId);

	}


