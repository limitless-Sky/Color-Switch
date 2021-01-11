package sample;


import javafx.scene.Group;
import javafx.scene.Node;

import java.io.Serializable;

public abstract class Obstacle implements Serializable {
    public boolean check=false;
    public abstract void make();
    double y;
    private int obId;
    public int level;
    private float speed=3.5f;
    public abstract Node defineOb();

    public int getObId() {
        return obId;
    }

    public void setObId(int obId) {
        this.obId = obId;
    }
    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
    public abstract void setY();
    public abstract double getY();
    public abstract void setOrgY(int num);
    public abstract Group getGroup();
}
 
