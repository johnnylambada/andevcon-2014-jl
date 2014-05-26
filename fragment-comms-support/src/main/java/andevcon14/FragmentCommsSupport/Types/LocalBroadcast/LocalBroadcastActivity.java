package andevcon14.FragmentCommsSupport.Types.LocalBroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import andevcon14.FragmentCommsSupport.R;

public class LocalBroadcastActivity extends FragmentActivity {
    private static final String COUNTER_KEY = "COUNTER_KEY";
    private Counter counter = null;
    private BroadcastReceiver countReceiver, updateReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.local_broadcast);
        Button minusButton = (Button) findViewById(R.id.minusButton);
        Button plusButton = (Button) findViewById(R.id.plusButton);
        final TextView count = (TextView) findViewById(R.id.count);

        if (savedInstanceState != null) {
            counter = (Counter) savedInstanceState.getSerializable(COUNTER_KEY);
        } else {
            counter = new Counter();
            LocalBroadcastFragment fragment = new LocalBroadcastFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.right, fragment)
                    .commit();
        }

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CounterBroadcastHelper.getInstance()
                        .broadcastUpdate(LocalBroadcastActivity.this, false);
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CounterBroadcastHelper.getInstance()
                        .broadcastUpdate(LocalBroadcastActivity.this, true);
            }
        });

        countReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int newCount = intent.getIntExtra(CounterBroadcastHelper.EXTRA_COUNT, 0);
                count.setText("" + newCount);
            }
        };

        updateReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                boolean isPlus = intent.getBooleanExtra(CounterBroadcastHelper.EXTRA_IS_PLUS,true);
                counter.update(isPlus);
                CounterBroadcastHelper.getInstance()
                        .broadcastCount(LocalBroadcastActivity.this,counter.getCount());
            }
        };

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(COUNTER_KEY, counter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(countReceiver);
        LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(updateReceiver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(
                        countReceiver,
                        CounterBroadcastHelper.getInstance().getReportIntentFilter());
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(
                        updateReceiver,
                        CounterBroadcastHelper.getInstance().getUpdateIntentFilter());
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        CounterBroadcastHelper.getInstance()
                .broadcastCount(this, counter.getCount());
    }
}
