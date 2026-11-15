
// كلاس الفاتورة لطباعة تفاصيل البيع
public class Invoice {
    private static int invoiceCounter = 1;
    private int invoiceId;
    private Customer customer;
    private Cart cart;
    
    // Constructor
    public Invoice(Customer customer, Cart cart) {
        this.invoiceId = invoiceCounter;
        invoiceCounter++; // نزود العداد عشان الفاتورة الجاية
        this.customer = customer;
        this.cart = cart;
        
    }

    // دالة طباعة الفاتورة
    public void printInvoice() {
        System.out.println("==========================");
        System.out.println("        Invoice");
        System.out.println("==========================");
        System.out.println("Invoice Number: " + this.invoiceId);
        System.out.println("The Customer: " + this.customer.getName());
        System.out.println("--------------------------");
        
        for (int i = 0; i < cart.getItems().size(); i++) {
            CartItem item = cart.getItems().get(i);
            System.out.println(item.getProduct().getName() + " x" + item.getQuantityToBuy() + 
                               " = " + item.getItemTotal() + " SAR");
        }
        
        System.out.println("--------------------------");
        System.out.println("Total: " + this.cart.getTotalPrice() + " SAR");
        System.out.println("==========================");
    }
}