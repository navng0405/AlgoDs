package OOD.Parkinglot.VehicleDetails;

public class Vehicle {
    protected String licensePlate;
    protected VehicleSize size;

    public Vehicle(String licensePlate,VehicleSize vehicleSize){
        this.licensePlate = licensePlate;
        this.size = vehicleSize;
    }

    public VehicleSize getSize() {
        return size;
    }
}
