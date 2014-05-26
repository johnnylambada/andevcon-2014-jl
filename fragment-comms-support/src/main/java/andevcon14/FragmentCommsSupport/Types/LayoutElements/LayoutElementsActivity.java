package andevcon14.FragmentCommsSupport.Types.LayoutElements;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import andevcon14.FragmentCommsSupport.R;

public class LayoutElementsActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_elements);
    }
}
