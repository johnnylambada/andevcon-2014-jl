package andevcon14.FragmentCommsSupport.Types.ObserverPattern;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import andevcon14.FragmentCommsSupport.R;

public class ObserverPatternFragment extends Fragment
implements Counter.Observer {
    private Button minusButton, plusButton;
    private TextView count;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sis) {
        super.onCreateView(inflater, container, sis); // I want LoggedFragment's side effect
        View view = inflater.inflate(R.layout.minus_text_plus, container, false);
        minusButton = (Button) view.findViewById(R.id.minusButton);
        plusButton = (Button) view.findViewById(R.id.plusButton);
        count = (TextView) view.findViewById(R.id.count);

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MinusPlusButtonInterface)getActivity()).onMinusButton(view);
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MinusPlusButtonInterface)getActivity()).onPlusButton(view);
            }
        });

        return view;
    }

    @Override
    public void onCount(int count) {
        this.count.setText(""+count);
    }
}
