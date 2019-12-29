package com.rushil.wallpaperapp.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rushil.wallpaperapp.misc.Constants;
import com.rushil.wallpaperapp.ui.home.pojos.CollectionsResponse;
import com.rushil.wallpaperapp.webservices.WallPaperAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeViewModel extends ViewModel implements Callback<List<CollectionsResponse>> {
    private static final String TAG = "HomeViewModel";
    private MutableLiveData<List<CollectionsResponse>> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
    }

    private void setmText(List<CollectionsResponse> mText) {
        this.mText.setValue(mText);
    }

    public LiveData<List<CollectionsResponse>> getText() {
        return mText;
    }

    public void getImageCollections() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WallPaperAPI wallPaperAPI = retrofit.create(WallPaperAPI.class);

        wallPaperAPI.getImagesCollection(Constants.CLIENT_ID).enqueue(this);

    }

    @Override
    public void onResponse(Call<List<CollectionsResponse>> call, Response<List<CollectionsResponse>> response) {
        setmText(response.body());
    }

    @Override
    public void onFailure(Call<List<CollectionsResponse>> call, Throwable t) {
        Log.e(TAG, "onFailure: " + t.getMessage());
    }
}