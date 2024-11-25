package dao;

import java.util.List;
import dto.buyerRequest;
import dto.buyerResponse;

public interface buyerDao {
	
	buyerResponse getBuyerById(int buyerId);
	boolean createbuyer(buyerRequest buyerrequest);
	boolean updatebuyer(buyerRequest buyerrequest,int buyerId);
	boolean deletebuyer(int buyerId);
	List<buyerResponse> getAllProducts();

}

