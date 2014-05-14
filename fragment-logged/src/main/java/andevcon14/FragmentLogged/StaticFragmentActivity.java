package andevcon14.FragmentLogged;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StaticFragmentActivity extends Activity {
    private final static String TAG = StaticFragmentActivity.class.getSimpleName();

    @Override public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.static_fragment_activity_layout); CallLogger.logIt(); }
    @Override public void onDestroy() { super.onDestroy(); CallLogger.logIt(); CallLogger.logIt(); }
    @Override public void onNewIntent(Intent intent) { super.onNewIntent(intent); CallLogger.logIt(); }
    @Override public void onPause() { super.onPause(); CallLogger.logIt(); }
    @Override public void onPostCreate(Bundle savedInstanceState) { super.onPostCreate(savedInstanceState); CallLogger.logIt(); }
    @Override public void onPostResume() { super.onPostResume(); CallLogger.logIt(); }
    @Override public void onRestart() { super.onRestart(); CallLogger.logIt(); }
    @Override public void onRestoreInstanceState(Bundle savedInstanceState) { super.onRestoreInstanceState(savedInstanceState); CallLogger.logIt(); }
    @Override public void onResume() { super.onResume(); CallLogger.logIt(); }
    @Override public void onSaveInstanceState(Bundle outState) { super.onSaveInstanceState(outState); CallLogger.logIt(); }
    @Override public void onStart() { super.onStart(); CallLogger.logIt(); }
    @Override public void onStop() { super.onStop(); CallLogger.logIt(); }
    @Override public void onUserLeaveHint() { super.onUserLeaveHint(); CallLogger.logIt(); }

    public final static class StaticFragment extends Fragment {
        @Override public void onActivityCreated(Bundle savedInstanceState) { super.onActivityCreated(savedInstanceState); CallLogger.logIt(); }
        @Override public void onAttach(Activity activity) { super.onAttach(activity); CallLogger.logIt(); }
        @Override public void onConfigurationChanged(Configuration newConfig) { super.onConfigurationChanged(newConfig); CallLogger.logIt(); }
        @Override public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); CallLogger.logIt(); }
        @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) { CallLogger.logIt(); return inflater.inflate(R.layout.fragment_layout, container, false); }
        @Override public void onDestroy() { super.onDestroy(); CallLogger.logIt(); }
        @Override public void onDestroyView() { super.onDestroyView(); CallLogger.logIt(); }
        @Override public void onDetach() { super.onDetach(); CallLogger.logIt(); }
        @Override public void onHiddenChanged(boolean hidden) { super.onHiddenChanged(hidden); CallLogger.logIt(); }
        @Override public void onInflate(Activity activity, AttributeSet attrs, Bundle sis) { super.onInflate(activity, attrs, sis); CallLogger.logIt(); }
        @Override public void onPause() { super.onPause(); CallLogger.logIt(); }
        @Override public void onResume() { super.onResume(); CallLogger.logIt(); }
        @Override public void onSaveInstanceState(Bundle outState) { super.onSaveInstanceState(outState); CallLogger.logIt(); }
        @Override public void onStart() { super.onStart(); CallLogger.logIt(); }
        @Override public void onStop() { super.onStop(); CallLogger.logIt(); }
        @Override public void onViewCreated(View view, Bundle savedInstanceState) { super.onViewCreated(view, savedInstanceState); CallLogger.logIt(); }
        @Override public void onViewStateRestored(Bundle savedInstanceState) { super.onViewStateRestored(savedInstanceState); CallLogger.logIt(); }
    }
}