package Control;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    
    public static Stage stanceStage;
    public static Scene loginScene;
    
    @Override
    public void start(Stage stage) throws Exception {
        //Fazer isso para cada nova interface criada
        Parent loginFxml = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        loginScene = new Scene(loginFxml);
        //-------------------------------
        stage.initStyle(StageStyle.UNDECORATED);
       
        stage.setScene(loginScene);//Mostra a tela desejada
        stage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
}
