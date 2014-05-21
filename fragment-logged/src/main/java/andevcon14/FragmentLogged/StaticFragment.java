package andevcon14.FragmentLogged;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;

/**
 * Created by john on 5/14/14.
 */
public class StaticFragment extends CenteredTextFragment {

    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        TypedArray a = activity.obtainStyledAttributes(attrs, R.styleable.FragmentArguments);
        CharSequence cs = a.getText(R.styleable.FragmentArguments_android_label);
        if (cs!=null)
            setText(cs.toString());
        a.recycle();
    }
}
