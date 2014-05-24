package andevcon14.FragmentComms.Types.LocalBroadcast;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import andevcon14.FragmentComms.R;

public class LocalBroadcastActivity extends Activity
implements MinusPlusButtonInterface{
    private static final String COUNTER_KEY = "COUNTER_KEY";
    private Button minusButton, plusButton;
    private TextView count;
    private Counter counter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.local_broadcast);
        minusButton = (Button) findViewById(R.id.minusButton);
        plusButton = (Button) findViewById(R.id.plusButton);
        count = (TextView) findViewById(R.id.count);

        if (savedInstanceState != null) {
            counter = (Counter) savedInstanceState.getSerializable(COUNTER_KEY);
        } else {
            counter = new Counter();
            LocalBroadcastFragment fragment = new LocalBroadcastFragment();
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.right, fragment)
                    .commit();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(COUNTER_KEY, counter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // TODO: unregister this (& in Fragments, unregister too)
    }

    @Override
    protected void onResume() {
        super.onResume();
        // TODO: register this (& in Fragments, unregister too)
    }

    @Override
    public void onMinusButton(View view) {
        counter.update(false);
    }

    @Override
    public void onPlusButton(View view) {
        counter.update(true);
    }
}
