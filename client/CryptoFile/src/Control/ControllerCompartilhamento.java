package Control;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javax.swing.DefaultComboBoxModel;

public class ControllerCompartilhamento implements Initializable {

    @FXML private Label lAdicionarUsuário;
    @FXML private ComboBox<?> cbAdicionarUsuário;
    @FXML private ComboBox<String> cbPermissão;
    @FXML private Button bAdicionarUsuário;
    @FXML private ImageView imgPermissão;
    private List<String> listPermissão = new ArrayList<>();
    private static ObservableList<String> obsPermissão;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       populaCbPermissão();
    }    
    
    
    private void populaCbPermissão(){
        listPermissão.add("Pode editar");
        listPermissão.add("Pode vizualizar");
        obsPermissão = FXCollections.observableArrayList(listPermissão);
        cbPermissão.setItems(obsPermissão);
    } 
    
    private void trocaImgCbPermissão(){
        if(cbPermissão.getValue().equals("Pode vizualizar")){
            imgPermissão.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/Images/eye.png")));
        }else{
            imgPermissão.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/Images/pen.png")));
        }
    }

    @FXML private void cbPermissãoOnAction(ActionEvent event) {
        trocaImgCbPermissão();
    }

    @FXML private void bAdcionarUsuárioOnAction(ActionEvent event) {
        Main.changeScreen("TelaPropriedade");
    }
    
}
