/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Main.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;

public class ControllerPrincipal implements Initializable {

    @FXML private ImageView BGlogin;
    @FXML private Button bFechar;
    @FXML private ImageView imgFechar;
    @FXML private Button bMinimizar;
    @FXML private ImageView imgMinimizar;
    @FXML private Line line;
    @FXML private Label lControladorTabela;
    @FXML private TreeTableView<?> tArquivos;
    @FXML private TreeTableColumn<?, ?> cNome;
    @FXML private TreeTableColumn<?, ?> cAutor;
    @FXML private TreeTableColumn<?, ?> cStatus;
    @FXML private Button bAdicionarArquivo;
    @FXML private Button bRemoverArquivo;
    @FXML private Label lNomeLogo;

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
    
    @FXML private void actionPerformed(ActionEvent event) {
        System.out.println(event.getSource());
        if (event.getSource() == bAdicionarArquivo) {
            System.out.println("Adicionar:");
        }
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
}
