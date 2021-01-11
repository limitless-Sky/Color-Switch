package sample;

import java.io.Serializable;

public class Player implements Serializable {
    protected String name;
    private int highScore;
    public int totStar;

    public Player(String name){
        this.name=name;
    }
    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }
}
