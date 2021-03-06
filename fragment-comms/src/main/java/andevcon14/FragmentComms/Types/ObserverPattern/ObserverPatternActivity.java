package andevcon14.FragmentComms.Types.ObserverPattern;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import andevcon14.FragmentComms.R;

public class ObserverPatternActivity extends Activity
implements Counter.Observer, MinusPlusButtonInterface{
    private static final String COUNTER_KEY = "COUNTER_KEY";
    private TextView count;
    private Counter counter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.observer_pattern);
        Button minusButton = (Button) findViewById(R.id.minusButton);
        Button plusButton = (Button) findViewById(R.id.plusButton);
        count = (TextView) findViewById(R.id.count);

        if (savedInstanceState != null) {
            counter = (Counter) savedInstanceState.getSerializable(COUNTER_KEY);
        } else {
            counter = new Counter();
            ObserverPatternFragment fragment = new ObserverPatternFragment();
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.right, fragment)
                    .commit();
        }
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMinusButton(view);
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPlusButton(view);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(COUNTER_KEY, counter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        counter.unRegister(this);
        counter.unRegister(
                (Counter.Observer)
                getFragmentManager()
                .findFragmentById(R.id.left));
        counter.unRegister(
                (Counter.Observer)
                getFragmentManager()
                .findFragmentById(R.id.right));
    }

    @Override
    protected void onResume() {
        super.onResume();
        counter.register(this);
        counter.register(
                (Counter.Observer)
                getFragmentManager()
                .findFragmentById(R.id.left));
        counter.register(
                (Counter.Observer)
                getFragmentManager()
                .findFragmentById(R.id.right));
    }

    @Override
    public void onCount(int count) {
        this.count.setText(""+count);
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
