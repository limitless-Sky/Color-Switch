package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.nio.file.Paths;


public class Main extends Application {
    Player player;
    @Override
    public void start(Stage primaryStage) throws Exception{
        player=new Player("Nikhil");
        AudioClip sound = new AudioClip(Paths.get("src/Sound Effects/Color Switch - Game Theme Music.wav").toUri().toString());
        sound.setVolume(0.1);
        sound.play();
        sound.setCycleCount(AudioClip.INDEFINITE);
        System.out.println(player.getHighScore());
        FXMLLoader loader= new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root=loader.load();
        GameController gameController =loader.getController();
        gameController.cController(player);
        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(new Scene(root, 360, 640));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
 
