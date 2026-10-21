package ec.edu.espe.systemliquorstore.model;

/**
 *
 * @author Demian Armas, Logical Lords, @ESPE
 */
public class Alert {

    private int alertId;
    private String message;

    public Alert(int alertId, String message) {
        this.alertId = alertId;
        this.message = message;
    }

    public void triggerSound() {
        System.out.println("BIP BIP Alerta " + alertId + ": " + message);
    }

    @Override
    public String toString() {
        return "Alert{alertId=" + alertId + ", message=" + message + '}';
    }

    public int getAlertId() {
        return alertId;
    }

    public void setAlertId(int alertId) {
        this.alertId = alertId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
