package jdbcdemo;

import java.sql.*;
/**
 *
 * @author Sayma
 */
public class WhereClause {
    
    static final String DB_URL = "jdbc:mysql://localhost:3306/STUDENTS";
    static final String USER = "Saima";
    static final String PASS = "12345";
    
    public static void main(String[] args) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        
        try{
            myConn = DriverManager.getConnection(DB_URL, USER, PASS);
            myStmt = myConn.createStatement();
            
            String query = "SELECT Student_ID, First_Name, Last_Name, Age FROM Registration";
            
            myRs = myStmt.executeQuery(query);
            
            System.out.println("Fetching records without condition...");
            
            while(myRs.next())
            {
                System.out.print("ID: " + myRs.getInt("Student_ID"));
                System.out.print(", Age: " + myRs.getInt("Age"));
                System.out.print(", First: " + myRs.getString("First_Name"));
                System.out.println(", Last: " + myRs.getString("Last_Name"));
            }
            
            System.out.println("Fetching records with condition...");
            
            query = "SELECT Student_ID, First_Name, Last_Name, Age FROM Registration" + " WHERE Student_ID >= 101 ";
            
            myRs = myStmt.executeQuery(query);
            
            while(myRs.next())
            {
                System.out.print("ID: " + myRs.getInt("Student_ID"));
                System.out.print(", Age: " + myRs.getInt("Age"));
                System.out.print(", First: " + myRs.getString("First_Name"));
                System.out.println(", Last: " + myRs.getString("Last_Name"));
            }
            
            myRs.close();
            
        }catch(SQLException e){
           e.printStackTrace();
        }
    }
}
