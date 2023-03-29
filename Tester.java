package BusBooking;

public class Tester {
	public static void main(String args[]) {
		Passenger passengerObj=new Passenger("Peter",26,"9865768743","abc123@gmail.com");
		BusBooking busBookingObj=new BusBooking("SEMISLEEPER",passengerObj,"florida","california",true,"Saturday");
		busBookingObj.calculateTotalBusFare();
		System.out.println("PNR Number:"+busBookingObj.getPnrNumber());
		System.out.println("Total Bus Fare:"+busBookingObj.getTotalBusFare());
	}

}
