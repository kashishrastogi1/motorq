package management;

import model.Alert;
import java.util.*;
public class AlertManagement {
    private List<Alert> alerts;
    public AlertManagement() {
        this.alerts = new ArrayList<>();
    }
    public void generateAlert(Alert alert) {
        alerts.add(alert);
        System.out.println(alert.toString());
    }

    public List<Alert> getAllAlerts() {
        return alerts;
    }
    public List<Alert> getAlertsByType(String type) {
        List<Alert> ans= new ArrayList<>();
        for (Alert a : alerts) {
            if (a.getType().equals(type)) {
                ans.add(a);
            }
        }
        return ans;
    }
    public List<Alert> getAlertsBySeverity(String severity) {
        List<Alert> ans = new ArrayList<>();
        for (Alert a : alerts) {
            if (a.getSeverity().equals(severity)) {
                ans.add(a);
            }
        }
        return ans;
    }
}
