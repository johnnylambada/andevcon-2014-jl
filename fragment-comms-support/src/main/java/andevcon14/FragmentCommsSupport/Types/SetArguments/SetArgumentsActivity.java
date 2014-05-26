package andevcon14.FragmentCommsSupport.Types.SetArguments;

import android.app.Activity;
import android.os.Bundle;

import andevcon14.FragmentCommsSupport.R;

/**
 * This activity hosts the fragment
 */
public class SetArgumentsActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_arguments);

        if (savedInstanceState == null) {
            Bundle bundle = new Bundle();
            bundle.putString("text",this.getClass().getSimpleName());

            SetArgumentsFragment fragment = new SetArgumentsFragment();
            fragment.setArguments(bundle);

            getFragmentManager()
                .beginTransaction()
                .add(R.id.dynamic, fragment)
                .commit();
        }
    }
}
