package com.example.ericfreitez.sertrolsign;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.ericfreitez.sertrolsign.fragments.AgregarEmpresaFragment;
import com.example.ericfreitez.sertrolsign.fragments.CrearProyectoFragment;
import com.example.ericfreitez.sertrolsign.fragments.ListarEmpresasFragment;
import com.example.ericfreitez.sertrolsign.fragments.ProyectosPendientesFragment;
import com.example.ericfreitez.sertrolsign.models.Proyecto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String userName;

    private List<Proyecto> proyectos= new ArrayList<>() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.setNavigationItemSelectedListener(this);


        //String userName = getIntent().getStringExtra("userName");

        //Bundle bundle = new Bundle();
        //bundle.putString("userName", userName);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        ProyectosPendientesFragment fragment = new ProyectosPendientesFragment();
        //fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.content_main, fragment);
        fragmentTransaction.commit();

        //String userName= (String) getIntent().getSerializableExtra("userName");



// Your fragment


        //ListaProyectoClient listaProyecto;
        //listaProyecto= (ListaProyectoClient) getIntent().getSerializableExtra("userProyectos");
        //String userName = getIntent().getExtras().getString();
        //Log.i("msg","------------->"+userName);

        /*if (listaProyecto!=null){

            proyectos= listaProyecto.getProyectos();
            for (int i=0; i <proyectos.size(); i++){
                Log.i("msg",proyectos.get(i).getNombreProyecto());
                Log.i("msg",proyectos.get(i).getNombreEmpresa());
                Log.i("msg",proyectos.get(i).getDescripcionProyecto());
                Log.i("msg",proyectos.get(i).getCodigoProyecto());
                Log.i("msg","--------------------------------");
            }

        }*/
    }
    public String getMyData() {
        return userName = getIntent().getStringExtra("userName");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.servicios) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            ProyectosPendientesFragment fragment = new ProyectosPendientesFragment();
            fragmentTransaction.replace(R.id.content_main, fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.agregar_empresa) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            AgregarEmpresaFragment fragment = new AgregarEmpresaFragment();
            fragmentTransaction.replace(R.id.content_main, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Agregar Empresa");

        } else if (id == R.id.listar_empresas) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            ListarEmpresasFragment fragment = new ListarEmpresasFragment();
            fragmentTransaction.replace(R.id.content_main, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Listas Empresas");

        } else if (id == R.id.crear_proyecto) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            CrearProyectoFragment fragment = new CrearProyectoFragment();
            fragmentTransaction.replace(R.id.content_main, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Crear Proyecto");

        } else if (id == R.id.cerrar) {
                finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
