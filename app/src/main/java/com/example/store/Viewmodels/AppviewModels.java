package com.example.store.Viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.store.HomeFragment.slidertopModel;
import com.example.store.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AppviewModels extends ViewModel {


    private MutableLiveData<List<slidertopModel>> mutableLiveData = new MutableLiveData<>();


    public LiveData<List<slidertopModel>> getBannerList() {
        loadBanners();
        return mutableLiveData;
    }


    private void loadBanners() {
        List<slidertopModel> pics = new ArrayList<>();
        pics.add(new slidertopModel(R.drawable.viewpager1));
        pics.add(new slidertopModel(R.drawable.viewpager2));
        pics.add(new slidertopModel(R.drawable.viewpager3));
        pics.add(new slidertopModel(R.drawable.viewpager4));

        mutableLiveData.setValue(pics); // داده‌ها رو به LiveData می‌دیم
    }
}

