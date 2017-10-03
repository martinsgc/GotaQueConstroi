package com.gotaqueconstroi.umagotaqueconstroi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnColeta = (ImageButton) findViewById(R.id.btnColeta);
        ImageButton btnComprar = (ImageButton) findViewById(R.id.btnComprar);
        ImageButton btnHistorico = (ImageButton) findViewById(R.id.btnHistorico);
        ImageButton btnTransparencia = (ImageButton) findViewById(R.id.btnTransparencia);

        //Chamar tela coleta
        btnColeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Collect.class));
            }
        });

    }
}
