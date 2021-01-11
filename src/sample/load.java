package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class load implements Initializable {
    String[] pathnames;
    Player player;
    @FXML
    private ListView listView;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private void startSelected(MouseEvent event) throws IOException {
        //        FXMLLoader loader2=new FXMLLoader(getClass().getResource("GameScreen.fxml"));
//        AnchorPane pane=loader2.load();
//        Start start =loader2.getController();
//        System.out.println(player.getHighScore());
//        start.saved();
//        start.GC(player);
//        rootPane.getChildren().setAll(pane);


        AudioClip sound = new AudioClip(Paths.get("src/Sound Effects/button.wav").toUri().toString());
        sound.play();
        sound.setVolume(0.5);
        String gameName = (String) listView.getSelectionModel().getSelectedItem();
        System.out.println(gameName);
        FXMLLoader loader2=new FXMLLoader(getClass().getResource("GameScreen.fxml"));
        AnchorPane pane=loader2.load();
        Start start =loader2.getController();
        System.out.println(player.getHighScore());
        start.deserializeFile(gameName);
        start.saved();
        start.GC(player);
        anchorPane.getChildren().setAll(pane);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        File f = new File("save/");
        pathnames = f.list();
        for(String pt: pathnames){
            listView.getItems().add(pt);
        }
    }

    public void take(Player player){
        this.player=player;
    }
    public void back() throws IOException {
        AudioClip sound = new AudioClip(Paths.get("src/Sound Effects/button.wav").toUri().toString());
        sound.play();
        sound.setVolume(0.5);
        FXMLLoader loader3=new FXMLLoader(getClass().getResource("sample.fxml"));
        GridPane paneRev=loader3.load();
        GameController start =loader3.getController();
        start.getPlayer(player);
        anchorPane.getChildren().setAll(paneRev);
    }
}
