package andevcon14.HallOfMirrors;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MirrorFragment extends Fragment {

    public static MirrorFragment newInstance(){
        MirrorFragment fragment = new MirrorFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View view = inflater.inflate(R.layout.hom_fragment, container, false);
        final View plusButton = view.findViewById(R.id.plusButton);
        final View border = view.findViewById(R.id.border);
        border.setVisibility(View.GONE);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusButton.setVisibility(View.GONE);
                border.setVisibility(View.VISIBLE);
                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                MirrorFragment newFragment = MirrorFragment.newInstance();
                ft.add(R.id.frame, newFragment);
                ft.commit();
            }
        });
        return view;
    }
}
