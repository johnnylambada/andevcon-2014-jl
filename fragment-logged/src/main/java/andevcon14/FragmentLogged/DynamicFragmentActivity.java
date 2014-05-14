package andevcon14.FragmentLogged;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class DynamicFragmentActivity extends LoggedActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic_fragment_activity_layout);

        if (savedInstanceState == null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            Fragment newFragment = new LoggedFragment();
            ft.add(R.id.dynamic, newFragment);
            ft.commit();
        }
    }
}
