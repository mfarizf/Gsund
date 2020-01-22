package com.example.gsund.api.retrofit.network;

import com.example.gsund.api.retrofit.APIListData;

import retrofit2.Call;
import retrofit2.http.GET;

public class DataService {
    public interface getListFoods {
        // Dapatkan Makanan
        @GET("foods")
        Call<APIListData> getListMakanan();

        //Dapatkan Olaharaga
        @GET("sports")
        Call<APIListData> getListOlahraga();

        //Dapatkan Diet
        @GET("diets")
        Call<APIListData> getListDiet();

        //Dapatkan Penyakit
        @GET("diseases")
        Call<APIListData> getListPenyakit();
    }
}
