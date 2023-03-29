package BusBooking;

public class Passenger {
	private static String[] domainArr= {"gmail","yahoo","hotmail"};
	private String name;
	private int age;
	private String phoneNo;
	private String emailId;
	
	public Passenger(String name,int age,String phoneNo,String emailId) {
		this.name=name;
		this.age=age;
		this.phoneNo=phoneNo;
		this.emailId=emailId;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public String getEmailId() {
		return emailId;
	}
	//To Champions!!
	public Boolean validatePassengerDetails() {
		
		//Implement your logic here
		if(this.getAge()>12 && this.getName().length()>=3 && this.getPhoneNo().charAt(0)=='9') {
			for(String str: domainArr) {
				if(this.getEmailId().contains(str)) {
					return true;
					
				}
			}
			
		}
		return false;
		}	
}