package management;

import model.Vehicle;
import model.Telemetry;
import model.Alert;

import java.time.LocalDateTime;
import java.util.*;

public class FleetAnalyticsManagement {
    private Map<String, Vehicle> vmap;  //getting all vehcile data
    private Map<String, Telemetry> latest;  //latest tele
    private List<Telemetry> telemetryLst;  //getting data
    private List<Alert> alerts;

    public FleetAnalyticsManagement(
        Map<String, Vehicle> vmap,
        Map<String, Telemetry> latest,
        List<Telemetry> telemetryLst,
        List<Alert> alerts
    ) {
        this.vmap = vmap;
        this.latest = latest;
        this.telemetryLst = telemetryLst;
        this.alerts = alerts;
    }

    public long activecnt() {
        long cnt = 0;
        LocalDateTime now = LocalDateTime.now();

        for (Telemetry data : latest.values()) {
            if (data.getTimeStamp().isAfter(now.minusHours(24))) {
                cnt++;
            }
        }

        return cnt;
    }

    public long inactivecnt() {
        return vmap.size() - activecnt();
    }

    public double avgFuelLevel() {
        if (latest.isEmpty()) return 0;

        double total = 0;
        int count = 0;

        for (Telemetry data : latest.values()) {
            total += data.getFuelLevel();
            count++;
        }

        return total / count;
    }

    public void alertCountByType() {
        Map<String, Integer> map = new HashMap<>();

        for (Alert a : alerts) {
            String type = a.getType();
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        System.out.println("Alerts by Type:");
        for (String type : map.keySet()) {
            System.out.println(map.get(type));
        }
    }

    public void alertCountBySeverity() {
        Map<String, Integer> map = new HashMap<>();

        for (Alert a : alerts) {
            String severity = a.getSeverity();
            map.put(severity, map.getOrDefault(severity, 0) + 1);
        }

        System.out.println("Alerts by Severity:");
        for (String sev : map.keySet()) {
            System.out.println(map.get(sev));
        }
    }

    public void showReport() {
        System.out.println(activecnt());
        System.out.println(inactivecnt());
        System.out.println(avgFuelLevel());
        alertCountByType();
        alertCountBySeverity();

    }
}
