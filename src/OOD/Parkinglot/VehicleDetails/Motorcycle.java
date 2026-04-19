package OOD.Parkinglot.VehicleDetails;

import OOD.Parkinglot.VehicleDetails.Vehicle;
import OOD.Parkinglot.VehicleDetails.VehicleSize;

public class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) {
        super(licensePlate, VehicleSize.MOTORCYCLE);
    }
}
