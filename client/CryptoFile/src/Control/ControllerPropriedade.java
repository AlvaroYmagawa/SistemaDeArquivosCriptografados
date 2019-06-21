package Control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;


public class ControllerPropriedade implements Initializable {

    @FXML private Button bFechar;
    @FXML private ImageView imgFechar;
    @FXML private Button bMinimizar;
    @FXML private ImageView imgMinimizar;
    @FXML private Line line;
    @FXML private TextArea taDados;
    @FXML private Line line1;
    @FXML private ImageView BGlogin;
    @FXML private Button bSalvar;
    @FXML private ImageView imgSalvar;
    @FXML private Label lNomeArquivo;
    @FXML private Button bAdicionarArquivo;
    @FXML private ImageView imgCompartilhar;
    @FXML private Button bVoltar;
    @FXML private ImageView imgVoltar;

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

    @FXML private void changeColor(MouseEvent event) {
        
    }

    @FXML private void changeColor1(MouseEvent event) {
    }
}
