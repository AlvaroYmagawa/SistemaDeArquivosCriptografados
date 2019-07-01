/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import model.businessObject.Diffie;
import model.businessObject.Hash;
import model.dataAcessObject.UserDAO;
import model.interfaces.LoginOperation;
import model.valueObject.User;
import view.Login;

/**
 *
 * @author Aluno
 */
public class ControllerLogin extends Controller implements LoginOperation
{

    private final Login login;

    public ControllerLogin(Login login) {
        this.login = login;

        login.getbEnter().addActionListener(this);
        login.getTfUser().addActionListener(this);

        ControllerHead.add(login.getTbHead(), login);
        add(login.getTfUser());
        add(login.getPfPasswd());

        login.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.login.getbEnter()) {
           login();
        }
      
      
    }

   

    @Override
    public boolean verifyFrameElements() {
        boolean result = true;
        if (this.login.getTfUser().getText().equals("")) {
            result = false;
            this.login.getTfUser().setBorder(this.login.getTfUser().border.red);
        } else {
            this.login.getTfUser().setBorder(this.login.getTfUser().border.black);
        }
        if (this.login.getPfPasswd().getText().equals("")) {
            result = false;
            this.login.getPfPasswd().setBorder(this.login.getPfPasswd().border.red);
        } else {
            this.login.getPfPasswd().setBorder(this.login.getPfPasswd().border.black);
        }
        return result;
    }

    @Override
    public void getFrameElements() {
        if (verifyFrameElements()) {

            this.login.setUserName(this.login.getTfUser().getText());

            this.login.setUserPassword(this.login.getPfPasswd().getText());
        } else {
            System.out.println("Há campos não preenchidos");
        }
    }

    @Override
    public void login() {
     //try {
            User user = new User();
//            user.setEmail(tfEmail.getText());
//            user.setSenha(Hash.gen(tfPasswd.getText()));
            user.setEmail("ld_silva13@hotmail.com");
            user.setSenha(Hash.gen("123456"));

            Diffie df = new Diffie("123456");
            String publica = df.publicKey().toString();

            System.out.println("Publica: " + publica);

            user.setKey(publica);

            User userRecebido = UserDAO.read(user);
            System.out.println(userRecebido.getToken()+" "+userRecebido.getName()+" "+userRecebido.getKey());
            //Parent mainScreenFxml = FXMLLoader.load(getClass().getResource("/View/TelaPrincipal.fxml"));
            //Main.mainScreenScene = new Scene(mainScreenFxml);
           // Main.changeScreen("TelaPrincipal");
       // } catch (IOException ex) {
       //     Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
       // }
    }

}
