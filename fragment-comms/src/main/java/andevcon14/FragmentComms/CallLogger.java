package andevcon14.FragmentComms;

import android.app.Fragment;
import android.util.Log;

import java.util.Locale;

public class CallLogger {
    private final static String TAG = CallLogger.class.getSimpleName();

    /**
     * Find the caller in the stack.
     * @return The full name of the calling function or null
     */
    private static String getCaller(String stopAt) {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        boolean foundMe = false;
        for(int i=0; i<stacktrace.length; i++) {
            StackTraceElement e = stacktrace[i];
            String methodName = e.getMethodName();
            if (foundMe) {
                if (!methodName.startsWith("access$")) {
                    return methodName;
                }
            } else {
                if (methodName.equals(stopAt)) {
                    foundMe = true;
                }
            }
        }
        return null;
    }

    private static void logFail(Object object){
        Log.e(TAG, object.getClass().getName() + " UNKNOWN CALLER");
    }

    /**
     * Log a generic method
     * @param object The object calling the method
     */
    public static void logMethod(Object object){
        String caller = getCaller("logMethod");
        if (caller==null)
            logFail(object);
        else
            Log.i(TAG,object.getClass().getSimpleName()+"."+caller);
    }

    public static void logFragment(Fragment fragment){
        String caller = getCaller("logFragment");
        if (caller==null)
            logFail(fragment);
        else {
            StringBuffer b = new StringBuffer();
            b.append(fragment.getClass().getSimpleName())
                    .append('.')
                    .append(caller)
                    .append(": getActivity=")
                    .append(fragment.getActivity()==null?"null":"value");
            Log.i(TAG, b.toString());
        }
    }
}
