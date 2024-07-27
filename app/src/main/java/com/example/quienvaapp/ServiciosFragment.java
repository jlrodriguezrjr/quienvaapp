package com.example.quienvaapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quienvaapp.ui.Adapter.ListaCategoriasAdapter;
import com.example.quienvaapp.ui.Adapter.ListaMandaditosAdapter;
import com.example.quienvaapp.ui.Adapter.ListaServiciosAdapter;
import com.example.quienvaapp.ui.Dto.ListaCategoriasDTO;
import com.example.quienvaapp.ui.Dto.ListaMandaditosDTO;
import com.example.quienvaapp.ui.Dto.ListaServiciosDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ServiciosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ServiciosFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ServiciosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ServiciosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ServiciosFragment newInstance(String param1, String param2) {
        ServiciosFragment fragment = new ServiciosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private RecyclerView rvCategorias;
    private ListaCategoriasAdapter adapterCategorias;
    private List<ListaCategoriasDTO> listaCategorias;

    private RecyclerView rvServicios;
    private ListaServiciosAdapter adapterServicios;
    private List<ListaServiciosDTO> listaServicios;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragment_servicios, container, false);

        rvCategorias = (RecyclerView)vista.findViewById(R.id.id_rv_lista_categorias);
        listaCategorias=new ArrayList<>();
        LinearLayoutManager ln1=new LinearLayoutManager(getActivity());
        ln1.setReverseLayout(true);
        ln1.setStackFromEnd(true);
        rvCategorias.setLayoutManager(ln1);
        adapterCategorias = new ListaCategoriasAdapter(listaCategorias,getActivity());
        rvCategorias.setAdapter(adapterCategorias);

        rvServicios = (RecyclerView)vista.findViewById(R.id.id_rv_lista_servicios);
        listaServicios=new ArrayList<>();
        LinearLayoutManager ln2=new LinearLayoutManager(getActivity());
        ln2.setReverseLayout(true);
        ln2.setStackFromEnd(true);
        rvServicios.setLayoutManager(ln2);
        adapterServicios = new ListaServiciosAdapter(listaServicios,getActivity());
        rvServicios.setAdapter(adapterServicios);

        AgregarListaCategorias("1", "alsdkjas", "Farmacias","1");
        AgregarListaCategorias("2", "alsdkjas", "Supermercado", "1");
        AgregarListaCategorias("3", "alsdkjas", "Comida", "1");

        AgregarListaServicios("1", "alsdkjas", "Pagos", "2");
        AgregarListaServicios("2", "alsdkjas", "Entregas y Envios", "2");
        AgregarListaServicios("3", "alsdkjas", "Alcohol", "2");
        return vista;
    }

    public void AgregarListaCategorias(String id, String imagen ,String nombre, String tipo){
        ListaCategoriasDTO masfotosObjetos=new ListaCategoriasDTO();
        masfotosObjetos.setId(id);
        masfotosObjetos.setImagen(imagen);
        masfotosObjetos.setNombre(nombre);
        masfotosObjetos.setTipo(tipo);
        listaCategorias.add(masfotosObjetos);
        adapterCategorias.notifyDataSetChanged();
    }

    public void AgregarListaServicios(String id, String imagen ,String nombre, String tipo){
        ListaServiciosDTO masfotosObjetos=new ListaServiciosDTO();
        masfotosObjetos.setId(id);
        masfotosObjetos.setImagen(imagen);
        masfotosObjetos.setNombre(nombre);
        masfotosObjetos.setTipo(tipo);
        listaServicios.add(masfotosObjetos);
        adapterServicios.notifyDataSetChanged();
    }
}