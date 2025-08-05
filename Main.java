import management.*;
import model.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        VehicleManagement vehicleService = new VehicleManagement();
        AlertManagement alertService = new AlertManagement();
        TelemetryManagement telemetryService = new TelemetryManagement(alertService);
        vehicleService.addVehicle(new Vehicle("VIN001", "Tesla", "Model S", "Corporate", "Elon", "Active"));
        vehicleService.addVehicle(new Vehicle("VIN002", "BMW", "i8", "Rental", "Max", "Active"));
        vehicleService.addVehicle(new Vehicle("VIN003", "Toyota", "Corolla", "Personal", "John", "Maintenance"));
        telemetryService.receiveTelemetryBatch(DummyTelemetryData.getTelemetryList());

        System.out.println("Alerts");
        for (Alert a : alertService.getAllAlerts()) {
            System.out.println(a.getVin() + " | " + a.getType() + " | " + a.getSeverity() + " | " + a.getMessage());
        }
        FleetAnalyticsManagement analytics = new FleetAnalyticsManagement(
            vehicleService.getMap(),
            telemetryService.getLatestMap(),
            telemetryService.getTelemetryData(),
            alertService.getAllAlerts()
        );

        System.out.println("Fleet Analytics");
        System.out.println("Active: " + analytics.activecnt());
        System.out.println("Inactive: " + analytics.inactivecnt());
        System.out.print("Avg fuel: " + analytics.avgFuelLevel());
    }
}
