package service;

import java.util.List;

import DAO.reviewsDAOClass;
import dto.reviewsRequest;
import dto.reviewsResponse;

public class reviewsService {
private final reviewsDAOClass reviewDao;
	
	public reviewsService()
	{
		reviewDao = new reviewsDAOClass();
	}
	
	public reviewsResponse getreviewsById(int productId)
	{
		try
		{
			return reviewDao.getreviewsById(productId);
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	
	public boolean createreview(reviewsRequest reviewsrequest)
	{
	    return reviewDao.createReview(reviewsrequest);
	}
	
	public boolean updatereview(reviewsRequest reviewsrequest, int productId) 
	{
	    return reviewDao.updateReview(reviewsrequest, productId);
	}
	
	public boolean deletereviewById(int productId)
	{
	    return reviewDao.deleteReviewById(productId);
	}
	public List<reviewsResponse> getAllReviews() 
	{
	    return reviewDao.getAllReviews();
	}



	
	public static void main(String[] args) {
		reviewsService r = new reviewsService();
		
//		System.out.println(r.createreview(new reviewsRequest(1,1,2,4,"NotGood")));
//		System.out.println(r.createreview(new reviewsRequest(3,2,1,3,"Avg")));
//		
//		System.out.println(r.getreviewsById(1));
//		System.out.println(r.getreviewsById(3));
//		
//		System.out.println(r.updatereview(new reviewsRequest(10,2,1,2,"notgood"), 10));
//		System.out.println(r.updatereview(new reviewsRequest(3,1,1,2,"bad"), 3));
//		System.out.println(r.deletereviewById(1));
	//	System.out.println(r.getAllReviews());

		
		
	}

}


