package andevcon14.FragmentComms.Types.SetArguments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;

import andevcon14.FragmentComms.CenteredTextFragment;
import andevcon14.FragmentComms.R;

public class SetArgumentsFragment extends CenteredTextFragment {
    private final static String TAG = SetArgumentsFragment.class.getSimpleName();

    // onAttach is a good spot to read the arguments from the Activity -- you know you have an
    // Activity since it's passed in as an argument, and it works for both Static and Dynamic
    // Fragments.  onResume is not a good place since CenteredTextFragment's onResume is where
    // we actually use the argument, and its onResume will be called before this one.
    
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        String text;
        Bundle bundle = getArguments();
        if (bundle == null) text = TAG + " null Bundle"; else {
            text = bundle.getString("text");
            if (text==null) text = TAG+" no getString";
        }
        setText(text);
    }
}
