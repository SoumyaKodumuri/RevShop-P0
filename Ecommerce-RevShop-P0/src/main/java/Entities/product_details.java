package Entities;

public class product_details {
	
	private int productId;
	private String productName;
	private int categoryId;
	private float price;
	private String productDescription;
	private int sellerId;
	private int productQuantity;
	private String userReview;
	
	
	public product_details(int productId,String productName, int categoryId, float price,String productDescription,int sellerId, int productQuantity, String userReview )
	{
		super();
		this.productId=productId;
		this.productName=productName;
		this.categoryId=categoryId;
		this.price=price;
		this.productDescription=productDescription;
		this.sellerId=sellerId;
		this.productQuantity=productQuantity;
		this.userReview=userReview;
	}
	

	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public int getSellerId() {
		return sellerId;
	}


	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}


	public int getProductQuantity() {
		return productQuantity;
	}


	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}


	public String getUserReview() {
		return userReview;
	}


	public void setUserReview(String userReview) {
		this.userReview = userReview;
	}
	
	
	

}
