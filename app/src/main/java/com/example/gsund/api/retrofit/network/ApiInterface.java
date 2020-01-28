package com.example.gsund.api.retrofit.network;

import com.example.gsund.api.retrofit.response.DietResponse;
import com.example.gsund.api.retrofit.response.MakananResponse;
import com.example.gsund.api.retrofit.response.OlahragaResponse;
import com.example.gsund.api.retrofit.response.PenyakitResponse;
import com.example.gsund.api.retrofit.response.TipsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
        // Dapatkan Makanan
        @GET("foods")
        Call<MakananResponse> getListMakanan();

        //Dapatkan Olaharaga
        @GET("sports")
        Call<OlahragaResponse> getListOlahraga();

        //Dapatkan Diet
        @GET("diets")
        Call<DietResponse> getListDiet();

        //Dapatkan Penyakit
        @GET("diseases")
        Call<PenyakitResponse> getListPenyakit();

        //Dapatkan Tips
        @GET("tips")
        Call<TipsResponse> getListTips();
}
