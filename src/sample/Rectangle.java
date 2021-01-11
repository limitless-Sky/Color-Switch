package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.StrokeTransition;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.util.Duration;

public class Rectangle extends Obstacle{
    transient Group group;
    @Override
    public void make() {
        group=new Group();
    }
    private float rec_length;
    private float rec_breadth;

    public float getRecLength() {
        return rec_length;
    }

    public void setRecLength(float rec_length) {
        this.rec_length = rec_length;
    }

    public float getRecBreadth() {
        return rec_breadth;
    }

    public void setRecBreadth(float rec_breadth) {
        this.rec_breadth = rec_breadth;
    }
    @Override
    public Node defineOb() {

        Line line1 = new Line(10,10,120,10);
        line1.setStroke(Color.RED);
        line1.setStrokeWidth(10);
//        line1.setStrokeLineCap(StrokeLineCap.ROUND);

        Line line2 = new Line(10,10,10,120);
        line2.setStroke(Color.BLUE);
        line2.setStrokeWidth(10);
//        line2.setStrokeLineCap(StrokeLineCap.ROUND);

        Line line3 = new Line(120,10,120,120);
        line3.setStroke(Color.YELLOW);
        line3.setStrokeWidth(10);
//        line3.setStrokeLineCap(StrokeLineCap.ROUND);

        Line line4 = new Line(120,120,10,120);
        line4.setStroke(Color.PURPLE);
        line4.setStrokeWidth(10);
//        line4.setStrokeLineCap(StrokeLineCap.ROUND);
        line1.setStrokeLineCap(StrokeLineCap.ROUND);
        line2.setStrokeLineCap(StrokeLineCap.ROUND);
        line3.setStrokeLineCap(StrokeLineCap.ROUND);
        line4.setStrokeLineCap(StrokeLineCap.ROUND);

        group.getChildren().addAll(line1,line2,line3,line4);

        group.setTranslateX(115);
        //group.setTranslateY(50);

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
//
//    @Override
//    public void setOrgY(int num) {
//        group.setTranslateY(num);
//    }
//
//    @Override
//    public Group getGroup() {
//        return this.group;
//    }
//
//    @Override
//    public double getY() {
//        return group.getTranslateY();
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
