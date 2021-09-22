package com.example.sofittaskapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sofittaskapp.R;
import com.example.sofittaskapp.model.HorizontalList;

import java.util.ArrayList;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ViewHolder> {

    ArrayList<HorizontalList> horizontalLists = new ArrayList<HorizontalList>();
    Context context;

    public HorizontalAdapter(ArrayList<HorizontalList> horizontalLists, Context context) {
        this.horizontalLists = horizontalLists;
        this.context = context;
    }

    @NonNull
    @Override
    public HorizontalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalAdapter.ViewHolder holder, int position) {

        Glide.with(holder.itemView.getContext())
                .load(horizontalLists.get(position).getImageUrl())
                .centerCrop().into(holder.mImage);
        holder.mTextView.setText(horizontalLists.get(position).getmText());
    }

    @Override
    public int getItemCount() {
        return horizontalLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView mImage;
        TextView mTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.hori_imageView);
            mTextView = itemView.findViewById(R.id.horizontal_TV);
        }
    }
}
