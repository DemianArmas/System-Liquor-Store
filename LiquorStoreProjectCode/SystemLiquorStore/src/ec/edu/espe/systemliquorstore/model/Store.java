/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.systemliquorstore.model;

/**
 *
 * @author Enrique Ayala, LogicLords,@ESPE
 */
public class Store {
     private int storeId;
    private String location;
 
    public Store(int storeId, String location) {
        this.storeId = storeId;
        this.location = location;
    }
 
    public void assignEmployee(Employee employee) {
        System.out.println("El empleado " + employee.getName() + " fue asignado a la tienda " + storeId + " en " + location);
    }
 
    public void setupPOS(PointOfSale pointOfSale) {
        System.out.println("La terminal " + pointOfSale.getTerminalId() + " fue instalada en la tienda " + storeId);
    }
 
    @Override
    public String toString() {
        return "Store{storeId=" + storeId + ", location=" + location + '}';
    }
 
    public int getStoreId() {
        return storeId;
    }
 
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
 
    public String getLocation() {
        return location;
    }
 
    public void setLocation(String location) {
        this.location = location;
    }
 
}
