package andevcon14.FragmentCommsSupport.Types.ManyFragments;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicInteger;

import andevcon14.FragmentCommsSupport.Types.ManyFragments.dummy.DummyContent;

/**
 * A fragment representing a list of Items.
 * <p />
 * <p />
 * Activities containing this fragment MUST implement the {@link Callbacks}
 * interface.
 */
public class ManyListFragment extends ListFragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

//    private FrameLayout.LayoutParams frameLayoutParams = new FrameLayout.LayoutParams(
//            ViewGroup.LayoutParams.MATCH_PARENT,
//            ViewGroup.LayoutParams.MATCH_PARENT
//    );

    private AbsListView.LayoutParams frameLayoutParams = new AbsListView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
    );

    public static ManyListFragment newInstance(String param1, String param2) {
        ManyListFragment fragment = new ManyListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ManyListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }

        BaseAdapter adapter = new BaseAdapter() {
            @Override public int getCount() { return 10000; }
            @Override public Object getItem(int i) { return new Integer(i); }
            @Override public long getItemId(int i) { return i; }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {

                if (view!=null){
                    ManyListItemFragment fragment = (ManyListItemFragment) view.getTag();
                    fragment.setCount(i);
                } else {
                    FrameLayout layout = new FrameLayout(getActivity());
                    layout.setLayoutParams(frameLayoutParams);
                    int id = generateViewId();
                    layout.setId(id);
                    ManyListItemFragment fragment = new ManyListItemFragment();
                    fragment.setCount(i);
                    getChildFragmentManager()
                            .beginTransaction()
                            .replace(id,fragment)
                            .commit();
                    view = layout;
                    view.setTag(fragment);
                }

                return view;
            }
        };
        setListAdapter( adapter );
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static int generateViewId() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            for (;;) {
                final int result = sNextGeneratedId.get();
                // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
                int newValue = result + 1;
                if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
                if (sNextGeneratedId.compareAndSet(result, newValue)) {
                    return result;
                }
            }
        } else {
            return View.generateViewId();
        }
    }
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
}
