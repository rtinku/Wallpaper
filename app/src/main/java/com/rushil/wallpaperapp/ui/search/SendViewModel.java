package com.rushil.wallpaperapp.ui.search;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rushil.wallpaperapp.misc.Constants;
import com.rushil.wallpaperapp.ui.search.pojo.SearchResponse;
import com.rushil.wallpaperapp.webservices.WallPaperAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SendViewModel extends ViewModel implements Callback<SearchResponse> {

    private static final String TAG = "SendViewModel";
    private MutableLiveData<SearchResponse> listMutableLiveData;

    public SendViewModel() {
        listMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<SearchResponse> getListMutableLiveData() {
        return listMutableLiveData;
    }

    public void setListMutableLiveData(SearchResponse listMutableLiveData) {
        this.listMutableLiveData.setValue(listMutableLiveData);
    }

    public void getSearchImages() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WallPaperAPI wallPaperAPI = retrofit.create(WallPaperAPI.class);
        wallPaperAPI.getSearchPhotos(Constants.CLIENT_ID, Constants.SEARCH_KEYWORD).enqueue(this);

    }

    @Override
    public void onResponse(Call<SearchResponse> call, Response<SearchResponse>response) {
        setListMutableLiveData(response.body());
    }

    @Override
    public void onFailure(Call<SearchResponse> call, Throwable t) {
        Log.e(TAG, "onFailure: " + t.getMessage());
    }
}