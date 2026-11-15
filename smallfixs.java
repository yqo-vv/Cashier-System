public class smallfixs {
    // دالة لحساب الإجمالي بعد الضريبة
    public static double calculateTotalWithTax(double subtotal) {
        double taxRate = 0.15; //نسبة الضريبة
        return subtotal + (subtotal * taxRate);
    }

    public static void main(String[] args) {
        double testAmount = 100.0;
        System.out.println("Original: $" + testAmount);
        System.out.println("Total with Tax: $" + calculateTotalWithTax(testAmount));
    }
}
    


