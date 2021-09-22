package com.example.sofittaskapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sofittaskapp.Adapter.HorizontalAdapter;
import com.example.sofittaskapp.Adapter.ServiceRecycler;
import com.example.sofittaskapp.R;
import com.example.sofittaskapp.model.HorizontalList;
import com.example.sofittaskapp.model.Service;

import java.util.ArrayList;

public class ServicesFragment extends Fragment {


    ServiceRecycler mAdpater;
    ArrayList<Service> serviceArrayList = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_services, container, false);
        recyclerView = view.findViewById(R.id.service_rc);
        initRecycler();
        setHorizontalData();

        return view;
    }
    private void setHorizontalData() {


        serviceArrayList.add(new Service("Government","Hello","Lorum","Ipsum",R.drawable.img_three,
                R.drawable.img_four,
                R.drawable.ic_baseline_medical_services_24,
                R.drawable.ic_baseline_home_repair_service_24));
        serviceArrayList.add(new Service("Service","Hello","Lorum","Ipsum",R.drawable.img_three,
                R.drawable.img_four,
                R.drawable.ic_baseline_medical_services_24,
                R.drawable.ic_baseline_home_repair_service_24));
        serviceArrayList.add(new Service("Service","Hello","Lorum","Ipsum",R.drawable.img_three,
                R.drawable.img_four,
                R.drawable.ic_baseline_medical_services_24,
                R.drawable.ic_baseline_home_repair_service_24));
        serviceArrayList.add(new Service("Governmen","Hello","Lorum","Ipsum",R.drawable.img_three,
                R.drawable.img_four,
                R.drawable.ic_baseline_medical_services_24,
                R.drawable.ic_baseline_home_repair_service_24));
        serviceArrayList.add(new Service("Service","Hello","Lorum","Ipsum",R.drawable.img_three,
                R.drawable.img_four,
                R.drawable.ic_baseline_medical_services_24,
                R.drawable.ic_baseline_home_repair_service_24));

        mAdpater.notifyDataSetChanged();

    }

    public void initRecycler() {

        mAdpater = new ServiceRecycler(serviceArrayList, getActivity());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdpater);
    }
}