package hr.ferit.fragmentapp.HistoryData;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import hr.ferit.fragmentapp.R;

public class HistoryDataViewHolder extends RecyclerView.ViewHolder {
    TextView year_textview;
    TextView description;


    public HistoryDataViewHolder(@NonNull View itemView) {
        super(itemView);
        year_textview = itemView.findViewById(R.id.year);
        description = itemView.findViewById(R.id.description);
    }
}