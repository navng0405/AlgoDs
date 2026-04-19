package OOD.Parkinglot.ParkingSpot;

import OOD.Parkinglot.VehicleDetails.VehicleSize;

public class CompactSpot extends ParkingSpot{
    public CompactSpot(String id, double rate) {
        super(id, VehicleSize.COMPACT, rate);
    }
}
