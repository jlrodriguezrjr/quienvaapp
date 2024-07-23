package com.example.quienvaapp;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.example.quienvaapp.ui.Adapter.ListaMandaditosAdapter;
import com.example.quienvaapp.ui.Dto.ListaMandaditosDTO;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quienvaapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    private RecyclerView rvMandaditos;
    private ListaMandaditosAdapter adapterMandaditos;
    private List<ListaMandaditosDTO> listaMandaditos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        rvMandaditos = (RecyclerView) findViewById(R.id.id_rv_lista_mandaditos);
        listaMandaditos=new ArrayList<>();
        LinearLayoutManager ln1=new LinearLayoutManager(this);
        ln1.setReverseLayout(true);
        ln1.setStackFromEnd(true);
        rvMandaditos.setLayoutManager(ln1);
        adapterMandaditos = new ListaMandaditosAdapter(listaMandaditos,this,this);
        rvMandaditos.setAdapter(adapterMandaditos);

        AgregarListaMandaditos("1","alskdj","jose luis rodriguez", "1");
        AgregarListaMandaditos("1","alskdj","jorge aldrin cruz rodriguez", "2");
        AgregarListaMandaditos("1","alskdj","luis angel candelario rodriguez", "3");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
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