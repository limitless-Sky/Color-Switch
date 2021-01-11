package sample;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public class ColorChanger extends Obstacle{
    transient Group group;

    @Override
    public void make() {
        group=new Group();
    }

    @Override
    public Node defineOb() {
        Arc arc1 = new Arc(10,10,10,10, 0, 90);
        arc1.setFill(Color.BLUE);
//        arc1.setStroke(Color.BLUE);
//        arc1.setStrokeWidth(10f);
        arc1.setType(ArcType.ROUND);

        Arc arc2 = new Arc(10,10,10,10,  90, 90);
        arc2.setFill(Color.RED);
//        arc2.setStroke(Color.RED);
//        arc2.setStrokeWidth(10f);
        arc2.setType(ArcType.ROUND);

        Arc arc3 = new Arc(10,10,10,10,  180, 90);
        arc3.setFill(Color.YELLOW);
//        arc3.setStroke(Color.YELLOW);
//        arc3.setStrokeWidth(10f);
        arc3.setType(ArcType.ROUND);

        Arc arc4 = new Arc(10,10,10,10,  270, 90);
        arc4.setFill(Color.PURPLE);
//        arc4.setStroke(Color.PURPLE);
//        arc4.setStrokeWidth(10f);
        arc4.setType(ArcType.ROUND);


        // translate the arc to a position
//        arc1.setTranslateX(100);
//        arc1.setTranslateY(100);

        // create a scene
        group.getChildren().addAll(arc1,arc2,arc3,arc4);
        group.setTranslateX(168);
        setY();
//        group.setTranslateY(100);

//        RotateTransition transition2=new RotateTransition(Duration.seconds(3),group);
//        transition2.setByAngle(360);
//        transition2.setCycleCount(RotateTransition.INDEFINITE);
//        transition2.setInterpolator(Interpolator.LINEAR);
//        transition2.play();
        return group;
    }
    @Override
//    public void setY()
//    {
//        group.setTranslateY(group.getTranslateY()+30);
//    }
//    public void setOrgY(int num) {
//        group.setTranslateY(num);
//    }
//
//    @Override
//    public Group getGroup() {
//        return group;
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
