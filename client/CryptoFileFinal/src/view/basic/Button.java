/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.basic;

import javax.swing.JLabel;

/**
 *
 * @author ld_si
 */
public class Button extends javax.swing.JButton{
    public BorderColor border;
    public JLabel tittle;
    public Button(String tittle) {
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setFocusable(false);
        setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/loginButtonY.png")));
        setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/loginButtonO.png")));
        setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/loginButtonOO.png")));
    }
}
