package model;
public class Vehicle {
    private String vin;
    private String manufacturer;
    private String model;
    private String fleetId;
    private String ownerName;
    private String registrationStatus;

    public Vehicle(String vin, String manufacturer, String model, String fleetId, String ownerName, String registrationStatus) {
        this.vin = vin;
        this.manufacturer = manufacturer;
        this.model = model;
        this.fleetId = fleetId;
        this.ownerName = ownerName;
        this.registrationStatus = registrationStatus;
    }

    public String getVin() { return vin; }
    public String getManufacturer() { return manufacturer; }
    public String getModel() { return model; }
    public String getFleetId() { return fleetId; }
    public String getOwnerName() { return ownerName; }
    public String getRegistrationStatus() { return registrationStatus; }
}
