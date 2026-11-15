// العضو 3
// يمثل المنتج والكمية اللي طلبها العميل في السلة
public class CartItem {
    private Product product;
    private int quantityToBuy;

    // Constructor
    public CartItem(Product product, int quantityToBuy) {
        this.product = product;
        this.quantityToBuy = quantityToBuy;
    }

    public Product getProduct() { return this.product; }
    public int getQuantityToBuy() { return this.quantityToBuy; }

    // حساب السعر الإجمالي لهذا العنصر
    public double getItemTotal() {
        return this.product.getPrice() * this.quantityToBuy;
    }
}