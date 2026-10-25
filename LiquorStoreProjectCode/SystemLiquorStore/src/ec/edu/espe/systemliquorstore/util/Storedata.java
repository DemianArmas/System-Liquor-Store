/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.systemliquorstore.util;

import ec.edu.espe.systemliquorstore.model.Customer;
import ec.edu.espe.systemliquorstore.model.CustomerPayment;
import ec.edu.espe.systemliquorstore.model.DailyCashRecord;
import ec.edu.espe.systemliquorstore.model.Product;
import ec.edu.espe.systemliquorstore.model.PurchaseOrder;
import ec.edu.espe.systemliquorstore.model.Sale;
import ec.edu.espe.systemliquorstore.model.StockMovement;
import ec.edu.espe.systemliquorstore.model.Supplier;
import java.util.ArrayList;
/**
 *
 * @author Enrique Ayala, LogicLords,@ESPE
 */
public class Storedata {
    private ArrayList<Product> products;
    private ArrayList<StockMovement> movements;
    private ArrayList<Supplier> suppliers;
    private ArrayList<PurchaseOrder> orders;
    private ArrayList<Sale> sales;
    private ArrayList<Customer> customers;
    private ArrayList<CustomerPayment> payments;
    private ArrayList<DailyCashRecord> cashRecords;
 
    public Storedata() {
        products = new ArrayList<>();
        movements = new ArrayList<>();
        suppliers = new ArrayList<>();
        orders = new ArrayList<>();
        sales = new ArrayList<>();
        customers = new ArrayList<>();
        payments = new ArrayList<>();
        cashRecords = new ArrayList<>();
    }
 
    public Storedata(ArrayList<Product> products, ArrayList<StockMovement> movements,
            ArrayList<Supplier> suppliers, ArrayList<PurchaseOrder> orders,
            ArrayList<Sale> sales, ArrayList<Customer> customers,
            ArrayList<CustomerPayment> payments, ArrayList<DailyCashRecord> cashRecords) {
        this.products = products;
        this.movements = movements;
        this.suppliers = suppliers;
        this.orders = orders;
        this.sales = sales;
        this.customers = customers;
        this.payments = payments;
        this.cashRecords = cashRecords;
    }
 
    public boolean isValid() {
        if (products == null || movements == null || suppliers == null || orders == null
                || sales == null || customers == null || payments == null || cashRecords == null) {
            return false;
        }
        for (Product product : products) {
            if (product == null || !product.isValid()) {
                return false;
            }
        }
        for (StockMovement movement : movements) {
            if (movement == null || !movement.isValid()) {
                return false;
            }
        }
        for (Supplier supplier : suppliers) {
            if (supplier == null || !supplier.isValid()) {
                return false;
            }
        }
        for (PurchaseOrder order : orders) {
            if (order == null || !order.isValid()) {
                return false;
            }
        }
        for (Sale sale : sales) {
            if (sale == null || !sale.isValid()) {
                return false;
            }
        }
        for (Customer customer : customers) {
            if (customer == null || !customer.isValid()) {
                return false;
            }
        }
        for (CustomerPayment payment : payments) {
            if (payment == null || !payment.isValid()) {
                return false;
            }
        }
        for (DailyCashRecord record : cashRecords) {
            if (record == null || !record.isValid()) {
                return false;
            }
        }
        return true;
    }
 
    public ArrayList<Product> getProducts() {
        return products;
    }
 
    public ArrayList<StockMovement> getMovements() {
        return movements;
    }
 
    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }
 
    public ArrayList<PurchaseOrder> getOrders() {
        return orders;
    }
 
    public ArrayList<Sale> getSales() {
        return sales;
    }
 
    public ArrayList<Customer> getCustomers() {
        return customers;
    }
 
    public ArrayList<CustomerPayment> getPayments() {
        return payments;
    }
 
    public ArrayList<DailyCashRecord> getCashRecords() {
        return cashRecords;
    }
 
}
 
