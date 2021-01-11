package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Start extends AnimationTimer implements Initializable,java.io.Serializable  {
    @FXML
    private transient AnchorPane frame;
    @FXML
    private transient Label myScore;
    private double diffBurst;
    String filename;
    int invisible;
    int score=0;
    int counter=0;
    long startTime;
    double tm=10*99999999;
    Obstacle nik[]=new Obstacle[40];
    ArrayList<Obstacle> onScreenObs=new ArrayList<>();
    Obstacle colorChanger[]=new Obstacle[40];
    ArrayList<Obstacle> onScreenCol=new ArrayList<>();
    Obstacle star[]=new Obstacle[40];
    ArrayList<Obstacle> onScreenStar=new ArrayList<>();
    Ball myBall;
    int addNext=4;
    int initialY=300;
    int diff=400;
    int wat=0;
    Player myPlayer;
    Obstacle burst;
    public void GC(Player player){
        this.myPlayer=player;
        burst=new BallBlaster();
        burst.make();
        //System.out.println(this.myPlayer.name);
    }
    public void init(){
        myBall=new Position();
        int counte=0;
        double spRed=0.25;
        for(int i=0;i<10;i++) {
            if(i==1)
                diff=70;
            else if(i==2)
                diff=50;
            else if(i>2)
                diff=30;
            nik[counte] = new sample.Circle();
            nik[counte].make();
            colorChanger[counte]=new ColorChanger();
            colorChanger[counte].make();
            star[counte]=new sample.Star();
            star[counte].make();
            nik[counte].setSpeed((float) (nik[counte].getSpeed()-spRed));
            nik[counte].setOrgY(initialY);
            colorChanger[counte].setOrgY(initialY+175);
            star[counte].setOrgY(initialY+42);
            initialY-=diff;
            counte+=1;
            nik[counte] = new sample.Rectangle();
            nik[counte].make();
            colorChanger[counte]=new ColorChanger();
            colorChanger[counte].make();
            star[counte]=new sample.Star();
            star[counte].make();
            nik[counte].setSpeed((float) (nik[counte].getSpeed()-spRed));
            nik[counte].setOrgY(initialY);
            colorChanger[counte].setOrgY(initialY+200);
            star[counte].setOrgY(initialY+42);
            initialY-=diff;
            counte+=1;
            nik[counte] = new sample.Plus();
            nik[counte].make();
            colorChanger[counte]=new ColorChanger();
            colorChanger[counte].make();
            star[counte]=new sample.Star();
            star[counte].make();
            nik[counte].setSpeed((float) (nik[counte].getSpeed()-spRed));
            nik[counte].setOrgY(initialY);
            colorChanger[counte].setOrgY(initialY+200);
            star[counte].setOrgY(initialY+42);
            initialY-=diff;
            counte+=1;
            nik[counte] = new sample.OuterCircle();
            nik[counte].make();
            colorChanger[counte]=new ColorChanger();
            colorChanger[counte].make();
            star[counte]=new sample.Star();
            star[counte].make();
            nik[counte].setSpeed((float) (nik[counte].getSpeed()-spRed));
            nik[counte].setOrgY(initialY);
            colorChanger[counte].setOrgY(initialY+200);
            star[counte].setOrgY(initialY+42);
            //initialY-=diff;
            counte+=1;
        }
        invisible=600;
        myBall.makeBall();
        myBall.setBallColor("0xffff00ff");
        myScore.setText(Integer.toString(score));
        onScreenObs.add(nik[0]);
        onScreenObs.add(nik[1]);
        onScreenObs.add(nik[2]);
        onScreenObs.add(nik[3]);
        onScreenCol.add(colorChanger[0]);
        onScreenCol.add(colorChanger[1]);
        onScreenCol.add(colorChanger[2]);
        onScreenCol.add(colorChanger[3]);
        onScreenStar.add(star[0]);
        onScreenStar.add(star[1]);
        onScreenStar.add(star[2]);
        onScreenStar.add(star[3]);
        //onScreenObs.add(nik[4]);
        myBall.setX(178);
        myBall.setY(560);
        frame.getChildren().addAll(myBall.defineBall(),star[0].defineOb(),colorChanger[0].defineOb(),nik[0].defineOb(),star[1].defineOb(),colorChanger[1].defineOb(),nik[1].defineOb(),star[2].defineOb(),colorChanger[2].defineOb(),nik[2].defineOb(),star[3].defineOb(),colorChanger[3].defineOb(),nik[3].defineOb());
    }
    public void saved(){
        try {
            int counte=0;
            double spRed=0.25;
            for(int i=0;i<10;i++) {
                if(i==1)
                    diff=70;
                else if(i==2)
                    diff=50;
                else if(i>2)
                    diff=30;
                nik[counte] = new sample.Circle();
                nik[counte].make();
                colorChanger[counte]=new ColorChanger();
                colorChanger[counte].make();
                star[counte]=new sample.Star();
                star[counte].make();
                nik[counte].setSpeed((float) (nik[counte].getSpeed()-spRed));
                nik[counte].setOrgY(initialY);
                colorChanger[counte].setOrgY(initialY+175);
                star[counte].setOrgY(initialY+42);
                initialY-=diff;
                counte+=1;
                nik[counte] = new sample.Rectangle();
                nik[counte].make();
                colorChanger[counte]=new ColorChanger();
                colorChanger[counte].make();
                star[counte]=new sample.Star();
                star[counte].make();
                nik[counte].setSpeed((float) (nik[counte].getSpeed()-spRed));
                nik[counte].setOrgY(initialY);
                colorChanger[counte].setOrgY(initialY+200);
                star[counte].setOrgY(initialY+42);
                initialY-=diff;
                counte+=1;
                nik[counte] = new sample.Plus();
                nik[counte].make();
                colorChanger[counte]=new ColorChanger();
                colorChanger[counte].make();
                star[counte]=new sample.Star();
                star[counte].make();
                nik[counte].setSpeed((float) (nik[counte].getSpeed()-spRed));
                nik[counte].setOrgY(initialY);
                colorChanger[counte].setOrgY(initialY+200);
                star[counte].setOrgY(initialY+42);
                initialY-=diff;
                counte+=1;
                nik[counte] = new sample.OuterCircle();
                nik[counte].make();
                colorChanger[counte]=new ColorChanger();
                colorChanger[counte].make();
                star[counte]=new sample.Star();
                star[counte].make();
                nik[counte].setSpeed((float) (nik[counte].getSpeed()-spRed));
                nik[counte].setOrgY(initialY);
                colorChanger[counte].setOrgY(initialY+200);
                star[counte].setOrgY(initialY+42);
                //initialY-=diff;
                counte+=1;
            }
            System.out.println(star[5]);
            int invisible=600;
            FileInputStream file=new FileInputStream("save/"+filename);
            ObjectInputStream ob=new ObjectInputStream(file);
            Start st=(Start) ob.readObject();
            addNext=st.addNext;
            wat=st.wat;
            nik=st.nik;
            score= st.score;
            counter=st.counter;
            onScreenObs=st.onScreenObs;
            colorChanger=st.colorChanger;
            onScreenCol=st.onScreenCol;
            star=st.star;
            onScreenStar=st.onScreenStar;
            myPlayer=st.myPlayer;
            //myBall=new Position();
            String cl=st.myBall.balc;
            System.out.println(cl);
            myBall=st.myBall;
            myBall.makeBall();
            myBall.setBallColor(cl);
            Files.deleteIfExists(Paths.get("save/"+filename));
            for(Obstacle a:onScreenObs){
                a.make();
            }

            for(Obstacle a:colorChanger){
                a.make();
            }

            for(Obstacle a:onScreenCol){
                a.make();
            }

            for(Obstacle a:onScreenStar){
                a.make();
            }
            //System.out.println(onScreenStar.get(0).getClass());
            //System.out.println(onScreenObs.get(1).getClass());
            //System.out.println(myBall.getY());
            //System.out.println(myBall.defineBall());
            //System.out.println(st.score);
            System.out.println("-----------------_Saved Game-------------------------------------");
            myScore.setText(Integer.toString(score));
            //onScreenObs.add(nik[4]);
            myBall.setX(178);
            frame.getChildren().addAll(myBall.defineBall(),onScreenStar.get(0).defineOb(),onScreenCol.get(0).defineOb(),onScreenObs.get(0).defineOb(),onScreenStar.get(1).defineOb(),onScreenCol.get(1).defineOb(),onScreenObs.get(1).defineOb(),onScreenStar.get(2).defineOb(),onScreenCol.get(2).defineOb(),onScreenObs.get(2).defineOb(),onScreenStar.get(3).defineOb(),onScreenCol.get(3).defineOb(),onScreenObs.get(3).defineOb());
            myBall.setY(myBall.getY());
            for(int i=0;i<onScreenObs.size();i++){
                onScreenObs.get(i).setOrgY((int) onScreenObs.get(i).getY());
            }
            for(int i=0;i<onScreenCol.size();i++){
                onScreenCol.get(i).setOrgY((int) onScreenCol.get(i).getY());
            }
            for(int i=0;i<onScreenStar.size();i++){
                onScreenStar.get(i).setOrgY((int) onScreenStar.get(i).getY());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        frame.setOnKeyPressed(ae->{
            switch (ae.getCode()){
                case W:
                    AudioClip sound = new AudioClip(Paths.get("src/Sound Effects/jump.wav").toUri().toString());
                    sound.play();
                    myBall.setY(myBall.getY()-30);
                    this.red();
                    for(int i=0;i<onScreenObs.size();i++){
                        if(onScreenObs.get(i).getY()>600) {
                            System.out.println("----------------------Value of y of obstacle is--------------------------"+onScreenObs.get(i).getY());
                            wat=0;
                            frame.getChildren().remove(6);
                            frame.getChildren().remove(5);
                            frame.getChildren().remove(4);
                            star[addNext].make();
                            nik[addNext].make();
                            //colorChanger[addNext].make();
                            frame.getChildren().add(frame.getChildren().size(),star[addNext].defineOb());
                            frame.getChildren().add(frame.getChildren().size(),nik[addNext].defineOb());
                            //frame.getChildren().add(nik[addNext].defineOb());
                            frame.getChildren().add(frame.getChildren().size(),colorChanger[addNext].defineOb());
                            //frame.getChildren().add(colorChanger[addNext].defineOb());
                            onScreenStar.remove(0);
                            onScreenObs.remove(0);
                            onScreenCol.remove(0);
                            onScreenStar.add(star[addNext]);
                            onScreenObs.add(nik[addNext]);
                            onScreenCol.add(colorChanger[addNext]);
                            addNext+=1;
                        }
                    }
                    counter+=1;
            }
        });

        this.start();
    }


    @FXML
    public void Pause() throws IOException {
        // player.show();
//        this.stop();
        AudioClip sound = new AudioClip(Paths.get("src/Sound Effects/button.wav").toUri().toString());
        sound.play();
        this.stop();
        Locale locale = new Locale("fr", "FR");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        String date = dateFormat.format(new Date());
        Locale locale2 = new Locale("fr", "FR");
        DateFormat dateFormat2 = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale2);
        String date2 = dateFormat2.format(new Date());
        String filename="save/"+"Score : "+score+"   "+date2+"   "+date+"_.ser";
        FileOutputStream file = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(this);
        pauseAlert ps=new pauseAlert();
        int ans=ps.display();
        if(ans==1){
            FXMLLoader loader3=new FXMLLoader(getClass().getResource("sample.fxml"));
            GridPane paneRev=loader3.load();
            GameController start =loader3.getController();
            start.getPlayer(myPlayer);
            frame.getChildren().setAll(paneRev);
        }
        else {
            this.start();
        }
    }
    Obstacle prStar=new Star();
    String balC="0xffff00ff";
    @Override
    public void handle(long l) {
        //System.out.println("In");
        for(Obstacle cb:onScreenCol){
            //System.out.println("For Loop");
            //System.out.println(cb);
            //System.out.println(cb.getGroup());
            if(myBall.defineBall().getBoundsInParent().intersects(cb.getGroup().getBoundsInParent())&&wat==0) {
                wat=1;
                myBall.changeColor();
                if(myBall.ballColor==Color.YELLOW) {
                    System.out.println("Changed to Yellow");
                    balC = "0xffff00ff";
                }
                if(myBall.ballColor==Color.BLUE) {
                    System.out.println("Changed to Blue");
                    balC = "0x0000ffff";
                }
                if(myBall.ballColor==Color.RED) {
                    System.out.println("Changed to Red");
                    balC = "0xff0000ff";
                }
                if(myBall.ballColor==Color.PURPLE) {
                    System.out.println("Changed to Purple");
                    balC = "0x800080ff";
                }
            }
        }
        for (Obstacle st:onScreenStar){
            //System.out.println(st.getY());
            if(myBall.defineBall().getBoundsInParent().intersects(st.defineOb().getBoundsInParent())&&!prStar.equals(st)){
                AudioClip sound = new AudioClip(Paths.get("src/Sound Effects/star.wav").toUri().toString());
                sound.play();
                score+=1;
                myScore.setText(Integer.toString(score));
                prStar=st;
            }
        }
        for(Obstacle ob:onScreenObs) {
            ArrayList<Node> th = new ArrayList<>(ob.getGroup().getChildren());
            Shape sh = Shape.intersect((Shape) myBall.defineBall(), (Shape) th.get(0));
            if (sh.getLayoutBounds().getWidth() >= 0 || sh.getLayoutBounds().getHeight() >= 0) {
                System.out.println(67);//BLUE
                //System.out.println(((Shape) th.get(0)).getStroke());
                if(!((Shape) th.get(0)).getStroke().toString().equals(balC)) {
                    System.out.println("ZERO");
                    stop();
                    startTime=System.nanoTime();
                    ballBurst(startTime,ob);
                }
            }
            Shape sh2 = Shape.intersect((Shape) myBall.defineBall(), (Shape) th.get(1));
            if (sh2.getLayoutBounds().getWidth() >= 0 || sh2.getLayoutBounds().getHeight() >= 0) {
                System.out.println(68);//RED
                //System.out.println(((Shape) th.get(1)).getStroke());
                if(!((Shape) th.get(1)).getStroke().toString().equals(balC)) {
                    System.out.println("FIRST");
                    stop();
                    startTime=System.nanoTime();
                    ballBurst(startTime,ob);
                }
            }
            Shape sh3 = Shape.intersect((Shape) myBall.defineBall(), (Shape) th.get(2));
            if (sh3.getLayoutBounds().getWidth() >= 0 || sh3.getLayoutBounds().getHeight() >= 0) {
                System.out.println(69);//YELLOW
                //System.out.println(((Shape) th.get(2)).getStroke());
                if(!((Shape) th.get(2)).getStroke().toString().equals(balC)) {
                    System.out.println("SECOND");
                    stop();
                    startTime=System.nanoTime();
                    ballBurst(startTime,ob);
                    }
            }
            Shape sh4 = Shape.intersect((Shape) myBall.defineBall(), (Shape) th.get(3));
            if (sh4.getLayoutBounds().getWidth() >= 0 || sh4.getLayoutBounds().getHeight() >= 0) {
                System.out.println(70);//PURPLE
                //System.out.println(((Shape) th.get(3)).getStroke());
                if(!((Shape) th.get(3)).getStroke().toString().equals(balC)) {
                    System.out.println("THIRD");
                    stop();
                    startTime=System.nanoTime();
                    ballBurst(startTime,ob);
                    //stop();

                }
            }
            if (counter != 0)
                myBall.setY(myBall.getY() + 0.12);
        }
    }

    public void loadResumeScreen(Obstacle ob) throws IOException {
        if(score>myPlayer.getHighScore())
            myPlayer.setHighScore(score);
        myPlayer.totStar=score;
        score-=3;
        try {
            end(ob);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FXMLLoader loader2=new FXMLLoader(getClass().getResource("PauseScene.fxml"));
        this.stop();
        AnchorPane pane2=loader2.load();
        PauseContoller start2 =loader2.getController();
        start2.PC(this.myPlayer);
        frame.getChildren().setAll(pane2);
    }

    public void red(){
        if(myBall.getY()<530){
            for(int i=0;i<onScreenObs.size();i++){
                onScreenObs.get(i).setY();
            }
            for(int i=0;i<onScreenCol.size();i++){
                onScreenCol.get(i).setY();
            }
            for(int i=0;i<onScreenStar.size();i++){
                onScreenStar.get(i).setY();
            }
        }
    }

    public void ballBurst(long startTime,Obstacle ob){
        AudioClip sound = new AudioClip(Paths.get("src/Sound Effects/breakball1.wav").toUri().toString());
        sound.play();
        AnimationTimer animationTimer=new AnimationTimer() {
            @Override
            public void handle(long l) {
                burst.setOrgY((int)myBall.getY());
                frame.getChildren().add(burst.defineOb());
                //stop();
                //frame.getChildren().remove(3);
                System.out.println(System.nanoTime() + "---------------------------------" + startTime);
                if (System.nanoTime() - startTime > tm) {
                    try {
                        //myScore.setText(Integer.toString(score));
                        this.stop();
                        loadResumeScreen(ob);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        animationTimer.start();
    }
    public void deserializeFile(String nm){
        this.filename=nm;
    }
    public void end(Obstacle ob) throws IOException {
        diffBurst=myBall.getY()+50;
        myBall.setY(myBall.getY()+50);
        filename="save/end.ser";
        FileOutputStream file = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(this);
    }
}
 
