// Name   : Arhan Gaiban
// Roll No: 43
// Experiment 4: User Defined Packages
// Program 2: Ecommerce Package — Customer Class

package Ecommerce;

public class Customer {
    private int    customerId;
    private String name;
    private String email;
    private String address;

    public Customer(int customerId, String name, String email, String address) {
        this.customerId = customerId;
        this.name       = name;
        this.email      = email;
        this.address    = address;
    }

    // Getters
    public int    getCustomerId() { return customerId; }
    public String getName()       { return name; }
    public String getEmail()      { return email; }
    public String getAddress()    { return address; }

    public void displayCustomer() {
        System.out.println("  Customer ID : " + customerId);
        System.out.println("  Name        : " + name);
        System.out.println("  Email       : " + email);
        System.out.println("  Address     : " + address);
    }
}
