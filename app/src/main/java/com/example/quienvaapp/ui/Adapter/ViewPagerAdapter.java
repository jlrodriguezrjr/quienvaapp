package com.example.quienvaapp.ui.Adapter;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.quienvaapp.MenuPrincipalFragment;
import com.example.quienvaapp.PerfilFragment;
import com.example.quienvaapp.ServiciosFragment;
import com.example.quienvaapp.ui.gallery.GalleryFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(FragmentActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new MenuPrincipalFragment();
            case 1:
                return new ServiciosFragment();
            case 2:
                return new PerfilFragment();
            default:
                throw new IllegalStateException("Unexpected position " + position);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}