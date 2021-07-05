package jdbcdemo;

import java.sql.*;
/**
 *
 * @author Sayma
 */
public class SelectRecord {
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
            
            while(myRs.next())
            {
                System.out.print("ID: " + myRs.getInt("Student_ID"));
                System.out.print(", Age: " + myRs.getInt("Age"));
                System.out.print(", First: " + myRs.getString("First_Name"));
                System.out.println(", Last: " + myRs.getString("Last_Name"));
            }
            
        }catch(SQLException e){
           e.printStackTrace();
        }
    }
}
