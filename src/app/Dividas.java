package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dividas extends Contas {

    private double percentual_desconto;

    Dividas(int id, int mes, int ano, double valor, Pessoas pessoa, double percentual_desconto) {
        super(id, mes, ano, valor, pessoa);
        this.percentual_desconto = percentual_desconto;
    }

    Dividas(int mes, int ano, double valor, int idpessoa, double percentual_desconto) {
        String url = "jdbc:mysql://localhost:3306/contas"; //NomeDoBanco
        String user = "root";
        String password = "";
        int aux = 1;
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = " INSERT INTO dividas (ano, mes, valor, percentual_desconto, pessoas_id) VALUES (?,?,?,?,?)";

            PreparedStatement statemente = connection.prepareStatement(sql);
            statemente.setInt(1, ano);
            statemente.setInt(2, mes);
            statemente.setDouble(3, valor);
            statemente.setDouble(4, percentual_desconto);
            statemente.setInt(5, idpessoa);
           
            statemente.execute();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

}
