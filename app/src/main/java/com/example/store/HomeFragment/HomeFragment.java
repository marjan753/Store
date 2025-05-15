package com.example.store.HomeFragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.store.MainActivity;
import com.example.store.R;
import com.example.store.Viewmodels.AppviewModels;
import com.example.store.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {
FragmentHomeBinding fragmentHomeBinding;
MainActivity mainActivity;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity= (MainActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentHomeBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);


        AppviewModels viewModel = new ViewModelProvider(requireParentFragment()).get(AppviewModels.class);

        SliderAdapter adapter = new SliderAdapter();
        fragmentHomeBinding.viewpager.setAdapter(adapter);

        viewModel.getBannerList().observe(getViewLifecycleOwner(), sliderList -> {
            adapter.setSliderList(sliderList);
        });


        return fragmentHomeBinding.getRoot();



    }
}