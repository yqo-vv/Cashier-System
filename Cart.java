
// العضو 3
import java.util.ArrayList;

// كلاس السلة يجمع العناصر
public class Cart {
    private ArrayList<CartItem> items;

    // Constructor
    public Cart() {
        this.items = new ArrayList<>();
    }

    // إضافة منتج للسلة
    public void addItem(CartItem item) {
        this.items.add(item);
    }

    // حساب المجموع الكلي للسلة
    public double getTotalPrice() {
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            total = total + items.get(i).getItemTotal();
        }
        return total;
    }

    public ArrayList<CartItem> getItems() {
        return this.items;
    }
    
    // تفريغ السلة
    public void clearCart() {
        this.items.clear();
    }
}