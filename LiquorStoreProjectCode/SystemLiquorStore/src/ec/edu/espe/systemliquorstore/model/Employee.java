/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.systemliquorstore.model;

import java.util.Date;

/**
 *
 * @author Enrique Ayala, LogicLords,@ESPE
 */
public class Employee {
   private int employeeId;
    private String name;
 
    public Employee(int employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }
 
    public void registerClockIn() {
        System.out.println("El empleado " + name + " registró su entrada: " + new Date());
    }
 
    @Override
    public String toString() {
        return "Employee{employeeId=" + employeeId + ", name=" + name + '}';
    }
 
    public int getEmployeeId() {
        return employeeId;
    }
 
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
}