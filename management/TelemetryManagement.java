package management;

import model.Telemetry;
import model.Alert;
import management.AlertManagement;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class TelemetryManagement {
    private List<Telemetry> telemetrydata = new ArrayList<>();
    private Map<String, Telemetry> latestTelemetry= new HashMap<>();
    private AlertManagement alertService;

    public TelemetryManagement(AlertManagement alertService) {
        this.alertService = alertService;
    }

    public void receiveTelemetry(Telemetry data) {
        telemetrydata.add(data);
        latestTelemetry.put(data.getVin(), data);
        checkAlerts(data);
    }

    public void receiveTelemetryBatch(List<Telemetry> datalst) {
        for (Telemetry data : datalst) {
            receiveTelemetry(data);
        }
    }

    public List<Telemetry> getTelemetryHistory(String vin) {
        return telemetrydata.stream().filter(data -> data.getVin().equals(vin)).sorted(Comparator.comparing(Telemetry::getTimeStamp)).collect(Collectors.toList());
    }

    public List<Telemetry> getLatestTelemetry(String vin) {
      List<Telemetry> latest = new ArrayList<>();
      LocalDateTime latestTime = null;

      for (Telemetry data : telemetrydata) {
        if (data.getVin().equals(vin)) {
            LocalDateTime recent = data.getTimeStamp();

            if (recent.isAfter(latestTime)) {
                latestTime = recent;
                latest.clear();
                latest.add(data);
            } 
        }
      }

      return latest;
   }


    private void checkAlerts(Telemetry data) {  //as we have the data
        if (data.getSpeed() > 120) {
            alertService.generateAlert(new Alert(data.getVin(), "SpeedViolation", "Warning", "Speed: " + data.getSpeed()));
        }
        if (data.getFuelLevel() < 15) {
            alertService.generateAlert(new Alert(data.getVin(), "LowFuel", "Extreme", "Fuel: " + data.getFuelLevel()));
        }
    }

    public Map<String, Telemetry> getLatestMap() {
      return latestTelemetry;


      
    }   

    public List<Telemetry> getTelemetryData() {
      return telemetrydata;
    }

}
