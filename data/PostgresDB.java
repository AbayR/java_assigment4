package data;
import data.interfaces.IDB;
import java.sql.*;
public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/medicines";
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.postgresql-42.3.2");

            // Establish the connection
            Connection con = DriverManager.getConnection("postgres://postgres:RazakovAbay09@localhost:5432/medicines", "postgres", "RazakovAbay09");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}