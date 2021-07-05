package jdbcdemo;

import java.sql.*;
/**
 *
 * @author Sayma
 */
public class DeleteRecords {
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
            
            String query = "DELETE FROM REGISTRATION " + "WHERE Student_ID = 103";
            
            myStmt.executeUpdate(query);
            
            query = "SELECT Student_ID, First_Name, Last_Name, Age FROM Registration";
            
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
