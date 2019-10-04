package com.example.coc.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coc.R;
import com.example.coc.data.ServiceViewModel;
import com.example.coc.retrofit.Response.Servicio;

import java.util.List;


public class ServicioFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    RecyclerView recyclerView;
    MyServicioRecyclerViewAdapter adapter;
    List<Servicio> serviceList;
    ServiceViewModel serviceViewModel;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ServicioFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ServicioFragment newInstance(int columnCount) {
        ServicioFragment fragment = new ServicioFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        serviceViewModel = ViewModelProviders.of(getActivity())
                .get(ServiceViewModel.class);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_servicio_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            adapter = new MyServicioRecyclerViewAdapter(getActivity(), serviceList);
            recyclerView.setAdapter(adapter);


            loadServiceData();
        }
        return view;
    }


    private void loadServiceData() {

        serviceViewModel.getServicios().observe(getActivity(), new Observer<List<Servicio>>() {
            @Override
            public void onChanged(List<Servicio> servicios) {
                serviceList = servicios;
                adapter.setData(serviceList);

            }
        });

    }


}
