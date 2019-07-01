/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.basic;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.border.LineBorder;

/**
 *
 * @author ld_si
 */
public class TextField extends javax.swing.JTextField {
    
    public BorderColor border;
    
    public TextField() {
        this.border = new BorderColor();
        setBorder(border.black);
    }

    public TextField(String admin) {
        this.setText(admin);
        this.border = new BorderColor();
        setBorder(border.black);
        setBackground(new Color(56, 13, 100));
        setForeground(Color.WHITE);
    }

    public String getVerifiedText() throws Exception{
        if (this.getText() != null && this.getText().length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(this.getText());
            if (matcher.matches()) {
                return this.getText();
            }
        }
        throw new Exception("Erro- texto possui caracteres não aceitos");
    }

}
