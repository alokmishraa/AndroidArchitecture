package android.architecture.alok.com.androidarchitecture.retrofit;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiResponseFetchManager {
    private static final String TAG = ApiResponseFetchManager.class.getSimpleName();
    private ApiInterface sApiInterface;

    private ApiInterface getApiInterface() {
        if (sApiInterface == null) {
            synchronized (ApiResponseFetchManager.class) {
                if (sApiInterface == null) {
                    sApiInterface = ApiClient.getClient().create(ApiInterface.class);
                }
            }
        }
        return sApiInterface;
    }

    public void getContactSupport() {

        Map<String, String> headerMap = new HashMap<>();
        getApiInterface().getContactSupport(headerMap, null, null).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response != null && response.body() != null) {
                    Log.d(TAG, " data := " + response.body());
                } else {
                    Log.d(TAG, " error a := ");
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d(TAG, " msg = " + t.getMessage());
            }
        });
    }

}
