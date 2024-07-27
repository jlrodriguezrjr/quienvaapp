package com.example.quienvaapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quienvaapp.databinding.FragmentHomeBinding;
import com.example.quienvaapp.ui.Adapter.ListaMandaditosAdapter;
import com.example.quienvaapp.ui.Dto.ListaMandaditosDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuPrincipalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuPrincipalFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String ARG_OBJECT = "object";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MenuPrincipalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment menuPrincipalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuPrincipalFragment newInstance(String param1, String param2) {
        MenuPrincipalFragment fragment = new MenuPrincipalFragment();
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
    private RecyclerView rvMandaditos;
    private ListaMandaditosAdapter adapterMandaditos;
    private List<ListaMandaditosDTO> listaMandaditos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragment_menu_principal, container, false);

        rvMandaditos = (RecyclerView)vista.findViewById(R.id.id_rv_lista_mandaditos);
        listaMandaditos=new ArrayList<>();
        LinearLayoutManager ln1=new LinearLayoutManager(getActivity());
        ln1.setReverseLayout(true);
        ln1.setStackFromEnd(true);
        rvMandaditos.setLayoutManager(ln1);
        adapterMandaditos = new ListaMandaditosAdapter(listaMandaditos,getActivity());
        rvMandaditos.setAdapter(adapterMandaditos);

        AgregarListaMandaditos("1","asd", "luis gei", "1");

        return vista;
    }

    public void AgregarListaMandaditos(String id, String imagen ,String nombre, String estatus){
        ListaMandaditosDTO masfotosObjetos=new ListaMandaditosDTO();
        masfotosObjetos.setId(id);
        masfotosObjetos.setImagenMandaditos(imagen);
        masfotosObjetos.setNombre(nombre);
        masfotosObjetos.setStatus(estatus);
        listaMandaditos.add(masfotosObjetos);
        adapterMandaditos.notifyDataSetChanged();
    }
}