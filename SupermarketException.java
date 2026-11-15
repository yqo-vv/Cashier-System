// كلاس خاص فينا عشان نعطي رسائل خطأ واضحة
public class SupermarketException extends Exception {
    
    // Constructor
    public SupermarketException(String message) {
        // نرسل الرسالة للكلاس الأب Exception
        super(message);
    }
}