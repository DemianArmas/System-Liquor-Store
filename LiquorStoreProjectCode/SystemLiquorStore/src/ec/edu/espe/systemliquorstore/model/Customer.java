/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.systemliquorstore.model;

/**
 *
 * @author Isaac Acurio, Logical Lords, @ESPE
 */
public class Customer {

    private int customerId;
    private String name;
    private double creditBalance;

    public Customer(int customerId, String name, double creditBalance) {
        this.customerId = customerId;
        this.name = name;
        this.creditBalance = creditBalance;
    }

    public void payDebt(double amount) {
        if (amount <= 0) {
            System.out.println("The payment amount must be greater than zero.");
        } else if (amount > creditBalance) {
            System.out.println("The amount $" + String.format("%.2f", amount)
                    + " exceeds the debt of $" + String.format("%.2f", creditBalance));
        } else {
            creditBalance -= amount;
            System.out.println(name + " paid $" + String.format("%.2f", amount)
                    + ". Remaining debt: $" + String.format("%.2f", creditBalance));
        }
    }

    @Override
    public String toString() {
        return "Customer{customerId=" + customerId + ", name=" + name
                + ", creditBalance=" + creditBalance + '}';
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(double creditBalance) {
        this.creditBalance = creditBalance;
    }

}
