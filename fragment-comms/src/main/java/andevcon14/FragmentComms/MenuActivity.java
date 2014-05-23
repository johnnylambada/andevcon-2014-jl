package andevcon14.FragmentComms;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MenuActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(Menu.getSimpleAdapter(this));
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = Menu.getIntent(this,position);
        startActivity(intent);
    }
}
