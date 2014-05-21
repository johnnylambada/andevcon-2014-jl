package andevcon14.FragmentLogged;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class LoggedActivity extends Activity {
    @Override public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); CallLogger.logMethod(this); }
    @Override public void onDestroy() { super.onDestroy(); CallLogger.logMethod(this); }
    @Override public void onNewIntent(Intent intent) { super.onNewIntent(intent); CallLogger.logMethod(this); }
    @Override public void onPause() { super.onPause(); CallLogger.logMethod(this); }
    @Override public void onPostCreate(Bundle savedInstanceState) { super.onPostCreate(savedInstanceState); CallLogger.logMethod(this); }
    @Override public void onPostResume() { super.onPostResume(); CallLogger.logMethod(this); }
    @Override public void onRestart() { super.onRestart(); CallLogger.logMethod(this); }
    @Override public void onRestoreInstanceState(Bundle savedInstanceState) { super.onRestoreInstanceState(savedInstanceState); CallLogger.logMethod(this); }
    @Override public void onResume() { super.onResume(); CallLogger.logMethod(this); }
    @Override public void onSaveInstanceState(Bundle outState) { super.onSaveInstanceState(outState); CallLogger.logMethod(this); }
    @Override public void onStart() { super.onStart(); CallLogger.logMethod(this); }
    @Override public void onStop() { super.onStop(); CallLogger.logMethod(this); }
    @Override public void onUserLeaveHint() { super.onUserLeaveHint(); CallLogger.logMethod(this); }
}