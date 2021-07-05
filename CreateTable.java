package jdbcdemo;

import java.sql.*;
/**
 *
 * @author Sayma
 */
public class CreateTable {
    static final String DB_URL = "jdbc:mysql://localhost:3306/Students";
    static final String USER = "Saima";
    static final String PASS = "*****";
    
    public static void main(String[] args) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        
        try{
            myConn = DriverManager.getConnection(DB_URL, USER, PASS);
            myStmt = myConn.createStatement();
            
            String sqlQuery = "CREATE TABLE REGISTRATION " +
                    "(Student_ID INTEGER not NULL, " +
                    " First_Name VARCHAR(25), " +
                    " Last_Name VARCHAR(25), " +
                    " Age INTEGER, " +
                    " PRIMARY KEY ( Student_ID )) ";
            
            myStmt.executeUpdate(sqlQuery);
            
            System.out.println("Created table in given database...");  
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
