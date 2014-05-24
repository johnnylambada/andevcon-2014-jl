package andevcon14.FragmentComms.Types.FactoryMethod;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;

import andevcon14.FragmentComms.CenteredTextFragment;
import andevcon14.FragmentComms.R;

public class FactoryMethodFragment extends CenteredTextFragment {
    private final static String TAG = FactoryMethodFragment.class.getSimpleName();

    public static FactoryMethodFragment newInstance(String text){
        FactoryMethodFragment fragment = new FactoryMethodFragment();
        fragment.setText(text);
        return fragment;
    }
}
