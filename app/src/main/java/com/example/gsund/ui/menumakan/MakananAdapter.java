package com.example.gsund.ui.menumakan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gsund.R;
import com.example.gsund.api.retrofit.model.MakananAPI;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.MakananViewHolder> {

    private ArrayList<MakananAPI> mData = new ArrayList<MakananAPI>();
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public void setData(ArrayList<MakananAPI> items) {
        mData.clear();
        mData.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MakananAdapter.MakananViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =  LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_makanan,parent,false);
        return new MakananAdapter.MakananViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MakananAdapter.MakananViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(mData.get(position).getGambar())
                .into(holder.imgMakanan);

        holder.tvNama.setText(mData.get(position).getNama());
        holder.tvJenis.setText(mData.get(position).getJenis());

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

    class MakananViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.img_makanan)
        ImageView imgMakanan;
        @BindView(R.id.tv_nama)
        TextView tvNama;
        @BindView(R.id.tv_jenis)
        TextView tvJenis;
        MakananViewHolder(@NonNull View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(MakananAPI data);
    }
}
