/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.basic;

import java.awt.Color;
import javax.swing.border.Border;

/**
 *
 * @author ld_si
 */
public class PasswordField extends javax.swing.JPasswordField{
    public BorderColor border;
    
    public PasswordField() {
        this.border = new BorderColor();
        setBorder(border.black);
    }

    public PasswordField(String admin) {
        this.setText(admin);
        this.border = new BorderColor();
        setBorder(border.black);
        setBackground(new Color(56, 13, 100));
        setForeground(Color.WHITE);
    }
}
