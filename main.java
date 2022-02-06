import controllers.UserController;
import data.PostgresDB;
import data.interfaces.IDB;
import respositories.UserRepository;
import respositories.interfaces.IUserRepository;

import java.sql.*;
import java.util.Properties;

public class main {

    public static void main(String[] args) throws SQLException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/medicines";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","RazakovAbay09");
        props.setProperty("ssl","true");
        Connection con = DriverManager.getConnection(connectionUrl, props) ;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            con = DriverManager.getConnection(connectionUrl, "postgres", "RazakovAbay09");

            // The object of statement is responsible to execute queries with the database
            stmt = con.createStatement();

            // The executeQuery() method of Statement interface is used to execute queries
            // to the database. This method returns the object of ResultSet that can be
            // used to get all the records of a table that matches the sql statement
            rs = stmt.executeQuery("select mistake * from users");

           while (rs.next()) // Processing the result
               System.out.println(rs.getInt("id") + "  "
                        + rs.getString("name") + "  " + rs.getDouble("price") + "  " + rs.getDate("expiration_date") + "  " + rs.getString("manufacturer") + "  " + rs.getString("usage"));
        }
        catch (Exception e) {
            System.out.println("Exception occurred!");
       } finally {

            try { // Close connection - clean up the system resources
               con.close();
            } catch (Exception e) {
                System.out.println("Exception occurred!");
           }
        }

        System.out.println("Finished!");

        // Here you specify which DB and UserRepository to use
        // And changing DB should not affect to whole code
        IDB db = new PostgresDB();
        IUserRepository repo = new UserRepository(db);
        UserController controller = new UserController(repo);
        myapp app = new myapp(controller);
        app.start();
    }
}