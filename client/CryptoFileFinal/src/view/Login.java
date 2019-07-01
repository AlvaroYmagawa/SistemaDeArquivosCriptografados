/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import view.basic.Head;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.valueObject.User;
import view.basic.Button;
import view.basic.PasswordField;
import view.basic.TextField;

/**
 *
 * @author Aluno
 */
public class Login extends JFrame {
    private User userOnStorage;
    private String userName;
    private String userPassword;
    
    
    private Button bEnter;
    private TextField tfUser;
    private PasswordField pfPasswd;
    private Head tbHead;
    private JLabel lbackground;
    private JLabel lb;

    public Login() {
        this.setResizable(false);
        this.setSize(900, 500);
        this.setLayout(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setBackground(new Color(41, 9,72));

        this.bEnter = new Button("Logar");
        this.tfUser = new TextField("admin");
        this.pfPasswd = new PasswordField("admin");
        this.tbHead = new Head("");
        this.lbackground = new JLabel();
        this.lb = new JLabel();
     

        this.tbHead.setBounds(0, 0, 900, 50);
        this.tfUser.setBounds(650, 210, 200, 35);
        this.pfPasswd.setBounds(650, 270, 200, 35);
        this.bEnter.setBounds(635, 340, 229, 38);
        this.lbackground.setBounds(0, 50, 600, 450);
        this.lb.setBounds(0, 50, 900, 450);
        this.lb.setForeground(new Color(41, 9,72));
        this.lb.setIcon(new ImageIcon(getClass().getResource("/view/images/lb.png")));
        ImageIcon image = new ImageIcon(getClass().getResource("/view/images/BGpurple.png"));
        this.lbackground.setIcon(new ImageIcon(image.getImage().getScaledInstance(600, 370, Image.SCALE_DEFAULT)));
        
        this.add(bEnter);;
        this.add(tfUser);
        this.add(pfPasswd);
        this.add(tbHead);
        this.add(lbackground);
        this.add(lb);
    }

    public User getUserOnStorage() {
        return userOnStorage;
    }

    public void setUserOnStorage(User userOnStorage) {
        this.userOnStorage = userOnStorage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Button getbEnter() {
        return bEnter;
    }

    public void setbEnter(Button bEnter) {
        this.bEnter = bEnter;
    }

    public TextField getTfUser() {
        return tfUser;
    }

    public void setTfUser(TextField tfUser) {
        this.tfUser = tfUser;
    }

    public PasswordField getPfPasswd() {
        return pfPasswd;
    }

    public void setPfPasswd(PasswordField pfPasswd) {
        this.pfPasswd = pfPasswd;
    }

    public Head getTbHead() {
        return tbHead;
    }

    public void setTbHead(Head tbHead) {
        this.tbHead = tbHead;
    }

    public JLabel getLbackground() {
        return lbackground;
    }

    public void setLbackground(JLabel lbackground) {
        this.lbackground = lbackground;
    }

    
}
