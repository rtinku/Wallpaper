package com.rushil.wallpaperapp.ui.gallery;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rushil.wallpaperapp.R;
import com.rushil.wallpaperapp.misc.BundleConstants;
import com.rushil.wallpaperapp.misc.Constants;
import com.rushil.wallpaperapp.ui.gallery.adapters.CollectionPhotosAdapter;
import com.rushil.wallpaperapp.ui.gallery.pojo.CollectionPhotosResponse;

import java.util.List;

public class GalleryFragment extends Fragment implements Observer<List<CollectionPhotosResponse>> {

    private GalleryViewModel galleryViewModel;
    private Context context;
    private RecyclerView rvCollectionPhotos;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            Constants.COLLECTION_ID = bundle.getInt(BundleConstants.COLLECTION_ID);
        }
        galleryViewModel.getCollectionPhotosResponseMutableLiveData().observeForever(this);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        setListeners();
        galleryViewModel.getCollectionPhotos();
    }

    private void initViews(View view) {
        rvCollectionPhotos = view.findViewById(R.id.rvCollectionPhotos);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rvCollectionPhotos.setLayoutManager(linearLayoutManager);
    }

    private void setListeners() {

    }


    @Override
    public void onChanged(List<CollectionPhotosResponse> collectionPhotosResponses) {
        CollectionPhotosAdapter collectionPhotosAdapter = new CollectionPhotosAdapter(context, collectionPhotosResponses);
        rvCollectionPhotos.setAdapter(collectionPhotosAdapter);
    }
}