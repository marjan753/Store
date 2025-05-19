package com.example.store.HomeFragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.store.Api.ApiService;
import com.example.store.Api.RetrofitClient;
import com.example.store.MainActivity;
import com.example.store.R;
import com.example.store.Viewmodels.AppviewModels;
import com.example.store.Viewmodels.ProductViewModel;
import com.example.store.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {
FragmentHomeBinding fragmentHomeBinding;
MainActivity mainActivity;
   ProductsAdapter productsAdapter;
    SliderAdapter sliderAdapter;

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

        sliderAdapter = new SliderAdapter();
        fragmentHomeBinding.viewpager.setAdapter(sliderAdapter);

        viewModel.getBannerList().observe(getViewLifecycleOwner(), sliderList -> {
            sliderAdapter.setSliderList(sliderList);
        });



//نمایش لیست محصولات
        ProductViewModel pviewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        productsAdapter = new ProductsAdapter();
        fragmentHomeBinding.recyclerProducts.setLayoutManager(new GridLayoutManager(getContext(), 2)); // 2 آیتم در هر ردیف
        fragmentHomeBinding.recyclerProducts.setAdapter(productsAdapter);

        pviewModel.getProducts().observe(getViewLifecycleOwner(), productList -> {
            if (productList != null) {
                productsAdapter.setProductList(productList);
            }
        });





        return fragmentHomeBinding.getRoot();



    }


}