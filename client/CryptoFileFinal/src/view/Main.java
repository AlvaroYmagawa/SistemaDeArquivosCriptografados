/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import view.basic.Button;
import view.basic.Head;
import view.basic.Table;

/**
 *
 * @author ld_si
 */
public class Main extends JFrame{
    private Head head;
    private Button jButtonAdicionar;
    private Button jButtonCompartilhar;
    private JLabel jLabelBackground;
    private JScrollPane jScrollPane1;
    public Table jTable;
    

    public Main() {
        
        this.setTitle("Controle de Estoque");
        this.setResizable(false);
        this.setSize(800, 600);
        this.setLayout(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        
        this.head = new Head("Controle de Estoque");
        this.head.setBounds(0, 0, 800, 50);
        this.jButtonAdicionar = new Button("Adicionar");
        this.jButtonAdicionar.setBounds(360 , 70, 110, 30);
        this.jButtonCompartilhar = new Button("Compartilhar");
        this.jButtonCompartilhar.setBounds(250, 70, 100, 30);
        this.jLabelBackground = new JLabel();
        this.jLabelBackground.setBounds(0, 50, 800, 550);
        this.jLabelBackground.setIcon(new ImageIcon(getClass().getResource("/view/images/back.png")));
      
        
        
        this.jScrollPane1 = new JScrollPane();
        this.jTable = new Table();
        this.jTable.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Status"
            }
        ));
        this.jTable.setFocusable(false);
        this.jTable.setShowVerticalLines(false);
        this.jScrollPane1.setViewportView(jTable);
        this.getContentPane().add(jScrollPane1);
        this.jScrollPane1.setBounds(6, 146, 788, 520);
      
       
        
        this.add(head);
        this.add(jButtonCompartilhar);
        this.add(jButtonAdicionar);
        this.add(jLabelBackground);
        
        
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Button getjButtonAdicionar() {
        return jButtonAdicionar;
    }

    public void setjButtonAdicionar(Button jButtonAdicionar) {
        this.jButtonAdicionar = jButtonAdicionar;
    }

    public Button getjButtonCompartilhar() {
        return jButtonCompartilhar;
    }

    public void setjButtonCompartilhar(Button jButtonCompartilhar) {
        this.jButtonCompartilhar = jButtonCompartilhar;
    }

    public JLabel getjLabelBackground() {
        return jLabelBackground;
    }

    public void setjLabelBackground(JLabel jLabelBackground) {
        this.jLabelBackground = jLabelBackground;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public Table getjTable() {
        return jTable;
    }

    public void setjTable(Table jTable) {
        this.jTable = jTable;
    }

    
    
}
