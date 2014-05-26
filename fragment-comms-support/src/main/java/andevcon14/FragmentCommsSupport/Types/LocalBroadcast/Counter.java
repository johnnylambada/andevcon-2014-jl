package andevcon14.FragmentCommsSupport.Types.LocalBroadcast;

import java.io.Serializable;

public class Counter implements Serializable {
    private int count = 0;

    public int getCount(){
        return count;
    }

    public void update(boolean isPlus){
        if (isPlus)
            count++;
        else
            count--;
    }
}
