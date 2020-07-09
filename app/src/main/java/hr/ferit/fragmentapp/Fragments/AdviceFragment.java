package hr.ferit.fragmentapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import hr.ferit.fragmentapp.Advice.NetworkUtilsAdvice;
import hr.ferit.fragmentapp.Advice.Slips;
import hr.ferit.fragmentapp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdviceFragment extends Fragment {

    private TextView textViewResult;
    private Button newadvice;
    Call<Slips> call;

    public static AdviceFragment newInstance() {
        AdviceFragment fragment = new AdviceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setUpAPIICall();
        View view=inflater.inflate(R.layout.advice_fragment,container,false);
        textViewResult=view.findViewById(R.id.text_view_result);
        newadvice=view.findViewById(R.id.button3);
        newadvice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpAPIICall();
            }
        });
        return view;
    }
    @Override
    public void onDestroy() {
        call.cancel();
        super.onDestroy();
    }
    private void setUpAPIICall(){
        call= NetworkUtilsAdvice.getApiInterface().getSlips();
        call.enqueue(new Callback<Slips>() {
            @Override
            public void onResponse(Call<Slips> call, Response<Slips> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("code: " + response.code());
                    return;
                }
                String advice = response.body().getSlip().getAdvice();
                textViewResult.setText(advice);
            }

            @Override
            public void onFailure(Call<Slips> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}
