package OOD.Parkinglot;

public class ParkingTicket {
    private String ticketId;
    private String spotId;
    private String licencePlate;
    private long startTime;
    private long endTime;
    private double totalCharge;

    public ParkingTicket(String ticketId, String spotId, String licencePlate, long startTime) {
        this.ticketId = ticketId;
        this.spotId = spotId;
        this.licencePlate = licencePlate;
        this.startTime = startTime;
        this.endTime = 0;
        this.totalCharge = 0.0;
    }

    public void setEndTime(long endTime){
        this.endTime = endTime;
    }

    public void calculateTotalCharge(double rate){
        if(endTime>startTime){
            long durationInHours = (endTime - startTime)/(1000*60*60);
            this.totalCharge = durationInHours*rate;
        }
    }

    public double getTotalCharge(){
        return totalCharge;
    }

}
