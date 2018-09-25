package android.architecture.alok.com.androidarchitecture.utility;

import android.util.Log;

/**
 * Created by NEX7IMH on 14-Jun-17
 */
public class AppLog {
    private static final boolean isAppLogEnabled = true;
    private AppLog() {}

    public static void i(String tag, String msg) {
        if(isAppLogEnabled) {
            Log.i(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if(isAppLogEnabled) {
            Log.d(tag, msg);
        }
    }

    public static void e(String tag, String msg, Exception e) {
        if(isAppLogEnabled) {
            Log.e(tag, msg, e);
            e.printStackTrace();
        }
        // Tracking exception
    }

}