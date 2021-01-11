package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;

public class Circle extends Obstacle{

    transient Group group;
    protected float circleRad;
    public float getRadius() {
        return circleRad;
    }

    public void setRadius(float circleRad) {
        this.circleRad = circleRad;
    }

    @Override
    public void make() {
        group=new Group();
    }

    @Override
    public Node defineOb() {
        Arc arc1 = new Arc(50, 50, 70,70 , 0, 90);
        arc1.setFill(Color.TRANSPARENT);
        arc1.setStroke(Color.BLUE);
        arc1.setStrokeWidth(10f);
        arc1.setType(ArcType.OPEN);

        Arc arc2 = new Arc(50, 50, 70,70 , 90, 90);
        arc2.setFill(Color.TRANSPARENT);
        arc2.setStroke(Color.RED);
        arc2.setStrokeWidth(10f);
        arc2.setType(ArcType.OPEN);

        Arc arc3 = new Arc(50, 50, 70,70 , 180, 90);
        arc3.setFill(Color.TRANSPARENT);
        arc3.setStroke(Color.YELLOW);
        arc3.setStrokeWidth(10f);
        arc3.setType(ArcType.OPEN);

        Arc arc4 = new Arc(50, 50, 70,70 ,270, 90);
        arc4.setFill(Color.TRANSPARENT);
        arc4.setStroke(Color.PURPLE);
        arc4.setStrokeWidth(10f);
        arc4.setType(ArcType.OPEN);

//        translate the arc to a position
//        arc1.setTranslateX(100);
//        arc1.setTranslateY(100);

        // create a scene
        group.getChildren().addAll(arc1,arc2,arc3,arc4);
        group.setTranslateX(125);
        //group.setTranslateY(300);

        RotateTransition transition2=new RotateTransition(Duration.seconds(super.getSpeed()),group);
        transition2.setByAngle(360);
        transition2.setCycleCount(RotateTransition.INDEFINITE);
        transition2.setInterpolator(Interpolator.LINEAR);
        transition2.play();

        return group;
    }
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
 
