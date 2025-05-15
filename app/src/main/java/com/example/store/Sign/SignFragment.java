package com.example.store.Sign;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.store.R;
import com.example.store.databinding.FragmentSignBinding;


public class SignFragment extends Fragment {

FragmentSignBinding fragmentSignBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentSignBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_sign,container,false);
        return fragmentSignBinding.getRoot();
    }
}