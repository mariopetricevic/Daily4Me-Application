package hr.ferit.fragmentapp.Weather;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterfaceWeather {
    @GET("/current?access_key=8245cc947a46a2baa4596bb5370dd64e&query=Osijek")
    Call<WeatherData> getWeatherData();
}
