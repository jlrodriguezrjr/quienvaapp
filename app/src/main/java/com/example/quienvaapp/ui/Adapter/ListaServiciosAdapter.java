package com.example.quienvaapp.ui.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quienvaapp.R;
import com.example.quienvaapp.ui.Dto.ListaCategoriasDTO;
import com.example.quienvaapp.ui.Dto.ListaServiciosDTO;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListaServiciosAdapter extends RecyclerView.Adapter<ListaServiciosAdapter.ListaServiciosHolder> {
    private List<ListaServiciosDTO>list;
    private Context context;
    public ListaServiciosAdapter(List<ListaServiciosDTO>list, Context context){
        this.list=list;
        this.context=context;
    }

    @NonNull
    @Override
    public ListaServiciosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_lista_servicios,parent,false);
        return new ListaServiciosAdapter.ListaServiciosHolder(v);
    }

    public void onBindViewHolder(@NonNull ListaServiciosHolder holder, int position) {
        Picasso.with(context).load(list.get(position).getImagen()).error(R.drawable.ic_menu_camera).into(holder.img);
        holder.nombre.setText(list.get(position).getNombre());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ListaServiciosHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView nombre;


        public ListaServiciosHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.id_imagen_servicios);
            nombre=itemView.findViewById(R.id.id_nombre_servicios);
        }
    }
}