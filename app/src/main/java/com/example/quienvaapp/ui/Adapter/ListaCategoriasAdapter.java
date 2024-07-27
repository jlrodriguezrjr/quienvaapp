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
import com.example.quienvaapp.ui.Dto.ListaMandaditosDTO;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListaCategoriasAdapter extends RecyclerView.Adapter<ListaCategoriasAdapter.ListaCategoriasHolder> {
    private List<ListaCategoriasDTO>list;
    private Context context;
    public ListaCategoriasAdapter(List<ListaCategoriasDTO>list, Context context){
        this.list=list;
        this.context=context;
    }

    @NonNull
    @Override
    public ListaCategoriasHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_lista_categorias,parent,false);
        return new ListaCategoriasAdapter.ListaCategoriasHolder(v);
    }

    public void onBindViewHolder(@NonNull ListaCategoriasHolder holder, int position) {
        Picasso.with(context).load(list.get(position).getImagen()).error(R.drawable.ic_menu_camera).into(holder.img);
        holder.nombre.setText(list.get(position).getNombre());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ListaCategoriasHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView nombre;


        public ListaCategoriasHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.id_imagen_categorias);
            nombre=itemView.findViewById(R.id.id_nombre_categorias);
        }
    }
}