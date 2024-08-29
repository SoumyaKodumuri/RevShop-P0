package Entities;

public class reviews {
	
	private int prod_ID;
	private int buyerId;
	private int sellerId;
	private int rating;
	private String comments;
	
	public reviews(int prod_ID, int buyerId,int sellerId, int rating, String comments) {
		this.prod_ID=prod_ID;
		this.buyerId=buyerId;
		this.sellerId=sellerId;
		this.rating=rating;
		this.comments=comments;
	}

	public int getProd_ID() {
		return prod_ID;
	}

	public void setProd_ID(int prod_ID) {
		this.prod_ID = prod_ID;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	

}
