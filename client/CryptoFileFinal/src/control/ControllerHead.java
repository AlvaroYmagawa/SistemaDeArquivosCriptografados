/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import view.basic.Head;

/**
 *
 * @author Aluno
 */
public class ControllerHead extends Controller{
    private Head head;
    private Point point = new Point();
    private JFrame frame;
    private JFrame mainFrame;
    private int op = 0;
    private boolean opMove = true;
    
    public ControllerHead(Head head, JFrame frame) {
        this.head = head;
        this.frame = frame;
        
        this.head.getbClose().addActionListener(this);
        this.head.getbClose().addMouseListener(this);
        this.head.getbMinimize().addActionListener(this);
        this.head.getbMinimize().addMouseListener(this);
        this.head.addMouseMotionListener(this);
        this.head.addMouseListener(this);
    }
    
    public static void add(Head head, JFrame frame){
        new ControllerHead(head, frame);
    }
    
    public ControllerHead(Head head, JFrame frame, JFrame mainFrame, int op, boolean opMove) {
        this.head = head;
        this.frame = frame;
        this.mainFrame = mainFrame;
        this.op = op;
        this.opMove = opMove;
        this.head.getbClose().addActionListener(this);
        this.head.getbClose().addMouseListener(this);
        this.head.getbMinimize().addActionListener(this);
        //this.head.getbMinimize().addMouseListener(this);
        this.head.addMouseMotionListener(this);
        this.head.addMouseListener(this);
    }
    
    public static void add(Head head, JFrame frame, JFrame mainFrame, int op, boolean opMove){
        new ControllerHead(head, frame, mainFrame, op, opMove);
    }
    
    public ControllerHead(Head head, JFrame frame, int op) {
        this.head = head;
        this.frame = frame;
        this.op = op;
        this.head.getbClose().addActionListener(this);
        this.head.getbClose().addMouseListener(this);
        this.head.getbMinimize().addActionListener(this);
        this.head.getbMinimize().addMouseListener(this);
        this.head.addMouseMotionListener(this);
        this.head.addMouseListener(this);
    }
    
    
    public static void add(Head head, JFrame frame, int op){
        new ControllerHead(head, frame, op);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.head.getbClose()) {
            if (this.op != 1) {
                System.exit(0);
            }else{
                this.mainFrame.setEnabled(true);
                this.frame.dispose(); 
            }
        }
        if (e.getSource() == this.head.getbMinimize()) {
            this.frame.setExtendedState(this.frame.ICONIFIED);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        point.x = e.getX();
        point.y = e.getY();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.head.getbClose()) {
            this.head.getbClose().setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/close1.png")));
        }
        if (e.getSource() == this.head.getbMinimize()) {
            this.head.getbMinimize().setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/minimize1.png")));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.head.getbClose()) {
            this.head.getbClose().setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/close.png")));
        }
        if (e.getSource() == this.head.getbMinimize()) {
            this.head.getbMinimize().setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/minimize.png")));
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (opMove) {
            Point p = this.frame.getLocation();
            this.frame.setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
        }
    } 
}
