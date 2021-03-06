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
import com.example.gsund.api.retrofit.model.RekomendasiAPI;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RekomendasiAdapter extends RecyclerView.Adapter<RekomendasiAdapter.ViewHolder> {

    private ArrayList<RekomendasiAPI> mData = new ArrayList<RekomendasiAPI>();
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public void setData(ArrayList<RekomendasiAPI> itemsMakanan, ArrayList<RekomendasiAPI> itemsOlahraga, ArrayList<RekomendasiAPI> itemsDiet) {
        mData.clear();
        mData.addAll(itemsMakanan);
        mData.addAll(itemsDiet);
        mData.addAll(itemsOlahraga);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RekomendasiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_option_home, parent, false);
        return new RekomendasiAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(mData.get(position).getGambar())
                .into(holder.imgGambar);

        holder.tvNama.setText(mData.get(position).getNama());
        holder.tvDeskripsi.setText(mData.get(position).getDeskripsi());

        holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(mData.get(holder.getAdapterPosition())));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_gambar)
        ImageView imgGambar;
        @BindView(R.id.tv_nama)
        TextView tvNama;
        @BindView(R.id.tv_deskripsi)
        TextView tvDeskripsi;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(RekomendasiAPI data);
    }
}
