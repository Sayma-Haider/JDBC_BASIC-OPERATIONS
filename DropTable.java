package jdbcdemo;

import java.sql.*;

/**
 *
 * @author Sayma
 */
public class DropTable {
    static final String DB_URL = "jdbc:mysql://localhost:3306/STUDENTS";
    static final String USER = "Saima";
    static final String PASS = "12345";
    
    public static void main(String[] args) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        
        try{
           myConn = DriverManager.getConnection(DB_URL, USER, PASS);
           
           String sqlQuery = "DROP TABLE REGISTRATION";
           
           myStmt = myConn.createStatement();
           myStmt.executeUpdate(sqlQuery);
           
           System.out.println("Table deleted in given database..."); 
        }catch(SQLException e){
           e.printStackTrace();
        }
    }
       
}

