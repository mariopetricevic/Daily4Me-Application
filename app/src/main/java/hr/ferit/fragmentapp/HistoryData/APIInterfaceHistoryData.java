package hr.ferit.fragmentapp.HistoryData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterfaceHistoryData {
    @GET("events.json")
    Call<Wikipedia> getEvents();
}
