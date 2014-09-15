package andevcon14.FragmentCommsSupport.Types.ManyFragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import andevcon14.FragmentCommsSupport.R;

public class ManyActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.many_fragments_activity);
    }
}
