package ec.edu.espe.systemliquorstore.model;

/**
 *
 * @author Demian Armas, Logical Lords, @ESPE
 */
public class Product {

    private int productId;
    private String name;
    private int currentStock;

    public Product(int productId, String name, int currentStock) {
        this.productId = productId;
        this.name = name;
        this.currentStock = currentStock;
    }

    public void reduceStock(int quantity) {
        if (quantity <= 0) {
            System.out.println("La cantidad debe ser mayor que cero.");
        } else if (quantity > currentStock) {
            System.out.println("No hay suficiente stock de " + name
                    + ". Disponible: " + currentStock + ", solicitado: " + quantity);
        } else {
            currentStock -= quantity;
            System.out.println("Stock de " + name + " reducido en " + quantity
                    + ". Quedan: " + currentStock);
        }
    }

    public Alert generateAlert() {
        return new Alert(productId, "Stock bajo de " + name
                + ". Stock actual: " + currentStock);
    }

    public void reorder(Supplier supplier) {
        System.out.println("Reabasteciendo " + name + " con " + supplier.getCompanyName());
        supplier.receiveOrder();
    }

    @Override
    public String toString() {
        return "Product{productId=" + productId + ", name=" + name
                + ", currentStock=" + currentStock + '}';
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }
}




