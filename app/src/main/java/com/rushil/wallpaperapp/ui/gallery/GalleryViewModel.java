package com.rushil.wallpaperapp.ui.gallery;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rushil.wallpaperapp.misc.Constants;
import com.rushil.wallpaperapp.ui.gallery.pojo.CollectionPhotosResponse;
import com.rushil.wallpaperapp.webservices.WallPaperAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GalleryViewModel extends ViewModel implements Callback<List<CollectionPhotosResponse>> {

    private MutableLiveData<List<CollectionPhotosResponse>> collectionPhotosResponseMutableLiveData;

    public GalleryViewModel() {
        collectionPhotosResponseMutableLiveData = new MutableLiveData<>();
    }


    public MutableLiveData<List<CollectionPhotosResponse>> getCollectionPhotosResponseMutableLiveData() {
        return collectionPhotosResponseMutableLiveData;
    }

    public void setCollectionPhotosResponseMutableLiveData(List<CollectionPhotosResponse> collectionPhotosResponseMutableLiveData) {
        this.collectionPhotosResponseMutableLiveData.setValue(collectionPhotosResponseMutableLiveData);
    }

    public void getCollectionPhotos() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WallPaperAPI wallPaperAPI = retrofit.create(WallPaperAPI.class);
        wallPaperAPI.getCollectionPhotos(Constants.COLLECTION_ID, Constants.CLIENT_ID).enqueue(this);
    }

    @Override
    public void onResponse(Call<List<CollectionPhotosResponse>> call, Response<List<CollectionPhotosResponse>> response) {
        setCollectionPhotosResponseMutableLiveData(response.body());
    }

    @Override
    public void onFailure(Call<List<CollectionPhotosResponse>> call, Throwable t) {

    }
}