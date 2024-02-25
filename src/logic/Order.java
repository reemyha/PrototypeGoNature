package logic;


public class Order {
	
	private String orderNumber;
	
	private String parkName;
	
	private String telephone;
	
	private String email;
	
	private String date;

	private String attendees;

	//Constructor for the order details
	public Order() {

	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setAttendees(String attendees) {
		this.attendees = attendees;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public String getParkName() {
		return parkName;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getEmail() {
		return email;
	}

	public String getDate() {
		return date;
	}

	public String getAttendees() {
		return attendees;
	}
}
