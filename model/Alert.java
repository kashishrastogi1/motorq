
package model;

public class Alert {
    private String vin;
    private String type;
    private String severity;
    private String message;

    public Alert(String vin, String type, String severity, String message) {
        this.vin = vin;
        this.type = type;
        this.severity = severity;
        this.message = message;
    }

    public String getVin() { return vin; }
    public String getType() { return type; }
    public String getSeverity() { return severity; }
    public String getMessage() { return message; }

}

