package Obs;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Subject {
    Timer timer;

    private final List<Observer> observers = new ArrayList<Observer>();
    int state;
    int delay, period;
    public Subject() {
        this.state = 0;
        this.delay = 0;
        this.period = 0;
    }
    public void start(int d,int p){
        this.delay = d;
        this.period = p;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                tick();
            }
        }, delay* 1000L, period* 1000L);
    }
    public void stop(){
        timer.cancel();
        System.out.println("STOP!");
    }
    public void clean(){
        state = 0;
        stop();
        System.out.println("CLEAN!");
    }
    private void tick(){
        if(state==0) this.state+=delay;
        else this.state+=period;
        notifyAllObservers();
    }
    public int getState() {
        return this.state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public void attach(Observer observer){
        observers.add(observer);
    }
    public void detach(Observer observer){
        observers.remove(observer);
    }
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
