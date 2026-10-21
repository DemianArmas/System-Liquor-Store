package ec.edu.espe.systemliquorstore.model;

/**
 *
 * @author Demian Armas, Logical Lords, @ESPE
 */
public class Item {

    private String barcode;
    private double sellingPrice;

    public Item(String barcode, double sellingPrice) {
        this.barcode = barcode;
        this.sellingPrice = sellingPrice;
    }

    public void linkProduct(Product product) {
        System.out.println("El articulo " + barcode + " se vinculo al producto " + product.getName());
    }

    public void applyDiscount(double percentage) {
        if (percentage < 0 || percentage > 100) {
            System.out.println("El descuento debe estar entre 0 y 100.");
            return;
        }
        sellingPrice = sellingPrice - (sellingPrice * percentage / 100);
        System.out.println("Descuento del " + percentage + "% aplicado. Nuevo precio: $"
                + String.format("%.2f", sellingPrice));
    }

    @Override
    public String toString() {
        return "Item{barcode=" + barcode + ", sellingPrice=" + sellingPrice + '}';
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

}
