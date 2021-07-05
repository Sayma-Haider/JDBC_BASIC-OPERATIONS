package jdbcdemo;

import java.sql.*;
/**
 *
 * @author Sayma
 */
public class InsertRecord {
    static final String DB_URL = "jdbc:mysql://localhost:3306/STUDENTS";
    static final String USER = "Saima";
    static final String PASS = "*****";
    
    public static void main(String[] args) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        
        try{
            myConn = DriverManager.getConnection(DB_URL, USER, PASS);
            myStmt = myConn.createStatement();
            
            System.out.println("Inserting records into the table...");          
            String sqlQuery = "INSERT INTO Registration VALUES (100, 'Harry', 'Potter', 18)";
            myStmt.executeUpdate(sqlQuery);
            sqlQuery = "INSERT INTO Registration VALUES (101, 'Hermione', 'Granger', 18)";
            myStmt.executeUpdate(sqlQuery);
            sqlQuery = "INSERT INTO Registration VALUES (102, 'Ronald', 'Weasely', 18)";
            myStmt.executeUpdate(sqlQuery);
            sqlQuery = "INSERT INTO Registration VALUES(103, 'Fred', 'Weasely', 21)";
            
            myStmt.executeUpdate(sqlQuery);
            System.out.println("Inserted records into the table...");  
         
        }catch(SQLException e){
           e.printStackTrace();
        }
    }
}
