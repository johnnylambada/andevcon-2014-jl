package andevcon14.FragmentCommsSupport.Types.FactoryMethod;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import andevcon14.FragmentCommsSupport.R;

/**
 * This activity hosts the fragment
 */
public class FactoryMethodActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_arguments);

        if (savedInstanceState == null) {
            FactoryMethodFragment fragment = FactoryMethodFragment.newInstance(this.getClass().getSimpleName());
            getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.dynamic, fragment)
                .commit();
        }
    }
}
