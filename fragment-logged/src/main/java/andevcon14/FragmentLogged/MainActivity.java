package andevcon14.FragmentLogged;

import android.animation.Animator;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Locale;

public class MainActivity extends Activity {
    private final static String TAG = MainActivity.class.getSimpleName();

    @Override public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_layout); logIt(); }
    @Override protected void onPostCreate(Bundle savedInstanceState) { super.onPostCreate(savedInstanceState); logIt(); }
    @Override protected void onDestroy() { super.onDestroy(); logIt(); logIt(); }

    @Override protected void onSaveInstanceState(Bundle outState) { super.onSaveInstanceState(outState); logIt(); }
    @Override protected void onRestoreInstanceState(Bundle savedInstanceState) { super.onRestoreInstanceState(savedInstanceState); logIt(); }

    @Override protected void onRestart() { super.onRestart(); logIt(); }
    @Override protected void onStart() { super.onStart(); logIt(); }
    @Override protected void onStop() { super.onStop(); logIt(); }

    @Override protected void onPause() { super.onPause(); logIt(); }
    @Override protected void onResume() { super.onResume(); logIt(); }
    @Override protected void onPostResume() { super.onPostResume(); logIt(); }

    @Override protected void onNewIntent(Intent intent) { super.onNewIntent(intent); logIt(); }
    @Override protected void onUserLeaveHint() { super.onUserLeaveHint(); logIt(); }

    private static void logIt() {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        boolean logged = false;
        boolean foundMe = false;
        for(int i=0; i<stacktrace.length; i++) {
            StackTraceElement e = stacktrace[i];
            String methodName = e.getMethodName();
            if (foundMe) {
                if (!methodName.startsWith("access$")) {
                    Log.i(TAG, String.format(Locale.US, "%s.%s", e.getClassName(), methodName));
                    logged = true;
                    break;
                }
            } else {
                if (methodName.equals("logIt")) {
                    foundMe = true;
                }
            }
        }
        if (!logged)
            Log.e(TAG, "unlogged call");
    }

    public final static class MyFragment extends Fragment {

        @Override public void onInflate(Activity activity, AttributeSet attrs, Bundle sis) { super.onInflate(activity, attrs, sis); logIt(); }

        @Override public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); logIt(); }
        @Override public void onDestroy() { super.onDestroy(); logIt(); }

        @Override public void onStart() { super.onStart(); logIt(); }
        @Override public void onStop() { super.onStop(); logIt(); }

        @Override public void onResume() { super.onResume(); logIt(); }
        @Override public void onPause() { super.onPause(); logIt(); }

        @Override public void onAttach(Activity activity) { super.onAttach(activity); logIt(); }
        @Override public void onDetach() { super.onDetach(); logIt(); }

        @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) { logIt(); View v = inflater.inflate(R.layout.fragment_layout, container, false); return v; }
        @Override public void onDestroyView() { super.onDestroyView(); logIt(); }

        @Override public void onHiddenChanged(boolean hidden) { super.onHiddenChanged(hidden); logIt(); }

        @Override public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) { logIt(); return super.onCreateAnimator(transit, enter, nextAnim); }

        @Override public void onViewCreated(View view, Bundle savedInstanceState) { super.onViewCreated(view, savedInstanceState); logIt(); }

        @Override public void onActivityCreated(Bundle savedInstanceState) { super.onActivityCreated(savedInstanceState); logIt(); }

        @Override public void onViewStateRestored(Bundle savedInstanceState) { super.onViewStateRestored(savedInstanceState); logIt(); }

        @Override public void onSaveInstanceState(Bundle outState) { super.onSaveInstanceState(outState); logIt(); }

        @Override public void onConfigurationChanged(Configuration newConfig) { super.onConfigurationChanged(newConfig); logIt(); }
    }
}