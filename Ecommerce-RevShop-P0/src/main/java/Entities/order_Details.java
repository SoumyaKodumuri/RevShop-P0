package Entities;

public class order_Details {
	private int orderId;
	private int product_id;
	private int quantity;
	private int buyerId;
	private int sellerId;
	private String shipping_address;
	private String order_date;
	private float total_amount;
	private String order_status;
	
	public order_Details(int orderId,int product_id,
	 int quantity,int buyerId,int sellerId, String shipping_address,String order_date,float total_amount,String order_status) {
		
		this.orderId=orderId;
		this.product_id=product_id;
		this.quantity=quantity;
		this.buyerId=buyerId;
		this.sellerId=sellerId;
		this.shipping_address=shipping_address;
		this.order_date=order_date;
		this.total_amount=total_amount;
		this.order_status=order_status;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public String getShipping_address() {
		return shipping_address;
	}

	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public float getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(float total_amount) {
		this.total_amount = total_amount;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	
	
	

}
