package dto;

public class buyerRequest {
	
	private int buyerId;
	private String buyerName;
	private String email;
	private String password;
	private int phoneNo;
	private String address;
	private String date;
	
	public buyerRequest(int buyerId,String buyerName, String email, String password,int phoneNo, String address,String date) {
		super();
		this.buyerId=buyerId;
		this.buyerName=buyerName;
		this.email=email;
		this.password=password;
		this.phoneNo=phoneNo;
		this.address=address;
		this.date=date;
	}
	
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "buyerRequest [buyerId=" + buyerId + ", buyerName=" + buyerName + ", email=" + email + ", password="
				+ password + ", phoneNo=" + phoneNo + ", address=" + address + ", date=" + date + "]";
	}
	
	

}
