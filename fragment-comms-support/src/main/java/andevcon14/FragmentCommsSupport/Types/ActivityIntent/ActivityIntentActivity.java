package andevcon14.FragmentCommsSupport.Types.ActivityIntent;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import andevcon14.FragmentCommsSupport.R;

/**
 * This activity hosts the fragment
 */
public class ActivityIntentActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
    }
}
