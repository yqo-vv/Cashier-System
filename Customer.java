
// كلاس يمثل العميل
public class Customer {
    private int customerId;
    private String name;
    private String phone;

    // Constructor
    public Customer(int customerId, String name, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
    }

    // Getters
    public int getCustomerId() { return this.customerId; }
    public String getName() { return this.name; }
    public String getPhone() { return this.phone; }

    // طباعة بيانات العميل
    public void displayCustomer() {
        System.out.println("Customer ID: " + this.customerId + " | Name: " + this.name + " | Phone: " + this.phone);
    }
}