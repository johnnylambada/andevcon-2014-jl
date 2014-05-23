package andevcon14.FragmentComms;

import android.os.Bundle;

public class StaticActivity extends LoggedActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.static_fragment_activity_layout);
    }
}
