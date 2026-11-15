// كلاس يمثل المنتج الواحد في السوبرماركت
public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private Category category;

    // Constructor الأول (Overloading)
    public Product(int id, String name, double price, int quantity, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    // Constructor (اذا بدون تصنيف نعطيه اخرى)
    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = Category.OTHER;
    }

    // دوال Getters و Setters
    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public double getPrice() { return this.price; }
    public int getQuantity() { return this.quantity; }
    public Category getCategory() { return this.category; }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // دالة لطباعة معلومات المنتج
    public void displayProduct() {
        System.out.println("ID: " + this.id + " | Name: " + this.name + 
                           " | Price: " + this.price + " | Qty: " + this.quantity + 
                           " | Category: " + this.category);
    }
}