/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.basic;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Aluno
 */
public class Head extends javax.swing.JPanel{
    private JButton bClose;
    private JButton bMinimize;
    private JLabel lTittle;

    public Head(String tittle) {
        
        
        this.bClose = new JButton();
        this.bMinimize = new JButton();
        this.lTittle = new JLabel();
        
        this.setPreferredSize(new java.awt.Dimension(800, 50));
        this.setBackground(new java.awt.Color(41, 9, 72));
        
        this.lTittle.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        this.lTittle.setText(tittle);
        this.lTittle.setForeground(new java.awt.Color(255, 255, 255));
        
        this.bClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/close.png"))); // NOI18N
        this.bClose.setBorder(null);
        this.bClose.setBorderPainted(false);
        this.bClose.setContentAreaFilled(false);
        this.bClose.setPreferredSize(new java.awt.Dimension(30, 10));
        this.bClose.setFocusable(false);

        this.bMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/minimize.png"))); // NOI18N
        this.bMinimize.setBorder(null);
        this.bMinimize.setBorderPainted(false);
        this.bMinimize.setContentAreaFilled(false);
        this.bMinimize.setFocusable(false);
        this.bMinimize.setPreferredSize(new java.awt.Dimension(30, 10));
      

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lTittle, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                .addGap(36, 36, 36)
                .addComponent(bMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bClose, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
    }

    public JButton getbClose() {
        return bClose;
    }

    public void setbClose(JButton bClose) {
        this.bClose = bClose;
    }

    public JButton getbMinimize() {
        return bMinimize;
    }

    public void setbMinimize(JButton bMinimize) {
        this.bMinimize = bMinimize;
    }

    public JLabel getlTittle() {
        return lTittle;
    }

    public void setlTittle(JLabel lTittle) {
        this.lTittle = lTittle;
    }
    
    
    
}
