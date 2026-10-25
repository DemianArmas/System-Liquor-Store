/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.systemliquorstore.model;

/**
 *
 * @author Enrique Ayala, LogicLords,@ESPE
 */
public class Business {
    
    private String companyName;
    private double totalRevenue;
 
    public Business(String companyName, double totalRevenue) {
        this.companyName = companyName;
        this.totalRevenue = totalRevenue;
    }
 
    public Report generateReport() {
        return new Report(1, totalRevenue);
    }
 
    public void addStore(Store store) {
        System.out.println("La tienda " + store.getStoreId() + " se agregó al negocio " + companyName);
    }
 
    public void auditLedger(Ledger ledger) {
        if (ledger.getCurrentBalance() == totalRevenue) {
            System.out.println("Auditoría correcta: el saldo del libro coincide con los ingresos totales.");
        } else {
            System.out.println("Auditoría con diferencias. Libro: $" + String.format("%.2f", ledger.getCurrentBalance())
                    + ", ingresos totales: $" + String.format("%.2f", totalRevenue));
        }
    }
 
    @Override
    public String toString() {
        return "Business{companyName=" + companyName + ", totalRevenue=" + totalRevenue + '}';
    }
 
    public String getCompanyName() {
        return companyName;
    }
 
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
 
    public double getTotalRevenue() {
        return totalRevenue;
    }
 
    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
 
}
 
