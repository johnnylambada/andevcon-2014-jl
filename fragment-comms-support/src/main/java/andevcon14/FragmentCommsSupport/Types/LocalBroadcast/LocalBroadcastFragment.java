package andevcon14.FragmentCommsSupport.Types.LocalBroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import andevcon14.FragmentCommsSupport.R;

public class LocalBroadcastFragment extends Fragment {
    private BroadcastReceiver countReceiver;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sis) {
        super.onCreateView(inflater, container, sis); // I want LoggedFragment's side effect
        View view = inflater.inflate(R.layout.minus_text_plus, container, false);
        Button minusButton = (Button) view.findViewById(R.id.minusButton);
        Button plusButton = (Button) view.findViewById(R.id.plusButton);
        final TextView count = (TextView) view.findViewById(R.id.count);

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CounterBroadcastHelper.getInstance()
                        .broadcastUpdate(getActivity(), false);
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CounterBroadcastHelper.getInstance()
                        .broadcastUpdate(getActivity(), true);
            }
        });

        countReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int newCount = intent.getIntExtra(CounterBroadcastHelper.EXTRA_COUNT, 0);
                count.setText(""+newCount);
            }
        };

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(getActivity())
                .unregisterReceiver(countReceiver);
    }

    @Override
    public void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(getActivity())
                .registerReceiver(
                        countReceiver,
                        CounterBroadcastHelper.getInstance().getReportIntentFilter());
    }
}
