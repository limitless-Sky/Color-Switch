package sample;

import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class PauseContoller implements Initializable {
    Player player;
    public void PC(Player player){
        this.player=player;
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println(this.player.name);
        myLabel.setText(Integer.toString(player.totStar));
        myHighScoreLabel.setText("High Score: "+player.getHighScore());
    }
    @FXML
    private Label myLabel,myHighScoreLabel;
    @FXML
    private Button newButoon,newButoon1,quitButton;
    @FXML
    private AnchorPane PsFrame;
    @FXML
    public void resumeFunc(ActionEvent actionEvent) throws IOException {
        if(player.totStar>=3)
            this.loadResumeScreen();
        else
        {
            Files.deleteIfExists(Paths.get("save/end.ser"));
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Unfortunately your total star count is less");
            a.show();
        }
    }
    @FXML
    public void quitFunc(ActionEvent actionEvent){

        AudioClip sound = new AudioClip(Paths.get("src/Sound Effects/button.wav").toUri().toString());
        sound.play();
        sound.setVolume(0.5);
        Platform.exit();
    }

    public void loadResumeScreen() throws IOException {
//        AnchorPane paneRev= FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
//        PsFrame.getChildren().setAll(paneRev);
        AudioClip sound = new AudioClip(Paths.get("src/Sound Effects/button.wav").toUri().toString());
        sound.play();
        sound.setVolume(0.5);
        player.totStar-=3;
//        FXMLLoader loader3=new FXMLLoader(getClass().getResource("sample.fxml"));
//        GridPane paneRev=loader3.load();
//        GameController start =loader3.getController();
//        start.getPlayer(player);
//        System.out.println(player.getHighScore());
//        PsFrame.getChildren().setAll(paneRev);
        FXMLLoader loader2=new FXMLLoader(getClass().getResource("GameScreen.fxml"));
        AnchorPane pane=loader2.load();
        Start start =loader2.getController();
        System.out.println(player.getHighScore());
        start.deserializeFile("end.ser");
        start.saved();
        start.GC(player);
        PsFrame.getChildren().setAll(pane);
    }
    public void mainMenu() throws IOException {
        Files.deleteIfExists(Paths.get("save/end.ser"));
        AudioClip sound = new AudioClip(Paths.get("src/Sound Effects/button.wav").toUri().toString());
        sound.play();
        sound.setVolume(0.5);
        FXMLLoader loader3=new FXMLLoader(getClass().getResource("sample.fxml"));
        GridPane paneRev=loader3.load();
        GameController start =loader3.getController();
        start.getPlayer(player);
        System.out.println(player.getHighScore());
        PsFrame.getChildren().setAll(paneRev);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ScaleTransition scaleTransition1=new ScaleTransition(Duration.millis(1000),newButoon);
        scaleTransition1.setCycleCount(ScaleTransition.INDEFINITE);
        scaleTransition1.setAutoReverse(true);
        scaleTransition1.setByX(0.15);
        ScaleTransition scaleTransition2=new ScaleTransition(Duration.millis(1000),quitButton);
        scaleTransition2.setCycleCount(ScaleTransition.INDEFINITE);
        scaleTransition2.setAutoReverse(true);
        scaleTransition2.setByX(0.15);
        ScaleTransition scaleTransition3=new ScaleTransition(Duration.millis(1000),newButoon1);
        scaleTransition3.setCycleCount(ScaleTransition.INDEFINITE);
        scaleTransition3.setAutoReverse(true);
        scaleTransition3.setByX(0.15);
        ParallelTransition parallelTransition=new ParallelTransition(scaleTransition1,scaleTransition2,scaleTransition3);
        parallelTransition.play();
    }
}
