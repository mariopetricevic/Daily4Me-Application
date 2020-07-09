package hr.ferit.fragmentapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import hr.ferit.fragmentapp.R;
import hr.ferit.fragmentapp.Weather.Current;
import hr.ferit.fragmentapp.Weather.Location;
import hr.ferit.fragmentapp.Weather.NetworkUtilsWeather;
import hr.ferit.fragmentapp.Weather.WeatherData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherFragment extends Fragment {

    private TextView textViewResult;
    private TextView tvlocationName;
    private ImageView image;
    private TextView tvDescription;
    private TextView tvTemperature;
    private TextView tvFeels_like;
    private TextView tvHumidity;
    private TextView tvPressure;

    Call<WeatherData> call;

    public static WeatherFragment newInstance() {
        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setUpAPIICall();
        View view=inflater.inflate(R.layout.weather_fragment,container,false);
        textViewResult=view.findViewById(R.id.text_view_result);
        tvlocationName=view.findViewById(R.id.location_name);
        tvDescription=view.findViewById(R.id.description);
        tvTemperature=view.findViewById(R.id.temperature);
        tvFeels_like=view.findViewById(R.id.feels_like);
        tvHumidity=view.findViewById(R.id.humidity);
        tvPressure=view.findViewById(R.id.pressure);
        image=view.findViewById(R.id.picture);
        return view;
    }

    @Override
    public void onDestroy() {
        call.cancel();
        super.onDestroy();
    }

    private void setUpAPIICall() {
        call = NetworkUtilsWeather.getApiInterface().getWeatherData();
        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("code: " + response.code());
                    return;
                }
                tvlocationName.setText("Location: "+ response.body().getLocation().getName() +", "+ response.body().getLocation().getCountry());
                tvDescription.setText("Description: "+ response.body().getCurrent().getWeatherDescriptions());
                tvTemperature.setText("Temperature: "+ response.body().getCurrent().getTemperature()+"°C");
                tvFeels_like.setText("Feels like: "+ response.body().getCurrent().getFeelslike()+"°C");
                tvHumidity.setText("Humidity: "+ response.body().getCurrent().getHumidity()+ " %");
                tvPressure.setText("Pressure: "+ response.body().getCurrent().getPressure()+" HPa");
                Picasso.with(image.getContext())
                        .load(response.body().getCurrent().getWeatherIcons().get(0)).into(image);
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

}
