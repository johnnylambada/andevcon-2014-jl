package andevcon14.FragmentLogged;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
    }

    public void startStaticFragmentActivity(View view){
        startActivity(new Intent(this,StaticFragmentActivity.class));
    }

    public void startDynamicFragmentActivity(View view){
        startActivity(new Intent(this,StaticFragmentActivity.class));
    }
}
