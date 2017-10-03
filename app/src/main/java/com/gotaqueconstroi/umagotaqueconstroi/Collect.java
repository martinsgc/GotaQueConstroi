package com.gotaqueconstroi.umagotaqueconstroi;

import android.content.DialogInterface;
import android.renderscript.Double2;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Collect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        ImageButton btnColeta = (ImageButton) findViewById(R.id.btnColeta);
        final EditText txtQuantidade = (EditText) findViewById(R.id.txtQuantidade);

        btnColeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer quantidade;
                quantidade = Integer.parseInt(txtQuantidade.getText().toString());
                //Criar Alert Dialog
                AlertDialog.Builder dialog;
                dialog = new AlertDialog.Builder(Collect.this);
                //Titulo do Dialog
                dialog.setTitle("Confirmação");
                //Mensagem da Dialog
                dialog.setMessage("Confirma a doação de "+quantidade+ " litros de óleo  ?");
                //Não deixar cancelar a Dialog
                dialog.setCancelable(false);
                //Definindo ícone
                dialog.setIcon(android.R.drawable.ic_dialog_alert);
                //Botao Negativo
                dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Collect.this, "Clicou no NÃO", Toast.LENGTH_LONG).show();
                    }
                });
                //Botao positivo
                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Collect.this, "Clicou no Sim", Toast.LENGTH_LONG).show();
                    }
                });
                //Criar a Dialog
                dialog.create();
                //Mostrar a Dialog
                dialog.show();

            }
        });
    }
}
