package com.gotaqueconstroi.umagotaqueconstroi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    public static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton btnColeta = (ImageButton) findViewById(R.id.btnColeta);
        ImageButton btnComprar = (ImageButton) findViewById(R.id.btnComprar);
        ImageButton btnHistorico = (ImageButton) findViewById(R.id.btnHistorico);
        ImageButton btnTransparencia = (ImageButton) findViewById(R.id.btnTransparencia);
        ImageButton btnSobre = (ImageButton) findViewById(R.id.btnSobre);

        //Chamar tela coleta
        btnColeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Collect.class));
            }
        });

        //Botão Sobre
        btnSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog;
                dialog = new AlertDialog.Builder(MainActivity.this);
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
    }
}