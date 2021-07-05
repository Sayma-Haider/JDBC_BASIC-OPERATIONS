package jdbcdemo;

import java.sql.*;

/**
 *
 * @author Sayma
 */
public class DropDb {
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "Saima";
    static final String PASS = "*****";
    
    public static void main(String[] args) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        
        try{
           myConn = DriverManager.getConnection(DB_URL, USER, PASS);
           
           String sqlQuery = "DROP DATABASE STUDENTS";
           
           myStmt = myConn.createStatement();
           myStmt.executeUpdate(sqlQuery);
           
           System.out.println("Database dropped successfully..."); 
           
        }catch(SQLException e){
           e.printStackTrace();
        }
    }
       
}
