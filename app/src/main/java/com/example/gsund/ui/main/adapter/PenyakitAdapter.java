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
import com.example.gsund.api.retrofit.model.PenyakitAPI;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PenyakitAdapter extends RecyclerView.Adapter<PenyakitAdapter.PenyakitViewHolder> {

    private ArrayList<PenyakitAPI> mData = new ArrayList<PenyakitAPI>();
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public void setData(ArrayList<PenyakitAPI> items) {
        mData.clear();
        mData.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PenyakitAdapter.PenyakitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_penyakit, parent, false);
        return new PenyakitAdapter.PenyakitViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PenyakitViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(mData.get(position).getGambar())
                .into(holder.imgOlahraga);

        holder.tvNama.setText(mData.get(position).getNama());
        holder.tvDeskripsi.setText(mData.get(position).getDeskripsi());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(mData.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class PenyakitViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_penyakit)
        ImageView imgOlahraga;
        @BindView(R.id.tv_nama)
        TextView tvNama;
        @BindView(R.id.tv_deskripsi)
        TextView tvDeskripsi;

        PenyakitViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(PenyakitAPI data);
    }
}
