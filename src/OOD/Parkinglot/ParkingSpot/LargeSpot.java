package OOD.Parkinglot.ParkingSpot;

import OOD.Parkinglot.VehicleDetails.VehicleSize;

public class LargeSpot extends ParkingSpot{
    public LargeSpot(String id, double rate) {
        super(id, VehicleSize.LARGE, rate);
    }
}
