package andevcon14.FragmentLogged;

import android.util.Log;

import java.util.Locale;

public class CallLogger {
    private final static String TAG = CallLogger.class.getSimpleName();

    /**
     * Find the caller in the stack.
     * @return The full name of the calling function or null
     */
    private static String getCaller() {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        boolean logged = false;
        boolean foundMe = false;
        for(int i=0; i<stacktrace.length; i++) {
            StackTraceElement e = stacktrace[i];
            String methodName = e.getMethodName();
            if (foundMe) {
                if (!methodName.startsWith("access$")) {
                    return String.format(Locale.US, "%s.%s", e.getClassName(), methodName);
                }
            } else {
                if (methodName.equals("logIt")) {
                    foundMe = true;
                }
            }
        }
        return null;
    }
    public static void logIt(){
        String caller = getCaller();
        if (caller==null)
            Log.e(TAG,"unknown caller");
        else
            Log.i(TAG,caller);
    }
}
