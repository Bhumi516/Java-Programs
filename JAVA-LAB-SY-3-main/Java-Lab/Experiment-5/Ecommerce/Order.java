// Name   : Bhumi Bhadre
// Roll No: 31
// Experiment 4: User Defined Packages
// Program 2: Ecommerce Package — Order Class

package Ecommerce;

import java.util.ArrayList;

public class Order {
    private int      orderId;
    private Customer customer;
    private ArrayList<Product> products;
    private ArrayList<Integer> quantities;

    public Order(int orderId, Customer customer) {
        this.orderId    = orderId;
        this.customer   = customer;
        this.products   = new ArrayList<>();
        this.quantities = new ArrayList<>();
    }

    // Place order — add product with quantity
    public void placeOrder(Product p, int qty) {
        if (p.getStock() < qty) {
            System.out.println("  ✗ Insufficient stock for \"" + p.getName() + "\"");
        } else {
            products.add(p);
            quantities.add(qty);
            p.reduceStock(qty);
            System.out.println("  ✓ Added " + qty + " x \"" + p.getName() + "\" to order.");
        }
    }

    // Calculate total cost
    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < products.size(); i++)
            total += products.get(i).getPrice() * quantities.get(i);
        return total;
    }

    // Display full order
    public void displayOrder() {
        System.out.println("  Order ID   : " + orderId);
        System.out.println("  Customer   : " + customer.getName());
        System.out.println("  Items:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println("    - " + products.get(i).getName()
                + " x" + quantities.get(i)
                + "  =  Rs." + (products.get(i).getPrice() * quantities.get(i)));
        }
        System.out.println("  Total Cost : Rs." + calculateTotal());
    }
}
