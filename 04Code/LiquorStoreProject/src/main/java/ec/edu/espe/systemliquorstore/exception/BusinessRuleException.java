package ec.edu.espe.systemliquorstore.exception;
/**
 *
 * @author Isaac Acurio, Demian Armas, Enrique Ayala, Logical Lords, @ESPE
 */
public class BusinessRuleException extends IllegalStateException {
    public BusinessRuleException(String message) {
        super(message);
    }
}
