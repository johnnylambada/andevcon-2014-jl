package andevcon14.FragmentComms.Types.ActivityIntent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import andevcon14.FragmentComms.R;

/**
 * This activity hosts the fragment
 */
public class ActivityIntentActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
    }
}
