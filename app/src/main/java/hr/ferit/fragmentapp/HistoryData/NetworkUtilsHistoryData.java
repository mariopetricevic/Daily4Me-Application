package hr.ferit.fragmentapp.HistoryData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkUtilsHistoryData {

    private static APIInterfaceHistoryData apiInterface;
    //String currentDate= DateFormat.getDateInstance().format(calendar.getTime());


    public static APIInterfaceHistoryData getApiInterface(){
        if(apiInterface==null){
            Calendar calendar=Calendar.getInstance();
            Date date = calendar.getTime();
            SimpleDateFormat format = new SimpleDateFormat("M/d/");
            String formattedDate = format.format(date);
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl("https://byabbe.se/on-this-day/"+formattedDate)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInterface=retrofit.create(APIInterfaceHistoryData.class);
        }
        return apiInterface;
    }
}
