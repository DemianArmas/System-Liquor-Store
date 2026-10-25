package ec.edu.espe.systemliquorstore.view;

import ec.edu.espe.systemliquorstore.model.Alert;
import ec.edu.espe.systemliquorstore.model.Cashier;
import ec.edu.espe.systemliquorstore.model.Customer;
import ec.edu.espe.systemliquorstore.model.Entry;
import ec.edu.espe.systemliquorstore.model.Item;
import ec.edu.espe.systemliquorstore.model.Product;
import ec.edu.espe.systemliquorstore.model.Record;
import ec.edu.espe.systemliquorstore.model.Sale;
import ec.edu.espe.systemliquorstore.model.Supplier;
import ec.edu.espe.systemliquorstore.model.Transaction;
/**
 *
 * @author Isaac Acurio, Logical Lords, @ESPE
 */
public class LiquorStoreSystem {

    public static void main(String[] args) {
        System.out.println("Liquor Store Simulator");
        System.out.println("======================");

        testStage1();
        testStage2();
    }

    private static void testStage1() {
        System.out.println("\n--- Stage 1 test ---");

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

    private static void testStage2() {
        System.out.println("\n--- Stage 2 test ---");

        Item item = new Item("7861234567890", 25.50);
        Entry entry = new Entry(1, 3);
        entry.assignItem(item);
        System.out.println("Entry subtotal: $" + String.format("%.2f", entry.calculateSubtotal()));

        Customer customer = new Customer(1, "Maria Lopez", 100.00);
        Cashier cashier = new Cashier(1, 200.00);
        cashier.serveCustomer(customer);

        Sale sale = cashier.completeSale();
        sale.addEntry(entry);

        Record record = sale.generateRecord();
        record.printReceipt();

        Transaction transaction = cashier.processPayment();
        transaction.approve();

        customer.payDebt(40.00);
        customer.payDebt(500.00);
        customer.payDebt(-5.00);
    }

}