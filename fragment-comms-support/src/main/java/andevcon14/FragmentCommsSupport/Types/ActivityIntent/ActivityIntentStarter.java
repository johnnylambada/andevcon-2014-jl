package andevcon14.FragmentCommsSupport.Types.ActivityIntent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Start ActivityIntentActivity
 */
public class ActivityIntentStarter extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Pass info via the Intent that starts the actual Activity.
        // This information is available to any Fragments through
        // getActivity().getIntent()

        Intent intent = new Intent(this,ActivityIntentActivity.class);
        intent.putExtra("text",this.getClass().getSimpleName());
        startActivity(intent);
        finish();
    }
}
