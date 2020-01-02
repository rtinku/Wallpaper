package com.rushil.wallpaperapp.ui.search.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rushil.wallpaperapp.R;
import com.rushil.wallpaperapp.misc.BundleConstants;
import com.rushil.wallpaperapp.ui.gallery.GalleryFragment;
import com.rushil.wallpaperapp.ui.search.pojo.SearchResponse;

import java.util.List;

public class SearchPhotoAdapter extends RecyclerView.Adapter<SearchPhotoAdapter.Holder> {

    private Context context;
    private List<SearchResponse.Result> collectionsResponseList;

    public SearchPhotoAdapter(Context context, List<SearchResponse.Result> collectionsResponseList) {
        this.context = context;
        this.collectionsResponseList = collectionsResponseList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new Holder(
                LayoutInflater.from(parent.getContext()).
                        inflate(R.layout.layout_collections_view, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.tvCollectionName.setText(collectionsResponseList.get(position).altDescription);
        Glide.with(context).load(collectionsResponseList.get(position).urls.small)
                .into(holder.ivCollectionPics);
    }

    @Override
    public int getItemCount() {
        return (collectionsResponseList != null) ? collectionsResponseList.size() : 0;
    }

    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView ivCollectionPics;
        private TextView tvCollectionName;

        Holder(@NonNull View itemView) {
            super(itemView);
            tvCollectionName = itemView.findViewById(R.id.tvCollectionName);
            ivCollectionPics = itemView.findViewById(R.id.ivCollectionPics);

           // itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            Bundle bundle = new Bundle();
//            bundle.putInt(BundleConstants.COLLECTION_ID, collectionsResponseList.get(getAdapterPosition()).id);
//            GalleryFragment galleryFragment = new GalleryFragment();
//            galleryFragment.setArguments(bundle);
//            FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
//            fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, galleryFragment).commit();
        }
    }

}
