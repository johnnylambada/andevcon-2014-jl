package andevcon14.FragmentCommsSupport.Types.LocalBroadcast;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import java.io.Serializable;

public class CounterBroadcastHelper implements Serializable {
    private final static String ACTION_REPORT = "ACTION_REPORT";
    private final static String ACTION_UPDATE = "ACTION_UPDATE";
    public final static String EXTRA_COUNT = "EXTRA_COUNT";
    public final static String EXTRA_IS_PLUS = "EXTRA_IS_PLUS";

    private static CounterBroadcastHelper instance = new CounterBroadcastHelper();

    private CounterBroadcastHelper(){}

    public static CounterBroadcastHelper getInstance(){
        return instance;
    }

    public IntentFilter getReportIntentFilter(){
        return new IntentFilter(ACTION_REPORT);
    }

    public IntentFilter getUpdateIntentFilter(){
        return new IntentFilter(ACTION_UPDATE);
    }

    public void broadcastCount(Context context, int count){
        Intent intent = new Intent(ACTION_REPORT);
        intent.putExtra(EXTRA_COUNT, count);
        LocalBroadcastManager.getInstance(context)
                .sendBroadcast(intent);
    }

    public void broadcastUpdate(Context context, boolean isPlus){
        Intent intent = new Intent(ACTION_UPDATE);
        intent.putExtra(EXTRA_IS_PLUS, isPlus);
        LocalBroadcastManager.getInstance(context)
                .sendBroadcast(intent);
    }
}
