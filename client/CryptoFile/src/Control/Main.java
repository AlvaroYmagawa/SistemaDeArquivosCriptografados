package Control;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    
    private static Stage stanceStage;
    public static Scene loginScene;
    public static Scene mainScreenScene;
    public static Scene propertyScene;
    
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
        
        //-------------------------------
        stage.initStyle(StageStyle.UNDECORATED);
       
        stage.setScene(loginScene);//Mostra a tela desejada
        stage.show();
    }
    
    public static void changeScreen(String screen){
        switch(screen){
            case "TelaLogin":
                stanceStage.setScene(loginScene);
                break;
            case "TelaPrincipal":
                stanceStage.setScene(mainScreenScene);
                break;
            case "TelaPropriedade":
                stanceStage.setScene(propertyScene);
                break;
        }
    }
    
    public static void closeScreen(){
        stanceStage.close();
    }
    
    public static void minimizeScreen(){
        stanceStage.setIconified(true);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
