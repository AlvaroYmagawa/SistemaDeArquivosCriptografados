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
import javafx.scene.control.ButtonBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ControllerLogin implements Initializable {
    
    @FXML
    private ImageView imgFechar;
    @FXML
    private ImageView imgMinimizar;
    @FXML private AnchorPane parent;
    @FXML public static Pane content;
    @FXML private Pane loginPane;
    @FXML
    private Button bFechar;
    @FXML
    private Button bMinimizar;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Main.makeDragble(parent);
    } 
    
    @FXML
    private void fecharMouseExited(MouseEvent event) {
        imgFechar.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/Images/close.png")));
    }

    @FXML
    private void fecharMouseEnter(MouseEvent event) {
        imgFechar.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/Images/close1.png")));
    } 

    @FXML
    private void MinimizarMouseExited(MouseEvent event) {
        imgMinimizar.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/Images/minimize.png")));
    }

    @FXML
    private void MinimizarMouseEnter(MouseEvent event) {
        imgMinimizar.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/Images/minimize1.png")));
    }

   
    @FXML private void brLogarOnAction(ActionEvent event) {
        Main.changeScreen("TelaPrincipal");
    }

    @FXML private void sair(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER){
           Main.changeScreen("TelaPropriedade");
        }
    }

    @FXML
    private void fechar(ActionEvent event) {
        Main.closeScreen();
    }

    @FXML
    private void minimizar(ActionEvent event) {
        Main.minimizeScreen();
    }


    
}
