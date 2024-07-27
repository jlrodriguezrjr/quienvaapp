package com.example.quienvaapp.ui.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.quienvaapp.MainActivity;
import com.example.quienvaapp.MenuPrincipalFragment;
import com.example.quienvaapp.R;
import com.example.quienvaapp.ui.Dto.ListaMandaditosDTO;
import com.squareup.*;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListaMandaditosAdapter extends RecyclerView.Adapter<ListaMandaditosAdapter.ListaMandaditosHolder> {
    private List<ListaMandaditosDTO>list;
    private Context context;
    public ListaMandaditosAdapter(List<ListaMandaditosDTO>list, Context context){
        this.list=list;
        this.context=context;

    }

    @NonNull
    @Override
    public ListaMandaditosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_lista_mandaditos,parent,false);
        return new ListaMandaditosAdapter.ListaMandaditosHolder(v);
    }

    public void onBindViewHolder(@NonNull ListaMandaditosHolder holder, int position) {
        Picasso.with(context).load(list.get(position).getImagenMandaditos()).error(R.mipmap.ic_launcher).into(holder.img);
        holder.nombre.setText(list.get(position).getNombre());
        if(list.get(position).getStatus().equals("1")) {
            holder.btnStatus.setBackgroundResource(R.drawable.activoboton);
            holder.status.setText("Activo");
        }else if(list.get(position).getStatus().equals("2")){
            holder.btnStatus.setBackgroundResource(R.drawable.inactivo);
            holder.status.setText("Inactivo");
        }else if(list.get(position).getStatus().equals("3")){
            holder.btnStatus.setBackgroundResource(R.drawable.fueraservicio);
            holder.status.setText("Fuera de servicio");
        }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ListaMandaditosHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView nombre;
        TextView status;
        ImageView btnStatus;

        public ListaMandaditosHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.id_imagen_mandaditos);
            nombre=itemView.findViewById(R.id.id_nombre_mandaditos);
            status=itemView.findViewById(R.id.id_status_mandaditos);
            btnStatus=itemView.findViewById(R.id.id_color_status_mandaditos);
        }
    }
}