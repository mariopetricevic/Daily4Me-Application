package hr.ferit.fragmentapp.Advice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkUtilsAdvice {

    private static APIInterfaceAdvice apiInterface;

    public static APIInterfaceAdvice getApiInterface(){
        if(apiInterface==null){
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl("https://api.adviceslip.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiInterface=retrofit.create(APIInterfaceAdvice.class);
        }
        return apiInterface;
    }

}
