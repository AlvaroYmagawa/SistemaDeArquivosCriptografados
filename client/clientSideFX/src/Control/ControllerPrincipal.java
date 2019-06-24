/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Main.Main;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.businessObject.RetrofitCore;
import model.dataAcessObject.archive_api;
import model.valueObject.Archive;
import model.valueObject.User;
import retrofit2.Call;
import retrofit2.Retrofit;

public class ControllerPrincipal implements Initializable {

    File file = null;
    public User user;

    @FXML
    private ImageView BGlogin;
    @FXML
    private Button bFechar;
    @FXML
    private ImageView imgFechar;
    @FXML
    private Button bMinimizar;
    @FXML
    private ImageView imgMinimizar;
    @FXML
    private Line line;
    @FXML
    private Label lControladorTabela;
    @FXML
    private TableView<Archive> table;
    @FXML
    private TableColumn<Archive, String> tableId;
    @FXML
    private TableColumn<Archive, String> tableNome;
    @FXML
    private TableColumn<Archive, String> tableStatus;
    @FXML
    private Button bAdicionarArquivo;
    @FXML
    private Button bRemoverArquivo;
    @FXML
    private Label lNomeLogo;

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
    private void actionPerformed(ActionEvent event) {
        System.out.println(event.getSource());
        if (event.getSource() == bAdicionarArquivo) {
            System.out.println("Adicionar :");
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "arquivo", "txt");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println("You chose to open this file: "
                        + chooser.getSelectedFile().getName());
                file = chooser.getSelectedFile();
            }

            try {
                String encodeFileToBase64Binary = RetrofitCore.encodeFileToBase64Binary(file);
                System.out.println(encodeFileToBase64Binary);

                Retrofit retrofit = RetrofitCore.retrofit();
                archive_api api = retrofit.create(archive_api.class);

                Archive arquivo = new Archive();
                arquivo.setName(file.getName());
                arquivo.setFile(encodeFileToBase64Binary);

                Call<Archive> call = api.newArchive(RetrofitCore.getHeaders(), arquivo);
                Archive u = (Archive) call.execute().body();
                System.out.println("URL: " + RetrofitCore.BASE_URL + u.getUrl());
                
                table.setItems(listaDeClientes());
            } catch (IOException ex) {
                Logger.getLogger(ControllerPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (event.getSource() == bRemoverArquivo) {
            Main.changeScreen("TelaPropriedade");
        }
    }
    
    private ObservableList<Archive> listaDeClientes() {
        return FXCollections.observableArrayList(
                new Archive(1, "teste.txt", "Rua Alvenaria 22"),
                new Archive(1, "teste.txt", "Rua Alvenaria 22"),
                new Archive(1, "teste.txt", "Rua Alvenaria 22")
               
        );
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
}
