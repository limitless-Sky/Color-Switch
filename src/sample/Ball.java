package sample;
import javafx.scene.Node;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.Serializable;
import java.nio.file.Paths;
import java.util.Random;

public abstract class Ball implements Serializable {
    public abstract double getX();
    public abstract void setX(double x);
    public abstract double getY();
    public abstract void setY(double y);
    public String balc="0xffff00ff";
    transient public Circle ball;
    protected int radius;
    transient public Color ballColor;
    public Node defineBall(){
        return this.ball;
    }
    public abstract void makeBall();
    public abstract void setBallColor(String bl);
    public void changeColor(){
        AudioClip sound = new AudioClip(Paths.get("src/Sound Effects/colorswitch.wav").toUri().toString());
        sound.play();
        Random rand=new Random();
        int num=rand.nextInt(4)+1;
        if(num==1) {
            this.ballColor=Color.BLUE;
            ball.setFill(Color.BLUE);
            balc="0x0000ffff";
        }
        else if(num==2) {
            this.ballColor=Color.RED;
            ball.setFill(Color.RED);
            balc="0xff0000ff";
        }
        else if(num==3) {
            this.ballColor=Color.YELLOW;
            ball.setFill(Color.YELLOW);
            balc="0xffff00ff";
        }
        else{
            this.ballColor=Color.PURPLE;
            ball.setFill(Color.PURPLE);
            balc="0x800080ff";
        }
    }
}
