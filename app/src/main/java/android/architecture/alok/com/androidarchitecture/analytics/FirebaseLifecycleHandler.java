package android.architecture.alok.com.androidarchitecture.analytics;

import android.app.Activity;
import android.app.Application;
import android.architecture.alok.com.androidarchitecture.utility.AppLog;
import android.os.Bundle;


public class FirebaseLifecycleHandler implements Application.ActivityLifecycleCallbacks {
    private int resumed;
    private int paused;
    private int started;
    private int stopped;
    private boolean needToSentEvent = true;
    private long startTime;
    private final String TAG = FirebaseLifecycleHandler.class.getSimpleName();

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
    }

    @Override
    public void onActivityResumed(Activity activity) {
        ++resumed;
        AppLog.d(TAG, "application is in resumed: " + (resumed > paused));
        if (needToSentEvent) {
            AppLog.d(TAG, "Session Start");
            startTime = System.currentTimeMillis();
            needToSentEvent = false;


        }
    }

    @Override
    public void onActivityPaused(Activity activity) {
        ++paused;
        AppLog.d(TAG, "application is in foreground: " + (resumed > paused));


    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    @Override
    public void onActivityStarted(Activity activity) {
        ++started;
    }

    @Override
    public void onActivityStopped(Activity activity) {
        ++stopped;
        AppLog.d(TAG, "application is visible: " + (started > stopped));
        if (started > stopped) {
            needToSentEvent = false;
        } else {
            needToSentEvent = true;
            AppLog.d(TAG, "Session Stop");
            long stopTime = System.currentTimeMillis();
            String email = "";
            AnalyticsLogger.logSessionEvents(startTime, stopTime, email, null);
        }

    }

}