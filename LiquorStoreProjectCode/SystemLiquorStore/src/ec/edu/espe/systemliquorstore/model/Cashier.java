/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.systemliquorstore.model;

/**
 *
 * @author Isaac Acurio, Logical Lords, @ESPE
 */
public class Cashier {

    private int shiftId;
    private double drawerBalance;

    public Cashier(int shiftId, double drawerBalance) {
        this.shiftId = shiftId;
        this.drawerBalance = drawerBalance;
    }

    public void serveCustomer(Customer customer) {
        System.out.println("Shift " + shiftId + " is serving " + customer.getName());
    }

    public Transaction processPayment() {
        return new Transaction(shiftId, 0.0);
    }

    public Sale completeSale() {
        return new Sale(shiftId, 0.0);
    }

    @Override
    public String toString() {
        return "Cashier{shiftId=" + shiftId + ", drawerBalance=" + drawerBalance + '}';
    }

    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    public double getDrawerBalance() {
        return drawerBalance;
    }

    public void setDrawerBalance(double drawerBalance) {
        this.drawerBalance = drawerBalance;
    }

}
