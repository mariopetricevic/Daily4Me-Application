package hr.ferit.fragmentapp.HistoryData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Wikipedia {

    @SerializedName("wikipedia")
    @Expose
    private String wikipedia;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("events")
    @Expose
    private List<Event> events = null;

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

}