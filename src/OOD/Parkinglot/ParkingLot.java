package OOD.Parkinglot;

import OOD.Parkinglot.ParkingSpot.ParkingSpot;
import OOD.Parkinglot.VehicleDetails.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<ParkingSpot> parkingSpots;

    ParkingLot(){
        this.parkingSpots = new ArrayList<>();
        //Initialize spots - simplified expample
        //In a real scenario, this might be loaded from a database or configuration
    }

    public void addSpot(ParkingSpot spot){
        this.parkingSpots.add(spot);
    }

    public boolean parkVehicle(Vehicle vehicle){
        for(ParkingSpot spot:parkingSpots){
            if(spot.fit(vehicle)){
                spot.park();
                System.out.println("Parked Vehicle with license plate :");
                return true;
            }
        }

        System.out.println("No spot available");
        return false;
    }

    public void leaveVehicle(ParkingSpot spot){
        spot.leave();
        System.out.println("Spot is avialble");
    }
}
