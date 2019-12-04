package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;


public class Principal {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        

        String url ="jdbc:mysql://localhost:3306/contas";//NomeDoBanco

        System.out.println("ate aqui funcuinou porra");

        String user ="root";
        String password="";
        

        Connection connection = DriverManager.getConnection(url, user, password);


        System.out.println("DEU CERTO " + connection);
    }
}