package andevcon14.FragmentCommsSupport.Types.ActivityIntent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import andevcon14.FragmentCommsSupport.R;

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
