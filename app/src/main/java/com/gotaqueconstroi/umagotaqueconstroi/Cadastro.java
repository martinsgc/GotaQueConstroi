package com.gotaqueconstroi.umagotaqueconstroi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        ImageButton btnContinua = (ImageButton) findViewById(R.id.btnContinua);
        final EditText txtNome = (EditText) findViewById(R.id.txtNome);
        final EditText txtRua = (EditText) findViewById(R.id.txtRua);
        final EditText txtNumero = (EditText) findViewById(R.id.txtNumero);
        final EditText txtComplemento = (EditText) findViewById(R.id.txtComplemento);
        final EditText txtBairro = (EditText) findViewById(R.id.txtBairro);
        final EditText txtTelefone = (EditText) findViewById(R.id.txtTelefone);


        btnContinua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome;
                String rua;
                String numero;
                String complemento;
                String bairro;
                String telefone;

                nome = txtNome.getText().toString();
                rua = txtRua.getText().toString();
                numero = txtNumero.getText().toString();
                complemento = txtComplemento.getText().toString();
                bairro = txtBairro.getText().toString();
                telefone = txtTelefone.getText().toString();

                if (nome.equals("") || rua.equals("") || numero.equals("") || bairro.equals("") || telefone.equals("")) {
                    Toast.makeText(Cadastro.this, "Favor preencha todos os campos corretamente", Toast.LENGTH_SHORT).show();

                    if (nome.equals("")) {
                        txtNome.requestFocus();
                    } else if (rua.equals("")) {
                        txtRua.requestFocus();
                    } else if (numero.equals("")) {
                        txtNumero.requestFocus();
                    } else if (bairro.equals("")) {
                        txtBairro.requestFocus();
                    } else if (telefone.equals("")) {
                        txtTelefone.requestFocus();
                    }

                } else {
                    //Criar Alert Dialog
                    AlertDialog.Builder dialog;
                    dialog = new AlertDialog.Builder(Cadastro.this);
                    //Titulo do Dialog
                    dialog.setTitle("Confirmação");
                    //Mensagem da Dialog
                    dialog.setMessage("Confirma o cadastro com os seguintes dados? \n \n "
                            + "Nome: " + nome + "\n"
                            + "Rua: " + rua + "\n"
                            + "Número: " + numero + "\n"
                            + "Complemento: " + complemento + "\n"
                            + "Bairro: " + bairro + "\n"
                            + "Telefone: " + telefone + "\n");

                    //Não deixar cancelar a Dialog
                    dialog.setCancelable(false);
                    //Definindo ícone
                    dialog.setIcon(android.R.drawable.ic_dialog_alert);
                    //Botao Negativo
                    dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(Cadastro.this, "Caadastro não realizado!", Toast.LENGTH_LONG).show();
                        }
                    });
                    //Botao positivo
                    dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(Cadastro.this, Instituicao.class));
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
