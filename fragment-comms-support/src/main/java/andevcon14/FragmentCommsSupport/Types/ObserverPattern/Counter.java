package andevcon14.FragmentCommsSupport.Types.ObserverPattern;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Counter implements Serializable {
    private int count = 0;
    private final Set<Observer> observers = new HashSet<Observer>();

    public void update(boolean isPlus){
        if (isPlus)
            count++;
        else
            count--;

        updateListeners();
    }
    public void register(Observer observer){
        if (observers.add(observer))
            observer.onCount(count);
    }
    public void unRegister(Observer observer){
        observers.remove(observer);
    }
    private void updateListeners(){
        for(Observer observer : observers)
            observer.onCount(count);
    }
    public interface Observer {
        public void onCount(int count);
    }
}
