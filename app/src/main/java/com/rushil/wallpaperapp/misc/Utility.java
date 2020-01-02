package com.rushil.wallpaperapp.misc;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

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
}
