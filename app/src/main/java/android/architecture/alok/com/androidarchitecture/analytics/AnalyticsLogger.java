package android.architecture.alok.com.androidarchitecture.analytics;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.HashMap;

/**
 * Created by ALOK MISHRAA on 08/27/2018
 * This Class is used log events for analytics
 */
public class AnalyticsLogger {
    private static final String SESSION_MANAGER = "session_manager";
    private static final String SOURCE = FirebaseAnalytics.Param.SOURCE;
    private static final String LABEL = FirebaseAnalytics.Param.CONTENT_TYPE;
    private static final String EXTRA = FirebaseAnalytics.Param.VALUE;
    private static final String EVENT_DEVELOPER_OPTIONS = "developer_options";

    public interface SessionEvents {
        String SESSION_START_TIME = "session_starttime";
        String SESSION_END_TIME = "session_endtime";
        String SESSION_DURATION = "session_duration";
        //String USER_ID = "user_id";
        String DEVICE_ID = "device_id";
        String EMAIL_ID = "email_id";
        String BPN = "bpn";
    }

    /***
     * This method logs event from event screen based on source,event name and label name
     * @param source the screen from where the event is logged
     * @param eventName the actual event in screen
     *  @param labelName the actual label
     *
     * */
    public static void logAnalytics(String source, String eventName, String labelName, String extraParam) {
        HashMap<String, String> dashboardEvents = new HashMap<>();
        dashboardEvents.put(SOURCE, source);
        dashboardEvents.put(LABEL, eventName);
        dashboardEvents.put(FirebaseAnalytics.Param.CONTENT, labelName);
        dashboardEvents.put(EXTRA, extraParam);
        AnalyticsWrapper.get().logEvent(EVENT_DEVELOPER_OPTIONS, dashboardEvents);
    }

    /*Log session events for analysis*/
    public static void logSessionEvents(long startTime, long endTime, String userId, String deviceId) {
        HashMap<String, String> eventHashMap = new HashMap<>();
        eventHashMap.put(SessionEvents.SESSION_START_TIME, String.valueOf(startTime));
        eventHashMap.put(SessionEvents.SESSION_END_TIME, String.valueOf(endTime));
        eventHashMap.put(SessionEvents.SESSION_DURATION, String.valueOf(endTime - startTime));
        eventHashMap.put(SessionEvents.EMAIL_ID, userId);
        eventHashMap.put(SessionEvents.DEVICE_ID, deviceId);
        AnalyticsWrapper.get().logEvent(SESSION_MANAGER, eventHashMap);
    }

}
