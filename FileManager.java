// نستدعي أداة جاهزة من الجافا عشان نقدر نكتب داخل الملفات
import java.io.FileWriter;
// نستدعي أداة ثانية عشان تمسك الأخطاء لو صار مشكلة وقت الف أو حفظ الملف
import java.io.IOException;

// الكلاس حقنا اللي يمسك شغل الملفات  
public class FileManager {
    
 // دالة  تاخذ مجموع الفاتورة  اللي نوعه دبل   عشان تحفظه
 public void saveSaleToFile(double total) {
        
 // نقول للبرنامج حاول تنفذ الكود الجاي، ولو صار خطأ حولنا على الـكاتش
   try {  
  //   معناها يضيف الفاتورة الجديدة تحت القديمة و ما يمسحها sale_report نفتح ملف اسمه
  FileWriter writer = new FileWriter("sales_report.txt", true);
            
 // نكتب داخل الملف الاجمالي  وبعدها المبلغ،  \n عشان ينزل سطر جديد
 writer.write("Sale amount: " + total + " SAR\n");
            
 // نقفل الملف عشان نضمن إن البيانات انحفظت صح
 writer.close();
            
 // لو صار أي خطأ ، البرنامج بيجي هنا ويمسك الخطأ 
} catch (IOException Y) {
            
// نطبع في الشاشة إن فيه خطأ، ونطبع تفاصيل الخطأ
System.out.println("An error occurred in the file: " + Y.getMessage());
 }
    }
}