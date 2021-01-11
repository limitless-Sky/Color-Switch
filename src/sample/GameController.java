package sample;

import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    Player player;
    @FXML
    private Label Title;
    @FXML
    private GridPane rootPane;
    @FXML
    private Button button1,button2,button3;

    public void cController(Player player){
        this.player=player;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //this.player.show();
        PathTransition pathTransition=new PathTransition();
        Line line=new Line();
        line.setStartY(0);
        line.setEndY(200);
        line.setStartX(115);
        line.setEndX(115);
        pathTransition.setNode(Title);
        pathTransition.setPath(line);
        pathTransition.setDuration(Duration.seconds(2));
        //pathTransition.play();

        ScaleTransition scaleTransition=new ScaleTransition();
        scaleTransition.setNode(Title);
        //scaleTransition.setToY(2);
        scaleTransition.setFromX(0);
        scaleTransition.setToX(1);
        scaleTransition.setDuration(Duration.seconds(2));
        //scaleTransition.play();

//        ScaleTransition scaleTransition1=new ScaleTransition();
//        scaleTransition1.setNode(button1);
//        scaleTransition1.setFromX(0);
//        scaleTransition1.setToX(1);
//        scaleTransition1.autoReverseProperty();
        ScaleTransition scaleTransition1=new ScaleTransition(Duration.millis(1000),button1);
        scaleTransition1.setCycleCount(ScaleTransition.INDEFINITE);
        scaleTransition1.setAutoReverse(true);
        scaleTransition1.setByX(0.15);
        ScaleTransition scaleTransition2=new ScaleTransition(Duration.millis(1000),button2);
        scaleTransition2.setCycleCount(ScaleTransition.INDEFINITE);
        scaleTransition2.setAutoReverse(true);
        scaleTransition2.setByX(0.15);
        ScaleTransition scaleTransition3=new ScaleTransition(Duration.millis(1000),button3);
        scaleTransition3.setCycleCount(ScaleTransition.INDEFINITE);
        scaleTransition3.setAutoReverse(true);
        scaleTransition3.setByX(0.15);
        ParallelTransition parallelTransition=new ParallelTransition(pathTransition,scaleTransition,scaleTransition1,scaleTransition2,scaleTransition3);
        parallelTransition.play();
    }
    @FXML
    public void loadScreen(ActionEvent actionEvent)throws IOException {

        AudioClip sound = new AudioClip(Paths.get("src/Sound Effects/button.wav").toUri().toString());
        sound.play();
        sound.setVolume(0.5);
        FXMLLoader loader2=new FXMLLoader(getClass().getResource("GameScreen.fxml"));
        AnchorPane pane=loader2.load();
        Start start =loader2.getController();
        System.out.println(player.getHighScore());
        start.init();
        start.GC(player);
        rootPane.getChildren().setAll(pane);
    }

    public void getPlayer(Player player){
        this.player=player;
    }
    public void resumeGame(ActionEvent actionEvent)throws IOException{
        AudioClip sound = new AudioClip(Paths.get("src/Sound Effects/button.wav").toUri().toString());
        sound.play();
        sound.setVolume(0.5);

//        FXMLLoader loader2=new FXMLLoader(getClass().getResource("GameScreen.fxml"));
//        AnchorPane pane=loader2.load();
//        Start start =loader2.getController();
//        System.out.println(player.getHighScore());
//        start.saved();
//        start.GC(player);
//        rootPane.getChildren().setAll(pane);
        FXMLLoader loader2=new FXMLLoader(getClass().getResource("savedMenu.fxml"));
        AnchorPane pane=loader2.load();
        load loader=loader2.getController();
        loader.take(player);
        rootPane.getChildren().setAll(pane);

    }
    public void cls(ActionEvent actionEvent) {

        AudioClip sound = new AudioClip(Paths.get("src/Sound Effects/button.wav").toUri().toString());
        sound.play();
        sound.setVolume(0.5);
        Platform.exit();
    }
}
