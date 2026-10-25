/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.systemliquorstore.model;

/**
 *
 * @author Isaac Acurio, Logical Lords, @ESPE
 */
public class Transaction {

    private int transactionId;
    private double amount;

    public Transaction(int transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public void approve() {
        System.out.println("Transaction " + transactionId + " for $"
                + String.format("%.2f", amount) + " was approved.");
    }

    @Override
    public String toString() {
        return "Transaction{transactionId=" + transactionId + ", amount=" + amount + '}';
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}