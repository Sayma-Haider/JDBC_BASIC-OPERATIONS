package jdbcdemo;

import java.sql.*;
/**
 *
 * @author Sayma
 */
public class Sorting {
    static final String DB_URL = "jdbc:mysql://localhost:3306/STUDENTS";
    static final String USER = "Saima";
    static final String PASS = "*****";
    
    public static void main(String[] args) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        
        try{
            myConn = DriverManager.getConnection(DB_URL, USER, PASS);
            myStmt = myConn.createStatement();
            
            String query = "SELECT Student_ID, First_Name, Last_Name, Age FROM Registration";
            
            myRs = myStmt.executeQuery(query);
            
            System.out.println("Fetching records before sorting...");
            
            while(myRs.next())
            {
                System.out.print("ID: " + myRs.getInt("Student_ID"));
                System.out.print(", Age: " + myRs.getInt("Age"));
                System.out.print(", First: " + myRs.getString("First_Name"));
                System.out.println(", Last: " + myRs.getString("Last_Name"));
            }
            
            System.out.println("Fetching records after sorting in ascending order...");
            
            query = "SELECT Student_ID, First_Name, Last_Name, Age FROM Registration" + " ORDER BY First_Name ASC ";
            
            myRs = myStmt.executeQuery(query);
            
            while(myRs.next())
            {
                System.out.print("ID: " + myRs.getInt("Student_ID"));
                System.out.print(", Age: " + myRs.getInt("Age"));
                System.out.print(", First: " + myRs.getString("First_Name"));
                System.out.println(", Last: " + myRs.getString("Last_Name"));
            }
            
            System.out.println("Fetching records after sorting in descending...");
            
            query = "SELECT Student_ID, First_Name, Last_Name, Age FROM Registration" + " ORDER BY First_Name DESC ";
            
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
