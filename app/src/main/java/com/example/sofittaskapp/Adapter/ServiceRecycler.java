package com.example.sofittaskapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sofittaskapp.R;
import com.example.sofittaskapp.model.Service;

import java.net.ContentHandler;
import java.util.ArrayList;

public class ServiceRecycler extends RecyclerView.Adapter<ServiceRecycler.ViewHolder> {

    ArrayList<Service> serviceArrayList = new ArrayList<>();
    Context context;

    public ServiceRecycler(ArrayList<Service> serviceArrayList, Context context) {
        this.serviceArrayList = serviceArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.service, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgOne.setImageResource(serviceArrayList.get(position).getImageUrl());
        holder.imgTwo.setImageResource(serviceArrayList.get(position).getSecondImage());
        holder.imgThree.setImageResource(serviceArrayList.get(position).getThirdImage());
        holder.imgFour.setImageResource(serviceArrayList.get(position).getFourthImage());
        holder.textOne.setText(serviceArrayList.get(position).getmText());
        holder.textTwo.setText(serviceArrayList.get(position).getmTextTwo());
        holder.textThree.setText(serviceArrayList.get(position).getmTextThree());
        holder.textFour.setText(serviceArrayList.get(position).getmTextFour());


    }

    @Override
    public int getItemCount() {
        return serviceArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgOne, imgTwo, imgThree, imgFour;
        TextView textOne, textTwo, textThree, textFour;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgOne = itemView.findViewById(R.id.imgOne);
            imgTwo = itemView.findViewById(R.id.imgTwo);
            imgThree = itemView.findViewById(R.id.imgThree);
            imgFour = itemView.findViewById(R.id.imgFour);

            textOne = itemView.findViewById(R.id.textOne);
            textTwo = itemView.findViewById(R.id.textTwo);
            textThree = itemView.findViewById(R.id.textThree);
            textFour = itemView.findViewById(R.id.textFour);
        }
    }
}
