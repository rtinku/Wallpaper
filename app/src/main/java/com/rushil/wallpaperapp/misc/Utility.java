package com.rushil.wallpaperapp.misc;

import android.app.ProgressDialog;
import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.DisplayMetrics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import java.io.IOException;

public class Utility {
    public static void replaceFragment(FragmentManager fragmentManager, Fragment fragment, int containerId, String tag) {

        Fragment currentFragment = fragmentManager.findFragmentByTag(tag);
        if (currentFragment == null) {
            fragmentManager.beginTransaction()
                    .replace(containerId, fragment, tag)
                    .addToBackStack("")
                    .commit();
        } else {
            fragmentManager.beginTransaction()
                    .replace(containerId, currentFragment, tag)
                    .addToBackStack("")
                    .commit();
        }

    }

    public static void setWallPaper(final Context context, final String url) {
        final WallpaperManager wallpaperManager = (WallpaperManager) context.getSystemService(Context.WALLPAPER_SERVICE);
        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Set Wallpaper....");
        progressDialog.setCancelable(false);
        if (wallpaperManager != null) {
            Handler thread = new Handler();
            thread.post(new Runnable() {
                @Override
                public void run() {
                    progressDialog.show();
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    Glide.with(context).asBitmap().load(url)
                            .override(displayMetrics.widthPixels, displayMetrics.heightPixels)
                            .into(new CustomTarget<Bitmap>() {
                                @Override
                                public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                                    try {
                                        wallpaperManager.setBitmap(resource);
                                        progressDialog.dismiss();
                                        ((AppCompatActivity) context).finish();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void onLoadCleared(@Nullable Drawable placeholder) {

                                }
                            });
                }
            });

        }
    }
}
