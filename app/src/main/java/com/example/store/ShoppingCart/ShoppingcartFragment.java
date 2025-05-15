package com.example.store.ShoppingCart;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.store.R;
import com.example.store.databinding.FragmentShoppingcartBinding;


public class ShoppingcartFragment extends Fragment {

FragmentShoppingcartBinding fragmentShoppingcartBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentShoppingcartBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_shoppingcart,container,false);
        return fragmentShoppingcartBinding.getRoot();
    }
}