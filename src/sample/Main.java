package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    Controller c;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();

        Parent root = loader.load(getClass().getResourceAsStream("sample.fxml"));
        c = loader.getController();
        primaryStage.setTitle("Bindings");
        primaryStage.setScene(new Scene(root, 150, 150));
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> handleExit());
    }


    private void handleExit()
    {
        c.Dispose();
        Platform.exit();
        System.exit(0);

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
