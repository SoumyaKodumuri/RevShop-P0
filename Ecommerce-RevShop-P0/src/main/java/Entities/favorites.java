package Entities;

public class favorites {
	private int productId;
	private int buyerId;
	
	public favorites(int productId, int buyerId) {
		this.productId=productId;
		this.buyerId=buyerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	

}
