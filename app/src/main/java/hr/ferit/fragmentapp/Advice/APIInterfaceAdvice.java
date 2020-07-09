package hr.ferit.fragmentapp.Advice;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterfaceAdvice {
    @GET("/advice")
    Call<Slips> getSlips();
}
