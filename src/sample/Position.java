package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.Serializable;

public class Position extends Ball implements Serializable {
    private double x;
    private double y;
    public double getX(){return x;};
    public void setX(double x){this.x=x;ball.setTranslateX(x);}
    public double getY(){return y;};
    public void setY(double y){this.y=y;ball.setTranslateY(y);};
    public void makeBall(){
        super.ball=new Circle(8);
        super.radius=8;
    }
    public void setBallColor(String bl){
        if(bl.equals("0x0000ffff")) {
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            this.ballColor=Color.BLUE;
            ball.setFill(Color.BLUE);
            balc="0x0000ffff";
        }
        else if(bl.equals("0xff0000ff")) {
            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||");
            this.ballColor=Color.RED;
            ball.setFill(Color.RED);
            balc="0xff0000ff";
        }
        else if(bl.equals("0xffff00ff")) {
            System.out.println("___________________________________________________");
            this.ballColor=Color.YELLOW;
            ball.setFill(Color.YELLOW);
            balc="0xffff00ff";
        }
        else{
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^6");
            this.ballColor=Color.PURPLE;
            super.ball.setFill(Color.PURPLE);
            balc="0x800080ff";
        }
    }
}
