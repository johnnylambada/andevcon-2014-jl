package andevcon14.FragmentComms.Types.LocalBroadcast;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Counter implements Serializable {
    private int count = 0;

    public void update(boolean isPlus){
        if (isPlus)
            count++;
        else
            count--;

        updateListeners();
    }
    private void updateListeners(){
        // TODO: send broadcast
    }
}
