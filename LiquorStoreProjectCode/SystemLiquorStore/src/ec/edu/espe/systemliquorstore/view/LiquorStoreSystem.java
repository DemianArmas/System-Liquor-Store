package ec.edu.espe.systemliquorstore.view;

import ec.edu.espe.systemliquorstore.model.Alert;
import ec.edu.espe.systemliquorstore.model.Business;
import ec.edu.espe.systemliquorstore.model.Cashier;
import ec.edu.espe.systemliquorstore.model.Customer;
import ec.edu.espe.systemliquorstore.model.Employee;
import ec.edu.espe.systemliquorstore.model.Entry;
import ec.edu.espe.systemliquorstore.model.Item;
import ec.edu.espe.systemliquorstore.model.Ledger;
import ec.edu.espe.systemliquorstore.model.PointOfSale;
import ec.edu.espe.systemliquorstore.model.Product;
import ec.edu.espe.systemliquorstore.model.Record;
import ec.edu.espe.systemliquorstore.model.Report;
import ec.edu.espe.systemliquorstore.model.Sale;
import ec.edu.espe.systemliquorstore.model.Store;
import ec.edu.espe.systemliquorstore.model.Supplier;
import ec.edu.espe.systemliquorstore.model.Transaction;
import java.util.Scanner;

/**
 *
 * @author Isaac Acurio, Enrique Ayala, Logical Lords, @ESPE
 */
public class LiquorStoreSystem {

    private static Scanner scanner = new Scanner(System.in);
    private static Ledger ledger = new Ledger(1, 0.0);
    private static double totalSales = 0.0;
    private static int saleCounter = 0;

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\nLiquor Store Simulator");
            System.out.println("======================");
            System.out.println("1. Gestionar inventario de un producto");
            System.out.println("2. Registrar una venta");
            System.out.println("3. Pagar deuda de un cliente");
            System.out.println("4. Abrir tienda y registrar entrada de empleado");
            System.out.println("5. Registrar un ingreso en el libro contable");
            System.out.println("6. Ver reporte y auditar el libro");
            System.out.println("0. Salir");
            option = readInt("Elija una opcion: ");
            switch (option) {
                case 1:
                    manageStock();
                    break;
                case 2:
                    registerSale();
                    break;
                case 3:
                    payCustomerDebt();
                    break;
                case 4:
                    openStore();
                    break;
                case 5:
                    registerIncome();
                    break;
                case 6:
                    showReport();
                    break;
                case 0:
                    System.out.println("Hasta pronto.");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        } while (option != 0);
    }

    private static void manageStock() {
        System.out.println("\n--- Inventario ---");
        int productId = readInt("Id del producto: ");
        String name = readText("Nombre del producto: ");
        int stock = readInt("Stock actual: ");
        Product product = new Product(productId, name, stock);
        int quantity = readInt("Cantidad a descontar del stock: ");
        product.reduceStock(quantity);
        Alert alert = product.generateAlert();
        alert.triggerSound();
        String answer = readText("Desea reabastecer el producto? (s/n): ");
        if (answer.equalsIgnoreCase("s")) {
            int supplierId = readInt("Id del proveedor: ");
            String companyName = readText("Nombre de la empresa proveedora: ");
            Supplier supplier = new Supplier(supplierId, companyName);
            product.reorder(supplier);
            supplier.deliverStock();
        }
    }

    private static void registerSale() {
        System.out.println("\n--- Venta ---");
        int shiftId = readInt("Numero de turno del cajero: ");
        double drawerBalance = readDouble("Dinero en caja: ");
        Cashier cashier = new Cashier(shiftId, drawerBalance);
        int customerId = readInt("Id del cliente: ");
        String customerName = readText("Nombre del cliente: ");
        Customer customer = new Customer(customerId, customerName, 0.0);
        cashier.serveCustomer(customer);
        Sale sale = cashier.completeSale();
        saleCounter++;
        sale.setSaleId(saleCounter);
        String more;
        int entryId = 0;
        do {
            entryId++;
            String barcode = readText("Codigo de barras del articulo: ");
            double price = readDouble("Precio de venta: ");
            double discount = readDouble("Descuento en porcentaje (0 si no hay): ");
            int quantity = readInt("Cantidad: ");
            Item item = new Item(barcode, price);
            if (discount > 0) {
                item.applyDiscount(discount);
            }
            Entry entry = new Entry(entryId, quantity);
            entry.assignItem(item);
            sale.addEntry(entry);
            more = readText("Agregar otro articulo? (s/n): ");
        } while (more.equalsIgnoreCase("s"));
        Record record = sale.generateRecord();
        record.printReceipt();
        Transaction transaction = cashier.processPayment();
        transaction.setTransactionId(saleCounter);
        transaction.setAmount(sale.getTotalAmount());
        transaction.approve();
        totalSales += sale.getTotalAmount();
        ledger.addIncome(sale.getTotalAmount());
    }

    private static void payCustomerDebt() {
        System.out.println("\n--- Pago de deuda ---");
        int customerId = readInt("Id del cliente: ");
        String name = readText("Nombre del cliente: ");
        double debt = readDouble("Deuda actual: ");
        Customer customer = new Customer(customerId, name, debt);
        double amount = readDouble("Monto a pagar: ");
        customer.payDebt(amount);
    }

    private static void openStore() {
        System.out.println("\n--- Apertura de tienda ---");
        int storeId = readInt("Id de la tienda: ");
        String location = readText("Ubicacion de la tienda: ");
        Store store = new Store(storeId, location);
        String companyName = readText("Nombre del negocio: ");
        Business business = new Business(companyName, totalSales);
        business.addStore(store);
        int employeeId = readInt("Id del empleado: ");
        String employeeName = readText("Nombre del empleado: ");
        Employee employee = new Employee(employeeId, employeeName);
        store.assignEmployee(employee);
        employee.registerClockIn();
        int terminalId = readInt("Id de la terminal de venta: ");
        PointOfSale pointOfSale = new PointOfSale(terminalId, "INACTIVO");
        store.setupPOS(pointOfSale);
        int shiftId = readInt("Numero de turno del cajero: ");
        Cashier cashier = new Cashier(shiftId, 0.0);
        pointOfSale.login(cashier);
    }

    private static void registerIncome() {
        System.out.println("\n--- Ingreso al libro contable ---");
        double amount = readDouble("Monto del ingreso: ");
        ledger.addIncome(amount);
    }

    private static void showReport() {
        System.out.println("\n--- Reporte y auditoria ---");
        String companyName = readText("Nombre del negocio: ");
        Business business = new Business(companyName, totalSales);
        Report report = business.generateReport();
        report.printReport();
        business.auditLedger(ledger);
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero entero.");
            }
        }
    }

    private static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            String line = scanner.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
            }
        }
    }

    private static String readText(String message) {
        String line;
        do {
            System.out.print(message);
            line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("El texto no puede estar vacio.");
            }
        } while (line.isEmpty());
        return line;
    }

}