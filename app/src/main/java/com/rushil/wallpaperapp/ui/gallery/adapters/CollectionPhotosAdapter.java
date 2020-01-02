package com.rushil.wallpaperapp.ui.gallery.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rushil.wallpaperapp.R;
import com.rushil.wallpaperapp.misc.Utility;
import com.rushil.wallpaperapp.ui.gallery.pojo.CollectionPhotosResponse;

import java.util.List;

public class CollectionPhotosAdapter extends RecyclerView.Adapter<CollectionPhotosAdapter.Holder> {

    private Context context;
    private List<CollectionPhotosResponse> collectionsResponseList;


    public CollectionPhotosAdapter(Context context, List<CollectionPhotosResponse> collectionsResponseList) {
        this.context = context;
        this.collectionsResponseList = collectionsResponseList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new Holder(
                LayoutInflater.from(parent.getContext()).
                        inflate(R.layout.layout_collections_images, parent, false)
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

    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

        private ImageView ivCollectionPics, ivMenu;
        private TextView tvCollectionName;

        Holder(@NonNull View itemView) {
            super(itemView);
            tvCollectionName = itemView.findViewById(R.id.tvCollectionName);
            ivCollectionPics = itemView.findViewById(R.id.ivCollectionPics);
            ivMenu = itemView.findViewById(R.id.ivMenu);
            ivMenu.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            PopupMenu popupMenu = new PopupMenu(context, ivMenu);
            popupMenu.inflate(R.menu.menu);
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.set_wallpaper:
                    Utility.setWallPaper(context, collectionsResponseList.get(getAdapterPosition()).urls.full);
                    break;
            }
            return true;
        }
    }

}
