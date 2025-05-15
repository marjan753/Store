package com.example.store.Orders;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.store.R;
import com.example.store.databinding.FragmentOrdersBinding;


public class OrdersFragment extends Fragment {
FragmentOrdersBinding fragmentOrdersBinding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentOrdersBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_orders,container,false);
        return fragmentOrdersBinding.getRoot();
    }
}