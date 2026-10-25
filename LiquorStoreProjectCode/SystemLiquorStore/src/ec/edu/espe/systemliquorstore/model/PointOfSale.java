/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.systemliquorstore.model;

/**
 *
 * @author Enrique Ayala, LogicLords,@ESPE
 */
public class PointOfSale {
    
    private int terminalId;
    private String status;
 
    public PointOfSale(int terminalId, String status) {
        this.terminalId = terminalId;
        this.status = status;
    }
 
    public void login(Cashier cashier) {
        status = "ACTIVO";
        System.out.println("El turno " + cashier.getShiftId() + " inició sesión en la terminal " + terminalId + ". Estado: " + status);
    }
 
    @Override
    public String toString() {
        return "PointOfSale{terminalId=" + terminalId + ", status=" + status + '}';
    }
 
    public int getTerminalId() {
        return terminalId;
    }
 
    public void setTerminalId(int terminalId) {
        this.terminalId = terminalId;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
 
}