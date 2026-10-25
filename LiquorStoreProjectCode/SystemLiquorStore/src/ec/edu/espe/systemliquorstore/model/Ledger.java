/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.systemliquorstore.model;

/**
 *
 * @author Enrique Ayala, LogicLords,@ESPE
 */
public class Ledger {
     private int ledgerId;
    private double currentBalance;
 
    public Ledger(int ledgerId, double currentBalance) {
        this.ledgerId = ledgerId;
        this.currentBalance = currentBalance;
    }
 
    public void addIncome(double amount) {
        if (amount <= 0) {
            System.out.println("El ingreso debe ser mayor que cero.");
            return;
        }
        currentBalance += amount;
        System.out.println("Ingreso de $" + String.format("%.2f", amount) + " registrado. Saldo actual: $" + String.format("%.2f", currentBalance));
    }
 
    @Override
    public String toString() {
        return "Ledger{ledgerId=" + ledgerId + ", currentBalance=" + currentBalance + '}';
    }
 
    public int getLedgerId() {
        return ledgerId;
    }
 
    public void setLedgerId(int ledgerId) {
        this.ledgerId = ledgerId;
    }
 
    public double getCurrentBalance() {
        return currentBalance;
    }
 
    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
 
}
 
