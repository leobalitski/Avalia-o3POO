package app;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DividasJF extends JFrame {
    private JButton botao;
    private JTextField textAno;
    private JLabel labelAno;
    private JTextField textValor;
    private JLabel labelValor;
    private JTextField textMes;
    private JLabel labelMes;
    private JTextField textPerd;
    private JLabel labelPerd;

    public DividasJF() {
        super("Dividas");
        botao = new JButton("Enviar");
        textAno = new JTextField(25);
        labelAno = new JLabel("Ano");
        textValor = new JTextField(25);
        labelValor = new JLabel("Valor");
        textMes = new JTextField(25);
        labelMes = new JLabel("MÊS");
        textPerd = new JTextField(25);
        labelPerd = new JLabel("PERC DESC");

        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));

        pane.add(labelMes);
        pane.add(textMes);

        pane.add(labelAno);
        pane.add(textAno);

        pane.add(labelValor);
        pane.add(textValor);

        pane.add(labelPerd);
        pane.add(textPerd);

        pane.add(botao);
        this.setVisible(true);
        this.setSize(300, 400);
        this.setContentPane(pane);

        ActionListener handlerAction = new ActionListener() {
            public void actionPerformed(final ActionEvent event) {
                methodAction(event);
            }
        };
        //chamando os botoes
        botao.addActionListener(handlerAction);
    }

    private void methodAction(final ActionEvent e) {
        
        if (e.getSource() == botao) {
            int ano = Integer.parseInt(textAno.getText());
            double valor = Double.parseDouble(textValor.getText());
            int mes = Integer.parseInt(textMes.getText());
            double percentual_desconto = Double.parseDouble(textPerd.getText());

            Dividas divida = new Dividas(mes, ano, valor, 1, percentual_desconto);

        }

    }

    public static void main(String[] args) {
        DividasJF Testando = new DividasJF();
    }

}