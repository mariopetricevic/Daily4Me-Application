package hr.ferit.fragmentapp.Advice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Slips {

    @SerializedName("slip")
    @Expose
    private Slip slip;

    public Slip getSlip() {
        return slip;
    }
}
