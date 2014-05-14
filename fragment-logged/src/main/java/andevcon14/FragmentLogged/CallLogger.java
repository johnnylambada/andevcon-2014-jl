package andevcon14.FragmentLogged;

import android.util.Log;

import java.util.Locale;

public class CallLogger {
    private final static String TAG = CallLogger.class.getSimpleName();
    public static void logIt() {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        boolean logged = false;
        boolean foundMe = false;
        for(int i=0; i<stacktrace.length; i++) {
            StackTraceElement e = stacktrace[i];
            String methodName = e.getMethodName();
            if (foundMe) {
                if (!methodName.startsWith("access$")) {
                    Log.i(TAG, String.format(Locale.US, "%s.%s", e.getClassName(), methodName));
                    logged = true;
                    break;
                }
            } else {
                if (methodName.equals("logIt")) {
                    foundMe = true;
                }
            }
        }
        if (!logged)
            Log.e(TAG, "unlogged call");
    }
}
