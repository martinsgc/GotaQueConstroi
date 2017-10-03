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
        ImageButton btnInformacao = (ImageButton) findViewById(R.id.btnInformacao);

        btnColeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer quantidade;
                String quantidadeDigitada;
                quantidadeDigitada = txtQuantidade.getText().toString();
                if(quantidadeDigitada.equals("")){
                    Toast.makeText(Collect.this, "Digite uma quantidade válida ", Toast.LENGTH_SHORT).show();
                }else {
                    quantidade = Integer.parseInt(txtQuantidade.getText().toString());

                    if (quantidade <= 0) {
                        Toast.makeText(Collect.this, "Digite uma quantidade válida ", Toast.LENGTH_SHORT).show();
                    } else {
                        //Criar Alert Dialog
                        AlertDialog.Builder dialog;
                        dialog = new AlertDialog.Builder(Collect.this);
                        //Titulo do Dialog
                        dialog.setTitle("Confirmação");
                        //Mensagem da Dialog
                        dialog.setMessage("Confirma a doação de " + quantidade + " litros de óleo  ?");
                        //Não deixar cancelar a Dialog
                        dialog.setCancelable(false);
                        //Definindo ícone
                        dialog.setIcon(android.R.drawable.ic_dialog_alert);
                        //Botao Negativo
                        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Collect.this, "Doação não realizada !", Toast.LENGTH_LONG).show();
                            }
                        });
                        //Botao positivo
                        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Collect.this, "Agradecemos a doação, em breve iremos recolher !", Toast.LENGTH_LONG).show();
                            }
                        });
                        //Criar a Dialog
                        dialog.create();
                        //Mostrar a Dialog
                        dialog.show();
                    }
                }

            }
        });
        btnInformacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog;
                dialog = new AlertDialog.Builder(Collect.this);
                dialog.setTitle("Informação");
                dialog.setMessage("Insira no campo acima a quantidade de litros de óleo usado que será " +
                        "disponibilizado para doação e logo em seguida clique no botão abaixo.");
                dialog.setCancelable(false);
                dialog.setIcon(android.R.drawable.ic_dialog_info);
                dialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
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
