package hr.ferit.fragmentapp.Advice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Slip {

    @SerializedName("advice")
    @Expose
    private String advice;
    @SerializedName("slip_id")
    @Expose
    private String slipId;

    public String getAdvice() {
        return advice;
    }

    public String getSlipId() {
        return slipId;
    }


}
