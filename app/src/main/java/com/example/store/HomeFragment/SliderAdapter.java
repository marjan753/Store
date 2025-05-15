package com.example.store.HomeFragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.store.databinding.ItemSliderBinding;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> {

    private List<slidertopModel> sliderList = new ArrayList<>();

    public void setSliderList(List<slidertopModel> list) {
        this.sliderList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemSliderBinding binding = ItemSliderBinding.inflate(inflater, parent, false); // مطمئن شو اسمش درسته
        return new SliderViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.bind(sliderList.get(position));
    }

    @Override
    public int getItemCount() {
        return sliderList.size();
    }

    public static class SliderViewHolder extends RecyclerView.ViewHolder {
        private final ItemSliderBinding binding;

        public SliderViewHolder(ItemSliderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(slidertopModel model) {
            binding.imageslide.setImageResource(model.getImageResId());
        }
    }
}

