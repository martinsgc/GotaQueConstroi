package com.gotaqueconstroi.umagotaqueconstroi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        ImageButton btnContinua = (ImageButton) findViewById(R.id.btnContinua);

        //Chamar tela coleta
        btnContinua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Cadastro.this, Instituicao.class));
            }
        });

    }
}
