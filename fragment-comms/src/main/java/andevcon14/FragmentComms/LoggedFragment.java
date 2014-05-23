package andevcon14.FragmentComms;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LoggedFragment extends Fragment {
    @Override public void onActivityCreated(Bundle sis) { super.onActivityCreated(sis); CallLogger.logFragment(this);}
    @Override public void onAttach(Activity activity) { super.onAttach(activity); CallLogger.logFragment(this);}
    @Override public void onConfigurationChanged(Configuration newConfig) { super.onConfigurationChanged(newConfig); CallLogger.logFragment(this);}
    @Override public void onCreate(Bundle sis) { super.onCreate(sis); CallLogger.logFragment(this);}
    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sis) { CallLogger.logFragment(this); return null; }
    @Override public void onDestroy() { super.onDestroy(); CallLogger.logFragment(this);}
    @Override public void onDestroyView() { super.onDestroyView(); CallLogger.logFragment(this);}
    @Override public void onDetach() { super.onDetach(); CallLogger.logFragment(this);}
    @Override public void onHiddenChanged(boolean hidden) { super.onHiddenChanged(hidden); CallLogger.logFragment(this); }
    @Override public void onInflate(Activity activity, AttributeSet attrs, Bundle sis) { super.onInflate(activity, attrs, sis); CallLogger.logFragment(this);}
    @Override public void onPause() { super.onPause(); CallLogger.logFragment(this);}
    @Override public void onResume() { super.onResume(); CallLogger.logFragment(this);}
    @Override public void onSaveInstanceState(Bundle outState) { super.onSaveInstanceState(outState); CallLogger.logFragment(this);}
    @Override public void onStart() { super.onStart(); CallLogger.logFragment(this);}
    @Override public void onStop() { super.onStop(); CallLogger.logFragment(this);}
    @Override public void onViewCreated(View view, Bundle sis) { super.onViewCreated(view, sis); CallLogger.logFragment(this);}
}
