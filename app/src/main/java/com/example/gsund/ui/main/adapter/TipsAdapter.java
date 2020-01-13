package com.example.gsund.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gsund.R;
import com.example.gsund.ui.main.ItemOption;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TipsAdapter extends RecyclerView.Adapter<TipsAdapter.ViewHolder> {

    private List<ItemOption> item = Arrays.asList(
            new ItemOption(1, "Food", "You're Choose Food", R.drawable.food),
            new ItemOption(2, "Diet", "You're Choose Diet", R.drawable.diet),
            new ItemOption(3, "Sport", "You're Choose Sport", R.drawable.sport));

    @NonNull
    @Override
    public TipsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =  LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_tips,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TipsAdapter.ViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(item.get(position).getImage())
                .into(holder.imgBackground);

        holder.judul.setText(item.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.background)
        ImageView imgBackground;
        @BindView(R.id.judul)
        TextView judul;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
