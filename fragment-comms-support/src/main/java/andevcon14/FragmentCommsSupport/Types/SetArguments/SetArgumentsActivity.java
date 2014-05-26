package andevcon14.FragmentCommsSupport.Types.SetArguments;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import andevcon14.FragmentCommsSupport.R;

/**
 * This activity hosts the fragment
 */
public class SetArgumentsActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_arguments);

        if (savedInstanceState == null) {
            Bundle bundle = new Bundle();
            bundle.putString("text",this.getClass().getSimpleName());

            SetArgumentsFragment fragment = new SetArgumentsFragment();
            fragment.setArguments(bundle);

            getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.dynamic, fragment)
                .commit();
        }
    }
}
