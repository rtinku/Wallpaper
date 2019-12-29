package com.rushil.wallpaperapp.ui.home;

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
import androidx.recyclerview.widget.RecyclerView;

import com.rushil.wallpaperapp.R;
import com.rushil.wallpaperapp.misc.Constants;
import com.rushil.wallpaperapp.ui.home.adapters.CollectionsAdapter;
import com.rushil.wallpaperapp.ui.home.pojos.CollectionsResponse;

import java.util.List;

public class HomeFragment extends Fragment implements Observer<List<CollectionsResponse>> {

    private HomeViewModel homeViewModel;
    private RecyclerView rvPhotoCollections;
    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        setListeners();
        getCollection();
    }

    private void initViews(View view) {
        rvPhotoCollections = view.findViewById(R.id.rvPhotoCollections);
    }

    private void setListeners() {
        homeViewModel.getText().observeForever(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, Constants.SPAN_COUNT);
        rvPhotoCollections.setLayoutManager(gridLayoutManager);
    }

    private void getCollection() {
        homeViewModel.getImageCollections();
    }

    @Override
    public void onChanged(List<CollectionsResponse> collectionsResponses) {
        CollectionsAdapter collectionsAdapter = new CollectionsAdapter(context, collectionsResponses);
        rvPhotoCollections.setAdapter(collectionsAdapter);
    }
}