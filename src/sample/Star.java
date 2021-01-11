package sample;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

public class Star extends Obstacle {
    transient Group group;
    @Override
    public void make() {
        group=new Group();
    }
    private float length;

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }
    @Override
    public Node defineOb() {
//        Rectangle obj1= new Rectangle();
//
////        group.setNodeOrientation()
//        Circle obj2= new Circle();
////        obj2.defineOb().set
//        group.getChildren().addAll(obj1.defineOb(),obj2.defineOb());
//        Circle obj = new Circle();
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{
                40d,0d,
                50d,16d,
                60d,0d,
                38d,9d,
                62d,9d,
        });

        polygon.setRotate(180);
        polygon.setFill(Color.WHITE);
//        obj.setRadius(2);
//        obj.setFill(Color.WHITE);
        group.getChildren().addAll(polygon);
        group.setTranslateX(125);
        group.setScaleY(1.25);
        group.setScaleX(1.25);
        return group;
    }
//    public void setY() {
//        group.setTranslateY(group.getTranslateY()+30);
//    }
//
//    @Override
//    public void setOrgY(int num) {
//        group.setTranslateY(num);
//    }
//    @Override
//    public double getY() {
//        return group.getTranslateY();
//    }@Override
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
