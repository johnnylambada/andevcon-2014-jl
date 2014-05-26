package andevcon14.FragmentCommsSupport;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CenteredTextFragment extends Fragment {
    private String text = "<NOT SET>";
    private View view;

    @Override
    public void onActivityCreated(Bundle sis) {
        super.onActivityCreated(sis);
        BundleManager.getFromBundle(this, sis);
    }

    @Override
    public void onCreate(Bundle sis) {
        super.onCreate(sis);
        BundleManager.getFromBundle(this, sis);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sis) {
        super.onCreateView(inflater,container,sis); // I want LoggedFragment's side effect
        BundleManager.getFromBundle(this, sis);
        view = inflater.inflate(R.layout.fragment_layout, container, false);
        return view;
    }

    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle sis) {
        super.onInflate(activity, attrs, sis);
        BundleManager.getFromBundle(this, sis);
    }

    @Override
    public void onResume() {
        super.onResume();
        applyText();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        BundleManager.saveToBundle(this, outState);
    }

    @Override
    public void onViewCreated(View view, Bundle sis) {
        super.onViewCreated(view, sis);
        BundleManager.getFromBundle(this, sis);
    }

    public String getText() {
        return text == null ? "" : text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private void applyText() {
        TextView textView = (TextView) view;
        textView.setText(text);
    }

    private final static class BundleManager {
        private final static String TEXT = "TEXT";

        public static void saveToBundle(CenteredTextFragment fragment, Bundle bundle) {
            if (bundle != null && fragment != null)
                bundle.putString(TEXT, fragment.getText());
        }

        public static void getFromBundle(CenteredTextFragment fragment, Bundle bundle) {
            if (bundle != null && fragment != null)
                fragment.setText(bundle.getString(TEXT));
        }
    }
}
