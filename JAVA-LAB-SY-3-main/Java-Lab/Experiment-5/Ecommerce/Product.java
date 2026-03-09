// Name   : Arhan Gaiban
// Roll No: 43
// Experiment 4: User Defined Packages
// Program 2: Ecommerce Package — Product Class

package Ecommerce;

public class Product {
    private int    productId;
    private String name;
    private double price;
    private int    stock;

    public Product(int productId, String name, double price, int stock) {
        this.productId = productId;
        this.name      = name;
        this.price     = price;
        this.stock     = stock;
    }

    // Getters
    public int    getProductId() { return productId; }
    public String getName()      { return name; }
    public double getPrice()     { return price; }
    public int    getStock()     { return stock; }

    public void reduceStock(int qty) { stock -= qty; }

    public void displayProduct() {
        System.out.println("  Product ID : " + productId);
        System.out.println("  Name       : " + name);
        System.out.println("  Price      : Rs." + price);
        System.out.println("  Stock      : " + stock);
    }
}
