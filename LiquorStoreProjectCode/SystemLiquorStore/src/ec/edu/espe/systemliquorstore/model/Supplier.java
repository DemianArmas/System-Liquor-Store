package ec.edu.espe.systemliquorstore.model;

/**
 *
 * @author Demian Armas, Logical Lords, @ESPE
 */
public class Supplier {

    private int supplierId;
    private String companyName;

    public Supplier(int supplierId, String companyName) {
        this.supplierId = supplierId;
        this.companyName = companyName;
    }

    public void receiveOrder() {
        System.out.println(companyName + " recibio un nuevo pedido.");
    }

    public void deliverStock() {
        System.out.println(companyName + " esta entregando la mercaderia.");
    }

    @Override
    public String toString() {
        return "Supplier{supplierId=" + supplierId + ", companyName=" + companyName + '}';
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
