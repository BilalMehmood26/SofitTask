package com.example.sofittaskapp.fragment;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.sofittaskapp.Adapter.HorizontalAdapter;
import com.example.sofittaskapp.Adapter.PostRecycler;
import com.example.sofittaskapp.R;
import com.example.sofittaskapp.model.HorizontalList;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private HorizontalAdapter mAdpater;
    private ArrayList<HorizontalList> horizontalLists = new ArrayList<>();
    private RecyclerView recyclerView;
    private ImageView mImgOne,mImgTwo,mImgThree,mImgFour;
    private CardView linearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        hooks(view);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();
                Fragment fragment = new ServicesFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        setImageFromGlide();
        initRecycler();
        setHorizontalData();
        return view;
    }

    private void setImageFromGlide() {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);

        Glide.with(getActivity())
                .setDefaultRequestOptions(requestOptions)
                .load(R.drawable.ic_baseline_room_service_24)
                .into(mImgOne);

        Glide.with(getActivity())
                .setDefaultRequestOptions(requestOptions)
                .load(R.drawable.ic_baseline_medical_services_24)
                .into(mImgTwo);

        Glide.with(getActivity())
                .setDefaultRequestOptions(requestOptions)
                .load(R.drawable.ic_baseline_home_repair_service_24)
                .into(mImgThree);

        Glide.with(getActivity())
                .setDefaultRequestOptions(requestOptions)
                .load(R.drawable.ic_baseline_home_repair_service_24)
                .into(mImgFour);
    }

    private void hooks(View view) {
        recyclerView = view.findViewById(R.id.horizontal_RV);
        mImgOne  = view.findViewById(R.id.img_one);
        mImgTwo  = view.findViewById(R.id.img_two);
        mImgThree  = view.findViewById(R.id.img_three);
        mImgFour  = view.findViewById(R.id.img_four);
        linearLayout = view.findViewById(R.id.onClick);

    }

    private void setHorizontalData() {

        horizontalLists.add(new HorizontalList("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has",
                "https://i.imgur.com/gTr1xWR.jpeg"));
        horizontalLists.add(new HorizontalList("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has",
                "https://i.imgur.com/f89NH3o.jpeg"));
        horizontalLists.add(new HorizontalList("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has",
                "https://i.imgur.com/MCy4JSr.jpeg"));
        horizontalLists.add(new HorizontalList("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has",
                "https://i.imgur.com/3hulfkT.jpeg"));
        horizontalLists.add(new HorizontalList("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has",
                "https://i.imgur.com/fsyrScY.jpeg"));
        mAdpater.notifyDataSetChanged();
    }

    public void initRecycler() {

        mAdpater = new HorizontalAdapter(horizontalLists, getActivity());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdpater);
    }

    void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
        fragmentTransaction.commit();

    }
}