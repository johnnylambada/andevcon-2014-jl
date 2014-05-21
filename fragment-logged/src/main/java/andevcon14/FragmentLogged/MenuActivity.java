package andevcon14.FragmentLogged;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MenuActivity extends Activity {
    public final static String RETAIN_INSTANCE = "RETAIN_INSTANCE";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
    }

    public void startStaticFragmentActivity(View view){
        startActivity(getIntent(StaticActivity.class));
    }

    public void startDynamicFragmentActivity(View view){
        startActivity(getIntent(DynamicActivity.class));
    }

    private Intent getIntent(Class<?> cls) {
        boolean retainInstance = ((CheckBox)findViewById(R.id.retainInstance)).isChecked();
        Intent intent = new Intent(this,cls);
        intent.putExtra(RETAIN_INSTANCE, retainInstance);
        return intent;
    }
}
