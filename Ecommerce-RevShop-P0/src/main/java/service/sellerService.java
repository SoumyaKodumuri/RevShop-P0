package service;

import DAO.sellerDAOClass;
import dto.sellerRequest;
import dto.sellerResponse;

public class sellerService {
	private final sellerDAOClass sellerDao;
	 
	public sellerService() {
		sellerDao =new sellerDAOClass();
	}
	
	public boolean createSeller(sellerRequest sellerrequest) {
		return sellerDao.createSeller(sellerrequest);
	}
	public sellerResponse getSellerById(int sellerId) {
		return sellerDao.getSellerById(sellerId);
		
	}
	public boolean updateSeller(sellerRequest sellerrequest, int sellerId) {
      return sellerDao.updateSeller(sellerrequest, sellerId);
	}
	
	public boolean deleteSeller(int sellerId) {
		return sellerDao.deleteSeller(sellerId);
	}

	
	public static void main(String[] args) {
		sellerService ss= new sellerService();
	//	System.out.println(ss.createSeller(new sellerRequest(12,"Soumya","s@gmail.com","asdfg",987898,"hyderabad")));
//		System.out.println(ss.createSeller(new sellerRequest("Satya","sa@gmail.com","kjhgf",987866,"hyd")));
//		System.out.println(ss.getSellerById(2));
		System.out.println(ss.getSellerById(3));
		
//		System.out.println(ss.updateSeller(new sellerRequest("chandu", "c@gmail.com","chandu", 77448855,"Khammam"), 14));
		
	//	System.out.println(ss.deleteSeller(12));
	}

}
