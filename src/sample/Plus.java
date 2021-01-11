package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.util.Duration;

public class Plus extends Obstacle {
    transient Group group;
    @Override
    public void make() {
        group=new Group();
    }
    @Override
    public Node defineOb() {
        Line l1=new Line(0,60,60,60);
        l1.setStroke(Color.RED);
        l1.setStrokeWidth(10);
        Line l2=new Line(60,60,120,60);
        l2.setStroke(Color.BLUE);
        l2.setStrokeWidth(10);
        Line l3=new Line(60,0,60,60);
        l3.setStroke(Color.YELLOW);
        l3.setStrokeWidth(10);
        Line l4=new Line(60,60,60,120);
        l4.setStroke(Color.PURPLE);
        l4.setStrokeWidth(10);
        l1.setStrokeLineCap(StrokeLineCap.ROUND);
        l2.setStrokeLineCap(StrokeLineCap.ROUND);
        l3.setStrokeLineCap(StrokeLineCap.ROUND);
        l4.setStrokeLineCap(StrokeLineCap.ROUND);
        group.getChildren().addAll(l1,l2,l3,l4);
        group.setTranslateX(75);
        //group.setTranslateY(-200);
        RotateTransition transition2=new RotateTransition(Duration.seconds(super.getSpeed()),group);
        transition2.setByAngle(360);
        transition2.setCycleCount(RotateTransition.INDEFINITE);
        transition2.setInterpolator(Interpolator.LINEAR);
        transition2.play();
        return group;
    }

    @Override
//    public void setY() {
//        group.setTranslateY(group.getTranslateY()+30);
//    }
//    public void setOrgY(int num) {
//        group.setTranslateY(num);
//    }
//    @Override
//    public double getY() {
//        return group.getTranslateY();
//    }
//    @Override
//    public Group getGroup() {
//        return this.group;
//    }
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
