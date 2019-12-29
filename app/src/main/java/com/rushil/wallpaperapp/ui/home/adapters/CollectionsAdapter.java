package com.rushil.wallpaperapp.ui.home.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rushil.wallpaperapp.R;
import com.rushil.wallpaperapp.ui.home.pojos.CollectionsResponse;

import java.util.List;

public class CollectionsAdapter extends RecyclerView.Adapter<CollectionsAdapter.Holder> {

    private Context context;
    private List<CollectionsResponse> collectionsResponseList;

    public CollectionsAdapter(Context context, List<CollectionsResponse> collectionsResponseList) {
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
        holder.tvCollectionName.setText(collectionsResponseList.get(position).title);
        Glide.with(context).load(collectionsResponseList.get(position).coverPhoto.urls.small)
                .into(holder.ivCollectionPics);
    }

    @Override
    public int getItemCount() {
        return (collectionsResponseList != null) ? collectionsResponseList.size() : 0;
    }

    class Holder extends RecyclerView.ViewHolder {

        private ImageView ivCollectionPics;
        private TextView tvCollectionName;

        Holder(@NonNull View itemView) {
            super(itemView);
            tvCollectionName = itemView.findViewById(R.id.tvCollectionName);
            ivCollectionPics = itemView.findViewById(R.id.ivCollectionPics);
        }
    }
}
