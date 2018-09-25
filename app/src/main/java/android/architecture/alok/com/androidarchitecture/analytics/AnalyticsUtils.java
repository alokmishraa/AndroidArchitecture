package android.architecture.alok.com.androidarchitecture.analytics;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.HashMap;

/*
 *
 * Created by Alok Mishra on 14/08/2018
 * This Class is used log events for analytics.
 * @Author Alok Mishra
 * */
public class AnalyticsUtils {
    private static final String SOURCE = "Source";
    private static final String LABEL = "Label";
    public static final String DEVICE_ID = "pbcare_device_id";
    public static final String MODEL_NUMBER = "pbcare_model_number";
    public static final String SERIAL_NUMBER = "pbcare_serial_number";

    public static final String CUSTOMER_ADDRESS = "pbcare_customer_address";
    public static final String CUSTOMER_NAME = "pbcare_customer_name";


    public interface SOURCE_SCREEN {
        String PBCARE_HOME_SCREEN = "Pbcare_home_screen";
        String PBCARE_MY_ACCOUNT = "Pbcare_your_account";
        String PBCARE_SIGN_IN = "Pbcare_sign_in";
        String PBCARE_WELCOME = "Pbcare_welcome_login";
        String PBCARE_SELF_HELP = "Pbcare_self_help";
        String PBCARE_ARTICLE_DESCRIPTION = "Pbcare_article_description";
        String PBCARE_ARTICLE_LIST = "Pbcare_article_list";
        String PBCARE_SELFHELP_SEARCH = "Pbcare_selfhelp_search";
        String PBCARE_SELECT_DEVICE = "Pbcare_select_device";
        String PBCARE_MANAGE_PROFILE = "Pbcare_manage_profile";
        String PBCARE_USER_PREFERENCE = "Pbcare_user_preference";
        String PBCARE_SPLASH_SCREEN = "Pbcare_splash_screen";
        String PBCARE_DASHBOARD_SCREEN = "Pbcare_dashboard_screen";
        String PBCARE_DEVICE_TAB = "Device_dashboard";
        String PBCARE_SUMMARY_TAB = "Pbcare_summary_dashboard";
        String PBCARE_REVIEW_SCREEN = "Pbcare_review_screen";
        String PBCARE_DEVICE_ALERTS = "Pbcare_device_alerts_screen";
        String PBCARE_INTRO_SCREEN = "Pbcare_intro_screen";
        String PBCARE_TICKET_STATUS_SCREEN = "Pbcare_ticket_status_screen";
        String PBCARE_NOTIFICATION_SCREEN = "Pbcare_notification_screen";
        String PBCARE_HOW_TO_USE_SCREEN = "Pbcare_how_to_use_screen";
    }

    public interface LABEL_NAME {
        String PBCARE_SIGN_IN_SUCCESS = "pbcare_sign_in_success";
        String DASHBOARD = "pbcare_dashboard";
        String SELF_HELP = "Self help";
        String MY_ACCOUNT = "My account";
        String ANALYTICS_LIST_SCREEN = "Analytics List Screen";
        String IMAGE_VIEW_NO = "Image_view_no";
        String IMAGE_VIEW_YES = "Image_view_yes";
        String ANALYTICS_DESCRIPTION_SCREEN = "Analytics Description Screen";
        String ANALYTICS_CALL_US = "Call us";
        String ANALYTICS_SEARCH_VIEW = "Search support";
        String ANALYTICS_SEARCH_AUDIO = "Search speak";
        String ANALYTICS_GUIDES = "Guides";
        String ANALYTICS_ERROR_MESSAGES = "Error Messages";
        String ANALYTICS_MENU_NOTIFICATION = "Notification alert";
        String ANALYTICS_SELECT_DEVICE = "Select Device";
        String ANALYTICS_CONTINUE_CLICK = "Continue";
        String ANALYTICS_SIGIN = "Welcome Login";
        String ANALYTICS_LOGIN_WEB_BACK = "Back clicked";
        String ANALYTICS_HOME_SCREEN = "Home Screen Back";
        String ANALYTICS_DASHBOARD_TAB = "Dashboard Tab";
        String ANALYTICS_DASHBOARD_CHANGE_DEVICE = "Device change";
        String ANALYTICS_DASHBOARD_USER_PROFILE = "User profile";
        String MAILING = "Mailing";
        String SHIPPING = "Shipping";
        String ANALYTICS_DASHBOARD_SAVING = "Saving view";
        String ANALYTICS_DASHBOARD_USAGE = "Usage view";

        String ANALYTICS_MENU_REVIEW = "Menu review";
        String SWITCH_ACCOUNT = "Switch account";
        String ANALYTICS_DEVICE_ALERT = "Device alert";

        String CONNECTIVITY = "Connectivity";
        String PRINTING = "Printing";
        String ACCOUNTS = "Accounts";
        String TROUBLESHOOTING = "Troubleshooting";
        String ANALYTICS_ONDEVICE_CHANGE = "Device update";
        String PBCARE_SIGN_OUT = "Pbcare sign out";
        String PBCARE_SIGN_OUT_SUCCESSFUL = "Pbcare sign out successful";
        String MANAGE_PROFILE = "Manage profile";
        String USER_PREFERENCE = "User preference";
        String SPLASH_BACK = "Splash screen back pressed";
        String WELCOME_BACK = "Welcome screen back pressed";
        String LAUNCH_ACTIVITY = "Launch new activity from Splash ";
        String PBCARE_SIGN_IN_FAILED = "Pbcare sign in failed";
        String SHOW_MORE = "Show more";
        String TICKET_STATUS = "Ticket status";

        String ANALYTICS_RATE_APP = "Rate app";
        String ANALYTICS_RATE_DEVICE = "Rate device";
        String ANALYTICS_REVIEW_SELECT_ACCOUNT = "Select account";
        String ANALYTICS_REVIEW_SELECT_DEVICE = "Select device";
        String ANALYTICS_REVIEW_SUBMIT = "Review submit";
        String ANALYTICS_REVIEW_RATING_BAR = "Review rating bar";
        String ANALYTICS_DASHBOARD_CHANGE_LOCAION = "Location change";
        String SKIP = "Skip";
        String NEXT = "Next";
        String PROCEED = "Proceed";
        String NOTIFICATION_LABEL = "Article Details ViewController";
        String NOTIFICATION_LABEL_SPLASH = "Splash Screen";
        String NOTIFICATION_LABEL_LOGIN = "Login Screen";
        String ANALYTICS_HOW_TO_USE_WEB_BACK = "How to use Back pressed";
        String HOW_TO_USE = "How to use link";
    }

    public interface EVENT_NAME {
        String LOGIN = "login";
        String ACTION_CLICKED = FirebaseAnalytics.Event.SELECT_CONTENT;
        String ACTION_SEARCH = FirebaseAnalytics.Event.SEARCH;
        String ACTION_BACK = "click_back";
        String CLICK_HOME = "click_home";
        String LOGGED_OUT_CONFIRMED = "logged_out_confirmed";
        String LOGGED_OUT_CANCELLED = "logged_out_cancelled";
        String COMPOUND_BUTTON_CHECK_CHANGED = "compound_changed_btn";
        String SELECT_ADDRESS = "bpn_address";
        String SELECT_CUSTOME_NAME = "customer_name";
        String SELECT_MODEL_NUMBER = "model_number";
        String SELECT_SERIAL_NUMBER = "serial_number";
        String ACTION_TRY_AGAIN = "try_again";
        String NOTIFICATION_CLICKED = "pushnotification_alert";
    }

    /***
     * This method logs event from event screen based on source,event name and label name
     * @param source the screen from where the event is logged
     * @param eventName the actual event in screen
     *  @param labelName the actual label
     *
     * */
    public static void logAnalytics(String source, String eventName, String labelName) {
        HashMap<String, String> dashboardEvents = new HashMap<>();
        dashboardEvents.put(SOURCE, source);
        dashboardEvents.put(LABEL, labelName);
        AnalyticsWrapper.get().logEvent(eventName, dashboardEvents);
    }
}
