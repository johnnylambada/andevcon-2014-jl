package andevcon14.FragmentComms;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class DynamicActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic_fragment_activity_layout);

        if (savedInstanceState == null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            DynamicFragment newFragment = DynamicFragment.newInstance("Dynamic");
            ft.add(R.id.dynamic, newFragment);
            ft.commit();
        }
    }
}
