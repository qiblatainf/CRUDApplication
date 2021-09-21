import java.sql.*;
import java.util.logging.*;

public class ConnectingToDB  {
    public PreparedStatement pst;
    public Connection conn;
    public ResultSet rs;
    public static Connection getConnection() {
        Connection conn = null;
        
        try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "26188");
        
        if (conn == null){
            System.out.println("Unable to connect with the DB");
            return null;
        }
        System.out.println("connected with DB");
       
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectingToDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    
    public static void main(String [] args){   
        Connection conn = ConnectingToDB.getConnection();
    }
}
