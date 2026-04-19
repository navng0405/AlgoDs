package OOD.Parkinglot.VehicleDetails;

import OOD.Parkinglot.VehicleDetails.Vehicle;
import OOD.Parkinglot.VehicleDetails.VehicleSize;

public class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, VehicleSize.COMPACT);
    }
}
