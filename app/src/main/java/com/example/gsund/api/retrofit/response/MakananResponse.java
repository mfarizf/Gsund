package com.example.gsund.api.retrofit.response;

import com.example.gsund.api.retrofit.model.MakananAPI;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MakananResponse {
    @SerializedName("status_code")
    private int status_code;
    @SerializedName("values")
    @Expose
    ArrayList<MakananAPI> values;

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public ArrayList<MakananAPI> getValues() {
        return values;
    }

    public void setValues(ArrayList<MakananAPI> values) {
        this.values = values;
    }
}
