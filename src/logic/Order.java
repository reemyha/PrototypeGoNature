package logic;


public class Order {
	
	private String orderNumber;
	
	private String parkName;
	
	private String telephone;
	
	private String email;
	
	private String date;

	private String attendees;

	//Constructor for the order details
	public Order(String orderNumber, String parkName, String telephone, String email, String date, String attendees) {
		this.orderNumber = orderNumber;
		this.parkName = parkName;
		this.telephone = telephone;
		this.email = email;
		this.date = date;
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
