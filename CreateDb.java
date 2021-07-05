package jdbcdemo;

import java.sql.*;
/**
 *
 * @author Sayma
 */
public class CreateDb {
    
    static final String DB_URL = "jdbc:mysql://localhost/";
    static final String USER = "Saima";
    static final String PASS = "12345";
    
    public static void main(String[] args) throws SQLException {
        
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        
        try{
            myConn = DriverManager.getConnection(DB_URL, USER, PASS); 
            myStmt = myConn.createStatement();
            
            String sqlQuery = "CREATE DATABASE STUDENTS";
            myStmt.executeUpdate(sqlQuery);
            System.out.println("Database created successfully...");  
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
