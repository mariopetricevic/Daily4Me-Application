package hr.ferit.fragmentapp.HistoryData;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hr.ferit.fragmentapp.R;

public class RecyclerAdapterHistoryData extends RecyclerView.Adapter<HistoryDataViewHolder> {
    private List<Event> mevents=new ArrayList<>();
    @NonNull
    @Override
    public HistoryDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View cellView= LayoutInflater.from(parent.getContext()).inflate(R.layout.history_fragment_cell,parent, false);
        return new HistoryDataViewHolder(cellView);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryDataViewHolder historyDataViewHolder, int position){
        Event event=mevents.get(position);
        historyDataViewHolder.year_textview.setText("Year "+event.getYear()+".");
        historyDataViewHolder.description.setText(event.getDescription());
    }
    @Override
    public int getItemCount(){
        return mevents.size();
    }
    public void addData(List<Event> events){
        this.mevents.clear();
        this.mevents.addAll(events);
        notifyDataSetChanged();
    }

}
