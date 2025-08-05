package management;
import model.Telemetry;
import java.util.*;
public class DummyTelemetryData {
    public static List<Telemetry> getTelemetryList() {
        List<Telemetry> data = new ArrayList<>();
        data.add(new Telemetry("VIN001", 28.6, 77.2, 90, "On", 60, 1000, "2025-08-05T10:00:00"));
        data.add(new Telemetry("VIN001", 28.6, 77.2, 125, "On", 10, 1030, "2025-08-05T13:00:00")); // alert
        data.add(new Telemetry("VIN002", 28.6, 77.2, 80, "On", 50, 800, "2025-08-05T09:30:00"));
        data.add(new Telemetry("VIN002", 28.6, 77.2, 75, "On", 45, 860, "2025-08-05T14:00:00"));
        data.add(new Telemetry("VIN003", 28.6, 77.2, 50, "Idle", 30, 500, "2025-08-05T08:00:00"));
        return data;
    }
}