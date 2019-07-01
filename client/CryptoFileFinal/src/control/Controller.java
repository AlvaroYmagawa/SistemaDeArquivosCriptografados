/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import view.basic.Button;
import view.basic.PasswordField;
import view.basic.TextField;

/**
 *
 * @author ld_si
 */
public class Controller extends ControllerBasic{

    private Button button;
    private TextField tf;
    private PasswordField pf;
    
    /**
     * 
     */
    public Controller() {
    }
    
    /**
     * 
     * @param textField 
     */
    public Controller(TextField textField) {
        this.tf = textField;
        this.tf.addFocusListener(this);
    }
    
    /**
     * 
     * @param pf 
     */
    public Controller(PasswordField pf) {
        this.pf = pf;
        this.pf.addFocusListener(this);
    }
    
    /**
     * 
     * @param button 
     */
    public Controller(Button button) {
        this.button = button;
        this.button.addMouseListener(this); 
    }
    
    /**
     * 
     * @param button 
     */
    protected void add(Button button){
        new Controller(button);
    }
    
    /**
     * 
     * @param pf 
     */
    protected void add(PasswordField pf){
        new Controller(pf);
    }
    
    /**
     * 
     * @param tf 
     */
    protected void add(TextField tf){
        new Controller(tf);
    }
    

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == this.tf) {
            this.tf.setBorder(this.tf.border.blue);
        }
        if (e.getSource() == this.pf) {
            this.pf.setBorder(this.pf.border.blue);
        }
       
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == this.tf) {
            this.tf.setBorder(this.tf.border.black);
        }
        if (e.getSource() == this.pf) {
            this.pf.setBorder(this.pf.border.black);
        }
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.button) {
            this.button.setBorder(this.button.border.blue);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.button) {
            this.button.setBorder(this.button.border.black);
        }
    }
}
