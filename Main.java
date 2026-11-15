// شفت انها احسن من الاراي العادية
import java.util.ArrayList;
// عشان نقدر نقرأ الكلام والأرقام اللي يكتبها المستخدم بالكيبورد
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        //سوينا مستخدم اسمه admin وكلمة السر 1357
        User admin = new User("admin", "1357");
        
        // وحدة نحفظ فيها المنتجات والثانية للعملاء
        ArrayList<Product> productsList = new ArrayList<>();
        ArrayList<Customer> customersList = new ArrayList<>();
        
        // سوينا اوبجكت من كلاس إدارة الملفات عشان نستخدمه في حفظ الفواتير بعدين
        FileManager fileManager = new FileManager();
        
        // ضفنا منتجات تجريبية للقائمة (حليب وبيبسي) عشان نجرب عليها
        productsList.add(new Product(1, "Milk", 5, 50, Category.FOOD));
        productsList.add(new Product(2, "Pepsi", 2.5, 100, Category.DRINKS));
        
        // ضفنا عميل تجريبي للقائمة
        customersList.add(new Customer(1, "Ahmed", "0556798453"));

        // نطبع رسالة ترحيبية للمستخدم
        System.out.println("== SuperMarket Sales Managment  ==");
        
        // نطلب منه يدخل اسم المستخدم
        System.out.print("User Name: ");
        String username = scanner.next(); // السكنر يقرأ الاسم ويحفظه في المتغير
        // نطلب منه يدخل كلمة المرور
        System.out.print("Password: ");
        String password = scanner.next(); // السكنر يقرأ الباسورد ويحفظه

        // هنا نشيّك: هل الاسم والباسورد اللي دخلها تطابق بيانات الادمين
        if (admin.login(username, password)) {
            // لو صح، نرحب فيه
            System.out.println(" Hello " + admin.getUsername() + "!");
            
            //هذا اللي بيخلي القائمة تعيد نفسها وما تقفل
            boolean run = true;
            
            //  حلقة تكرار (لوب) تشتغل طالما المتغيرصحيح
            while (run) {
                // نطبع خيارات القائمة الرئيسية
                System.out.println("--- Main Menu ---");
                System.out.println("1.Add Product");
                System.out.println("2.Display Products");
                System.out.println("3.Add Customer");
                System.out.println("4.Cashier Sales Process");
                System.out.println("5.Exit");
                System.out.println("Choose: ");
                
                // نقرأ رقم الخيار اللي اختاره المستخدم
                int choice = scanner.nextInt();
                
                // لو اختار 1 (إضافة منتج)
                if (choice == 1) {
                    // نطلب تفاصيل المنتج (ID، اسم، سعر، كمية) ونقرأها بالسكنر
                    System.out.print("Product ID: ");
                    int pId = scanner.nextInt();
                    System.out.print("Product Name: ");
                    String pName = scanner.next();
                    System.out.print("Price: ");
                    double pPrice = scanner.nextDouble();
                    System.out.print("Quantity: ");
                    int pQty = scanner.nextInt();
                    
                    // ننشئ كائن جديد للمنتج بالبيانات اللي دخلناها
                    Product newProd = new Product(pId, pName, pPrice, pQty);
                    // نضيف المنتج لقائمة المنتجات
                    productsList.add(newProd);
                    System.out.println("Added successfully!");
                    
                     // لو اختار 2 (عرض المنتجات)
                     } else if (choice == 2) {
                     System.out.println("--- Product List ---");
                    // لوب يلف على كل المنتجات اللي في القائمة ويطبعها واحد واحد
                    for (int i = 0; i < productsList.size(); i++) {
                    productsList.get(i).displayProduct();
  }
 }                  else if (choice == 3) {
	 
                    // نطلب بيانات العميل (ID، اسم، جوال)
                     System.out.print("Customer ID: ");
                     int Id = scanner.nextInt();
     System.out.print(" Customer Name: ");
     String Name = scanner.next();
    
     System.out.print("Phone Number: ");
     String Phone = scanner.next();    
      // ننشئ العميل ونضيفه للقائمة
      customersList.add(new Customer(Id, Name, Phone));
      System.out.println("Customer added successfully");  
      // لو اختار 4 (عملية البيع -)
       } else if (choice == 4) {
      // نستخدم عشان لو صار خطأ في البيع  وما يعلق البرنامج
      try {
      // نشيك لو قائمة العملاء أو المنتجات فاضية ما نقدر نبيع
      if (customersList.isEmpty() || productsList.isEmpty()) {
       // الخطأ المخصص حقنا اللي سويناه في المشروع
       throw new SupermarketException("No customers or products available to complete the sale!");
                        }
      // ننشئ سلة تسوق جديدة
      Cart cart = new Cart();
      // نختار أول عميل في القائمة كمثال عشان نبيع له
      Customer currentCustomer = customersList.get(0);       
      System.out.println("--- New sale for the customer " + currentCustomer.getName() + " ---");
      System.out.print("The requested product: ");
      int sId = scanner.nextInt();
                        
                        // متغير فاضي بنحط فيه المنتج لو لقيناه
                        Product foundProd = null;
                        // لوب يبحث في قائمة المنتجات عن المنتج اللي حطه هل حقه يطابق اللي أدخله المستخدم
                        for (int i = 0; i < productsList.size(); i++) {
                        if (productsList.get(i).getId() == sId) {
                                foundProd = productsList.get(i);
                            }
                        }
                        
                        // لو لقينا المنتج  
                        if (foundProd != null) {
                            System.out.print("Required quantity: ");
                            int reqQty = scanner.nextInt();
                            
                            // نشيك هل الكمية المطلوبة متوفرة في المخزون؟
                            if (reqQty <= foundProd.getQuantity()) {
                                 // نضيف المنتج للسلة
                                cart.addItem(new CartItem(foundProd, reqQty));
                                // نخصم الكمية اللي انباعت من المخزون الأساسي للمنتج
                                foundProd.setQuantity(foundProd.getQuantity() - reqQty);
                                
                                // ننشئ فاتورة ونطبعها
                                Invoice inv = new Invoice(currentCustomer, cart);
                                inv.printInvoice();
                                
                                // نحفظ الملف في فايل مانجر
                               fileManager.saveSaleToFile(cart.getTotalPrice());
                               } else {
                                System.out.println("اThe quantity is not available in stock");
                               }
                               } else {
                                System.out.println("The product not found");
                               }
                          
                      // هنا نمسك الخطأ المخصص (SupermarketException) ونطبع رسالته
                    } catch (SupermarketException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    
                       // لو اختار 5 (خروج)
                    } else if (choice == 5) {
                      System.out.println("Invalid option");
                 //نغير قيمة رن الى فالس عشان يوقف البرنامج 
                 run = false;
                 } else {
                 // لو أدخل رقم غير
                 System.out.println("Invalid option!");
  }
}
                 // لو الباسورد أو اليوزر خطأ
                } else {
                 System.out.println("Invalid login Data");
                 }
                // نقفل السكنر عشان ما يستهلك من ذاكرة الجهاز
                scanner.close();
    }
}