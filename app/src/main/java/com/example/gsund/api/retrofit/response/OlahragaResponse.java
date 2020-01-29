package com.example.gsund.api.retrofit.response;

import com.example.gsund.api.retrofit.model.OlahragaAPI;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OlahragaResponse {
    @SerializedName("status_code")
    private int status_code;
    @SerializedName("values")
    @Expose
    ArrayList<OlahragaAPI> values;

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public ArrayList<OlahragaAPI> getValues() {
        return values;
    }

    public void setValues(ArrayList<OlahragaAPI> values) {
        this.values = values;
    }
}
