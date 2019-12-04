package app;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuJF extends JFrame {
    private JButton botaodaPessoa;
    
    private JButton botaodaDivida;
    private JButton botaodoProvento;
    private JButton botaoConPessoa;
    private JButton botaoConDivida;
    private JButton botaoConProvento;
    

    public MenuJF() {
        super("Menu");
        botaodaPessoa = new JButton("Cadastrar Pessoa");
        botaodaDivida = new JButton("Cadastrar Divida");
        botaodoProvento = new JButton("Cadastrar Proventos");
        botaoConPessoa = new JButton("Consultar Pessoa");
        botaoConDivida = new JButton("Consultar Dividas");
        botaoConProvento = new JButton("Consultar Provento");

        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));

        

        pane.add(botaodaPessoa);
        pane.add(botaodaDivida);
        pane.add(botaodoProvento);
        pane.add(botaoConPessoa);
        pane.add(botaoConDivida);
        pane.add(botaoConProvento);

        this.setVisible(true);
        this.setSize(200, 300);
        this.setContentPane(pane);

        ActionListener handlerAction = new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == botaodaPessoa){
                    new PessoaJF();
                } else if(e.getSource() == botaodoProvento){
                    new ProventosJF();
                } else if (e.getSource() == botaodaDivida){
                    new DividasJF();
                } else if (e.getSource() == botaoConPessoa){
                    new ListagemJF(1);

                }
            }
        };
        botaodaPessoa.addActionListener(handlerAction);
        botaodaDivida.addActionListener(handlerAction);
        botaodoProvento.addActionListener(handlerAction);
        botaoConPessoa.addActionListener(handlerAction);
        botaoConDivida.addActionListener(handlerAction);
        botaoConProvento.addActionListener(handlerAction);
    }

  

    

    public static void main(String[] args) {
        MenuJF menu = new MenuJF();
    }

}