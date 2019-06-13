/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author ld_si
 */
public class FramePrincipal extends javax.swing.JFrame {

    private JLabel lbNumeroMaximo;
    private JLabel lbNumeroGerado;
    private JLabel lbNumeroOrdenado;
    private JLabel lbQtdeTrocas;
    private JTextField tfNumeroMaximo;
    private JTextField tfNumeroGerado;
    private JTextField tfNumeroOrdenado;
    private JTextField tfQtdeTrocas;
    private JTextPane tpInformacao;
    private JScrollPane spRolagemPassos;
    private JButton btGerarNumero;
    private JButton btOrdernarNumero;

    //Get and Set
    public JButton getBtGerarNumero() {
        return btGerarNumero;
    }
    public JButton getBtOrdernarNumero() {
        return btOrdernarNumero;
    }
    public JTextField getTfNumeroGerado() {
        return tfNumeroGerado;
    }
    public JTextField getTfNumeroMaximo() {
        return tfNumeroMaximo;
    }
    public JTextField getTfNumeroOrdenado() {
        return tfNumeroOrdenado;
    }
    public JTextField getTfQtdeTrocas() {
        return tfQtdeTrocas;
    }
    public JTextPane getTpInformacao() {
        return tpInformacao;
    }
    public JScrollPane getSpRolagemPassos() {
        return spRolagemPassos;
    }  

    public FramePrincipal() {

        this.setTitle("MVC");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(380, 320);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.lbNumeroMaximo = new JLabel("Numero maximo");
        this.lbNumeroGerado = new JLabel("Numero gerado");
        this.lbNumeroOrdenado = new JLabel("Numero ordenado");
        this.lbQtdeTrocas = new JLabel("Qtde de trocas");

        this.tfNumeroMaximo = new JTextField("1");
        this.tfNumeroMaximo.setEnabled(false);
        this.tfNumeroGerado = new JTextField();
        this.tfNumeroGerado.setEnabled(false);
        this.tfNumeroOrdenado = new JTextField();
        this.tfNumeroOrdenado.setEnabled(false);
        this.tfQtdeTrocas = new JTextField();
        this.tfQtdeTrocas.setEnabled(false);

        this.btGerarNumero = new JButton("Gerar numero randomico");
        this.btOrdernarNumero = new JButton("Ordenar numero gerado");
        this.btOrdernarNumero.setEnabled(false);

        this.tpInformacao = new JTextPane();
        this.tpInformacao.setText("Esse sistema ordena uma sequencia numerica atravez do algoritmo bolha (buble sort).\n\nEsse algoritmo realiza trocas entre um numero e o seu imediato caso este seja menor que o proximo.");
        //Evita que o texto do TextPane seja selecionavel
        this.tpInformacao.setEnabled(false);
        //Define a cor do texto
        this.tpInformacao.setDisabledTextColor(Color.BLACK);
        //Tira o fundo branco padrao do TextPane
        this.tpInformacao.setOpaque(false);

        this.spRolagemPassos = new JScrollPane();
        this.spRolagemPassos.setBorder(null);
        this.spRolagemPassos.setViewportView(this.tpInformacao);

        this.lbNumeroMaximo.setBounds(20, 20, 150, 20);
        this.lbNumeroGerado.setBounds(20, 85, 150, 20);
        this.lbNumeroOrdenado.setBounds(20, 150, 150, 20);
        this.lbQtdeTrocas.setBounds(20, 215, 150, 20);

        this.tfNumeroMaximo.setBounds(20, 50, 100, 25);
        this.tfNumeroGerado.setBounds(20, 115, 100, 25);
        this.tfNumeroOrdenado.setBounds(20, 180, 100, 25);
        this.tfQtdeTrocas.setBounds(20, 245, 100, 25);

        this.btGerarNumero.setBounds(150, 20, 200, 25);
        this.btOrdernarNumero.setBounds(150,55, 200, 25);

        this.spRolagemPassos.setBounds(150, 90, 200, 180);

        this.add(lbNumeroMaximo);
        this.add(lbNumeroGerado);
        this.add(lbNumeroOrdenado);
        this.add(lbQtdeTrocas);

        this.add(tfNumeroMaximo);
        this.add(tfNumeroGerado);
        this.add(tfNumeroOrdenado);
        this.add(tfQtdeTrocas);

        this.add(btGerarNumero);
        this.add(btOrdernarNumero);

        this.add(spRolagemPassos);
    }
}
