package android.architecture.alok.com.androidarchitecture.analytics;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.Map;

/**
 * Created by Alok Mishra on 14/08/18.
 * Wrapper around Analytics providers
 */

public class AnalyticsWrapper {

    private static final AnalyticsWrapper instance = new AnalyticsWrapper();
    private FirebaseAnalytics mFirebaseAnalytics;

    private AnalyticsWrapper() {
    }

    public void init(Context context) {
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);
    }

    public static AnalyticsWrapper get() {
        return instance;
    }

    private boolean isAnalyticNeeded() {
        return true;
    }

    /**
     * Log event with additional parameters
     *
     * @param eventName name of event
     * @param data      additional parameter for more informative analytics
     */
    public void logEvent(String eventName, Map<String, String> data) {
        if (!isAnalyticNeeded()) {
            return;
        }

        if (!TextUtils.isEmpty(eventName)) {
            Bundle bundle = new Bundle();
            for (Map.Entry<String, String> e : data.entrySet()) {
                bundle.putString(e.getKey(), e.getValue());
            }
            mFirebaseAnalytics.logEvent(eventName, bundle);
        }
    }

    public void setUserProperty(String name, String value) {
        if (!isAnalyticNeeded()) return;
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(value)) {
            mFirebaseAnalytics.setUserProperty(name, value);
        }
    }

    public void setUniqueUserId(String id) {
        if (!isAnalyticNeeded()) return;
        if (!TextUtils.isEmpty(id)) {
            mFirebaseAnalytics.setUserId(id);
        }
    }

}
