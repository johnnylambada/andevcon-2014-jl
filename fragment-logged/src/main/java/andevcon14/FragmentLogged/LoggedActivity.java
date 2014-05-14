package andevcon14.FragmentLogged;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class LoggedActivity extends Activity {
    @Override public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); CallLogger.logIt(); }
    @Override public void onDestroy() { super.onDestroy(); CallLogger.logIt(); CallLogger.logIt(); }
    @Override public void onNewIntent(Intent intent) { super.onNewIntent(intent); CallLogger.logIt(); }
    @Override public void onPause() { super.onPause(); CallLogger.logIt(); }
    @Override public void onPostCreate(Bundle savedInstanceState) { super.onPostCreate(savedInstanceState); CallLogger.logIt(); }
    @Override public void onPostResume() { super.onPostResume(); CallLogger.logIt(); }
    @Override public void onRestart() { super.onRestart(); CallLogger.logIt(); }
    @Override public void onRestoreInstanceState(Bundle savedInstanceState) { super.onRestoreInstanceState(savedInstanceState); CallLogger.logIt(); }
    @Override public void onResume() { super.onResume(); CallLogger.logIt(); }
    @Override public void onSaveInstanceState(Bundle outState) { super.onSaveInstanceState(outState); CallLogger.logIt(); }
    @Override public void onStart() { super.onStart(); CallLogger.logIt(); }
    @Override public void onStop() { super.onStop(); CallLogger.logIt(); }
    @Override public void onUserLeaveHint() { super.onUserLeaveHint(); CallLogger.logIt(); }
}