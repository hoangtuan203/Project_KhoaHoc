package DAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DatabaseConnect {
    public static Connection c;
    public static Statement s;
    
    public static String host, port, dbName, dbUser, dbPassword;
    
    
    public static void connectDB()
    {
        host = "localhost";
        port = "3306";
        dbUser = "root";
        dbName = "school";
        dbPassword = "";
        String dbPath = "jdbc:mysql://" + host + ":" + port + "/"
                + dbName + "?useUnicode=yes&characterEncoding=UTF-8";
        try {
            c = (Connection) DriverManager.getConnection(dbPath, dbUser, dbPassword);
            s = c.createStatement();
            
            System.out.println("Kết nối thành công DB");
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }
    public static Connection getConnection()
    {
        return c;
    }
    //run sql
    public static ResultSet doReadQuery(String sql) {
        ResultSet rs = null;
        
        try {
            rs = s.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return rs;
    }
     public static void closeConnection() {
        try {
            if (s != null) {
                s.close();
            }
            if (c != null) {
                c.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    //test connection
    public static void main(String[] args) {
        DatabaseConnect.connectDB();
        
    } 
}
