package com.rushil.wallpaperapp.webservices;

import com.rushil.wallpaperapp.misc.Constants;
import com.rushil.wallpaperapp.ui.home.pojos.CollectionsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WallPaperAPI {
    @GET(Constants.IMAGE_COLLECTIONS)
    Call<List<CollectionsResponse>> getImagesCollection(@Query("client_id") String client_id);
}
