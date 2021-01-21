
package db_islemler;
import java.sql.*;


public class Db_Baglanti {
    public Connection con ;
    public Statement statement ;
    public PreparedStatement preparedstatement;
    
    
    public Db_Baglanti(){
        this.statement = null;
        this.con = null;
        
    
        // Yukarıdaki özelliklerle url oluşturmalıyız..
        // "jdbc:mysql://localhost:3306/demo
        String url = ("jdbc:oracle:thin:@localhost:1521:XE");
        
        try {
            //Veri tabanına bağlanmak için gerekli olan Driver'ı başlatmalyız.
            Class.forName ("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadı...");
        }
        
        try {
            con = DriverManager.getConnection(url, "SYSTEM", "oracledb123");
            statement = con.createStatement();
            System.out.println("Bağlantı Başarılı...");
        } catch (SQLException ex) {
            System.out.println("Bağlantı Başarısız...");
        }
    }
    
    
    
}
