package BusBooking;

public class BusBooking extends Booking{
	private static String[] startDestinationArr= {"FLO-CAL","CAL-GEO","CAL-WAS"};
	private static int[] busFareArr= {200,400,600};
	private String busType;
	private double totalBusFare;
	private String day;
	
	public BusBooking(String busType,Passenger passenger,String source,String destination,boolean returnJourney,String day) {
		super(passenger,source,destination,returnJourney);
		this.busType=busType;
		this.totalBusFare=0;
		this.day=day;
	}
	public double getTotalBusFare() {
		return totalBusFare;
	}
	@Override
	public String toString() {
		return "BusBooking("+"busType: " +this.busType + ", passenger: "+this.getPassenger() +", source: " + this.getSource() + ","
				+ ", returnJourney: " + this.getReturnJourney() + ", day: " +this.day+")";
	}
	public int identifyChargedPercentage(String busType) {
		int percentageCharge=0;
		if(busType.equalsIgnoreCase("ORDINARY")) {
			percentageCharge=5;
		}
		else if(busType.equalsIgnoreCase("SEMISLEEPER")) {
			percentageCharge=10;
		}
		else if(busType.equalsIgnoreCase("SLEEPER")) {
			percentageCharge=20;
		}
		else {
			percentageCharge=-1;
		}
		return percentageCharge;
	}
	
	 //To Champions!!
	public int findBaseFare() {
	//Implement your logic here!!
	String onwardJourney=super.getSource().substring(0, 3)+"-"+super.getDestination().substring(0, 3);
	String returnJourney=super.getDestination().substring(0, 3)+"-"+super.getSource().substring(0, 3);
	for(int i=0;i<BusBooking.startDestinationArr.length;i++) {
		if(onwardJourney.equalsIgnoreCase(BusBooking.startDestinationArr[i])|| returnJourney.equalsIgnoreCase(BusBooking.startDestinationArr[i])) {
			return BusBooking.busFareArr[i];
		}
	}
	return -1;
	}
	public void calculateTotalBusFare() {
	//Implement your logic here!!
		double finalFare=0.0;
		if(super.getPassenger().validatePassengerDetails()==false) {
		this.totalBusFare=-1.0;
		super.setPnrNumber("NA");
		}
		else {
			int baseFare=this.findBaseFare();
			int taxPercentage=this.identifyChargedPercentage(busType);
			if(baseFare!=-1 && taxPercentage!=-1) {
				finalFare=baseFare+((taxPercentage*baseFare)/100);
				if(this.day.equalsIgnoreCase("friday")||this.day.equalsIgnoreCase("saturday")||this.day.equalsIgnoreCase("sunday")) {
					finalFare+=30;
				}
				if(super.getPassenger().getAge()>=60) {
					finalFare=finalFare-((50*finalFare)/100);
				}
				if(super.getReturnJourney()==true) {
					finalFare=(2*finalFare)+20;
				}
				else {
					finalFare+=10;	
					
				}
				this.totalBusFare=finalFare;
				super.generatePnrNumber();
				
				
			}
			else {
				this.totalBusFare=-1.0;
				super.setPnrNumber("NA");
			}
		}
			
	}
	
}