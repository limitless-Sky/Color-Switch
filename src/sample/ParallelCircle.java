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

public class ParallelCircle extends Obstacle{


    protected float outCircleRad;

    public float getOutCircleRad() {
        return outCircleRad;
    }

    public void setOutCircleRad(float outCircleRad) {
        this.outCircleRad = outCircleRad;
    }

    transient Group group;
    @Override
    public void make() {
        group=new Group();
    }

    @Override
    public Node defineOb() {
        Arc arc1 = new Arc(50, 50, 70,70, 0, 90);
        arc1.setFill(Color.TRANSPARENT);
        arc1.setStroke(Color.BLUE);
        arc1.setStrokeWidth(10f);
        arc1.setType(ArcType.OPEN);

        Arc arc2 = new Arc(50, 50, 70,70, 90, 90);
        arc2.setFill(Color.TRANSPARENT);
        arc2.setStroke(Color.RED);
        arc2.setStrokeWidth(10f);
        arc2.setType(ArcType.OPEN);

        Arc arc3 = new Arc(50, 50, 70,70, 180, 90);
        arc3.setFill(Color.TRANSPARENT);
        arc3.setStroke(Color.YELLOW);
        arc3.setStrokeWidth(10f);
        arc3.setType(ArcType.OPEN);

        Arc arc4 = new Arc(50, 50, 70,70, 270, 90);
        arc4.setFill(Color.TRANSPARENT);
        arc4.setStroke(Color.PURPLE);
        arc4.setStrokeWidth(10f);
        arc4.setType(ArcType.OPEN);
        Group temp= new Group();
        // translate the arc to a position
//        arc1.setTranslateX(100);
//        arc1.setTranslateY(100);

        // create a scene
//        temp.getChildren().addAll(arc1,arc2,arc3,arc4);
//        group.setTranslateX(100);
//        group.setTranslateY(100);
        RotateTransition transition1=new RotateTransition(Duration.seconds(super.getSpeed()),temp);
        transition1.setByAngle(360);
        transition1.setCycleCount(RotateTransition.INDEFINITE);
        transition1.setInterpolator(Interpolator.LINEAR);
        transition1.play();


        Arc arc5 = new Arc(50, 50, 90,90, 0, 90);
        arc5.setFill(Color.TRANSPARENT);
        arc5.setStroke(Color.BLUE);
        arc5.setStrokeWidth(10f);
        arc5.setType(ArcType.OPEN);

        Arc arc6 = new Arc(50, 50, 90,90,  90, 90);
        arc6.setFill(Color.TRANSPARENT);
        arc6.setStroke(Color.RED);
        arc6.setStrokeWidth(10f);
        arc6.setType(ArcType.OPEN);

        Arc arc7 =new Arc(50, 50, 90,90,  180, 90);
        arc7.setFill(Color.TRANSPARENT);
        arc7.setStroke(Color.YELLOW);
        arc7.setStrokeWidth(10f);
        arc7.setType(ArcType.OPEN);

        Arc arc8 = new Arc(50, 50, 90,90, 270, 90);
        arc8.setFill(Color.TRANSPARENT);
        arc8.setStroke(Color.PURPLE);
        arc8.setStrokeWidth(10f);
        arc8.setType(ArcType.OPEN);

        // translate the arc to a position
//        arc1.setTranslateX(100);
//        arc1.setTranslateY(100);

        // create a scene
//        Group temp2= new Group();
//        temp2.getChildren().addAll(arc5,arc6,arc7,arc8);
        group.getChildren().addAll(arc1,arc2,arc3,arc4,arc5,arc6,arc7,arc8);
        group.setTranslateX(125);
        //group.setTranslateY(-450);

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
//    public double getY() {
//        return group.getTranslateY();
//    }
//    @Override
//    public Group getGroup() {
//        return this.group;
//    }
//    public void setOrgY(int num) {
//        group.setTranslateY(num);
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
