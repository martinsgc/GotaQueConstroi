package com.gotaqueconstroi.umagotaqueconstroi;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

public class Principal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        ImageButton btnColeta = (ImageButton) findViewById(R.id.btnColeta);
        ImageButton btnComprar = (ImageButton) findViewById(R.id.btnComprar);
        ImageButton btnHistorico = (ImageButton) findViewById(R.id.btnHistorico);
        ImageButton btnTransparencia = (ImageButton) findViewById(R.id.btnTransparencia);
        ImageButton btnSobre = (ImageButton) findViewById(R.id.btnSobre);

        //Chamar tela coleta
        btnColeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Principal.this, Collect.class));
            }
        });

        //Chamar tela venda
        btnComprar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Principal.this, Venda.class));
            }
        });

        //Botão Sobre
        btnSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog;
                dialog = new AlertDialog.Builder(Principal.this);
                dialog.setTitle("Sobre o  Projeto");
                dialog.setMessage("O Uma Gota que Constrói surgiu através da necessidade de um" +
                        " projeto que pudesse gerar renda, mas que fosse além de uma idéia financeira... Que fosse algo " +
                        "que sensibilizasse a população para necessidade de cuidarmos do nosso meio ambiente.");
                dialog.setCancelable(false);
                dialog.setIcon(R.drawable.logo_pq);
                dialog.setNegativeButton("OK" , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.create();
                dialog.show();

            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
    //Comentado para remover ... Settings da barra superior
   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    } */

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

        if (id == R.id.mnuComprar) {
            startActivity(new Intent(Principal.this, Venda.class));
        } else if (id == R.id.mnuHistorico) {


        } else if (id == R.id.mnuTransparencia) {

        } else if (id == R.id.mnuColeta) {
            startActivity(new Intent(Principal.this, Collect.class));

        } else if (id == R.id.mnuInstituicoes) {


        } else if (id == R.id.mnuSair) {

        } else if (id == R.id.mnuSobre) {

        } else if (id == R.id.mnuCadastro){
            startActivity(new Intent(Principal.this, Cadastro.class));

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
