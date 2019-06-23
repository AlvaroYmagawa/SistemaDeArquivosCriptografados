/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ControllerPrincipal implements Initializable {

    @FXML private ImageView imgFechar;
    @FXML private ImageView imgMinimizar;
    @FXML private AnchorPane parent;
    @FXML private Pane content;
    @FXML
    private Button bVoltar;
    @FXML
    private ImageView imgVoltar;
    @FXML
    private Button bSalvar;
    @FXML
    private ImageView imgSalvar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Main.makeDragble(parent);
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
    
    @FXML
    private void voltarLogin(ActionEvent event) {
          Main.changeScreen("TelaLogin");
    }

    @FXML
    private void voltarMouseExited(MouseEvent event) {
    }

    @FXML
    private void voltarMouseEnter(MouseEvent event) {
    }

    @FXML
    private void voltarOnAction(ActionEvent event) {
    }

    @FXML
    private void salvarMouseExited(MouseEvent event) {
    }

    @FXML
    private void salvarMouseEnter(MouseEvent event) {
    }

    @FXML
    private void salvarOnAction(ActionEvent event) {
    }
    
    
}
