package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class pauseAlert {
    private int counter;
    public int display(){
        counter=0;
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Pause Menu");
        window.setWidth(250);
        window.setHeight(250);
        Label label=new Label();
        label.setText("Game Saved");
        label.setFont(Font.font("Inconsolata Expanded Bold"));
        label.setScaleX(2);
        label.setScaleY(2);
        Button button=new Button("Resume");
        button.setOnAction(e-> {
            AudioClip sound = new AudioClip(Paths.get("src/Sound Effects/button.wav").toUri().toString());
            sound.play();
            sound.setVolume(0.5);
            window.close();
        });
        Button button2=new Button("Main Menu");
        button2.setOnAction(e-> {
            AudioClip sound = new AudioClip(Paths.get("src/Sound Effects/button.wav").toUri().toString());
            sound.play();
            sound.setVolume(0.5);
            counter=1;
            window.close();
        });
        VBox layout=new VBox(20);
        layout.getChildren().addAll(label,button,button2);
        layout.setAlignment(Pos.CENTER);
        Scene scene=new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        return counter;
    }
}
