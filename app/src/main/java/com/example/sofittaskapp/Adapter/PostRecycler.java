package com.example.sofittaskapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sofittaskapp.R;
import com.example.sofittaskapp.model.Post;

import java.util.ArrayList;

public class PostRecycler extends RecyclerView.Adapter<PostRecycler.ViewHolder> {

    ArrayList<Post> postsArrayList = new ArrayList<>();
    Context context;

    public PostRecycler(ArrayList<Post> postsArrayList, Context context) {
        this.postsArrayList = postsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.userId.setText(postsArrayList.get(position).getmUserId());
        holder.id.setText(postsArrayList.get(position).getmId());
        holder.title.setText(postsArrayList.get(position).getmTitle());
        holder.body.setText(postsArrayList.get(position).getmBody());

    }

    @Override
    public int getItemCount() {
        return postsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, userId, title, body;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            userId = itemView.findViewById(R.id.user_id);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
        }
    }
}
