package com.example.quienvaapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.quienvaapp.R;
import com.example.quienvaapp.databinding.FragmentHomeBinding;
import com.example.quienvaapp.ui.Adapter.ListaMandaditosAdapter;
import com.example.quienvaapp.ui.Adapter.ViewPagerAdapter;
import com.example.quienvaapp.ui.Dto.ListaMandaditosDTO;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    private static final int[] tabIcons = {
            R.drawable.ic_menu_send,
            R.drawable.ic_menu_camera,
            R.drawable.ic_launcher_foreground
    };
    private static final String[] tabTitles = {"Mandaditos", "Servicios", "Perfil"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        viewPager = root.findViewById(R.id.viewPager);
        tabLayout = root.findViewById(R.id.tabLayout);

        viewPager.setAdapter(new ViewPagerAdapter(getActivity()));

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            tab.setIcon(tabIcons[position]);
            tab.setText(tabTitles[position]);
        }).attach();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}