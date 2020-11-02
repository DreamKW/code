package test0820.look;


import java.util.Observable;
import java.util.Observer;

public class Look implements Observer {
    public Look(){

    }
    public Look(Observable observable){
        observable.addObserver(this);
    }
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("你变le:"+((Customer)o).getScore());
        System.out.println("args:"+arg.toString());
    }
}
