package hr.ferit.fragmentapp.HistoryData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Event {

    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("wikipedia")
    @Expose
    private List<Wikipedium> wikipedia = null;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Wikipedium> getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(List<Wikipedium> wikipedia) {
        this.wikipedia = wikipedia;
    }

}