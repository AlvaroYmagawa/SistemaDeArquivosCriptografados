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
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
import model.valueObject.User;
import retrofit2.Call;
import retrofit2.Retrofit;

public class ControllerPrincipal implements Initializable {

    public static User user;
    public File file;
    private static final ExecutorService threadpool = Executors.newFixedThreadPool(3);
    public ArchiveDAO arq = new ArchiveDAO();
    private final List<Archive> arqList = ArchiveDAO.read(user.getEmail(), user.getToken());
    private final ObservableList<Archive> obl = FXCollections.observableArrayList();
    
    
    @FXML
    private ImageView imgFechar;
    @FXML
    private ImageView imgMinimizar;
    @FXML
    private AnchorPane parent;
    @FXML
    private Pane content;
    @FXML
    private TextField tfSearch;
    @FXML
    private Button buttonEdit;
    @FXML
    private Button buttonNew;
    @FXML
    private Button btClose;
    @FXML
    private Button btMinimize;
    @FXML
    private Label lNome;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Main.makeDragble(parent);
        lNome.setText(user.getName());
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
            file = ArchiveDAO.read();

            String content = TextDAO.readText(file);
            System.out.println("Directorio: " + file.getCanonicalPath().substring(0, file.getCanonicalPath().lastIndexOf("\\") + 1));
            System.out.println("nome: " + file.getName());

            Task tarefa = new Task() {

                @Override
                protected String call() throws Exception {
                    return AES.encrypt(content.getBytes(), user.getSenha().getBytes());
                }

                @Override
                protected void succeeded() {
                    System.out.println("Cifrado: "+ getValue());
                   
                }
            };
            Thread t = new Thread(tarefa);
            t.setDaemon(true);
            t.start();

            while (!tarefa.isDone()) {
                System.out.println("PRocessando");
            }

            String scifrado = (String) tarefa.getValue();
            System.out.println("Recebido: " + scifrado);
            byte[] cifrado = scifrado.getBytes();
            threadpool.shutdown();
            //byte[] decifrado = aes.decrypt(cifrado, user.getSenha().getBytes());
            System.out.println("Cifrado: " + cifrado.toString());

            String encodeFileToBase64Binary = RetrofitCore.encodeFileToBase64Binary(file);
            System.out.println(encodeFileToBase64Binary);

            Retrofit retrofit = RetrofitCore.retrofit();
            archive_api api = retrofit.create(archive_api.class);

            Archive arquivo = new Archive();
            arquivo.setName(file.getName());
            arquivo.setFile(encodeFileToBase64Binary);

            Call<Archive> call = api.newArchive(RetrofitCore.getHeadersTESTE(), arquivo);
        } catch (IOException ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

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
    private void voltarLogin(ActionEvent event) {
        Main.changeScreen("TelaLogin");
    }

}
