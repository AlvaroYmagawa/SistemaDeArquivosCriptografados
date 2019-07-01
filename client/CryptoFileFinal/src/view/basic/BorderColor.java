/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.basic;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author ld_si
 */
public class BorderColor{
    private Border line;
    private Border margin;
    public Border black;
    public Border blue;
    public Border grey;
    public Border red;
    
    
    public BorderColor() {
        this.line = new LineBorder(new java.awt.Color(56, 13, 100), 2, true);
        this.margin = new EmptyBorder(0, 0, 0, 0);
        this.black = new CompoundBorder(line, margin);
        
//        this.line = new LineBorder(new java.awt.Color(51, 153, 255), 4, true);
//        this.blue = new CompoundBorder(line, margin);
        
        this.line = new LineBorder(new java.awt.Color(211 , 85, 6), 2, true);
        this.blue = new CompoundBorder(line, margin);
        
        this.line = new LineBorder(new java.awt.Color(255, 0, 0), 3, true);
        this.red = new CompoundBorder(line, margin);
        
        this.line = new LineBorder(new java.awt.Color(153, 153, 153), 2, true);
        this.grey = new CompoundBorder(line, margin);
    }
    
}
