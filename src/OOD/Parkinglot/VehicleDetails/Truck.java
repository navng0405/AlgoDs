package OOD.Parkinglot.VehicleDetails;

import OOD.Parkinglot.VehicleDetails.Vehicle;
import OOD.Parkinglot.VehicleDetails.VehicleSize;

public class Truck extends Vehicle {
    public Truck(String licensePlate) {
        super(licensePlate, VehicleSize.LARGE);
    }
}
