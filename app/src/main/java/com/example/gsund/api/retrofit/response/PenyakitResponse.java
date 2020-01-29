package com.example.gsund.api.retrofit.response;

import com.example.gsund.api.retrofit.model.PenyakitAPI;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PenyakitResponse {
    @SerializedName("status_code")
    private int status_code;
    @SerializedName("values")
    ArrayList<PenyakitAPI> values;

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public ArrayList<PenyakitAPI> getValues() {
        return values;
    }

    public void setValues(ArrayList<PenyakitAPI> values) {
        this.values = values;
    }
}
