/* Reference
 * https://zetcode.com/db/mysqljava/
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCMySQLVersion {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/databasedb?useSSL=false";
        String user = "student1";
        String password = "pass";
        
        String query = "SELECT VERSION()";

        try (Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                
                System.out.println(rs.getString(1));
            }

        } catch (SQLException ex) {
            
            Logger lgr = Logger.getLogger(JDBCMySQLVersion.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } 
    }
}