package clientside.control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Kenzo
 */
public class ControllerLogin extends Application implements Initializable {

    public static Stage stanceStage;
    public static Scene loginScene;

    public ControllerLogin(String[] args) {
        launch(args);
    }
    
    
    
    @FXML
    private ImageView BGlogin;

    @FXML
    private Label LBtop;

    @FXML
    private Label LBleft;

    @FXML
    private TextField tfNome;

    @FXML
    private PasswordField pfSenha;

    @FXML
    private Button btLogar;

    @FXML
    private Button bFechar;

    @FXML
    private Line line;

    @FXML
    private Label LBlname;

    @FXML
    private Button bMinimizar;

    @FXML
    private ImageView imgFechar;

    @FXML
    private ImageView imgMinimizar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
    private void fecharOnAction(ActionEvent event) {
        Stage stage = (Stage) bFechar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void MinimizarMouseExited(MouseEvent event) {
        imgMinimizar.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/Images/minimize.png")));
    }

    @FXML
    private void MinimizarMouseEnter(MouseEvent event) {
        imgMinimizar.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/Images/minimize1.png")));
    }

    @FXML
    private void minizarOnAction(ActionEvent event) {
        Stage stage = (Stage) bMinimizar.getScene().getWindow();
        stage.setIconified(true);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Fazer isso para cada nova interface criada
        Parent loginFxml = FXMLLoader.load(getClass().getResource("clientside/view/Login.fxml"));
        loginScene = new Scene(loginFxml);
        //-------------------------------
        stage.initStyle(StageStyle.UNDECORATED);

        stage.setScene(loginScene);//Mostra a tela desejada
        stage.show();
    }
}