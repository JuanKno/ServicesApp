package com.example.coc;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.coc.retrofit.Response.Servicio;

import java.util.List;


public class MyServicioRecyclerViewAdapter extends RecyclerView.Adapter<MyServicioRecyclerViewAdapter.ViewHolder> {

    private Context ctx;
    private final List<Servicio> mValues;

    public MyServicioRecyclerViewAdapter(Context contexto, List<Servicio> items) {
        mValues = items;
        ctx = contexto;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_servicio, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.tvNombreServicio.setText(holder.mItem.getNombreServicio());
        holder.tvDescripcion.setText(holder.mItem.getDescripcion());

        String fotoInicio = holder.mItem.getFotoInicio();

        if (!fotoInicio.equals("")) {
            Glide.with(ctx).load("https://coc-sas.000webhostapp.com/api/imagen/" + fotoInicio)
                    .into(holder.ivFotoInicio);


        }


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView ivFotoInicio;
        public final TextView tvNombreServicio;
        public final TextView tvDescripcion;
        public Servicio mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ivFotoInicio = view.findViewById(R.id.imageViewFotoInicio);
            tvNombreServicio = view.findViewById(R.id.textViewNombreServicio);
            tvDescripcion = view.findViewById(R.id.textViewDescripcion);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvNombreServicio.getText() + "'";
        }
    }
}
