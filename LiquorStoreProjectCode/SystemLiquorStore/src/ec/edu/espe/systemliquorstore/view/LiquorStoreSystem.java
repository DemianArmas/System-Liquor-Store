package ec.edu.espe.systemliquorstore.view;

import ec.edu.espe.systemliquorstore.model.Alert;
import ec.edu.espe.systemliquorstore.model.Item;
import ec.edu.espe.systemliquorstore.model.Product;
import ec.edu.espe.systemliquorstore.model.Supplier;
import ec.edu.espe.systemliquorstore.model.Record;

/**
 *
 * @author Demian Armas, Logical Lords, @ESPE
 */
public class LiquorStoreSystem {
    
    public static void main(String[] args) {
        System.out.println("Simulador de Licoreria");
        System.out.println("======================");

        testStage1();
    }

    private static void testStage1() {
        System.out.println("\n--- Prueba de la etapa 1 ---");

        Supplier supplier = new Supplier(1, "Licores del Austro");
        Product product = new Product(1, "Whisky 750ml", 5);
        Item item = new Item("7861234567890", 25.50);

        product.reduceStock(3);
        product.reduceStock(10);

        Alert alert = product.generateAlert();
        alert.triggerSound();

        product.reorder(supplier);
        supplier.deliverStock();

        item.linkProduct(product);
        item.applyDiscount(10);
        item.applyDiscount(150);

        Record record = new Record(1, "1 x " + product.getName()
                + " ... $" + String.format("%.2f", item.getSellingPrice()));
        record.printReceipt();
    }
    
}
