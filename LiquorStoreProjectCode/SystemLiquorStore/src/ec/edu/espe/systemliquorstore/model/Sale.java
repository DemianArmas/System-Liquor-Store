/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.systemliquorstore.model;

/**
 *
 * @author Isaac Acurio, Logical Lords, @ESPE
 */
public class Sale {

    private int saleId;
    private double totalAmount;

    public Sale(int saleId, double totalAmount) {
        this.saleId = saleId;
        this.totalAmount = totalAmount;
    }

    public void addEntry(Entry entry) {
        totalAmount += entry.calculateSubtotal();
        System.out.println("Entry added to sale " + saleId
                + ". Current total: $" + String.format("%.2f", totalAmount));
    }

    public Record generateRecord() {
        String text = "Sale " + saleId + " - Total: $" + String.format("%.2f", totalAmount);
        return new Record(saleId, text);
    }

    @Override
    public String toString() {
        return "Sale{saleId=" + saleId + ", totalAmount=" + totalAmount + '}';
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

}
