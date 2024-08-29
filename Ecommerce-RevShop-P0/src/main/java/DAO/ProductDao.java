package DAO;

import java.util.List;
import java.util.Optional;

import dto.productRequest;
import dto.productResponse;

public interface ProductDao {
	
	boolean createProduct(productRequest productrequest);
	boolean updateProduct(productRequest productrequest, int productId);
	boolean deleteProduct(int productId);
	
	public productResponse getProductById (int productId);
	List<productResponse> getAllProducts();
	productResponse getProductByName(String productName);
	
	public productResponse getCategoryById(int categoryId);
	public List<productResponse> getAllCategories();
	
    productResponse getProductDescriptionById(int productId);
    productResponse getProductReviewsById(int productId);
    productResponse getProductPriceById(int productId);

}


