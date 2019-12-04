package app;

import java.awt.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListagemJF extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final JTextArea textArea;
    String textoTela;

    public ListagemJF(final int mostrar) {

        super("Listagem");
        final String url = "jdbc:mysql://localhost:3306/contas";// NomeDoBanco
        final String user = "root";
        final String password = "";
        try {
            final Connection connection = DriverManager.getConnection(url, user, password);
            final String sql = " Select * from pessoas ";
            final Statement statement = connection.createStatement();
            final ResultSet resultados = statement.executeQuery(sql);
            while (resultados.next()) {
                final Pessoas pessoa = new Pessoas(resultados.getInt("id"), resultados.getString("nome"),
                        resultados.getString("email"));

                textoTela = textoTela + "Nome: " + resultados.getString("nome") + "\nEmail: "
                        + resultados.getString("email") + "\n";

                if (mostrar == 2) {

                }
            }
        } catch (final Exception er) {
            System.out.println("Não Criou uma PEssoa" + er);
        }

        textArea = new JTextArea(textoTela);
        final Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(textArea);
        this.setVisible(true);
        this.setSize(400, 285);
        this.setContentPane(pane);
    }

    public static void main(final String[] args) {
        final ListagemJF lista = new ListagemJF(1);
    }

}