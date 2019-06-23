package Control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Main.Main;
import java.io.IOException;
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
import model.businessObject.RetrofitCore;
import model.dataAcessObject.user_api;
import model.valueObject.User;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 *
 * @author Kenzo
 */
public class ControllerLogin implements Initializable {

    @FXML
    private ImageView BGlogin;
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

    public ImageView getBGlogin() {
        return BGlogin;
    }

    public void setBGlogin(ImageView BGlogin) {
        this.BGlogin = BGlogin;
    }

    public Button getbFechar() {
        return bFechar;
    }

    public void setbFechar(Button bFechar) {
        this.bFechar = bFechar;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Label getLBlname() {
        return LBlname;
    }

    public void setLBlname(Label LBlname) {
        this.LBlname = LBlname;
    }

    public Button getbMinimizar() {
        return bMinimizar;
    }

    public void setbMinimizar(Button bMinimizar) {
        this.bMinimizar = bMinimizar;
    }

    public ImageView getImgFechar() {
        return imgFechar;
    }

    public void setImgFechar(ImageView imgFechar) {
        this.imgFechar = imgFechar;
    }

    public ImageView getImgMinimizar() {
        return imgMinimizar;
    }

    public void setImgMinimizar(ImageView imgMinimizar) {
        this.imgMinimizar = imgMinimizar;
    }

    public Label getLBtop() {
        return LBtop;
    }

    public void setLBtop(Label LBtop) {
        this.LBtop = LBtop;
    }

    public Label getLBleft() {
        return LBleft;
    }

    public void setLBleft(Label LBleft) {
        this.LBleft = LBleft;
    }

    public TextField getTfNome() {
        return tfNome;
    }

    public void setTfNome(TextField tfNome) {
        this.tfNome = tfNome;
    }

    public PasswordField getPfSenha() {
        return pfSenha;
    }

    public void setPfSenha(PasswordField pfSenha) {
        this.pfSenha = pfSenha;
    }

    public Button getBtLogar() {
        return btLogar;
    }

    public void setBtLogar(Button btLogar) {
        this.btLogar = btLogar;
    }

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
        Main.closeScreen();
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
        Main.minimizeScreen();
    }

    @FXML
    private void brLogarOnAction(ActionEvent event) {

    }

    @FXML
    private void sair(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            Main.changeScreen("TelaPropriedade");
        }
    }

    @FXML
    private void actionPerformed(ActionEvent e) {
        if (e.getSource() == btLogar) {
            try {
                User user = new User();
                user.setEmail(tfNome.getText());
                user.setSenha(pfSenha.getText());
                
                Retrofit retrofit = RetrofitCore.retrofit();
                user_api api = retrofit.create(user_api.class);
                
                Call<User> call = api.Signin(user);
                User u = call.execute().body();
                if (user.getEmail().equals(u.getEmail())) {
                    System.out.println("Login autorizado");
                    Main.changeScreen("TelaPrincipal");
                }else{
                    System.out.println("Login nao autorizado");
                }
                
            } catch (IOException ex) {
                System.out.println("Erro - "+ex.getMessage());
            }

           
        }

    }

}
