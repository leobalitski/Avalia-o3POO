package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Proventos extends Contas {

    private double imposto;

    public Proventos(int id, int mes, int ano, double valor, Pessoas pessoa, double imposto) {
        super(id, mes, ano, valor, pessoa);
        this.imposto = imposto;
    }

    public Proventos(int mes, int ano, double valor, Pessoas pessoa, double imposto) {
        this(0, mes, ano, valor, pessoa, imposto);
        
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO proventos (ano, mes, valor, imposto, pessoas_id) VALUES (?,?,?,?,?)";
            PreparedStatement statemente = connection.prepareStatement(sql);
            statemente.setInt(1, ano);
            statemente.setInt(2, mes);
            statemente.setDouble(3, valor);
            statemente.setDouble(4, imposto);
            statemente.setInt(5, pessoa.getId());
            statemente.execute();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public Proventos() {
    }

    public Proventos(double imposto) {
        this.imposto = imposto;
    }

    public double getImposto() {
        return this.imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public Proventos imposto(double imposto) {
        this.imposto = imposto;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Proventos)) {
            return false;
        }
        Proventos proventos = (Proventos) o;
        return imposto == proventos.imposto;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(imposto);
    }

    @Override
    public String toString() {
        return "{" +
            " imposto='" + getImposto() + "'" +
            "}";
    }


}