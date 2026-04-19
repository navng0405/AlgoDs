package OOD.Parkinglot.ParkingSpot;

import OOD.Parkinglot.VehicleDetails.Vehicle;
import OOD.Parkinglot.VehicleDetails.VehicleSize;

public class ParkingSpot {
    protected final String id;
    protected final VehicleSize size;
    protected boolean isAvailable;
    protected double rate;
    public ParkingSpot(String id, VehicleSize size,double rate) {
        this.id = id;
        this.size = size;
        this.isAvailable = true;
        this.rate = rate;
    }

    public boolean fit(Vehicle vehicle){
        return this.isAvailable && this.size == vehicle.getSize();
    }

    public void park(){
        this.isAvailable = false;
    }

    public void leave(){
        this.isAvailable = true;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public String getId(){
        return id;
    }

    public double getRate(){
        return rate;
    }
}
