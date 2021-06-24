package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreDB implements IDB {
    public Connection getConnection() throws SQLException, ClassCastException,ClassNotFoundException {
        String jdbcURL = "jdbc:postgresql://localhost:5432/ASProject";
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, "postgres","0000");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }
}
