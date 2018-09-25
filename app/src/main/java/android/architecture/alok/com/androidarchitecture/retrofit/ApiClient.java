package android.architecture.alok.com.androidarchitecture.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // TODO in case of adding Header uncomment code
        /*httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                // add ALL common Header in Request
                Request request = chain.request().newBuilder()
                        .addHeader(ConstantUnits.serialNumber, mSharedPreferenceHelper.getStringPreference(mSharedPreferenceHelper.BASE_INFO_SERIAL_NUMBER))
                        .build();
                return chain.proceed(request);
            }
        });*/
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("BuildConfig.BASE_URL").client(httpClient.build()).build();
        }
        return retrofit;
    }
}
