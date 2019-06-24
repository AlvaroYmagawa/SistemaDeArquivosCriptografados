/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.ControllerPrincipal.user;
import Main.Main;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.businessObject.AES;
import model.businessObject.RetrofitCore;
import model.dataAcessObject.ArchiveDAO;
import model.dataAcessObject.TextDAO;
import model.dataAcessObject.archive_api;
import model.valueObject.Archive;
import model.valueObject.ListaArquivo;
import model.valueObject.User;
import retrofit2.Call;
import retrofit2.Retrofit;

public class ControllerPrincipal implements Initializable {

    public static User user;
    public File file;
    private Task task;
    @FXML
    private ImageView imgFechar;
    @FXML
    private ImageView imgMinimizar;
    @FXML
    private AnchorPane parent;
    @FXML
    private Pane content;
    @FXML
    private Label lNome;
    @FXML
    private TableView<ListaArquivo> table;
    @FXML
    private TableColumn<ListaArquivo, String> tcNomeArquivo;
    @FXML
    private TableColumn<ListaArquivo, String> tcProprietario;
    @FXML
    private TableColumn<ListaArquivo, String> tcStatus;
    @FXML
    private Button btEdit;
    @FXML
    private Button btNew;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Main.makeDragble(parent);
        lNome.setText(user.getName());
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
    private void btNew(ActionEvent event) {
        try {
            System.out.println("New");

            file = ArchiveDAO.read();

            String content = TextDAO.readText(file);
            System.out.println("Directorio: " + file.getCanonicalPath().substring(0, file.getCanonicalPath().lastIndexOf("\\") + 1));
            System.out.println("nome: " + file.getName());
            
            btNew.setOnAction(cenario);
            
            
            String scifrado = (String) task.getValue();

            System.out.println(
                    "Recebido: " + scifrado);
            byte[] cifrado = scifrado.getBytes();

            //byte[] decifrado = aes.decrypt(cifrado, user.getSenha().getBytes());
            System.out.println(
                    "Cifrado: " + cifrado.toString());

            String encodeFileToBase64Binary = RetrofitCore.encodeFileToBase64Binary(file);

            System.out.println(encodeFileToBase64Binary);

            Retrofit retrofit = RetrofitCore.retrofit();
            archive_api api = retrofit.create(archive_api.class);

            Archive arquivo = new Archive();

            arquivo.setName(file.getName());
            arquivo.setFile(encodeFileToBase64Binary);

            Call<Archive> call = api.newArchive(RetrofitCore.getHeadersTESTE(), arquivo);
        } catch (IOException ex) {
            Logger.getLogger(ControllerPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    EventHandler<ActionEvent> cenario = e -> {
        

         new Task() {

            @Override
            protected String call() throws Exception {
                return "leandro";
            }

            @Override
            protected void succeeded() {
                System.out.println("Concluido");
            }
        };
        Thread t = new Thread(task);
        t.setDaemon(true);
        t.start();
    };

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
    private void voltarLogin(ActionEvent event) {
        Main.changeScreen("TelaLogin");
    }

    @FXML
    private void excluir(ActionEvent event) {
    }

    @FXML
    private void tableOnclick(MouseEvent event) {
    }

}
