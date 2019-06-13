/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSlider;

/**
 *
 * @author ld_si
 */
public class DialogGerarNumero extends JDialog{

    private JLabel lbNumeroMaximo;
    private JButton btGerar;
    private JButton btGerarOrdenar;
    private JSlider slNumeroMaximo;

    //Get and Set
    public JButton getBtGerar() {
        return btGerar;
    }
    public JButton getBtGerarOrdenar() {
        return btGerarOrdenar;
    }    
    public JSlider getSlNumeroMaximo() {
        return slNumeroMaximo;
    }

    public DialogGerarNumero() {
        this.setSize(300, 205);
        this.setLocationRelativeTo(null);
        this.setTitle("Gerar numero randomico");
        this.setModal(true);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        this.lbNumeroMaximo = new JLabel("Numero maximo da sequencia");

        this.slNumeroMaximo = new JSlider(1, 99999);
        this.slNumeroMaximo.setMajorTickSpacing(9999);
        this.slNumeroMaximo.setPaintTicks(true);

        this.btGerar = new JButton("Gerar numero");
        this.btGerarOrdenar = new JButton("Gerar e ordenar");

        this.lbNumeroMaximo.setBounds(20, 20, 200, 20);
        this.slNumeroMaximo.setBounds(20, 50, 245, 30);
        this.btGerar.setBounds(70, 90, 150, 25);
        this.btGerarOrdenar.setBounds(70, 125, 150, 25);

        this.add(lbNumeroMaximo);
        this.add(slNumeroMaximo);
        this.add(btGerar);
        this.add(btGerarOrdenar);
    }
}
