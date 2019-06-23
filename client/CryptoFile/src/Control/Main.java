package Control;


import java.awt.geom.Rectangle2D;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {
    
    public static Stage stanceStage;
    public static Scene loginScene;
    public static Scene mainScreenScene;
    public static Scene propertyScene;
    public static Scene shareScene;
    public static double x = 0;
    public static double y = 0;
    
    @Override
    public void start(Stage stage) throws Exception {
        stanceStage = stage;
        //Fazer isso para cada nova interface criada
        Parent loginFxml = FXMLLoader.load(getClass().getResource("/View/TelaLogin.fxml"));
        loginScene = new Scene(loginFxml);
        Parent mainScreenFxml = FXMLLoader.load(getClass().getResource("/View/TelaPrincipal.fxml"));
        mainScreenScene = new Scene(mainScreenFxml);
        Parent propertyFxml = FXMLLoader.load(getClass().getResource("/View/TelaPropriedade.fxml"));
        propertyScene = new Scene(propertyFxml);
        Parent shareFxml = FXMLLoader.load(getClass().getResource("/View/TelaCompartilhamento.fxml"));
        shareScene = new Scene(shareFxml);
        
        //-------------------------------
        stage.initStyle(StageStyle.UNDECORATED);
        
        stage.setScene(loginScene);//Mostra a tela desejada
        stage.show();
        
        centerScreen();
    }
    
    public static void centerScreen(){
        javafx.geometry.Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();//Centraliza a tela
        stanceStage.setX((primScreenBounds.getWidth() - stanceStage.getWidth()) / 2);
        stanceStage.setY((primScreenBounds.getHeight() - stanceStage.getHeight()) / 2);
    }
    
    public static void changeScreen(String screen){
        switch(screen){
            case "TelaLogin":
                stanceStage.setScene(loginScene);
                centerScreen();
                break;
            case "TelaPrincipal":
                stanceStage.setScene(mainScreenScene);
                centerScreen();
                break;
            case "TelaPropriedade":
                stanceStage.setScene(propertyScene);
                centerScreen();
                break;
            case "TelaCompartilhamento":
                stanceStage.setScene(shareScene);
                centerScreen();
                break;
        }
    }
    
    public static void closeScreen(){
        stanceStage.close();
    }
    
    public static void minimizeScreen(){
        stanceStage.setIconified(true);
    }
    
    public static void makeDragble(javafx.scene.layout.AnchorPane parent){
        parent.setOnMousePressed((event) -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        parent.setOnMouseDragged((event) ->{
            stanceStage.setX(event.getScreenX() - x);
            stanceStage.setY(event.getScreenY() - y);
            stanceStage.setOpacity(0.8f);
        });
        
        parent.setOnDragDone((event) ->{
            stanceStage.setOpacity(1.0f);
        });
        
        parent.setOnMouseReleased((event) ->{
            stanceStage.setOpacity(1.0f); 
        });
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
