package test0820.look;

import java.util.Observable;

public class Customer extends Observable {
    public int score;
    public int getScore(){
        return this.score;
    }
    public void setScore(int score){
        if (score != this.score){
            this.score = score;
            setChanged();
            notifyObservers("我变了");
        }
    }
}
