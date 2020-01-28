package com.example.gsund.api.retrofit.response;

import com.example.gsund.api.retrofit.model.DietAPI;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DietResponse {
    @SerializedName("status_code")
    private int status_code;
    @SerializedName("values")
    ArrayList<DietAPI> values;

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public ArrayList<DietAPI> getValues() {
        return values;
    }

    public void setValues(ArrayList<DietAPI> values) {
        this.values = values;
    }
}
