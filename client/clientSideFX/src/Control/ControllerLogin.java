/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Main.Main;
import static Main.Main.mainScreenScene;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.businessObject.Diffie;
import model.businessObject.Hash;
import model.businessObject.RetrofitCore;
import model.dataAcessObject.UserDAO;
import model.dataAcessObject.user_api;
import model.valueObject.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * FXML Controller class
 *
 * @author ld_si
 */
public class ControllerLogin implements Initializable {

    @FXML
    private AnchorPane parent;
    @FXML
    private Pane content;
    @FXML
    private Pane loginPane;
    @FXML
    private Button button;
    @FXML
    private PasswordField tfPasswd;
    @FXML
    private TextField tfEmail;
    @FXML
    private Button bFechar;
    @FXML
    private ImageView imgFechar;
    @FXML
    private Button bMinimizar;
    @FXML
    private ImageView imgMinimizar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void brLogarOnAction(ActionEvent event) {
        try {
            User user = new User();
//            user.setEmail(tfEmail.getText());
//            user.setSenha(Hash.gen(tfPasswd.getText()));
            user.setEmail("ld_silva13@hotmail.com");
            user.setSenha(Hash.gen("123456")); 
            
            Diffie df = new Diffie("123456");
            String publica = df.publicKey().toString();
            
            System.out.println("Publica: "+publica);
            
            user.setKey(publica);
            
            ControllerPrincipal.user = UserDAO.read(user);
            Parent mainScreenFxml = FXMLLoader.load(getClass().getResource("/View/TelaPrincipal.fxml"));
            Main.mainScreenScene = new Scene(mainScreenFxml);
            Main.changeScreen("TelaPrincipal");
           
        } catch (IOException ex) {
            System.out.println("Erro - "+ex.getMessage());
        }
        
        
    }

    @FXML
    private void fecharMouseExited(MouseEvent event) {
    }

    @FXML
    private void fecharMouseEnter(MouseEvent event) {
    }

    @FXML
    private void fechar(ActionEvent event) {
    }

    @FXML
    private void MinimizarMouseExited(MouseEvent event) {
    }

    @FXML
    private void MinimizarMouseEnter(MouseEvent event) {
    }

    @FXML
    private void minimizar(ActionEvent event) {
    }

    @FXML
    private void sair(KeyEvent event) {
    }
    
}
