package Control;

import Main.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


public class ControllerPropriedade implements Initializable {

    @FXML private ImageView imgFechar;
    @FXML private ImageView imgMinimizar;
    @FXML private ImageView imgSalvar;
    @FXML private ImageView imgVoltar;
    @FXML private AnchorPane parent;
    @FXML private Pane content;

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

    @FXML private void salvarMouseExited(MouseEvent event) {
        imgSalvar.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/Images/save.png")));
    }

    @FXML private void salvarMouseEnter(MouseEvent event) {
        imgSalvar.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/Images/save1.png")));
    }

    @FXML private void salvarOnAction(ActionEvent event) {
    }

    @FXML private void voltarMouseExited(MouseEvent event) {
        imgVoltar.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/Images/back.png")));
    }

    @FXML private void voltarMouseEnter(MouseEvent event) {
        imgVoltar.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/Images/back1.png")));
    }

    @FXML private void voltarOnAction(ActionEvent event) {
        Main.changeScreen("TelaPrincipal");
    }

    @FXML
    private void bCompartilharOnAction(ActionEvent event) {
        Main.changeScreen("TelaCompartilhamento");
    }

    @FXML
    private void voltarLogin(ActionEvent event) {
        Main.changeScreen("TelaLogin");
    }
    
}
