package hr.ferit.fragmentapp.HistoryData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wikipedium {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("wikipedia")
    @Expose
    private String wikipedia;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

}