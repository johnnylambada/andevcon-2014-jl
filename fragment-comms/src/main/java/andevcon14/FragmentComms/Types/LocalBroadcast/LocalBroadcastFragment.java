package andevcon14.FragmentComms.Types.LocalBroadcast;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import andevcon14.FragmentComms.R;

public class LocalBroadcastFragment extends Fragment
implements MinusPlusButtonInterface{
    private Button minusButton, plusButton;
    private TextView count;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sis) {
        super.onCreateView(inflater, container, sis); // I want LoggedFragment's side effect
        View view = inflater.inflate(R.layout.minus_text_plus, container, false);
        minusButton = (Button) view.findViewById(R.id.minusButton);
        plusButton = (Button) view.findViewById(R.id.plusButton);
        count = (TextView) view.findViewById(R.id.count);
        return view;
    }

    @Override
    public void onMinusButton(View view) {
        ((MinusPlusButtonInterface)getActivity()).onMinusButton(view);
    }

    @Override
    public void onPlusButton(View view) {
        ((MinusPlusButtonInterface)getActivity()).onPlusButton(view);
    }
}
