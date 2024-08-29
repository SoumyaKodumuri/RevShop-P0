package dto;

public class favouritesRequest {
	
	private int productId;
	private int buyerId;
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
	@Override
	public String toString() {
		return "favouritesRequest [productId=" + productId + ", buyerId=" + buyerId + "]";
	}
	
	

}
