package com.example.gsund.api.retrofit;

import com.example.gsund.api.retrofit.model.APIDietModel;
import com.example.gsund.api.retrofit.model.APIMakananModel;
import com.example.gsund.api.retrofit.model.APIOlahragaModel;
import com.example.gsund.api.retrofit.model.APIPenyakitModel;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class APIListData {
    @SerializedName("listMakanan")
    private ArrayList<APIMakananModel> listMakanan;
    @SerializedName("listOlahraga")
    private ArrayList<APIOlahragaModel> listOlahraga;
    @SerializedName("listDiet")
    private ArrayList<APIDietModel> listDiet;
    @SerializedName("listPenyakit")
    private ArrayList<APIPenyakitModel> listPenyakit;

    public ArrayList<APIMakananModel> getListMakanan() {
        return listMakanan;
    }

    public void setListMakanan(ArrayList<APIMakananModel> listMakanan) {
        this.listMakanan = listMakanan;
    }

    public ArrayList<APIOlahragaModel> getListOlahraga() {
        return listOlahraga;
    }

    public void setListOlahraga(ArrayList<APIOlahragaModel> listOlahraga) {
        this.listOlahraga = listOlahraga;
    }

    public ArrayList<APIDietModel> getListDiet() {
        return listDiet;
    }

    public void setListDiet(ArrayList<APIDietModel> listDiet) {
        this.listDiet = listDiet;
    }

    public ArrayList<APIPenyakitModel> getListPenyakit() {
        return listPenyakit;
    }

    public void setListPenyakit(ArrayList<APIPenyakitModel> listPenyakit) {
        this.listPenyakit = listPenyakit;
    }
}
