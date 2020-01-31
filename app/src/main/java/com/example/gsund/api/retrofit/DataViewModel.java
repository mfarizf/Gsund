package com.example.gsund.api.retrofit;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gsund.api.retrofit.model.DietAPI;
import com.example.gsund.api.retrofit.model.MakananAPI;
import com.example.gsund.api.retrofit.model.OlahragaAPI;
import com.example.gsund.api.retrofit.model.PenyakitAPI;
import com.example.gsund.api.retrofit.model.TipsAPI;
import com.example.gsund.api.retrofit.network.ApiInterface;
import com.example.gsund.api.retrofit.network.RetrofitInstance;
import com.example.gsund.api.retrofit.response.DietResponse;
import com.example.gsund.api.retrofit.response.MakananResponse;
import com.example.gsund.api.retrofit.response.OlahragaResponse;
import com.example.gsund.api.retrofit.response.PenyakitResponse;
import com.example.gsund.api.retrofit.response.TipsResponse;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataViewModel extends ViewModel {

    // Kumpulan Response
    private MakananResponse makananResponse;
    private OlahragaResponse olahragaResponse;
    private PenyakitResponse penyakitResponse;
    private DietResponse dietResponse;
    private TipsResponse tipsResponse;

    // Kumpulan Live Data
    private MutableLiveData<ArrayList<MakananAPI>> listDataMakanan = new MutableLiveData<>();
    private MutableLiveData<ArrayList<OlahragaAPI>> listDataOlahraga = new MutableLiveData<>();
    private MutableLiveData<ArrayList<PenyakitAPI>> listDataPenyakit = new MutableLiveData<>();
    private MutableLiveData<ArrayList<DietAPI>> listDataDiet = new MutableLiveData<>();
    private MutableLiveData<ArrayList<TipsAPI>> listDatatips = new MutableLiveData<>();

    // Makanan
    public void setDataMakanan() {
        ApiInterface service = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);

        Call<MakananResponse> call = service.getListMakanan();

        call.enqueue(new Callback<MakananResponse>() {
            @Override
            public void onResponse(@NotNull Call<MakananResponse> call, @NotNull Response<MakananResponse> response) {
                if (response.isSuccessful()) {
                    makananResponse = response.body();
                    if (makananResponse != null) {
                        listDataMakanan.postValue(makananResponse.getValues());
                    } else {
                        Log.d("CheckDataFromAPI", "Data Kosong!");
                    }
                } else {
                    Log.d("CheckDataFromAPI", "Response Gagal diterima!");
                }
            }

            @Override
            public void onFailure(@NotNull Call<MakananResponse> call, @NotNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public LiveData<ArrayList<MakananAPI>> getDataMakanan() {
        return listDataMakanan;
    }

    // Olahraga
    public void setDataOlahraga() {
        ApiInterface service = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);

        Call<OlahragaResponse> call = service.getListOlahraga();

        call.enqueue(new Callback<OlahragaResponse>() {
            @Override
            public void onResponse(@NotNull Call<OlahragaResponse> call, @NotNull Response<OlahragaResponse> response) {
                if (response.isSuccessful()) {
                    olahragaResponse = response.body();
                    if (olahragaResponse != null) {
                        listDataOlahraga.postValue(olahragaResponse.getValues());
                    } else {
                        Log.d("CheckDataFromAPI", "Data Kosong!");
                    }
                } else {
                    Log.d("CheckDataFromAPI", "Response Gagal diterima!");
                }
            }

            @Override
            public void onFailure(@NotNull Call<OlahragaResponse> call, @NotNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public LiveData<ArrayList<OlahragaAPI>> getDataOlahraga() {
        return listDataOlahraga;
    }

    // Penyakit
    public void setDataPenyakit() {
        ApiInterface service = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);

        Call<PenyakitResponse> call = service.getListPenyakit();

        call.enqueue(new Callback<PenyakitResponse>() {
            @Override
            public void onResponse(@NotNull Call<PenyakitResponse> call, @NotNull Response<PenyakitResponse> response) {
                if (response.isSuccessful()) {
                    penyakitResponse = response.body();
                    if (penyakitResponse != null) {
                        listDataPenyakit.postValue(penyakitResponse.getValues());
                    } else {
                        Log.d("CheckDataFromAPI", "Data Kosong!");
                    }
                } else {
                    Log.d("CheckDataFromAPI", "Response Gagal diterima!");
                }
            }

            @Override
            public void onFailure(@NotNull Call<PenyakitResponse> call, @NotNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public LiveData<ArrayList<PenyakitAPI>> getDataPenyakit() {
        return listDataPenyakit;
    }

    // Diet
    public void setDataDiet() {
        ApiInterface service = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);

        Call<DietResponse> call = service.getListDiet();

        call.enqueue(new Callback<DietResponse>() {
            @Override
            public void onResponse(@NotNull Call<DietResponse> call, @NotNull Response<DietResponse> response) {
                if (response.isSuccessful()) {
                    dietResponse = response.body();
                    if (dietResponse != null) {
                        listDataDiet.postValue(dietResponse.getValues());
                    } else {
                        Log.d("CheckDataFromAPI", "Data Kosong!");
                    }
                } else {
                    Log.d("CheckDataFromAPI", "Response Gagal diterima!");
                }
            }

            @Override
            public void onFailure(@NotNull Call<DietResponse> call, @NotNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public LiveData<ArrayList<DietAPI>> getDataDiet() {
        return listDataDiet;
    }

    // Tips
    public void setDataTips() {
        ApiInterface service = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);

        Call<TipsResponse> call = service.getListTips();

        call.enqueue(new Callback<TipsResponse>() {
            @Override
            public void onResponse(@NotNull Call<TipsResponse> call, @NotNull Response<TipsResponse> response) {
                if (response.isSuccessful()) {
                    tipsResponse = response.body();
                    if (tipsResponse != null) {
                        listDatatips.postValue(tipsResponse.getValues());
                    } else {
                        Log.d("CheckDataFromAPI", "Data Kosong!");
                    }
                } else {
                    Log.d("CheckDataFromAPI", "Response Gagal diterima!");
                }
            }

            @Override
            public void onFailure(@NotNull Call<TipsResponse> call, @NotNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public LiveData<ArrayList<TipsAPI>> getDataTips() {
        return listDatatips;
    }

}
