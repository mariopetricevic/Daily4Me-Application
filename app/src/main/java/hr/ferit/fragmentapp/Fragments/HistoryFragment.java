package hr.ferit.fragmentapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import hr.ferit.fragmentapp.HistoryData.NetworkUtilsHistoryData;
import hr.ferit.fragmentapp.HistoryData.RecyclerAdapterHistoryData;
import hr.ferit.fragmentapp.HistoryData.Wikipedia;
import hr.ferit.fragmentapp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryFragment extends Fragment {
    private TextView textViewResult;
    private TextView textViewDate;
    private RecyclerView recycler;
    private RecyclerAdapterHistoryData adapter;

    Call<Wikipedia> call;
    Calendar calendar=Calendar.getInstance();
    Date date = calendar.getTime();
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
    String formattedDate = format.format(date);

    public static HistoryFragment newInstance() {
        HistoryFragment fragment = new HistoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setUpAPIICall();
        View view=inflater.inflate(R.layout.history_fragment,container,false);
        textViewDate=view.findViewById(R.id.text_view_date);
        textViewDate.setText(formattedDate);
        textViewResult=view.findViewById(R.id.text_view_result);
        recycler= view.findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter=new RecyclerAdapterHistoryData();
        recycler.setAdapter(adapter);
        return view;

    }
    @Override
    public void onDestroy() {
        call.cancel();
        super.onDestroy();
    }
    private void setUpAPIICall() {
        call = NetworkUtilsHistoryData.getApiInterface().getEvents();
        call.enqueue(new Callback<Wikipedia>() {
            @Override
            public void onResponse(Call<Wikipedia> call, Response<Wikipedia> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("code: " + response.code());
                    return;
                }
                adapter.addData(response.body().getEvents());
            }
            @Override
            public void onFailure(Call<Wikipedia> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}
