package management;

import model.Vehicle;
import java.util.*;

public class VehicleManagement{
    private Map<String,Vehicle> map = new HashMap<>();

    public void addVehicle(Vehicle vehicle) {
        map.put(vehicle.getVin(), vehicle);
    }

    public Vehicle getVehicle(String vin) {
        return map.get(vin);
    }

    public Collection<Vehicle> getAllVehicles() {
        return map.values();
    }

    public void removeVehicle(String vin) {
        map.remove(vin);
    }
    public Map<String, Vehicle> getMap() {
       return map;
    }

}
