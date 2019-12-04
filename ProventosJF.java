package app;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;;

public class ProventosJF extends JFrame {
    private JButton botao;
    private JTextField textAno;
    private JLabel labelAno;
    private JTextField textValor;
    private JLabel labelValor;
    private JTextField textMes;
    private JLabel labelMes;
    private JTextField textImposto;
    private JLabel labelImposto;
    private JTextField textPessoa;
    private JLabel labelPessoa;

    public ProventosJF() {
        super("Proventos");
        botao = new JButton("Enviar");
        textAno = new JTextField(25);
        labelAno = new JLabel("Ano");
        textValor = new JTextField(25);
        labelValor = new JLabel("Valor");
        textMes = new JTextField(25);
        labelMes = new JLabel("MÊS");
        textImposto = new JTextField(25);
        labelImposto = new JLabel("IMPOSTO");
        textPessoa = new JTextField(25);
        labelPessoa = new JLabel("ID Pessoa");

        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));

        pane.add(labelPessoa);
        pane.add(textPessoa);

        pane.add(labelMes);
        pane.add(textMes);

        pane.add(labelAno);
        pane.add(textAno);

        pane.add(labelValor);
        pane.add(textValor);

        pane.add(labelImposto);
        pane.add(textImposto);

        pane.add(botao);
        this.setVisible(true);
        this.setSize(300, 400);
        this.setContentPane(pane);

        ActionListener handlerAction = new ActionListener() {
            public void actionPerformed(final ActionEvent event) {
                methodAction(event);
            }
        };
        
        botao.addActionListener(handlerAction);
    }

    private void methodAction(final ActionEvent e) {
       
        if (e.getSource() == botao) {
            int ano = Integer.parseInt(textAno.getText());
            double valor = Double.parseDouble(textValor.getText());
            int mes = Integer.parseInt(textMes.getText());
            int imposto = Integer.parseInt(textMes.getText());
            String url = "jdbc:mysql://localhost:3306";//NomeDoBanco
            String user = "root";
            String password = "";
            try {
                Connection connection = DriverManager.getConnection(url, user, password);
                String sql = " Select * from pessoas where id =" + textPessoa.getText();
                Statement statement = (Statement) connection.createStatement();
                ResultSet resultados = statement.executeQuery(sql);
                while (resultados.next()) {
                    Pessoas pessoa = new Pessoas(resultados.getInt("id"), resultados.getString("nome"),
                            resultados.getString("email"));
                    Proventos provento = new Proventos(mes, ano, valor, pessoa, imposto);
                }
            } catch (Exception er) {
                System.out.println("Não Criou uma PEssoa" + er);
            }

        }

    }

    public static void main(String[] args) {
        CdProventosJF teste = new CdProventosJF();
    }

}