package com.example.sofittaskapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sofittaskapp.Adapter.PostRecycler;
import com.example.sofittaskapp.R;
import com.example.sofittaskapp.model.Post;
import com.example.sofittaskapp.retrofit.Api;
import com.example.sofittaskapp.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Post> postArrayList = new ArrayList<>();
    private PostRecycler mAdpater;
    Api apiService;
    private ProgressBar progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_posts, container, false);
        recyclerView = view.findViewById(R.id.post_recycle);
        progressBar  = view.findViewById(R.id.progressBar);
        showProgressBar();
        initRecycler();
        apiService = RetrofitClient.getInstance().create(Api.class);

        apiService.getPost().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getActivity(), "" + response.code(), Toast.LENGTH_SHORT).show();
                    hideProgressBar();
                    return;
                }
                List<Post> postList = response.body();
                for(Post post : postList){
                    postArrayList.add(post);
                }
                mAdpater.notifyDataSetChanged();
                hideProgressBar();
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                hideProgressBar();
            }
        });
        return view;
    }

    public void initRecycler() {

        mAdpater = new PostRecycler(postArrayList, getActivity());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdpater);
    }

    public void showProgressBar(){
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar(){
        progressBar.setVisibility(View.GONE);
    }
}