package service;

import dao.buyerDAOClass;


import dto.buyerRequest;
import dto.buyerResponse;

public class buyerService {
	private final buyerDAOClass buyerDao;
	public buyerService() {
		buyerDao= new buyerDAOClass();
		
	}
	
	public boolean createbuyer(buyerRequest buyerrequest) {
	return buyerDao.createbuyer(buyerrequest);
		
	}
	public buyerResponse getBuyerById(int buyerId) {
		return buyerDao.getBuyerById(buyerId);
		
	}
	public boolean updatebuyer(buyerRequest buyerrequest, int buyerId) {
		return buyerDao.updatebuyer(buyerrequest, buyerId);
		
	}

	
	public static void main(String[] args) {
		
		buyerService bs=new buyerService();
		//System.out.println(bs.createbuyer(new buyerRequest("vyshu", "v@gmail.com", "12345", 987685,"khammam")));
	
		System.out.println(bs.getBuyerById(1));
		//System.out.println(bs.updatebuyer(new buyerRequest("Soumya", "s@gmail.com", "12345", 996632255, "hyderabad"), 1));
	}


}

