package DAO;

import dto.sellerRequest;
import dto.sellerResponse;

public interface sellerDao {
	boolean createSeller(sellerRequest sellerrequest);
	boolean updateSeller(sellerRequest sellerrequest, int sellerId);
	boolean deleteSeller(int sellerId);
	public sellerResponse getSellerById (int sellerId);


}
