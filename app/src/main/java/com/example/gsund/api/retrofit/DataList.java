package com.example.gsund.api.retrofit;

import com.example.gsund.api.retrofit.model.DietAPI;
import com.example.gsund.api.retrofit.model.MakananAPI;
import com.example.gsund.api.retrofit.model.OlahragaAPI;
import com.example.gsund.api.retrofit.model.PenyakitAPI;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataList {
    @SerializedName("listMakanan")
    private ArrayList<MakananAPI> listMakanan;
    @SerializedName("listOlahraga")
    private ArrayList<OlahragaAPI> listOlahraga;
    @SerializedName("listDiet")
    private ArrayList<DietAPI> listDiet;
    @SerializedName("listPenyakit")
    private ArrayList<PenyakitAPI> listPenyakit;

    public ArrayList<MakananAPI> getListMakanan() {
        return listMakanan;
    }

    public void setListMakanan(ArrayList<MakananAPI> listMakanan) {
        this.listMakanan = listMakanan;
    }

    public ArrayList<OlahragaAPI> getListOlahraga() {
        return listOlahraga;
    }

    public void setListOlahraga(ArrayList<OlahragaAPI> listOlahraga) {
        this.listOlahraga = listOlahraga;
    }

    public ArrayList<DietAPI> getListDiet() {
        return listDiet;
    }

    public void setListDiet(ArrayList<DietAPI> listDiet) {
        this.listDiet = listDiet;
    }

    public ArrayList<PenyakitAPI> getListPenyakit() {
        return listPenyakit;
    }

    public void setListPenyakit(ArrayList<PenyakitAPI> listPenyakit) {
        this.listPenyakit = listPenyakit;
    }
}
