package dto;

public class buyerRequest {
	private String buyerName;
	private String email;
	private String password;
	private long phoneNo;
	private String address;
	//private String date;
	
	
	public buyerRequest(String buyerName, String email, String password,long phoneNo, String address) {
		super();
	
		this.buyerName=buyerName;
		this.email=email;
		this.password=password;
		this.phoneNo=phoneNo;
		this.address=address;
		//this.date=date;
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

	public long getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

//	public String getDate() {
//		return date;
//	}
//
//	public void setDate(String date) {
//		this.date = date;
//	}

}
