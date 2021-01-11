package sample;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

import java.util.Random;

public class BallBlaster extends Obstacle{

    transient Group group;
    protected float circleRad;
    @Override
    public void make() {
        group=new Group();
    }
    @Override
    public Node defineOb() {
        Random random = new Random();
        javafx.scene.shape.Circle ball[] = new javafx.scene.shape.Circle[50];
        for(int i=0;i<ball.length;i++){
            ball[i]= new javafx.scene.shape.Circle();
            ball[i].setRadius(5);
            ball[i].setCenterX(168);
            ball[i].setCenterY(this.y);
            ball[i].setFill(Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
        }

        Group group = new Group();
        for(int i=0;i<ball.length;i++){
            group.getChildren().addAll(ball[i]);
        }

        PathTransition pathTransition[] = new PathTransition[ball.length];

        for(int i=0;i<pathTransition.length;i++){
            int x=-(int)ball[i].getCenterX() + random.nextInt((int) (4.5*ball[i].getCenterX()));
            int y=-(int)ball[i].getCenterY()+random.nextInt((int) (4.5*ball[i].getCenterY()));
            Line line= new Line(ball[i].getCenterX(),ball[i].getCenterY(),x,y);
            pathTransition[i]= new PathTransition();
            pathTransition[i].setNode(ball[i]);
            pathTransition[i].setDuration(Duration.seconds(1));
            pathTransition[i].setPath(line);
            pathTransition[i].setCycleCount(1);
            pathTransition[i].setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        }
        ParallelTransition parallelTransition = new ParallelTransition();
        for(int i=0;i<pathTransition.length;i++){
            parallelTransition.getChildren().add(pathTransition[i]);
        }
        parallelTransition.play();
        return  group;
    }

    @Override
    public void setY()
    {
        this.y+=30;
        group.setTranslateY(this.y);
    }
    public void setOrgY(int num) {
        this.y=num;
        group.setTranslateY(num);
    }
    @Override
    public double getY() {
        return this.y;
    }
    @Override
    public Group getGroup() {
        return this.group;
    }
}
