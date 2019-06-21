package Control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author Kenzo
 */
public class ControllerLogin implements Initializable {
    
    @FXML private ImageView BGlogin;
    @FXML private Button bFechar;
    @FXML private Line line;
    @FXML private Label LBlname;
    @FXML private Button bMinimizar;
    @FXML private ImageView imgFechar;
    @FXML private ImageView imgMinimizar;
    @FXML private Label LBtop;
    @FXML private Label LBleft;
    @FXML private TextField tfNome;
    @FXML private PasswordField pfSenha;
    @FXML private Button btLogar;
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML private void fecharMouseExited(MouseEvent event) {
        imgFechar.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/Images/close.png")));
    }

    @FXML private void fecharMouseEnter(MouseEvent event) {
        imgFechar.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/Images/close1.png")));
    } 

    @FXML private void fecharOnAction(ActionEvent event) {
        Main.closeScreen();
    }

    @FXML private void MinimizarMouseExited(MouseEvent event) {
        imgMinimizar.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/Images/minimize.png")));
    }

    @FXML private void MinimizarMouseEnter(MouseEvent event) {
        imgMinimizar.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/Images/minimize1.png")));
    }

    @FXML private void minizarOnAction(ActionEvent event) {
        Main.minimizeScreen();
    }

    @FXML private void brLogarOnAction(ActionEvent event) {
        Main.changeScreen("TelaPrincipal");
    }

    @FXML private void sair(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER){
           Main.changeScreen("TelaPropriedade");
        }
    }
}
