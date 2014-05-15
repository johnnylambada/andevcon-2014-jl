package andevcon14.FragmentLogged;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LoggedFragment extends Fragment {
    private String text = "<NOT SET>";
    View view;
    @Override public void onActivityCreated(Bundle sis) { super.onActivityCreated(sis); CallLogger.logIt(); BundleManager.getFromBundle(this,sis);}
    @Override public void onAttach(Activity activity) { super.onAttach(activity); CallLogger.logIt(); }
    @Override public void onConfigurationChanged(Configuration newConfig) { super.onConfigurationChanged(newConfig); CallLogger.logIt(); }
    @Override public void onCreate(Bundle sis) { super.onCreate(sis); CallLogger.logIt(); BundleManager.getFromBundle(this,sis);}
    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sis) { CallLogger.logIt(); BundleManager.getFromBundle(this,sis); view = inflater.inflate(R.layout.fragment_layout, container, false); return view; }
    @Override public void onDestroy() { super.onDestroy(); CallLogger.logIt(); }
    @Override public void onDestroyView() { super.onDestroyView(); CallLogger.logIt(); }
    @Override public void onDetach() { super.onDetach(); CallLogger.logIt(); }
    @Override public void onHiddenChanged(boolean hidden) { super.onHiddenChanged(hidden); CallLogger.logIt(); }
    @Override public void onInflate(Activity activity, AttributeSet attrs, Bundle sis) { super.onInflate(activity, attrs, sis); CallLogger.logIt(); BundleManager.getFromBundle(this,sis);}
    @Override public void onPause() { super.onPause(); CallLogger.logIt(); }
    @Override public void onResume() { super.onResume(); CallLogger.logIt(); applyText(); }
    @Override public void onSaveInstanceState(Bundle outState) { super.onSaveInstanceState(outState); CallLogger.logIt(); BundleManager.saveToBundle(this,outState);}
    @Override public void onStart() { super.onStart(); CallLogger.logIt(); }
    @Override public void onStop() { super.onStop(); CallLogger.logIt(); }
    @Override public void onViewCreated(View view, Bundle sis) { super.onViewCreated(view, sis); CallLogger.logIt(); BundleManager.getFromBundle(this,sis);}

    public String getText() { return text == null?"":text; }
    public void setText(String text) { this.text = text; }

    private void applyText(){
        TextView textView = (TextView) view;
        textView.setText(text);
    }

    private final static class BundleManager {
        private final static String TEXT = "TEXT";

        public static void saveToBundle(LoggedFragment fragment, Bundle bundle){
            if (bundle!=null && fragment!=null)
                bundle.putString(TEXT,fragment.getText());
        }
        public static  void getFromBundle(LoggedFragment fragment, Bundle bundle){
            if (bundle!=null && fragment!=null)
                fragment.setText(bundle.getString(TEXT));
        }
    }
}
