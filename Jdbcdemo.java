package jdbcdemo;

import java.sql.*;
/**
 *
 * @author Sayma
 */
public class Jdbcdemo {

    public static void main(String[] args) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String user = "Saima";
        String pass = "*****";

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/University", user, pass);

            // 2. Create a statement
            myStmt = myConn.createStatement();

            // 3. Execute SQL query
            myRs = myStmt.executeQuery("select * from EngineeringStudents");
            //myRs = myStmt.executeQuery("select Student_ID, Department, First_Name, Last_Name, PassOutYear, UniversityRank from EngineeringStudents where Student_ID = 10202");

            // 4. Process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
                /*String UniversityData = "";
                for(int i = 1; i <= 4; i++)
                    UniversityData += myRs.getString(i) + ":";
                
                System.out.println(UniversityData);*/
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
    }
    
}
