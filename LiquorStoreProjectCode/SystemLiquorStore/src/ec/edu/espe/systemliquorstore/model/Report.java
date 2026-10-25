/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.systemliquorstore.model;

/**
 *
 * @author Enrique Ayala, LogicLords,@ESPE
 */
public class Report {
      private int reportId;
    private double totalSales;
 
    public Report(int reportId, double totalSales) {
        this.reportId = reportId;
        this.totalSales = totalSales;
    }
 
    public void printReport() {
        System.out.println("======== REPORTE " + reportId + " ========");
        System.out.println("Total de ventas: $" + String.format("%.2f", totalSales));
        System.out.println("============================");
    }
 
    @Override
    public String toString() {
        return "Report{reportId=" + reportId + ", totalSales=" + totalSales + '}';
    }
 
    public int getReportId() {
        return reportId;
    }
 
    public void setReportId(int reportId) {
        this.reportId = reportId;
    }
 
    public double getTotalSales() {
        return totalSales;
    }
 
    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }
 
}