package com.example.gsund.api.retrofit.network;

import com.example.gsund.api.retrofit.DataList;
import com.example.gsund.api.retrofit.response.MakananResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
        // Dapatkan Makanan
        @GET("foods")
        Call<MakananResponse> getListMakanan();

        //Dapatkan Olaharaga
        @GET("sports")
        Call<DataList> getListOlahraga();

        //Dapatkan Diet
        @GET("diets")
        Call<DataList> getListDiet();

        //Dapatkan Penyakit
        @GET("diseases")
        Call<DataList> getListPenyakit();
}
