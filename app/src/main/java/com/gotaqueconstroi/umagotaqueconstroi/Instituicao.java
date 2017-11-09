package com.gotaqueconstroi.umagotaqueconstroi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class Instituicao extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instituicao);

        ImageButton btnConcluir = (ImageButton) findViewById(R.id.btnConcluir);
        final RadioButton rdbApae = (RadioButton) findViewById(R.id.rdbApae);
        final RadioButton rdbAssociacao = (RadioButton) findViewById(R.id.rdbAssociacao);
        final RadioButton rdbCaps = (RadioButton) findViewById(R.id.rdbCaps);
        final RadioButton rdbCapsAd = (RadioButton) findViewById(R.id.rdbCapsAd);

        btnConcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String instituicao = null;


                 if (rdbApae.isChecked()) {
                    instituicao = "APAE";

                } else if (rdbAssociacao.isChecked()) {
                    instituicao = "Associação de Bairro";

                } else if (rdbCaps.isChecked()) {
                    instituicao = "CAPS";

                } else if (rdbCapsAd.isChecked()) {
                    instituicao = "CAPS AD";

                } else {
                     Toast.makeText(Instituicao.this, "Favor selecione uma instituição!", Toast.LENGTH_SHORT).show();
                 }

                    if (rdbApae.isChecked() || rdbAssociacao.isChecked() || rdbCaps.isChecked() || rdbCapsAd.isChecked()) {
                        //Criar Alert Dialog
                        AlertDialog.Builder dialog;
                        dialog = new AlertDialog.Builder(Instituicao.this);
                        //Titulo do Dialog
                        dialog.setTitle("Confirmação");
                        //Mensagem da Dialog
                        dialog.setMessage("Confirma criação de vínculo com " + instituicao + "?");

                        //Não deixar cancelar a Dialog
                        dialog.setCancelable(false);
                        //Definindo ícone
                        dialog.setIcon(android.R.drawable.ic_dialog_alert);
                        //Botao Negativo
                        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Instituicao.this, "Cadastro não realizado!", Toast.LENGTH_LONG).show();
                            }
                        });
                        //Botao positivo
                        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Instituicao.this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();
                                finish();
                            }
                        });
                        //Criar a Dialog
                        dialog.create();
                        //Mostrar a Dialog
                        dialog.show();


                    }

            }
        });


    }
}
