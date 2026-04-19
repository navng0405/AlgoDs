package OOD.Parkinglot.ParkingSpot;

import OOD.Parkinglot.VehicleDetails.VehicleSize;

public class SmallSpot extends ParkingSpot{
    public SmallSpot(String id,double rate) {
        super(id, VehicleSize.MOTORCYCLE, rate);
    }
}
