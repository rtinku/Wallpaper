package com.rushil.wallpaperapp.ui.search;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rushil.wallpaperapp.R;
import com.rushil.wallpaperapp.misc.Constants;
import com.rushil.wallpaperapp.ui.search.adapters.SearchPhotoAdapter;
import com.rushil.wallpaperapp.ui.search.pojo.SearchResponse;

public class SearchFragment extends Fragment implements Observer<SearchResponse>, View.OnClickListener {

    private SendViewModel sendViewModel;
    private Context context;
    private AppCompatEditText etQuery;
    private RecyclerView rvSearchResult;
    private ProgressBar progressBar;
    private ImageView ivFind;
    private boolean isFind;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        sendViewModel = ViewModelProviders.of(this).get(SendViewModel.class);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_send, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        setListeners();
    }

    private void initViews(View view) {
        rvSearchResult = view.findViewById(R.id.rvSearchResult);
        etQuery = view.findViewById(R.id.etQuery);
        ivFind = view.findViewById(R.id.ivFind);
        progressBar = view.findViewById(R.id.progressBar);

    }

    private void setListeners() {
        ivFind.setOnClickListener(this);
        sendViewModel.getListMutableLiveData().observeForever(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rvSearchResult.setLayoutManager(linearLayoutManager);
    }

    private void getSearchPhotos() {
        progressBar.setVisibility(View.VISIBLE);
        Constants.SEARCH_KEYWORD = etQuery.getText().toString();
        sendViewModel.getSearchImages();
    }

    @Override
    public void onChanged(SearchResponse searchResponses) {
        progressBar.setVisibility(View.GONE);

        SearchPhotoAdapter collectionsAdapter = new SearchPhotoAdapter(context, searchResponses.results);
        rvSearchResult.setAdapter(collectionsAdapter);

    }

    @Override
    public void onClick(View v) {
        if (isFind && etQuery.length() > 0) {
            ivFind.setImageResource(R.drawable.outline_search_black_24);
            etQuery.setText("");
            isFind=false;
        } else if (etQuery.length() > 0) {
            ivFind.setImageResource(R.drawable.outline_cancel_black_24);
            isFind = true;
            getSearchPhotos();
        } else {
            Toast.makeText(context, "Please Enter Valid Keyword.", Toast.LENGTH_SHORT).show();
        }
    }
}