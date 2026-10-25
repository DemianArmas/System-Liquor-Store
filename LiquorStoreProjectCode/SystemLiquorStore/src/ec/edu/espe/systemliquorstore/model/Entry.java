/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.systemliquorstore.model;

/**
 *
 * @author Isaac Acurio, Logical Lords, @ESPE
 */
public class Entry {

    private int entryId;
    private int quantity;
    private Item item;

    public Entry(int entryId, int quantity) {
        this.entryId = entryId;
        this.quantity = quantity;
    }

    public void assignItem(Item item) {
        this.item = item;
        System.out.println("Item " + item.getBarcode() + " assigned to entry " + entryId);
    }

    public double calculateSubtotal() {
        if (item == null) {
            System.out.println("Entry " + entryId + " has no item assigned.");
            return 0.0;
        }
        return quantity * item.getSellingPrice();
    }

    @Override
    public String toString() {
        return "Entry{entryId=" + entryId + ", quantity=" + quantity + ", item=" + item + '}';
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}