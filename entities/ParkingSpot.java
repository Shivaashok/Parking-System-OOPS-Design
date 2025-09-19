package entities;

import vehicle.Vehicle;
import vehicle.VehicleSize;

public class ParkingSpot{
    private final String spot_id;
    private final VehicleSize spotSize;
    private Vehicle parkedVehicle;
    private Boolean isoccupied;


    public ParkingSpot(String spot_id, VehicleSize spotSize){
        this.spot_id = spot_id;
        this.spotSize = spotSize;
        this.parkedVehicle = null;
        this.isoccupied = false;
    }

    public Boolean is_available(){return !isoccupied;}
    public String get_spot_id(){return spot_id;}
    public VehicleSize get_spot_size(){return spotSize;}
    public Boolean is_occupied(){return isoccupied;}

    public synchronized void park_vehicle(Vehicle vehicle){
        parkedVehicle = vehicle;
        isoccupied = true;
    }

    public synchronized void unpark_vehicle(Vehicle vehicle){
        parkedVehicle = null;
        isoccupied = false;
    }

    public boolean can_fit_vehicle(Vehicle vehicle){
        if(isoccupied) return false;
        
        switch(vehicle.get_size()){
            case SMALL:
                return vehicle.get_size() == spotSize;
            case MEDIUM:
                return spotSize == VehicleSize.MEDIUM || spotSize == VehicleSize.LARGE;
            case LARGE:
                return spotSize == VehicleSize.LARGE;
            default : 
                return false;
        }
    }

}