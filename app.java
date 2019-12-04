package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(final String[] args) throws SQLException {
        final String url = "jdbc:mysql://localhost:3306/contas";
        final String user = "root";
        final String password = "";

        // DriverManager.registerDriver(new Driver());
        final Connection connection = DriverManager
            .getConnection(url, user,password);

        System.out.println("deu certo " + connection);
    }
}