package android.architecture.alok.com.androidarchitecture.ui.activity;

import android.architecture.alok.com.androidarchitecture.R;
import android.architecture.alok.com.androidarchitecture.ui.fragment.DashboardFragment;
import android.architecture.alok.com.androidarchitecture.ui.fragment.HomeFragment;
import android.architecture.alok.com.androidarchitecture.ui.fragment.NotificationFragment;
import android.architecture.alok.com.androidarchitecture.utility.AppLog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = HomeActivity.class.getSimpleName();
    private final String FRAG_HOME = "home_frag";
    private final String FRAG_DASHBOARD = "dashboard_frag";
    private final String FRAG_NOTIFICATIONS = "notifications_frag";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    loadFragByTag(FRAG_HOME);
                    return true;
                case R.id.navigation_dashboard:
                    loadFragByTag(FRAG_DASHBOARD);
                    return true;
                case R.id.navigation_notifications:
                    loadFragByTag(FRAG_NOTIFICATIONS);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragByTag(FRAG_HOME);
    }

    private void loadFragByTag(String tag) {
        Fragment frag = getSupportFragmentManager().findFragmentByTag(tag);
        if (frag == null) {
            AppLog.d(TAG, "$tag not found, creating a new one.");
            switch (tag) {
                case FRAG_HOME:
                    frag = HomeFragment.getInstance();
                    break;
                case FRAG_DASHBOARD:
                    frag = DashboardFragment.getInstance();
                    break;
                case FRAG_NOTIFICATIONS:
                    frag = NotificationFragment.getInstance();
                    break;
                default:
                    frag = HomeFragment.getInstance();
                    break;
            }

        } else {
            AppLog.d(TAG, "$tag found.");
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_main, frag, tag)
                .commit();
    }


}
