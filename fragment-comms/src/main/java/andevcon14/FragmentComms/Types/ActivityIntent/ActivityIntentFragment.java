package andevcon14.FragmentComms.Types.ActivityIntent;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;

import andevcon14.FragmentComms.CenteredTextFragment;
import andevcon14.FragmentComms.R;

public class ActivityIntentFragment extends CenteredTextFragment {
    private final static String TAG = ActivityIntentFragment.class.getSimpleName();

    // onAttach is a good spot to read the arguments from the Activity -- you know you have an
    // Activity since it's passed in as an argument, and it works for both Static and Dynamic
    // Fragments.  onResume is not a good place since CenteredTextFragment's onResume is where
    // we actually use the argument, and its onResume will be called before this one.
    
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        String text;
        Intent intent = activity.getIntent();
        if (intent == null) text = TAG + " null Intent"; else {
            text = intent.getStringExtra("text");
            if (text==null) text = TAG+" no getStringExtra";
        }
        setText(text);
    }
}
