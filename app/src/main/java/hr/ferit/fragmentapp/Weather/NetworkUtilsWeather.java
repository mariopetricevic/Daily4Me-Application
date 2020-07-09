package hr.ferit.fragmentapp.Weather;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkUtilsWeather {

    private static APIInterfaceWeather apiInterface;

    public static APIInterfaceWeather getApiInterface(){
        if(apiInterface==null){

            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl("http://api.weatherstack.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInterface=retrofit.create(APIInterfaceWeather.class);
        }
        return apiInterface;
    }

}