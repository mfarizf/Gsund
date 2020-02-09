package com.example.gsund.api.retrofit.response;

import com.example.gsund.api.retrofit.model.RekomendasiAPI;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RekomendasiResponse {
    @SerializedName("statusCode")
    private int statusCode;
    @SerializedName("values")
    ArrayList<RekomendasiAPI> values;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public ArrayList<RekomendasiAPI> getValues() {
        return values;
    }

    public void setValues(ArrayList<RekomendasiAPI> values) {
        this.values = values;
    }
}
