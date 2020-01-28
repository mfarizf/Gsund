package com.example.gsund.api.retrofit.response;

import com.example.gsund.api.retrofit.model.TipsAPI;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TipsResponse {
    @SerializedName("status_code")
    private int status_code;
    @SerializedName("values")
    ArrayList<TipsAPI> values;

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public ArrayList<TipsAPI> getValues() {
        return values;
    }

    public void setValues(ArrayList<TipsAPI> values) {
        this.values = values;
    }
}
