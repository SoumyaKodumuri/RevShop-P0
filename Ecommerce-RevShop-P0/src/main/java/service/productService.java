package service;

import java.util.List;

import DAO.ProductDAOClass;
import dto.productRequest;
import dto.productResponse;

public class productService {
	private final ProductDAOClass ProductDao ;
	
	public productService() {
		
		ProductDao =new ProductDAOClass();
	}
	
	public productResponse getProductById(int productId) {

			return ProductDao.getProductById(productId);
		
			
	}
	
	public boolean createProduct(productRequest productrequest) {
		return ProductDao.createProduct(productrequest);
	}
	
	public boolean updateproduct(productRequest productrequest, int productId) {
		return ProductDao.updateProduct(productrequest, productId);
		
	}
	public List<productResponse> getAllProducts() {
		List<productResponse> products = ProductDao.getAllProducts();
		return products;
	}

	
	public static void main(String[] args) {
		productService ps=new productService();
		
		//System.out.println(ps.createProduct(new productRequest("Boat Smart Watch", 28, 999.9f, "Black-BoatWatch water Resistance", 2, 3, "Good")));
	//	System.out.println(ps.createProduct(new productRequest("Boat Smart Watch", 28, 999.9f, "RosePink-BoatWatch water Resistance", 2, 3, "Good")));
		List<productResponse> products=ps.getAllProducts();
	    
		for(productResponse product :products) {
			System.out.println(product.toString());
		}
		//System.out.println(ps.getProductById(20));
	//System.out.println(ps.updateproduct(new productRequest("Noise Smart Watch", 28, 1099.99f, "Navy Blue water proof", 2, 2, "Good"), 2));
	 
	}

}
