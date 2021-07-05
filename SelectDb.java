package jdbcdemo;

import java.sql.*;
/**
 *
 * @author Sayma
 */
public class SelectDb {
    static final String DB_URL = "jdbc:mysql://localhost:3306/STUDENTS";
    static final String USER = "Saima";
    static final String PASS = "*****";
    
    public static void main(String[] args) throws SQLException {
        
        Connection myConn = null;
        
        System.out.println("Connecting to a selected database...");
        
        try{
            myConn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
