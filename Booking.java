package BusBooking;

public class Booking {
	private static int counter=1000;
	private Passenger passenger;
	private String source;
	private String destination;
	private boolean returnJourney;
	private String pnrNumber;
	
	public Booking(Passenger passenger,String source,String destination,boolean returnJourney) {
		super();
		this.passenger = passenger;
		this.source = source;
		this.destination = destination;
		this.returnJourney = returnJourney;
	}
	public String getPnrNumber() {
		return pnrNumber;
	}
	public void setPnrNumber(String pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public String getSource() {
		return source;
	}
	public String getDestination() {
		return destination;
	}
	public boolean getReturnJourney() {
		return returnJourney;
	}
	public void generatePnrNumber() {
		//Implement your logic here!!
		this.setPnrNumber(this.getPassenger().getName().toUpperCase().charAt(0)+""+ ++counter);
	}
}