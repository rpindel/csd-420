import java.sql.SQLException;
import javax.sql.RowSet;
import javax.sql.rowset.*;

public class DBPostCode {
    // main method
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Step 1 - Driver - Load driver for needed database type
        Class.forName("Required database driver");

        // Create your RowSet object **this is the new method versus what is provided in the textbook
        JdbcRowSet myRowSet = RowSetProvider.newFactory().createJdbcRowSet();
        
        // Step 2 and 3 - Connection and Statement
        myRowSet.setUrl("Database connection url");
        myRowSet.setUsername("Database connection username");
        myRowSet.setPassword("Database connection password");
        myRowSet.setCommand("SELECT * from myTable");
        myRowSet.execute();

        // Step 4 - ResultSet - Display the data returned from the command DB query
        while (myRowSet.next()) {
            System.out.println(myRowSet.getString(1) + "\t" + 
                myRowSet.getString(2) + "\t" + myRowSet.getString(n));
        } 

        // Close database connection because we are using a connected RowSet object
        myRowSet.close();        
    };
}
