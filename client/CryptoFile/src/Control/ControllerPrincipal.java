/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Arquivo;
import Model.ArquivoDAO;
import Model.ListaArquivo;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

public class ControllerPrincipal implements Initializable {

    @FXML private ImageView imgFechar;
    @FXML private ImageView imgMinimizar;
    @FXML private AnchorPane parent;
    @FXML private Pane content;
    
    
    //Parte de controle de TableView
    @FXML private TableView<ListaArquivo> table;
    @FXML private TableColumn<ListaArquivo, String> tcNomeArquivo;
    @FXML private TableColumn<ListaArquivo, String> tcProprietario;
    @FXML private TableColumn<ListaArquivo, String> tcStatus;
    
    public ArquivoDAO arq = new ArquivoDAO();
    private final List<Arquivo> arqList = arq.listArq();
    private final ObservableList<ListaArquivo> obl = FXCollections.observableArrayList();
    //---------------------------------
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Main.makeDragble(parent);
        populaTabela();
    }
    
    private void populaTabela(){
        if(obl.isEmpty()){
            obl.clear();
        }
        
        arqList.forEach((arquivo) -> {
            ListaArquivo list = new ListaArquivo(arquivo.getNomeArquivo(), arquivo.getHashArquivos(), arquivo.getDadoArquivos());
            obl.add(list);
        });
        
        tcNomeArquivo.setCellValueFactory(new PropertyValueFactory<>("NomeArquivo"));
        tcProprietario.setCellValueFactory(new PropertyValueFactory<>("HashCode"));
        tcStatus.setCellValueFactory(new PropertyValueFactory<>("dadosArquivo"));
        table.setItems(obl);
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
    private void tableOnclick(MouseEvent event) {
        System.out.println(table.getSelectionModel().getSelectedItem().getDadosArquivo());
        if (JOptionPane.showOptionDialog(null,"Deseja Abrir o arquivo"+table.getSelectionModel().getSelectedItem().getDadosArquivo(),"Quit?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, null, null) == 0){
            Main.changeScreen("TelaPropriedade");
        }
    }
    
    private void excluir(){
        table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
    }

    
    
}
