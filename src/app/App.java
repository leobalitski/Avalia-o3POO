package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(final String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/contas?useTimezone=true&serverTimezone=UTC";
         String user = "root";
         String password = "";
         Connection connection = DriverManager.getConnection(url, user,password);
         
            System.out.println("deu certo caramba");

        
        System.out.println("deu certo " + connection);
        connection.close();
    }
}