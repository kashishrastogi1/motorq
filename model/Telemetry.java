package model;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Telemetry{
    private String vin;
    private double latitude;
    private double longitude;
    private double speed;
    private String engineStatus;
    private double fuelLevel;
    private double odometer;
    private LocalDateTime timestamp;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
    public Telemetry(String vin, double latitude, double longitude, double speed, String engineStatus, double fuelLevel, double odometer, String Strtimestamp) {
        this.vin = vin;
        this.latitude = latitude;
        this.longitude = longitude;
        this.speed = speed;
        this.engineStatus = engineStatus;
        this.fuelLevel = fuelLevel;
        this.odometer = odometer;
        this.timestamp = LocalDateTime.parse(Strtimestamp, formatter);;
    }

    public String getVin() {return vin;}
    public double getOdometer() {return odometer;}
    public double getSpeed() { return speed; }
    public double getFuelLevel() { return fuelLevel; }
    public LocalDateTime getTimeStamp() {return timestamp;}
}
