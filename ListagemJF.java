package app;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListagemJF extends JFrame {
    private JTextArea textArea;
    String textoTela;

    public ListagemJF(int mostrar) {
        
        super("Listagem");
        String url = "jdbc:mysql://localhost:3306/contas";//NomeDoBanco
        String user = "root";
        String password = "";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = " Select * from pessoas ";
            Statement statement = connection.createStatement();
            ResultSet resultados = statement.executeQuery(sql);
            while (resultados.next()){
                Pessoas pessoa = new Pessoas(
                                    resultados.getInt("id"), 
                                    resultados.getString("nome"), 
                                    resultados.getString("email")
                                    );
                
                textoTela = textoTela +"Nome: "+resultados.getString("nome")+"\nEmail: "+ resultados.getString("email")+"\n";

                if(mostrar==2){
                  
                }
            }
        } catch (Exception er) {
            System.out.println("Não Criou uma PEssoa"+er);
        }





       textArea = new JTextArea(textoTela);
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
pane.add(textArea);
        this.setVisible(true);
        this.setSize(400, 285);
        this.setContentPane(pane); 
    }
    public static void main(String[] args) {
        ListagemJF lista = new ListagemJF(1);
    }

}