package fabricioferreira.coletaseletivatorres.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import fabricioferreira.coletaseletivatorres.Fragments.*;
import fabricioferreira.coletaseletivatorres.R;
import android.support.v7.app.AppCompatActivity;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        if (savedInstanceState == null){
            FragmentColetaTorres fragColeta = new FragmentColetaTorres();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.drawer_layout, fragColeta);
            ft.commit();
        }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

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

        if (id == R.id.coleta) {
            //FragmentColetaTorres fragColeta = (FragmentColetaTorres) fm.findFragmentById(R.id.fragmentColeta);
            FragmentColetaTorres fragColeta = new FragmentColetaTorres();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.drawer_layout, fragColeta, "fragColeta");
            ft.addToBackStack("pilha");
            ft.commit();

        } else if (id == R.id.papel) {
            //FragmentPapel fragPapel = (FragmentPapel) fm.findFragmentById(R.id.fragmentPapel);
            FragmentPapel fragPapel = new FragmentPapel();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.drawer_layout, fragPapel, "fragPapel");
            ft.addToBackStack("pilha");
            ft.commit();

        } else if (id == R.id.plastico) {
            //FragmentPlastico fragPlastico = (FragmentPlastico) fm.findFragmentById(R.id.fragmentPlastico);
            FragmentPlastico fragPlastico = new FragmentPlastico();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.drawer_layout, fragPlastico, "fragPlastico");
            ft.addToBackStack("pilha");
            ft.commit();

        } else if (id == R.id.organico) {
            //FragmentOrganico fragOrganico = (FragmentOrganico) fm.findFragmentById(R.id.fragmentOrganico);
            FragmentOrganico fragOrganico = new FragmentOrganico();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.drawer_layout, fragOrganico, "fragOrganico");
            ft.addToBackStack("pilha");
            ft.commit();

        } else if (id == R.id.metal) {
            //FragmentMetal fragMetal = (FragmentMetal) fm.findFragmentById(R.id.fragmentMetal);
            FragmentMetal fragMetal = new FragmentMetal();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.drawer_layout, fragMetal, "fragMetal");
            ft.addToBackStack("pilha");
            ft.commit();

        } else if (id == R.id.vidro) {
            //FragmentVidro fragVidro = (FragmentVidro) fm.findFragmentById(R.id.fragmentMetal);
            FragmentVidro fragVidro = new FragmentVidro();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.drawer_layout, fragVidro, "fragVidro");
            ft.addToBackStack("pilha");
            ft.commit();

        } else if (id == R.id.alarm){


        } else if (id == R.id.maps){

            FragmentTransaction ft = fm.beginTransaction();
            chamaMapa();
            ft.addToBackStack("pilha");
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }

    public void chamaMapa(){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
