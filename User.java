// كلاس يمثل الكاشير أو مدير النظام
public class User {
    private String username;
    private String password;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // يتحقق من تسجيل الدخول
    public boolean login(String u, String p) {
        if (this.username.equals(u) && this.password.equals(p)) {
            return true;
        } else {
            return false;
        }
    }

    // Getters
    public String getUsername() {
        return this.username;
    }
}