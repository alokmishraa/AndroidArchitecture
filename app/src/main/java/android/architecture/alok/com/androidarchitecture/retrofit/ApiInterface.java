package android.architecture.alok.com.androidarchitecture.retrofit;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface<T> {
    // No Headers
    @GET("v1/public/yql?format=json")
    Call<T> getForeCast(@Query("q") String forcastQuesy);

    // add multiple Headers
    @Headers({
            "Accept: application/json",
            "User-Agent: Your-App-Name",
            "Cache-Control: max-age=640000"
    })
    @GET("v1/public/yql?format=json")
    Call<T> getForeCast1(@Query("q") String forcastQuesy);

    @GET("resource/contact/{model}/{countryCode}")
    Call<T> getContactSupport(@HeaderMap Map<String, String> headers, @Path("model") String model, @Path("countryCode") String countryCode);

    // add Single Header
    @Headers({"Accept: application/json"})
    @GET("/contact/{model}/{countryCode}")
    Call<T> getContacData(String model, String countryCode);

}