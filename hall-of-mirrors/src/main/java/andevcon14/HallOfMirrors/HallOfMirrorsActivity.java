package andevcon14.HallOfMirrors;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class HallOfMirrorsActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hom_activity);

        if (savedInstanceState == null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            MirrorFragment newFragment = MirrorFragment.newInstance();
            ft.add(R.id.frame, newFragment);
            ft.commit();
        }
    }
}
