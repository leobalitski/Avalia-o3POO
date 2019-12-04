package app;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PessoaJF extends JFrame {
    private JButton botao;
    private JTextField textNome;
    private JLabel labelNome;
    private JTextField textEmail;
    private JLabel labelEmail;
    
    public PessoaJF() {
        super("Pessoa");
        botao = new JButton("Enviar");
        textNome = new JTextField(25);
        labelNome = new JLabel("Nome");
        textEmail = new JTextField(25);
        labelEmail = new JLabel("Email");
        

        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));

        pane.add(labelNome);
        pane.add(textNome);

        pane.add(labelEmail);
        pane.add(textEmail);

       
        pane.add(botao);
        this.setVisible(true);
        this.setSize(300, 400);
        this.setContentPane(pane);

        ActionListener handlerAction = new ActionListener() {
            public void actionPerformed(final ActionEvent event) {
                methodAction(event);
            }
        };
        // adicionando os botões a lista de ações
        botao.addActionListener(handlerAction);
    }

    private void methodAction(final ActionEvent e) {
        if (e.getSource() == botao) {
            String nome = textNome.getText();
            String email = textEmail.getText();
            

            Pessoas pessoa = new Pessoas(nome,email);
            

        }

    }

    public static void main(String[] args) {
        PessoaJF pessoa = new PessoaJF();
    }

}